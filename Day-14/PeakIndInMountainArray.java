
public class PeakIndInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while(i < j) {
            int mid = (i+j)/2;
            if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid]) {
                return mid;
            }
            else if(arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1]) {
                i = mid;
            }
            else {
                j = mid;
            }
        }
        return -1;
    }
}
