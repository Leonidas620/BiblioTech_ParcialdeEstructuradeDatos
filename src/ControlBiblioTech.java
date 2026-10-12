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
