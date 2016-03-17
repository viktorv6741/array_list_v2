package v2;

import java.util.Arrays;

public class MyArray<T extends Number> implements Comparable<MyArray> {

    private static final int CAPACITY = 1;
    private T[] array;
    private int currentPosition;

    //Constructors
/////////////////////////////////////////////////////////////////////

    public MyArray() {
        this.array = (T[]) new Number[CAPACITY];
        this.currentPosition = 0;
    }

    //Getters and Setters
/////////////////////////////////////////////////////////////////////

    public T[] getArray() {
        return array;
    }

/////////////////////////////////////////////////////////////////////

    public void add(T newElement) {
        if (currentPosition >= array.length) {
            array = Arrays.copyOf(array, array.length + CAPACITY);
        }
        array[currentPosition++] = newElement;
    }

    public void remove(int index) {
        try {
            int copyLength = array.length - index - 1;
            System.arraycopy(array, index + 1, array, index, copyLength);
            array[array.length - 1] = null;
            currentPosition--;
        } catch (RuntimeException e) {
            System.out.println("Not appropriate action\n");
        }
    }

    public void trimToSize() {
        array = Arrays.copyOf(array, currentPosition);
    }

    public void sort() {
        Arrays.sort(array);
    }

    public void addCollection(MyArray myArray) {
        int newLength = array.length + myArray.getArray().length;

        array = Arrays.copyOf(array, newLength);

        System.arraycopy(myArray.getArray(), 0, array, currentPosition, currentPosition);
        currentPosition = newLength;
    }

    //getMin & getMax
/////////////////////////////////////////////////////////////////////

    public <T extends Comparable> T getMin() {
        T min = (T) array[0];
        for (int i = 0; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = (T) array[i];
            }
        }
        return min;
    }

    public <T extends Comparable> T getMax() {
        T max = (T) array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = (T) array[i];
            }
        }
        return max;
    }

    //BinarySearch
/////////////////////////////////////////////////////////////////////

    public <T extends Comparable> int binarySearchIterative(T keyElement) {

        Arrays.sort(array);

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (keyElement == array[mid]) {
                return mid;
            } else if (keyElement.compareTo(array[mid]) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

/////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public int compareTo(MyArray o) {
        return 0;
    }
}
