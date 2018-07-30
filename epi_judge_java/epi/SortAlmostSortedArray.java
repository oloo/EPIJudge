package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.Iterator;
import java.util.*;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {

  public static List<Integer>
  sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
    // TODO - you fill in here.
    List<Integer> values = new ArrayList<Integer>();
    PriorityQueue<Integer> heap = new PriorityQueue<>(k);
    for(int index=0; index < k; index++) {
        if (sequence.hasNext()) {
		heap.add(sequence.next());
	}
    }

    while(sequence.hasNext()) {
	heap.add(sequence.next());
        values.add(heap.poll());
    }

    while(heap.size() > 0) {
        values.add(heap.poll());
    }
  
  return values;
  }
  @EpiTest(testDataFile = "sort_almost_sorted_array.tsv")
  public static List<Integer>
  sortApproximatelySortedDataWrapper(List<Integer> sequence, int k) {
    return sortApproximatelySortedData(sequence.iterator(), k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortAlmostSortedArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
