import java.util.*;
public class MergeSort {
    public void divide(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        divide(arr, low, mid);
        divide(arr, mid + 1, high);
        mergeSort(arr, low, mid, high);
    }

    public void mergeSort(int[] arr, int low, int mid, int high) {
        int[] tempArray = new int[high - low + 1];
        int index = 0;
        int left = low;
        int right = mid + 1;

        // Merge the two halves into tempArray
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tempArray[index] = arr[left];
                left++;
            } else {
                tempArray[index] = arr[right];
                right++;
            }
            index++;
        }

        while (left <= mid) {
            tempArray[index] = arr[left];
            left++;
            index++;
        }

        while (right <= high) {
            tempArray[index] = arr[right];
            right++;
            index++;
        }

        // Copy sorted elements back into the original array
        for (int i = 0; i < tempArray.length; i++) {
            arr[low+ i] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] arr = {9, 5,7,3};

        ms.divide(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }
}
