import java.util.*;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> maxHeap, minHeap;
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        
        if(minHeap.size() > maxHeap.size()+1) {
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size() > minHeap.size()+1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int s1 = maxHeap.size();
        int s2 = minHeap.size();
        
        if(s1 == s2) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else if(s1 > s2) {
            return (double)maxHeap.peek();
        }
        return (double)minHeap.peek();
    }
}
