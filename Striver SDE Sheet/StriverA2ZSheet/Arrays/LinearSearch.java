package Arrays;

// Linear Search
public class LinearSearch {

    // Swaps two elements in the array  //Array is call by reference 
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Performs a linear search and swaps the found element with the first element
    public static int linearSearch(int[] numbers, int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                swap(numbers, i, 0); // Swap the found element with the first element
                return i;
            }
        }
        return -1; // Key not found
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 8;

        int index = linearSearch(numbers, key);

        // Print the array after swapping
        for (int number : numbers) {
            System.out.print(" " + number);
        }

        // Print the result of the search
        if (index == -1) {
            System.out.println("\nNot Found");
        } else {
            System.out.println("\nKey is at index: " + index);
        }
    }
}
