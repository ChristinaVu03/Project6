// Christina Vu
// This program implements the quick sort algorithm
import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Your Name Here
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, 0, values.length - 1, order);
}

public <T> void quickSort(T[] values, int low, int high, Comparator<? super T> order) {
    if (low < high) {
        // Partition the array, values[p..q-1] <= pivot and values[q+1..r] >= pivot
        int partitionIndex = partition(values, low, high, order);

        // Recursively sort the two halves
        quickSort(values, low, partitionIndex - 1, order);
        quickSort(values, partitionIndex + 1, high, order);
    }
}

public <T> int partition(T[] values, int low, int high, Comparator<? super T> order) {
    T pivot = values[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (order.compare(values[j], pivot) <= 0) {
            i++;

            // Swap values[i] and values[j]
            T temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
    }

    // Swap values[i+1] and values[high] (put pivot in the correct position)
    T temp = values[i + 1];
    values[i + 1] = values[high];
    values[high] = temp;

    return i + 1;
}// sort(T[], Comparator<? super T>
} // class Quicksort
