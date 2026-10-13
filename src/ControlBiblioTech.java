public class ControlBiblioTech {
    public ArrayList<Libro> prestamos;

    public ControlBiblioTech() {
        prestamos = new ArrayList<Libro>();
    }

    //Metodos desarrollados

    // @Emily Elena Concha Morejon inciso a
    public ArrayList<String> librosVencidos(int diasLimite) {
        if (diasLimite < 0) {
            throw new IllegalArgumentException("El límite de días no puede ser negativo.");
        }

        if (prestamos == null || prestamos.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<String> titulosVencidos = new ArrayList<>();

        for (int i = 0; i < prestamos.size(); i++) {
            Libro libro = prestamos.get(i);
            if (libro.getDias() > diasLimite) {
                titulosVencidos.add(libro.getNombre());
            }
        }

        if (titulosVencidos.isEmpty()) {
            return new ArrayList<>();
        }

        return titulosVencidos;
    }

    // @Dario Riverol Herrera inciso b
    public int promedioDiasPorCategoria(String categoria) {
        if (prestamos.isEmpty()) {
            throw new IllegalStateException("La lista esta vacia");
        }
        int sumaDias = 0;
        int cantLibrosPorCategoria = 0;
        for (int i = 0; i < prestamos.size(); i++) {
            Libro o = (Libro) prestamos.get(i);
            if (categoria.equalsIgnoreCase(o.getCategoria())) {
                sumaDias += o.getDias();
                cantLibrosPorCategoria++;
            }
        }
        if (cantLibrosPorCategoria == 0) {
            throw new IllegalArgumentException("No se encontraron libros de esta categoria");
        }
        return Math.round(sumaDias / cantLibrosPorCategoria);
    }

    //@Martha Alina Montane Arias inciso c
    public boolean renovarPrestamo(String codigo, int diasAdicionales) {
        if (codigo == null || diasAdicionales <= 0) {
            return false;
        }
        boolean renovar = false;
        for (int i = 0; i < prestamos.size(); i++) {
            Libro libro = prestamos.get(i);
            if (libro.getCod().equalsIgnoreCase(codigo)) {
                libro.setDias(libro.getDias() + diasAdicionales);
                renovar = true;
            }
        }
        return renovar;
    }

    //@Cesar Paredes Real inciso d
    public int EliminarLibrosPorCategoria(String categoria) {
        if (prestamos.isEmpty()) {
            return 0;
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede ser nula ni vacía.");
        }
        int eliminados = 0;

        for (int i = 0; i < prestamos.size(); i++) {
            Libro libro = prestamos.get(i);
            if (categoria.equalsIgnoreCase(libro.getCategoria())){
                prestamos.remove(i);
                eliminados++;
                i--;
            }
        }
        return eliminados;
    }

    //@Lazaro Gabriel Garcia Enriquez inciso e
    Libro buscarLibroConMAsDias(){
        if(prestamos.isEmpty()){
            throw new IllegalStateException("La lista esta vacia");
        }
        Libro mejorLibro = prestamos.get(0);
        for (int i = 1; i < prestamos.size(); i++) {
            Libro libro = prestamos.get(i);
            if (libro.getDias() > mejorLibro.getDias()) {
                mejorLibro = libro;
            }
        }
        return mejorLibro;
    }
}


