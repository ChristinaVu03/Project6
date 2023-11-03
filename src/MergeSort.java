//Christina Vu
//This program implements the merge sort algorithm
import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Your Name Here
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
        mergeSort(values, order);
    }

    private <T> void mergeSort(T[] values, Comparator<? super T> order) {
        int n = values.length;

        if (n > 1) {
            int mid = n / 2;

            // Split the array into two halves
            T[] left = Arrays.copyOfRange(values, 0, mid);
            T[] right = Arrays.copyOfRange(values, mid, n);

            // Recursively sort each half
            mergeSort(left, order);
            mergeSort(right, order);

            // Merge the sorted halves
            merge(values, left, right, order);
        }
    }

    private <T> void merge(T[] values, T[] left, T[] right, Comparator<? super T> order) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (order.compare(left[i], right[j]) <= 0) {
                values[k++] = left[i++];
            } else {
                values[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < left.length) {
            values[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < right.length) {
            values[k++] = right[j++];
        }
    } // 
} // class MergeSort
