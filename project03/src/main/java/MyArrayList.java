import java.util.*;

public class MyArrayList<T> implements List<T> {
    private Object[] mass;
    private int def_capacity = 10;
    private int freeSpace;
    private int size;

    public MyArrayList(int size) {
        if (size > 10){
            this.mass = new Object[size];
            def_capacity = size;
            freeSpace = size;
            this.size = 0;
        }
        else if (size >= 0 && size <= 10){
            this.mass = new Object[def_capacity];
            freeSpace = def_capacity;
            this.size = 0;
        }
        else throw new IllegalArgumentException("Size cannot be negative.");
    }

    public MyArrayList() {
        this.mass = new Object[def_capacity];
        freeSpace = def_capacity;
    }


    public boolean addAll(Collection<? extends T> c) {
        if (!sizeCheck(c.size())) rescaleMass();
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            mass[size] = arr[i];
            size++;
        }
        freeSpace -= c.size();
        return true;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        if (!sizeCheck(c.size())) rescaleMass();
        Object[] tmpMass = new Object[size - index];
        System.arraycopy(mass, index, tmpMass, 0, size - index);
        System.arraycopy(c.toArray(), 0, mass, index, c.size());
        size += c.size();
        System.arraycopy(tmpMass, 0, mass, size, tmpMass.length);
        freeSpace -= c.size();
        return true;
    }

    public boolean sizeCheck(int size){
        return size < freeSpace;
    }

    public void rescaleMass(){
        freeSpace = mass.length;
        mass = Arrays.copyOf(mass, mass.length*2);
    }

    @Override
    public T get(int index) {
        return (T) mass[index];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(mass, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MassIterator(0);
    }

    @Override
    public boolean add(T t) {
        if (!sizeCheck(1)) rescaleMass();
        mass[size] = t;
        size++;
        freeSpace--;
        return true;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("listIterator with index method");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("isEmpty method");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("contains method");
    }



    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("remove method");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("containsAll method");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("removeAll method");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll method");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("clear method");
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException("set method");
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException("void add method method");
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("remove method");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("indexOf method");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("lastIndexOf method");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("subList method");
    }

    @Override
    public void sort(Comparator<? super T> c) {
        Arrays.sort(mass, 0, size, (Comparator) c);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ArrayList [");

        for (int i = 0; i < size; i++) {
            if (i == size-1){
                builder.append(mass[i] + "]");
                return builder.toString();
            }
            builder.append(mass[i] + ", ");
        }
        return builder.toString();
    }

    private class MassIterator implements ListIterator<T>{
        private T element;
        private int index;
        private int lastMod = -1;

        public MassIterator(int index) {
            this.index = index;
        }

        @Override
        public void remove() {
            if (lastMod == -1) throw new IllegalStateException("U need to next() smth");
            System.arraycopy(mass, lastMod + 1, mass, lastMod, size - (lastMod + 1));
            freeSpace += 1;
        }

        @Override
        public boolean hasNext() {
            if (index >= size || index < -1) throw new NoSuchElementException("Wrong element index");
            return mass[index + 1] != null;
        }

        @Override
        public boolean hasPrevious() {
            return mass[index - 1] != null;
        }

        @Override
        public T next() {
            if (index >= size || index < -1) throw new NoSuchElementException("Wrong element index");
            element = (T) mass[index];
            lastMod = index;
            index++;
            return element;
        }

        @Override
        public T previous() {
            if (index >= size || index < -1) throw new NoSuchElementException("Wrong element index");
            index--;
            lastMod = index;
            element = (T) mass[index];
            return element;
        }

        @Override
        public int nextIndex() {
            if (index >= size || index < -1) throw new NoSuchElementException("Wrong element index");
            return index;
        }

        @Override
        public int previousIndex() {
            if (index <= -1) return -1;
            return index - 1;
        }

        @Override
        public void set(T t) {
            if (index >= size || index < -1) throw new NoSuchElementException("Wrong element index");
            mass[index] = t;
        }

        @Override
        public void add(T t) {

        }
    }


}
