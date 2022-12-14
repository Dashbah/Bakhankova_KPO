public class IntegerList implements IntegerListInterface {
    private int[] arr;
    private int size;
    private int capacity = 16;

    public IntegerList() {
        arr = new int[16];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Integer)) {
            throw new ClassCastException();
        }
        int val = (int) o;
        for (int i = 0; i < size; ++i) {
            if (arr[i] == val) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public void add(int index, Integer element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (size == capacity) {
            capacity *= 2;
            var newArray = new int[capacity];
            if (size >= 0) {
                System.arraycopy(arr, 0, newArray, 0, size);
            }
            arr = newArray;
        }

        for (int i = size; i > index; --i) {
            arr[i] = arr[i-1];
        }
        arr[index] = element;

        ++size;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        var removedElement = arr[index];
        for (int i = index; i < size - 1; ++i) {
            arr[i] = arr[i + 1];
        }
        --size;
        return removedElement;
    }

    @Override
    public int indexOf(Integer o) {
        for (var i = 0; i < size; ++i) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean add(Integer e) {
        add(size, e);
        return true;
    }

    @Override
    public boolean remove(Integer o) {
        var index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }
}
