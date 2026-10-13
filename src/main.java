public class main {

    public static void main(String[] args) {
        System.out.println("=== PRUEBAS BIBLIOTECH - EQUIPO 4 ===");

        ControlBiblioTech control = new ControlBiblioTech();

        // Datos sugeridos
        control.prestamos.add(new Libro("L01", "Java a Fondo", 15, "Ingeniería"));
        control.prestamos.add(new Libro("L02", "Cien Años de Soledad", 8, "Literatura"));
        control.prestamos.add(new Libro("L03", "Estructuras de Datos", 22, "Ingeniería"));
        control.prestamos.add(new Libro("L04", "Breve Historia Universal", 30, "Historia"));

        System.out.println("Libros cargados: " + control.prestamos.size());

        // ==========================
        // CASOS POSITIVOS
        // ==========================
        System.out.println("\n--- CASOS POSITIVOS ---");

        // a) librosVencidos
        ArrayList<String> vencidos = control.librosVencidos(10);
        imprimirLista("a) Libros vencidos con límite 10", vencidos);

        // b) promedioDiasPorCategoria
        int promedioIngenieria = control.promedioDiasPorCategoria("Ingeniería");
        System.out.println("b) Promedio días Ingeniería: " + promedioIngenieria
                + " (esperado 18 por división entera: (15+22)/2)");

        // c) renovarPrestamo
        boolean renovado = control.renovarPrestamo("L02", 5);
        Libro libroRenovado = buscarPorCodigo(control, "L02");
        System.out.println("c) Renovar L02 +5 días: " + renovado
                + " -> nuevos días: " + libroRenovado.getDias());

        // e) buscarLibroConMasDias antes de eliminar
        Libro masDias = control.buscarLibroConMAsDias();
        System.out.println("e) Libro con más días: "
                + masDias.getNombre() + " (" + masDias.getDias() + " días)");

        // d) EliminarLibrosPorCategoria
        int eliminados = control.EliminarLibrosPorCategoria("Historia");
        System.out.println("d) Libros eliminados de Historia: " + eliminados
                + " -> tamaño actual: " + control.prestamos.size());

        // e) buscarLibroConMasDias después de eliminar
        Libro masDiasDespues = control.buscarLibroConMAsDias();
        System.out.println("e) Libro con más días tras eliminar Historia: "
                + masDiasDespues.getNombre() + " (" + masDiasDespues.getDias() + " días)");

        // ==========================
        // CASOS NEGATIVOS
        // ==========================
        System.out.println("\n--- CASOS NEGATIVOS ---");

        // a) días límite negativo
        try {
            control.librosVencidos(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("a) OK excepción: " + e.getMessage());
        }

        // b) categoría inexistente
        try {
            control.promedioDiasPorCategoria("NoExiste");
        } catch (IllegalArgumentException e) {
            System.out.println("b) OK excepción: " + e.getMessage());
        }

        // c) código inexistente
        boolean renovadoInexistente = control.renovarPrestamo("L99", 3);
        System.out.println("c) Renovar código inexistente L99: " + renovadoInexistente);

        // c) código nulo
        boolean renovadoNulo = control.renovarPrestamo(null, 3);
        System.out.println("c) Renovar código null: " + renovadoNulo);

        // d) categoría nula
        try {
            control.EliminarLibrosPorCategoria(null);
        } catch (IllegalArgumentException e) {
            System.out.println("d) OK excepción: " + e.getMessage());
        }

        // b) lista vacía en promedio
        ControlBiblioTech vacio = new ControlBiblioTech();
        try {
            vacio.promedioDiasPorCategoria("Ingeniería");
        } catch (IllegalStateException e) {
            System.out.println("b) Lista vacía: " + e.getMessage());
        }

        // e) lista vacía en buscarLibroConMAsDias
        try {
            vacio.buscarLibroConMAsDias();
        } catch (Exception e) {
            System.out.println("e) Lista vacía: " + e.getClass().getSimpleName()
                    + " - " + e.getMessage());
        }

        // a) lista vacía en librosVencidos: no lanza excepción, retorna lista vacía
        ArrayList<String> vencidosVacio = vacio.librosVencidos(10);
        System.out.println("a) librosVencidos en lista vacía, tamaño: " + vencidosVacio.size());

        // ==========================
        // PRUEBAS EXTRA SOBRE ArrayList
        // ==========================
        System.out.println("\n--- PRUEBAS EXTRA ArrayList ---");

        ArrayList<String> lista = new ArrayList<>();

        try {
            lista.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ArrayList get(0) en lista vacía: " + e.getMessage());
        }

        lista.add("A");
        lista.add("B");

        try {
            lista.remove(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ArrayList remove(5) inválido: " + e.getMessage());
        }

        try {
            lista.add("C", 5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ArrayList add(C, 5) inválido: " + e.getMessage());
        }

        System.out.println("\n=== FIN DE PRUEBAS ===");
    }

    // Método auxiliar para buscar un libro por código
    static Libro buscarPorCodigo(ControlBiblioTech control, String codigo) {
        for (int i = 0; i < control.prestamos.size(); i++) {
            Libro libro = control.prestamos.get(i);
            if (libro.getCod().equalsIgnoreCase(codigo)) {
                return libro;
            }
        }
        return null;
    }

    // Método auxiliar para imprimir listas de Strings
    static void imprimirLista(String titulo, List<String> lista) {
        System.out.print(titulo + ": [");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
            if (i < lista.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
