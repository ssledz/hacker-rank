package io.ssledz.hackerrank.challenge.doc.d032021;

/**
 * Day 21: Generics
 * https://www.hackerrank.com/challenges/30-generics/problem
 */
public class day21 {
    class Printer<T> {
        public void printArray(T[] xs) {
            for (T x : xs) {
                System.out.println(x);
            }
        }
    }
}
