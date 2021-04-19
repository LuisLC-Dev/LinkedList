package uaslp.ingenieria.labs.list;

public interface List<T> {

    void add(T data);

    public T get(int index);

    public void delete(int index);

    public int getSize();
}
