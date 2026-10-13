public class ArrayList<T> implements List<T>{
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
    public void add(T dato) {
        asegurarCapacidad();
        datos[cantidad] = dato;
        cantidad++;
    }

    @Override
    public void add(T dato, int index) {
        validarIndice(index);
        asegurarCapacidad();
        for (int i = cantidad; i > index; i--) {
            datos[i] = datos[i - 1];
        }
        datos[index] = dato;
        cantidad++;
    }

    @Override
    public T remove(int index) {
        validarIndice(index);
        Object eliminado = get(index);
        for (int i = index; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1];
        }
        datos[cantidad - 1] = null;
        cantidad--;
        return (T) eliminado;
    }

    @Override
    public T get(int index) {
        validarIndice(index);
        return (T) datos[index];
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
