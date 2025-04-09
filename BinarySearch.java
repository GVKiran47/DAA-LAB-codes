import java.util.Arrays;

public class BinarySearch {
    public static boolean searcher(int[] arr, int low, int high, int element) {

        if (low > high) {

            return false;
        }


        int mid = (low + high) / 2;

        if (arr[mid] == element) {
            return true;
        } else if (element < arr[mid]) {
            return searcher(arr, low, mid - 1, element);
        } else {
            return searcher(arr, mid + 1, high, element);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, -8, 7, 4, 3, 22, 1};
        Arrays.sort(arr);
        int element = 4;
        System.out.println(searcher(arr, 0, arr.length - 1, element));
    }
}
