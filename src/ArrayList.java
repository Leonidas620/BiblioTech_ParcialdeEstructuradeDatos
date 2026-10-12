public class ArrayList implements List{
    private Object[] datos;
    private int cantidad;

    public ArrayList() {
        datos = new Object[10];
        cantidad = 0;
    }

    private void asegurarCapacidad() {
        if (cantidad == datos.length) {
            Object[] nuevo = new Object[datos.length * 2];
            for (int i = 0; i < datos.length; i++) {
                nuevo[i] = datos[i];
            }
            datos = nuevo;
        }
    }

    private void validarIndice(int indice) {
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException(
                    "Índice fuera de rango: " + indice + " (tamaño actual: " + cantidad + ")");
        }
    }

    @Override
    public void add(Object dato) {
        asegurarCapacidad();
        datos[cantidad] = dato;
        cantidad++;
    }

    @Override
    public void add(Object dato, int index) {
        validarIndice(index);
        datos[index] = dato;
    }

    @Override
    public Object remove(int index) {
        validarIndice(index);
        Object eliminado = get(index);
        for (int i = index; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1];
        }
        datos[cantidad - 1] = null;
        cantidad--;
        return eliminado;
    }

    @Override
    public Object get(int index) {
        validarIndice(index);
        return datos[index];
    }

    @Override
    public int size() {
        return cantidad;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return cantidad == 0;
    }
}
