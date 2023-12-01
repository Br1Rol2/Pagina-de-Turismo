package controladores;

import datatypes.DataActividad;
import datatypes.DataPaquete;
import datatypes.DataSalida;
import datatypes.DataUsuario;
import logica.Usuario;
import java.time.LocalDate;
import excepciones.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Proveedor;
import logica.Turista;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import logica.ActividadTuristica;
import logica.Categoria;
import logica.Departamento;
import logica.EstadoActividad;
import logica.Inscripcion_general;
import logica.Inscripcion_paquete;
import logica.Paquete;
import logica.SalidasTuristicas;

public class Sistema implements ISistema {

    private final EntityManager em;
    private DataActividad[] dataActividades;
    private Departamento deptoSeleccionado;
    private ActividadTuristica actividadSeleccionada;
    private Turista turistaSeleccionado;
    private SalidasTuristicas salidaSeleccionada;
    private String nombre;
    private String descripcion;
    private LocalDate alta;
    private LocalDate fechaSalida;
    public LocalDate fechaSistema = LocalDate.now();
    int cantidad;
    String imagen;

    public Sistema() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LABPAPP_WEB");
        em = emf.createEntityManager();
        //getObjectsFromDB();
    }

    public EntityManager getEntityManager() {
        return em;
    }

    static Sistema instancia = null;

    public static Sistema getInstance() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }

    // public static Map<String, DataUsuario> turistaMail = new HashMap<>();
    //  public static Map<String, DataUsuario> usuariosMail = new HashMap<>();
    public DataUsuario verInfoUsuario(String mail) throws UsuarioNoExisteException {

        Usuario u = getUsuarioDB(mail);
        if (u != null) {
            return u.devolverData();
        } else {
            return null;

        }

    }

    public Departamento selectDepartamento(String nombreDepartamento) {
        deptoSeleccionado = Departamento.encontrarDepto(nombreDepartamento);
        return deptoSeleccionado;
    }

    public Paquete selectPaquete(String nombre_paquete) {
        return Paquete.getPaqueteByNombre(nombre_paquete);
    }

    public ActividadTuristica selectActividad(String nombre) {
        for (Map.Entry<String, Usuario> entry : Usuario.usuariosMail.entrySet()) {
            Usuario usuario = entry.getValue();
            if (usuario instanceof Proveedor) {

                Proveedor proveedor = (Proveedor) usuario;//Casteo de proveedor de usuario 
                for (ActividadTuristica act : proveedor.getActTuristica()) {
                    if (act.getNombre() == null ? nombre == null : act.getNombre().equals(nombre)) {
                        actividadSeleccionada = act;
                        return act;
                    }
                }
            }
        }
        return null;
    }

    public boolean estaInscritoTuristaSalida(String mailTurista, String nombreSalida) {

        Query query = em.createNativeQuery("SELECT COUNT(*) FROM INSCRIPCION_GENERAL i JOIN turista_inscripcion_general ti where i.ID = ti.nscripcion_general_id and i.salidaInscripcion = ? and iturista_correo = ?");
        query.setParameter(1, nombreSalida);
        query.setParameter(2, mailTurista);
        Long count = (Long) query.getSingleResult();

        return (count > 0);
    }

    public boolean excedeLimiteInscripcion(String nombreSalida, int cantTurista) {

        salidaSeleccionada = actividadSeleccionada.getSalidaByNombre(nombreSalida);
        return (salidaSeleccionada.getCantInscritos() + cantTurista > salidaSeleccionada.getCantidadMaximaTuristas());
    }

    public SalidasTuristicas getSalidaByNombre(String nombreSalida) {
        return getSalidaFromBD(nombreSalida);
    }

    public boolean inscripcionSalida(String mailTurista, String nombreSalida, int cantTurista, LocalDate fechaInscr) {
        boolean valido = true;
        turistaSeleccionado = (Turista) Usuario.obtenerUsuario(mailTurista);
        salidaSeleccionada = getSalidaByNombre(nombreSalida);
        this.alta = fechaInscr;
        if (salidaSeleccionada.estaInscritoUsuario(mailTurista) || salidaSeleccionada.getCantInscritos() + cantTurista > salidaSeleccionada.getCantidadMaximaTuristas()) {
            valido = false;
        }
        return valido;
    }

    public void confirmarInscripcion(int cantTurista, double costogral) {
        Collection<Turista> turistas = new ArrayList<>();
        turistas.add(turistaSeleccionado);

        String jpql = "SELECT MAX(ig.id) FROM Inscripcion_general ig";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        Long maxId = query.getSingleResult();

// Paso 3: Calcular el nuevo ID
        long nuevoId = 1;
        if (maxId != null) {
            nuevoId = maxId + 1;
        }

        Inscripcion_general nuevaInscripcion = new Inscripcion_general(nuevoId, cantTurista, costogral, salidaSeleccionada, turistas);
        nuevaInscripcion.setFechaCompra(alta);
        salidaSeleccionada.agregarInscripcionGral(nuevaInscripcion);
        salidaSeleccionada.aumentarCantInscritos(cantTurista);

        for (Turista t : turistas) {
            t.agregarInscripcionGral(nuevaInscripcion);  // Llamar a la función para cada turista en la colección

        }

        try {
            em.getTransaction().begin();
            em.merge(nuevaInscripcion);

            em.merge(salidaSeleccionada);
            em.getTransaction().commit();
        } catch (Exception e) {

            //em.getTransaction().rollback();
        }
    }

    public boolean AltaActividadTuristica(String correoProveedor, String nombreAct, String descripcion, Integer duracion, double costo, String depto, LocalDate fechaA, String ciudad, ArrayList<String> eleccionesCategoria, String imagen) {

        Usuario u = Usuario.obtenerUsuario(correoProveedor);
        boolean flag = false;
        if (u != null) {
            if (u instanceof Proveedor) {
                Proveedor proveedor = (Proveedor) u;
                Collection<ActividadTuristica> act = proveedor.getActTuristica();
                Query query = em.createNativeQuery("SELECT NOMBRE FROM ACTIVIDADTURISTICA WHERE NOMBRE = ?");
                query.setParameter(1, nombreAct);
                if (!query.getResultList().isEmpty()) {
                    flag = true;
                }

                if (!flag) {
                    ActividadTuristica nuevaAct = new ActividadTuristica(nombreAct, descripcion, duracion, costo, ciudad, fechaA, imagen);
                    proveedor.addActTuristica(nuevaAct);
                    Departamento dep = selectDepartamento(depto);

                    dep.addActTurisica(nuevaAct);
                    nuevaAct.setProveedor(proveedor);
                    nuevaAct.setDepartamento(dep);

                    Set<Categoria> categoriasSeleccionadas = new HashSet<>();
                    for (int i = 0; i < eleccionesCategoria.size(); i++) {
                        System.out.println("llegamo");
                        String categoria = eleccionesCategoria.get(i);
                        Categoria cat = getCatFromBD(categoria);
                        //System.out.println(cat.getNombreCat());
                        nuevaAct.addCategoria(cat);

                    }

                    try {
                        em.getTransaction().begin();
                        em.merge(nuevaAct);
                        //em.merge(deptoSeleccionado);
                        em.getTransaction().commit();
                    } catch (Exception e) {
                    }
                }
            }
        }
        return flag;
    }

    public Categoria getCatFromBD(String nombreCategoria) {
        Query catquery = em.createNativeQuery("SELECT * FROM CATEGORIA WHERE NOMBRECAT = ?", Categoria.class);
        catquery.setParameter(1, nombreCategoria);
        Categoria cat = (Categoria) catquery.getSingleResult();
        return cat;
    }

    public DataActividad ConsultaActTuristica(String ciudad, String nombreAct) {
        ActividadTuristica act = selectActividad(nombreAct);
        return act.devolverData();
    }
