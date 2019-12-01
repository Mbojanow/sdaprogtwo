package pl.sdacademy.prog.zadb;

import java.util.Set;

public class MedianDemo {

  public static void main(String[] args) {

    final Set<Integer> ints = Set.of(2, 7, 5, 123, 13, 12 ,1);
    final Double median = MedianUtil.findMedian(ints);
    System.out.println(median);

    final Set<Long> longs = Set.of(2L, 7L, 5L, 123L, 13L, 12L ,1L);
    final Double longsMedian = MedianUtil.findMedian(longs);
    System.out.println(longsMedian);

    //MedianUtil.findMedian(Arrays.asList("a", "b"));
  }
}
