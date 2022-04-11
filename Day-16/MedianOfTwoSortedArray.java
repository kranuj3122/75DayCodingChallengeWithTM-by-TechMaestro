
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m==0 && n==0) {
            return 0.0;
        }
        int count = (m+n)/2 + 1;
        int curr=0, prev=0;
        int i=0, j=0;
        boolean stop = false;
        while(i<m && j<n) {
            prev = curr;
            if(nums1[i] <= nums2[j]) {
                curr = nums1[i++];
            }
            else {
                curr = nums2[j++];
            }
            count--;
            if(count==0) {
                stop = true;
                break;
            }
        }
        while(!stop && i<m) {
            prev = curr;
            curr = nums1[i++];
            count--;
            if(count == 0) {
                break;
            }
        }
        while(!stop && j<n) {
            prev = curr;
            curr = nums2[j++];
            count--;
            if(count == 0) {
                break;
            }
        }
        if((m+n)%2 == 1) {
            return (double)curr;
        }
        
        return (double)(prev+curr)/2.0;
    }
}
