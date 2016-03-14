package v2;

public class TestArray {
    public static void main(String[] args) {

        MyArray<Integer> myArray = new MyArray();

        myArray.add(3);
        myArray.add(5);
        myArray.add(1);
        myArray.add(3);

        System.out.println(myArray);

        printArray(myArray.getArray());

        System.out.println(myArray.getMin());
        System.out.println(myArray.getMax());


        myArray.sort();

        myArray.addCollection(myArray);

        System.out.println(myArray);

        myArray.add(435);

        System.out.println(myArray);


    }

    public static <T> void printArray(T[] array) {
        for (T value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
