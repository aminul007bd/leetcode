public class PeakIndexMountainArray {
    //Input: arr = [0,1,0]
    //Output: 1

    //arr[i] > arr[i+1] > ... > arr[arr.length - 1]

    public static int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }

}
