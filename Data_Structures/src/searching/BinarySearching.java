package searching;
import java.util.Arrays;

public class BinarySearching {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } 
            else if (arr[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 2};
        Arrays.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        int target = 3;
        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}