/*
    public void AltaSalidaTuristica(String correoProveedor, String nombreSalida, String lugar, Integer cantTuristas, LocalDate fechaSalida, LocalDate fechaAlta) {

        nombre = nombreSalida;
        this.descripcion = lugar;
        this.alta = fechaAlta;
        this.fechaSalida = fechaSalida;
        this.cantidad = cantTuristas;

    }

    public void confirmarAltaSalida() {
        SalidasTuristicas nuevaS = actividadSeleccionada.crearSalida(nombre, descripcion, cantidad, alta, fechaSalida, imagen);
        try {
            em.getTransaction().begin();
            em.merge(nuevaS);
            em.merge(actividadSeleccionada);
            em.getTransaction().commit();
        } catch (Exception e) {

        }
    }*/

    public void registrarUsuario(String nick, String name, String ap, String mail, LocalDate fecNac, String tipoUsuario, String nacionalidad, String descripcion, String web, String imagenPerfil, String password) throws UsuarioRepetidoException {
        getAllUsersFromBD();
        Usuario u = Usuario.obtenerUsuario(mail);
        if (u != null) {
            throw new UsuarioRepetidoException("El usuario con el correo electrónico " + mail + " ya está registrado");
        } else if (Usuario.obtenerUsuarioPorNick(nick) != null) {
            throw new UsuarioRepetidoException("El nickname " + nick + " ya está en uso");
        } else {

            Usuario nuevoUsuario = new Usuario(nick, name, ap, mail, fecNac, imagenPerfil, password);

            try {
                em.getTransaction().begin();
                em.persist(nuevoUsuario);
                em.getTransaction().commit();
            } catch (Exception e) {
            }

            if (tipoUsuario.equals("turista") || tipoUsuario.equals("Turista")) {
                Turista turista = new Turista(nick, name, ap, mail, fecNac, nacionalidad, imagenPerfil, password);
                Usuario.addUsuario(turista);

                try {
                    em.getTransaction().begin();
                    em.persist(turista);
                    em.getTransaction().commit();
                } catch (Exception e) {
                }

            } else if (tipoUsuario.equals("proveedor") || tipoUsuario.equals("Proveedor")) {
                Proveedor proveedor = new Proveedor(nick, name, ap, mail, fecNac, descripcion, web, imagenPerfil, password);
                Usuario.addUsuario(proveedor);

                try {
                    em.getTransaction().begin();
                    em.persist(proveedor);
                    em.getTransaction().commit();
                } catch (Exception e) {
                }
            }
        }
    }

    public void modificarDatosUsuario(String mail, String nuevoNombre, String nuevoApellido, LocalDate nuevaFechaNacimiento, String imagenP) throws UsuarioNoExisteException {
        // Obtén el usuario directamente de la base de datos
        Usuario usuario = getUsuarioDB(mail);

        if (usuario == null) {
            throw new UsuarioNoExisteException("El usuario con el correo electrónico " + mail + " no existe");
        }
        // Actualiza los datos del usuario
        usuario.setNombre(nuevoNombre);
        usuario.setApellido(nuevoApellido);
        usuario.setFecha(nuevaFechaNacimiento);
        usuario.setImagenPerfil(imagenP);

        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
        }

    }

    public boolean confirmarCreacionPaquete(String nombre, String descripcion, int validez, int descuento, LocalDate alta, String imagen) {
        Paquete nuevoPaquete = new Paquete(nombre, descripcion, descuento, validez, alta, imagen);
        Paquete.paquetes.put(nombre, nuevoPaquete);
        try {
            em.getTransaction().begin();
            em.persist(nuevoPaquete);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        return true;
    }

    public void getAllUsersFromBD() {
        em.getTransaction().begin();
        Usuario.usuariosMail.clear();
        //PROVEEDOR
        List<Proveedor> proveequery = em.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();

        for (Proveedor p : proveequery) {
            Proveedor.addUsuario(p);
        }
        //TURISTA
        List<Turista> turquery = em.createQuery("SELECT t FROM Turista t", Turista.class).getResultList();
        for (Turista t : turquery) {
            Turista.addUsuario(t);
        }

        em.getTransaction().commit();

    }

    public void getObjectsFromDB() {
        getAllUsersFromBD();
        em.getTransaction().begin();

        // DEPARTAMENTOS
        List<Departamento> deptosquery = em.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
        for (Departamento d : deptosquery) {
            //AltaDepartamento(d.getNombreDepartamento(),d.getDescripcion()   , d.getWeb());
            Departamento.departamentos.put(d.getNombreDepartamento(), d);
            // Realiza una consulta para obtener las actividades asociadas a este departamento
            for (ActividadTuristica act : d.getActTuristica()) {
                // act.getProveedor().addActTuristica(act);
                TypedQuery<SalidasTuristicas> salidasQuery = em.createQuery(
                        "SELECT s FROM SalidasTuristicas s WHERE s.actividadAsociada = :act", SalidasTuristicas.class);
                salidasQuery.setParameter("act", act);
                List<SalidasTuristicas> actividades = salidasQuery.getResultList();

                List<Paquete> paqquery = em.createQuery("SELECT paq FROM Paquete paq", Paquete.class).getResultList();

                for (Paquete p : paqquery) {
                    Paquete.paquetes.put(p.getNombre_paquete(), p);
                }
                //PAQUETES

                // Aquí puedes hacer lo que necesites con la lista de actividades obtenidas
                // Por ejemplo, puedes agregarlas al departamento o realizar alguna otra operación.
                // Luego, puedes utilizar las actividades como sea necesario, por ejemplo, agregarlas al departamento:
                //  d.getActTuristica().addAll(actividades);
            }

        }

        em.getTransaction().commit();

//entityManager.close();
    }

    public boolean existePaquete(String nombre) {
        return (selectPaquete(nombre) != null);
    }

    public void modificarPaquete(String nombre, String descripcion, int validez, int descuento, LocalDate alta) {

        Paquete paq = selectPaquete(nombre);
        paq.setDescri(descripcion);
        paq.setValidez(validez);
        paq.setDescuento(descuento);
        paq.setAlta(alta);
    }

    public void AltaSalidaTuristicaDepto(String nombre, String lugar, int cantidad, LocalDate alta, LocalDate fecSal, String nombreAct, String nombreDepto, String imagen, LocalTime hora) {
        ActividadTuristica actividadSel = this.selectActividad(nombreAct);
        //Departamento dept = this.selectDepartamento(nombreDepto);
        //dept.addActTurisica(actividadSel);
        SalidasTuristicas nuevaS = actividadSel.crearSalida(nombre, lugar, cantidad, alta, fecSal, imagen, hora);
        
        em.getTransaction().begin();
        em.merge(nuevaS);
        em.merge(actividadSel);
        em.getTransaction().commit();
    }


    /*
    public String[] listarActividadesProveedor(Proveedor proveedor) {
        int i = 0;
        String[] actsarr = new String[proveedor.getActTuristica().size()];
        for (ActividadTuristica actividad : proveedor.getActTuristica()) {
            actsarr[i] = actividad.getNombre();
            i++;
        }
        return actsarr;
    }
     */
    public String[] obtenerSalidasInscritasTurista(String correoTurista) {

        Usuario usr = getUsuarioDB(correoTurista);
        Turista turista = (Turista) usr; // Manejo de error en caso de que el usuario no exista
        if (turista != null) {
            Collection<SalidasTuristicas> salidasInscritas = turista.getSalidasInscritas();
            String[] arreglo = new String[salidasInscritas.size()];
            int i = 0;
            for (SalidasTuristicas salida : salidasInscritas) {
                arreglo[i] = salida.getNombreSalida();
                i++;
            }
            return arreglo;
        }
        return new String[0]; // Devuelve un arreglo vacío si no se encontraron salidas inscritas
    }

    public DataSalida[] dataSalidasActividadesProveedor(String proveedorCorreo) {

        Usuario usr = getUsuarioDB(proveedorCorreo);
        Proveedor proveedor = (Proveedor) usr;
        Collection salidas = proveedor.getSalidasAsociadas();
        DataSalida[] datas = new DataSalida[salidas.size()];
        int i = 0;
        for (Object salida : salidas) {
            datas[i] = ((SalidasTuristicas) salida).devolverData();
            i++;
        }
        return datas;

    }

    public boolean validarCredenciales(String email, String password) {

        Usuario usr = getUsuarioDB(email);
        if (usr == null) {
            return false;
        }

        return usr.tienePswd(password);
    }

    public Usuario getUsuarioDB(String email) {

        Usuario usr = em.find(Usuario.class, email);
        return usr;
    }

    public DataUsuario verInfoUsuarioNick(String nick) {
        getAllUsersFromBD();
        Usuario usr = Usuario.obtenerUsuarioPorNick(nick);
        if (usr == null) {
            return null;
        } else {
            return usr.devolverData();
        }
    }

    public void registrarCategoria(String nombreCat) {

        Categoria cat = Categoria.obtenerCategoria(nombreCat);
        if (cat != null) {
            return;
        } else {
            Categoria nuevaCat = new Categoria(nombreCat);

            try {
                em.getTransaction().begin();
                em.persist(nuevaCat);
                em.getTransaction().commit();
            } catch (Exception e) {
            }

            Categoria.agregarCategoria(nuevaCat);

        }
    }

    public List<Paquete> getAllPaqsFromBD() {
        List<Paquete> paqquery = em.createQuery("SELECT paq FROM Paquete paq", Paquete.class).getResultList();
        return paqquery;
    }

    public List<ActividadTuristica> getAllActsFromBD() {
        EstadoActividad estado = EstadoActividad.CONFIRMADA;
        List<ActividadTuristica> actquery = em.createQuery("SELECT act FROM ActividadTuristica act WHERE act.estado = :estado", ActividadTuristica.class)
                .setParameter("estado", estado)
                .getResultList();
        return actquery;
    }

    public DataActividad infoActividad(String nombreActividad) {
        Query actquery = em.createNativeQuery("SELECT * FROM ACTIVIDADTURISTICA WHERE NOMBRE = ?", ActividadTuristica.class);
        actquery.setParameter(1, nombreActividad);
        ActividadTuristica actividad = (ActividadTuristica) actquery.getSingleResult();
        return actividad.devolverData();
    }

    public String getTipo(String nick) {

        String tipo = null;
        Usuario usr = Usuario.obtenerUsuarioPorNick(nick);
        if (usr instanceof Proveedor) {
            tipo = "proveedor";
        }
        if (usr instanceof Turista) {
            tipo = "turista";
        }
        return tipo;
    }

    public List<Categoria> getAllCatsFromBD() {
        List<Categoria> catsquery = em.createQuery("SELECT cat FROM Categoria cat", Categoria.class).getResultList();
        return catsquery;
    }

    public List<String> getAllActsdeCatFromBD(String categoria) {
        Query query = em.createNativeQuery("SELECT nombre_actividad FROM Actividad_Categoria WHERE nombre_categoria = ?");
        query.setParameter(1, categoria);
        List<String> estaACT = query.getResultList();
        return estaACT;
    }

    public List<String> getAllActsFromPaqFromBD(String paquete) {
        Query query = em.createNativeQuery("SELECT Act_nombre FROM ActividadTuristica_Paquete WHERE Paquete_nombre = ?");
        query.setParameter(1, paquete);
        List<String> estaACT = query.getResultList();
        return estaACT;
    }

    public DataPaquete infoPaquete(String nombrePaquete) {
        Query paqquery = em.createNativeQuery("SELECT * FROM PAQUETE WHERE NOMBRE_PAQUETE = ?", Paquete.class);
        paqquery.setParameter(1, nombrePaquete);
        Paquete paq = (Paquete) paqquery.getSingleResult();
        return paq.devolverData();
    }

    public List<Departamento> getAllDepFromBD() {
        List<Departamento> depquery = em.createQuery("SELECT dep FROM Departamento dep", Departamento.class).getResultList();
        return depquery;
    }

    public List<String> getAllActsdeDepFromBD(String depto) {
        Query query = em.createNativeQuery("SELECT NOMBRE FROM ACTIVIDADTURISTICA WHERE departamento_nombre = ? AND ESTADO=1");
        query.setParameter(1, depto);
        List<String> acts = query.getResultList();
        return acts;
    }

    public ActividadTuristica selectActFromDB(String nombreact) {
        Query paqquery = em.createNativeQuery("SELECT * FROM ACTIVIDADTURISTICA WHERE NOMBRE = ?", ActividadTuristica.class);
        paqquery.setParameter(1, nombreact);
        ActividadTuristica act = (ActividadTuristica) paqquery.getSingleResult();
        return act;
    }

    public List<String> getAllCatsdeActFromBD(String act) {
        Query query = em.createNativeQuery("SELECT nombre_categoria FROM Actividad_Categoria WHERE nombre_actividad = ?");
        query.setParameter(1, act);
        List<String> cats = query.getResultList();
        return cats;
    }

    public Categoria selectCatFromDB(String nombreact) {
        Query catquery = em.createNativeQuery("SELECT * FROM CATEGORIA WHERE NOMBRE = ?", Categoria.class);
        catquery.setParameter(1, nombreact);
        Categoria cat = (Categoria) catquery.getSingleResult();
        return cat;
    }

    public List<String> getAllPaqsdeActFromBD(String act) {
        Query query = em.createNativeQuery("SELECT Paquete_nombre FROM ActividadTuristica_Paquete WHERE Act_nombre = ?");
        query.setParameter(1, act);
        List<String> paqs = query.getResultList();
        return paqs;
    }

    public List<String> getAllSaldeActFromBD(String act) {
        Query query = em.createNativeQuery("SELECT NOMBRESALIDA FROM SALIDASTURISTICAS WHERE actividadAsociada = ?");
        query.setParameter(1, act);
        List<String> sal = query.getResultList();
        ActividadTuristica actv = selectActividad(act);

        return sal;
    }

    public SalidasTuristicas getSalidaFromBD(String nombre) {
        if (nombre == null) {
            return null;
        } else {
            return em.find(SalidasTuristicas.class, nombre);
        }
    }

    public void InscripcionPaquete(String nombreP1, String email1, float costoPaquete1, int cantidad1, LocalDate vencimiento1, LocalDate fechaCompra1) {

        System.out.println(nombreP1);
        System.out.println(vencimiento1);

        System.out.println(email1);
        Paquete ctm = getPaqFromBD(nombreP1);
        Inscripcion_paquete inspaquete = new Inscripcion_paquete(email1, costoPaquete1, cantidad1, vencimiento1, fechaCompra1);
        //String nombreP,String email,float costoPaquete,int cantidad,LocalDate vencimiento,LocalDate fechaCompra

        //inspaquete= new Inscripcion_paquete(ctm,email1,costoPaquete1,cantidad1,vencimiento1,fechaCompra1);
        Turista tur;

        tur = (Turista) getUsuarioDB(email1);
        //inspaquete.setPaquete(ctm);

        inspaquete.setPaquete(ctm);
        inspaquete.iniciarMapaInscr();

        tur.agregarInscripcionPaq(inspaquete);
        try {
            em.getTransaction().begin();
            em.persist(inspaquete);
            em.persist(ctm);
            em.getTransaction().commit();
        } catch (Exception e) {
        }

        String consultaSql = "SELECT MAX(id) FROM INSCRIPCION_PAQUETE";
        Query query = em.createNativeQuery(consultaSql);

        Object resultado = query.getSingleResult();
        String idMasAlto = resultado.toString();

        em.getTransaction().begin();

        Query query2 = em.createNativeQuery("UPDATE INSCRIPCION_PAQUETE SET p_nombre_paquete = ? WHERE ID = ?");
        query2.setParameter(1, nombreP1);
        query2.setParameter(2, idMasAlto);
        int filasActualizadas = query2.executeUpdate();

        em.getTransaction().commit();

    }

    public Paquete getPaqFromBD(String nombrePaquete) {
        Query paqquery = em.createNativeQuery("SELECT * FROM PAQUETE WHERE NOMBRE_PAQUETE = ?", Paquete.class);
        paqquery.setParameter(1, nombrePaquete);
        Paquete paq = (Paquete) paqquery.getSingleResult();
        return paq;
    }

    public List<String> getAllCatFromPaqFromBD(String paquete) {
        Query query = em.createNativeQuery("SELECT nombre_categoria FROM Paquete_Categoria WHERE nombre_paquete= ?");
        query.setParameter(1, paquete);
        List<String> estaCat = query.getResultList();
        return estaCat;
    }

    public List<String> getAllPaqsConActFromBD() {
        Query query = em.createNativeQuery("SELECT DISTINCT Paquete_nombre FROM ActividadTuristica_Paquete");
        List<String> paqs = query.getResultList();
        return paqs;
    }

    public List<String> TurConPaqFromBD(String email, String nombrepaq) {
        Query query = em.createNativeQuery("SELECT ID FROM INSCRIPCION_PAQUETE WHERE EMAIL= ? AND p_nombre_paquete= ?");
        query.setParameter(1, email);
        query.setParameter(2, nombrepaq);
        List<String> estaPaq = query.getResultList();
        return estaPaq;
    }

    public void mergeInscrPaq(Inscripcion_paquete ins) {
        em.merge(ins);
    }

    public void confirmarInscripcion(int cantTurista, double costogral, String tipo) {
        Collection<Turista> turistas = new ArrayList<>();
        turistas.add(turistaSeleccionado);

        String jpql = "SELECT MAX(ig.id) FROM Inscripcion_general ig";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        Long maxId = query.getSingleResult();

// Paso 3: Calcular el nuevo ID
        long nuevoId = 1;
        if (maxId != null) {
            nuevoId = maxId + 1;
        }

        Inscripcion_general nuevaInscripcion = new Inscripcion_general(nuevoId, cantTurista, costogral, salidaSeleccionada, turistas);
        nuevaInscripcion.setFechaCompra(alta);
        nuevaInscripcion.setTipo(tipo);
        salidaSeleccionada.agregarInscripcionGral(nuevaInscripcion);
        salidaSeleccionada.aumentarCantInscritos(cantTurista);

        for (Turista t : turistas) {
            t.agregarInscripcionGral(nuevaInscripcion);  // Llamar a la función para cada turista en la colección

        }

        try {
            em.getTransaction().begin();
            em.merge(nuevaInscripcion);

            em.merge(salidaSeleccionada);
            em.getTransaction().commit();
        } catch (Exception e) {

            //em.getTransaction().rollback();
        }

    }

    public List<String> listarPaqInscritoTurContieneAct(String mailTurista, String nombreActividad) {

        String jpql = "SELECT p.p_nombre_paquete FROM INSCRIPCION_PAQUETE as p "
                + "JOIN ActividadTuristica_Paquete as ap "
                + "WHERE ap.Act_nombre = ? "
                + "AND p.EMAIL = ? AND ap.Paquete_nombre = p.p_nombre_paquete";

        Query query = em.createNativeQuery(jpql);

        query.setParameter(1, nombreActividad);

        query.setParameter(2, mailTurista);

        List<String> paquetes = query.getResultList();

        return paquetes;

    }

    public String[] listarDepartamentos() {
        getObjectsFromDB();
        Collection<Departamento> deptos = Departamento.departamentos.values();
        String[] nombresDepto = new String[deptos.size()];
        int i = 0;
        for (Departamento d : deptos) {
            nombresDepto[i] = d.getNombreDepartamento();
            i++;
        }
        return nombresDepto;
    }

    public String[] listarActividadesConfirmadasDeptoArreglo(String depto) {
        deptoSeleccionado = Departamento.encontrarDepto(depto);

        ActividadTuristica[] actividades = deptoSeleccionado.getActividades();

        List<ActividadTuristica> actsConfirm = new ArrayList();
        dataActividades = new DataActividad[actividades.length];

        for (ActividadTuristica act : actividades) {
            if (act.getEstado() == EstadoActividad.CONFIRMADA) {
                actsConfirm.add(act);
            }
        }
        int largo = actsConfirm.size();
        String nombresActConfirm[] = new String[largo];
        for (int i = 0; i < largo; i++) {
            nombresActConfirm[i] = actsConfirm.get(i).getNombre();

        }
        return nombresActConfirm;
    }

    public DataUsuario[] getUsuarios() {
        getAllUsersFromBD();
        Usuario[] usrs = Usuario.getUsuarios();

        if (usrs != null) {
            DataUsuario[] du = new DataUsuario[usrs.length];
            Usuario usuario;

            // Para separar lógica de presentación, no se deben devolver los Usuario,
            // sino los DataUsuario
            for (int i = 0; i < usrs.length; i++) {
                usuario = usrs[i];
                du[i] = usuario.devolverData();
            }
            return du;
        } else {
            DataUsuario[] du = new DataUsuario[0];
            return du ;
        }
    }
}
