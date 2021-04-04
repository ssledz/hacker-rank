package io.ssledz.hackerrank.challenge.doc.d032021;

/**
 * Day 14: Scope
 * https://www.hackerrank.com/challenges/30-scope/problem
 */
public class day14 {
    class Difference {
        private int[] elements;
        public int maximumDifference;

        public Difference(int[] elements) {
            this.elements = elements;
        }

        public void computeDifference() {
            int max = java.util.stream.IntStream.of(elements).max().getAsInt();
            int min = java.util.stream.IntStream.of(elements).min().getAsInt();
            maximumDifference = Math.abs(max - min);
        }
    }

}
