import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0, right = arr.length - k;

        // Binary search against teh criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if(x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // create output in correct format
        List<Integer> result = new ArrayList<>();
        for( int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
