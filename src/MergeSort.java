import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {19 ,65 ,23, 3, 1, 4, 2, 5, 9, 15};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {

        // base case, if array is less than 2, it's already sorted
        if (arr.length < 2) {
            return;
        }
        // find the middle index of the array
        int middle = arr.length / 2;

        // split the array in half
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        // recursively sort the left and right arrays
        mergeSort(left);
        mergeSort(right);

        // merge the sorted left and right arrays back into the original array
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {

        int i = 0, j = 0, k = 0;

        // while there are still elements in both arrays
        while (i < left.length && j < right.length) {

            // add the smaller element to the final array
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        // add any remaining elements from the left array
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        // add any remaining elements from the right array
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
