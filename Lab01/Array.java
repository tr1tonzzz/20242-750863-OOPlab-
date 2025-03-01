import java.util.Arrays;
import java.util.Scanner;
public class Array{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        if (size <= 0) {
            System.out.println("Error: Array size must be a positive number");
            scanner.close();
            return;
        }
        int[] my_array = new int[size];
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            my_array[i] = scanner.nextInt();
        }
        Arrays.sort(my_array);
        System.out.println("Sorted array: " + Arrays.toString(my_array));
        int sum = 0;
        for (int num : my_array) {
            sum += num;
        }
        System.out.println("Sum of array elements: " + sum);
        double average = (double) sum / my_array.length;
        System.out.println("Average of array elements: " + average);

    }
}