import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;


public class MyArrayList<T> implements List<T> {
    private Object[] massList;
    private int DEF_CAPACITY = 10;
    private int trueCapacity;
    private int freeSpace;
    private int size;

    public MyArrayList(int size) {
        if (size > 10){
            this.massList = new Object[size];
            trueCapacity = size;
            DEF_CAPACITY = size;
            freeSpace = size;
            this.size = 0;
        }
        else if (size >= 0 && size <= 10){
            this.massList = new Object[DEF_CAPACITY];
            trueCapacity = DEF_CAPACITY;
            freeSpace = DEF_CAPACITY;
            this.size = 0;
        }
        else throw new IllegalArgumentException("Size cannot be negative.");
    }

    public MyArrayList() {
        this.massList = new Object[DEF_CAPACITY];
        trueCapacity = DEF_CAPACITY;
        freeSpace = DEF_CAPACITY;
    }


    public boolean addAll(Collection<? extends T> c) {
        if (!sizeCheck(c.size())) rescaleMass();
        Object[] arr = c.toArray();
        for (int i = 0; i < arr.length; i++) {
            massList[size] = arr[i];
            size++;
        }
        return true;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        if (!sizeCheck(c.size())) rescaleMass();

        Object[] tmpMass = new Object[size - index];
        System.arraycopy(massList, index, tmpMass, 0, size - index);
        System.arraycopy(c.toArray(), 0, massList, index, c.size());
        size += c.size();
        System.arraycopy(tmpMass, 0, massList, size, tmpMass.length);

        return true;
    }

    public boolean sizeCheck(int size){
        return size < freeSpace;
    }

    public void rescaleMass(){
        freeSpace = trueCapacity;
        trueCapacity *= 2;
        massList = Arrays.copyOf(massList, trueCapacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(massList, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return (T)massList[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public void sort(Comparator<? super T> c) {

        Arrays.sort(massList, 0, size, (Comparator) c);

    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "massList=" + Arrays.toString(massList) +
                '}';
    }
}
