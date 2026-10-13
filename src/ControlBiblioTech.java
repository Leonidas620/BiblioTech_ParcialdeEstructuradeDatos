public class ControlBiblioTech {
    public ArrayList prestamos = new ArrayList();
    //Metodos desarrollados
    // @Emily Elena Concha Morejon inciso a
    public ArrayList<String> LibrosVencidos(int diasLimite) {
        if (diasLimite < 0) {
            throw new IllegalArgumentException("El límite de días no puede ser negativo.");
        }

        if (prestamos == null || prestamos.isEmpty()) {
            throw new IllegalStateException("No hay libros registrados en el catálogo.");
        }

        ArrayList<String> titulosVencidos = new ArrayList<>();

        for (int i = 0; i < prestamos.size(); i++) {
            Libro libro = prestamos.get(i);
            if (libro == null) {
                throw new IllegalStateException("Se encontró un libro nulo en la posición " + i + ".");
            }
            if (libro.getDiasDePrestamo() > diasLimite) {
                titulosVencidos.add(libro.getTitulo());
            }
        }

        if (titulosVencidos.isEmpty()) {
            throw new IllegalStateException("No hay libros vencidos con ese límite.");
        }

        return titulosVencidos;
    }

    // @Dario Riverol Herrera inciso b
    public int promedioDiasPorCategoria(String categoria){
        if (prestamos.isEmpty()) {
            throw new NullPointerException("La lista esta vacia");
        }
        int sumaDias = 0;
        int cantLibrosPorCategoria = 0;
        for (int i = 0; i < prestamos.size(); i++) {
            Libro o = (Libro) prestamos.get(i);
            if(categoria.equalsIgnoreCase(o.getCategoria())){
                sumaDias+=o.getDias();
                cantLibrosPorCategoria++;
            }
        }
        if (cantLibrosPorCategoria == 0) {
            throw new IllegalArgumentException("No se encontraron libros de esta categoria");
        }
        return Math.round(sumaDias / cantLibrosPorCategoria);
    }
}
//@Martha Alina Montane Arias inciso c
public boolean renovarPrestamo(String codigo, int diasAdicionales) {

    if (codigo == null || diasAdicionales <= 0) {
        return false;
    }

    for (int i = 0; i < prestamos.size(); i++) {
        Libro libro = prestamos.get(i);
        if (libro.getCodigo().equalsIgnoreCase(codigo)) {
            libro.setDiasPrestamo(libro.getDiasPrestamo() + diasAdicionales);
            return true;
        }
    }

    return false;
}


//@Cesar Paredes Real inciso d
    public int EliminarLibrosPorCategoria(String categoria) {

    if (prestamos.isEmpty()) {
        throw new IllegalStateException(
                "El catálogo está vacío. No se puede eliminar por categoría.");
    }
    if (categoria == null || categoria.trim().isEmpty()) {
        throw new IllegalArgumentException(
                "La categoría no puede ser nula ni vacía.");
    }

    int eliminados = 0;
    Iterator<Libro> it = prestamos.iterator();

    for(int i = 0, i<prestamos.size()) {
        Comparación sin distinguir mayúsculas/minúsculas
        if (prestamos.get(i).getCategoria().equalsIgnoreCase(categoria.trim())) {
            prestamos.remove(i); // Eliminación segura durante la iteración
            eliminados++;
        }
    }

    if (eliminados == 0) {
        throw new IllegalStateException(
                "No se encontraron libros de la categoría: " + categoria);
    }

    return eliminados;
}


