package searching;

public class LinearSearching {
    
    public static void linearSearch(int[] arr, int target) {
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Target " + target + " found at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Target " + target + " not found in the array.");
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 7, 0, 11, 13};
        linearSearch(array, 0);
        linearSearch(array, 3);
    }
}
