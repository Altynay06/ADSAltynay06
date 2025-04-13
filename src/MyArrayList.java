public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    public void add(T item) {
        if (size == array.length) {
            resize();
        }
        array[size++] = item;
    }

    public T get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        return (T) array[index];
    }

    public T remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        T removed = (T) array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removed;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}