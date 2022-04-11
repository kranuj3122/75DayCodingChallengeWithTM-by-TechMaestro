import java.util.*;

public class CountOfSmallerAfterSelf {
    static int[] count;
    static Pair[] temp;
    
    static class Pair {
        int ind, val;
        Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }
    
    static void mergeSort(Pair[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    
    static void merge(Pair[] arr, int l, int m, int r) {
        int i=l, j=m+1;
        int k=l;
        while(i<=m && j<=r) {
            if(arr[i].val > arr[j].val) {
                count[arr[i].ind] += (r-j+1);
                temp[k] = arr[i++];
            }
            else {
                temp[k] = arr[j++];
            }
            k++;
        }
        while(i<=m) {
            temp[k++] = arr[i++];
        }
        while(j<=r) {
            temp[k++] = arr[j++];
        }
        for(i=l; i<=r; i++) {
            arr[i] = temp[i];
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        Pair[] arr = new Pair[n];
        for(int i=0; i<n; i++) {
            arr[i] = new Pair(nums[i], i);
        }
        temp = new Pair[n];
        mergeSort(arr, 0, n-1);
        List<Integer> ans = new ArrayList<>();
        for(int num: count) {
            ans.add(num);
        }
        return ans;
    }
}
