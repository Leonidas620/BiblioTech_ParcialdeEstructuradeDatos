public class Libro {
    private String cod;
    private String nombre;
    private String categoria;
    private int dias;

    public Libro(String cod, String nombre, int dias, String categoria) {
        this.cod = cod;
        this.nombre = nombre;
        this.dias = dias;
        this.categoria=categoria;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
