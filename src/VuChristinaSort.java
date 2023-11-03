//Author: Christina Vu
//This program combines ideas from TimSort, particularly the concept of a "minRun," with a stable insertion sort for small subarrays. 
import java.util.Arrays;
import java.util.Comparator;

public class VuChristinaSort implements Sorter {
    
    public static final int MIN_MERGE = 32;
    
    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        int length = values.length;
        
        if (length < MIN_MERGE) {
            insertionSort(values, order, 0, length);
            return;
        }
        
        // Determine the best size for merging
        int minRun = minRunLength(length);
        
        for (int i = 0; i < length; i += minRun) {
            int end = Math.min(i + minRun, length);
            insertionSort(values, order, i, end);
        }
        
        // Merge runs using a stack to maintain stability
        for (int size = minRun; size < length; size *= 2) {
            for (int left = 0; left < length; left += 2 * size) {
                int mid = left + size;
                int right = Math.min(left + 2 * size, length);
                merge(values, order, left, mid, right);
            }
        }
    }
    
    public <T> void insertionSort(T[] values, Comparator<? super T> order, int left, int right) {
        for (int i = left + 1; i < right; i++) {
            T key = values[i];
            int j = i - 1;
            
            while (j >= left && order.compare(values[j], key) > 0) {
                values[j + 1] = values[j];
                j--;
            }
            
            values[j + 1] = key;
        }
    }
    
    public <T> void merge(T[] values, Comparator<? super T> order, int left, int mid, int right) {
        int len1 = mid - left;
        int len2 = right - mid;
        
        T[] leftArray = Arrays.copyOfRange(values, left, mid);
        T[] rightArray = Arrays.copyOfRange(values, mid, right);
        
        int i = 0, j = 0, k = left;
        
        while (i < len1 && j < len2) {
            if (order.compare(leftArray[i], rightArray[j]) <= 0) {
                values[k++] = leftArray[i++];
            } else {
                values[k++] = rightArray[j++];
            }
        }
        
        while (i < len1) {
            values[k++] = leftArray[i++];
        }
        
        while (j < len2) {
            values[k++] = rightArray[j++];
        }
    }
    
    public int minRunLength(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
}

//Work Cited: ChatGPT
