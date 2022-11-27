public class Main {
    public static void main(String[] args) { 

        //Inciso a
        ComparadorAscendente CompAscendente = new ComparadorAscendente();
        ListaEnlazada lista_numeros = new ListaEnlazada(CompAscendente);
        lista_numeros.addNodo(10);
        lista_numeros.addNodo(21);
        lista_numeros.addNodo(1);
        lista_numeros.addNodo(5);
        lista_numeros.addNodo(11);

        //Inciso b
        for (Nodo numero : lista_numeros) {
            System.out.println("Numero: " + numero);
        }

        //Inciso c
        System.out.println();
        lista_numeros.eliminarNodoPos(0);
        lista_numeros.eliminarNodoElement(5);
        lista_numeros.eliminarNodoElement(11);

        for (Nodo numero : lista_numeros) {
            System.out.println("Numero: " + numero);
        }

        //Inciso d
        System.out.println();
        ListaEnlazada lista_strings = new ListaEnlazada(CompAscendente);
        lista_strings.addNodo("facil");
        lista_strings.addNodo("es");
        lista_strings.addNodo("parcial");
        lista_strings.addNodo("prog 2");

        //Inciso e
        for (Nodo string : lista_strings) {
            System.out.println("String: " + string);
        }

        //Inciso f
        System.out.println();
        System.out.println("Posicion de la palabra 'parcial': " + lista_strings.getPosicionNodo("parcial"));

        //Inciso g
        System.out.println("Posicion de la palabra 'recuperatorio': " + lista_strings.getPosicionNodo("recuperatorio"));

        //inciso h
        System.out.println();
        ComparadorDescendente CompDescendente = new ComparadorDescendente();
        lista_strings.setComportamientoAdd(CompDescendente);
        for (Nodo string : lista_strings) {
            System.out.println("String: " + string);
        }

        //Inciso i
        System.out.println();
        Alumno alumno1 = new Alumno("John", "Doe", "1200000", 74);
        Alumno alumno2 = new Alumno("Federico", "Lopez", "35999888", 27);
        Alumno alumno3 = new Alumno("Juana", "Garcia", "27123455", 37);
        Alumno alumno4 = new Alumno("Mora", "Diaz", "37124425", 25);
        Alumno alumno5 = new Alumno("Flora", "Rivas", "34555111", 28);
        Alumno alumno6 = new Alumno("Martin", "Gomez", "34111222", 29);
        Alumno alumno7 = new Alumno("Roman", "Bazan", "32555111", 32);
        Grupo grupo_unicen1 = new Grupo("unicen");
        Grupo grupo_unicen2 = new Grupo("exactas");
        Grupo grupo_unicen3 = new Grupo("humanas");
        Grupo grupo_unicen4 = new Grupo("historia");

        alumno1.agregarIntereses("intercambio");

        alumno2.agregarIntereses("redes");
        alumno2.agregarIntereses("php");
        alumno2.agregarIntereses("java");
        alumno2.agregarIntereses("python");

        alumno3.agregarIntereses("programacion");
        alumno3.agregarIntereses("php");
        alumno3.agregarIntereses("java");

        alumno4.agregarIntereses("psicologia");
        alumno4.agregarIntereses("freud");

        alumno5.agregarIntereses("historia");
        alumno5.agregarIntereses("antigua");

        alumno6.agregarIntereses("romanos");
        alumno6.agregarIntereses("egipcios");
        alumno6.agregarIntereses("griegos");

        alumno7.agregarIntereses("argentina");

        grupo_unicen4.agregarElemento(alumno5);
        grupo_unicen4.agregarElemento(alumno6);
        grupo_unicen4.agregarElemento(alumno7);

        grupo_unicen3.agregarElemento(alumno4);
        grupo_unicen3.agregarElemento(grupo_unicen4);

        grupo_unicen2.agregarElemento(alumno2);
        grupo_unicen2.agregarElemento(alumno3);

        grupo_unicen1.agregarElemento(alumno1);
        grupo_unicen1.agregarElemento(grupo_unicen2);
        grupo_unicen1.agregarElemento(grupo_unicen3);

        Alumno competidor1 = new Alumno("juan", "suarez", "33222444", 32);
        Alumno competidor2 = new Alumno("julio", "cesar", "33222111", 32);
        Alumno competidor3 = new Alumno("bernardino", "rivas", "30987654", 34);
        Alumno competidor4 = new Alumno("jose", "paso", "33322112", 33);
        Alumno competidor5 = new Alumno("isaac", "newton", "12343565", 73);
        Grupo grupo_olimpiadas1 = new Grupo("olimpiadas matematicas");
        Grupo grupo_olimpiadas2 = new Grupo("matea2");
        Grupo grupo_olimpiadas3 = new Grupo("losFibo");

        competidor1.agregarIntereses("sucesiones");
        competidor1.agregarIntereses("algebra");

        competidor2.agregarIntereses("sucesiones");
        competidor2.agregarIntereses("algebra");

        competidor3.agregarIntereses("matematicas");

        competidor4.agregarIntereses("problemas");

        competidor5.agregarIntereses("sucesiones");

        grupo_olimpiadas3.agregarElemento(competidor3);
        grupo_olimpiadas3.agregarElemento(competidor4);
        grupo_olimpiadas3.agregarElemento(competidor5);

        grupo_olimpiadas2.agregarElemento(competidor1);
        grupo_olimpiadas2.agregarElemento(competidor2);

        grupo_olimpiadas1.agregarElemento(grupo_olimpiadas2);
        grupo_olimpiadas1.agregarElemento(grupo_olimpiadas3);

        ListaEnlazada lista_estructuras = new ListaEnlazada(CompDescendente);
        lista_estructuras.addNodo(grupo_olimpiadas1);
        lista_estructuras.addNodo(grupo_unicen1);
        for (Nodo estructura : lista_estructuras) {
            System.out.println("Estructura: " + estructura);
        }
    }
}