public class ControlBiblioTech {
    public ArrayList prestamos = new ArrayList();
    //Metodos desarrollados

    // @Dario Riverol Herrera
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


