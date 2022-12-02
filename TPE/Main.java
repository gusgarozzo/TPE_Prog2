

public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> listaNumeros = new ListaEnlazada<>();

        System.out.println("//--------------------INCISO A--------------------");
        listaNumeros.agregar(new Node<>(10));
        listaNumeros.agregar(new Node<>(21));
        listaNumeros.agregar(new Node<>(1));
        listaNumeros.agregar(new Node<>(5));
        listaNumeros.agregar(new Node<>(11));

        System.out.println("--------------------INCISO B--------------------");
        for(Object elem : listaNumeros){
            System.out.println(elem);
        }

        System.out.println("--------------------INCISO C--------------------");
        listaNumeros.eliminarNodo(0);
        listaNumeros.eliminarNodo(new Node<>(5));
        listaNumeros.eliminarNodo(new Node<>(11));

        for(Object elem : listaNumeros){
            System.out.println(elem);
        }
//--------------------INCISO D--------------------
        ListaEnlazada<String> listaPalabras = new ListaEnlazada<>();
        listaPalabras.agregar(new Node<>("Facil"));
        listaPalabras.agregar(new Node<>("Es"));
        listaPalabras.agregar(new Node<>("Parcial"));
        listaPalabras.agregar(new Node<>("Prog 2"));

        System.out.println("--------------------INCISO E--------------------");
        for(Object elem : listaPalabras){
            System.out.println(elem);
        }

        System.out.println("--------------------INCISO F--------------------");
        System.out.println(listaPalabras.obtenerValorPorPos(new Node<>("Parcial")));

        System.out.println("--------------------INCISO G--------------------");
        System.out.println(listaPalabras.obtenerValorPorPos(new Node<>("Recuperatorio")));

        System.out.println("--------------------INCISO H--------------------");
        listaPalabras.setorden(new OrdenDescendete<>());

        for(Object elem : listaPalabras){
            System.out.println(elem);
        }

        System.out.println("--------------------INCISO I--------------------");

        Alumno flora = new Alumno("Flora", "Rivas", 34555111, 18);
        flora.addIntereses("historia");
        flora.addIntereses("antigua");

        Alumno martin = new Alumno("Martin", "Gomez", 34111222, 18);
        martin.addIntereses("romanos");
        martin.addIntereses("egipcios");
        martin.addIntereses("griegos");

        Alumno roman = new Alumno("Roman", "Bazan", 32555111, 18);
        roman.addIntereses("argentina");

        Alumno jhon = new Alumno("Jhon", "Doe", 12000000, 18);
        jhon.addIntereses("intercambio");

        Alumno mora = new Alumno("Mora", "Diaz", 37124425, 18);
        mora.addIntereses("psicologia");
        mora.addIntereses("Freud");

        Alumno juana = new Alumno("Juana", "Garcia", 27123455, 18);
        juana.addIntereses("programacion");
        juana.addIntereses("php");
        juana.addIntereses("java");

        Alumno federico = new Alumno("Federico", "Lopez", 35999888, 18);
        federico.addIntereses("redes");
        federico.addIntereses("php");
        federico.addIntereses("java");
        federico.addIntereses("Python");

        GrupoFacultad unicen = new GrupoFacultad("unicen");
        GrupoFacultad humanas = new GrupoFacultad("humanas");
        GrupoFacultad exactas = new GrupoFacultad("exactas");
        GrupoFacultad historia = new GrupoFacultad("Historia");

        exactas.addElemento(federico);
        exactas.addElemento(juana);

        historia.addElemento(flora);
        historia.addElemento(martin);
        historia.addElemento(roman);

        humanas.addElemento(mora);
        humanas.addElemento(historia);

        unicen.addElemento(jhon);
        unicen.addElemento(humanas);
        unicen.addElemento(exactas);

        System.out.println("----------------------------------------");
        System.out.println(unicen);

        GrupoFacultad olimpiadasMatematicas = new GrupoFacultad("Olimpiadas Matematicas");
        GrupoFacultad matea2 = new GrupoFacultad("Matea2");
        GrupoFacultad losFibo = new GrupoFacultad("LosFibo");

        Alumno juan = new Alumno("Juan", "Juarez", 33222444, 18);
        jhon.addIntereses("sucesiones");
        jhon.addIntereses("álgebra");

        Alumno julio = new Alumno("Julio", "Cesar", 33222111, 18);
        jhon.addIntereses("sucesiones");
        jhon.addIntereses("algebra");

        Alumno bernardino = new Alumno("Bernardino", "Rivas", 30987654, 18);
        jhon.addIntereses("matemáticas");

        Alumno jose = new Alumno("José", "Paso", 33322112, 18);
        jhon.addIntereses("problemas");

        Alumno isaac = new Alumno("Isaac", "Newton", 12343565, 18);
        jhon.addIntereses("sucesiones");

        losFibo.addElemento(bernardino);
        losFibo.addElemento(jose);
        losFibo.addElemento(isaac);

        matea2.addElemento(juan);
        matea2.addElemento(julio);

        olimpiadasMatematicas.addElemento(matea2);
        olimpiadasMatematicas.addElemento(losFibo);

        System.out.println("----------------------------------------");
        System.out.println(olimpiadasMatematicas);
    }
}