public interface List <T>{
  void add(T dato);
  void add(T dato, int index);
  T remove(int index);
  T get(int index);
  int size();
  void clear();
  boolean isEmpty();
}
