package io.ssledz.hackerrank.challenge.doc.d032021;

/**
 * Day 19: Interfaces
 * https://www.hackerrank.com/challenges/30-interfaces/problem
 */
public class day19 {

    public static void main(String[] args) {

        Calculator c = new Calculator();
        System.out.println(c.divisorSum(25));
        System.out.println(c.divisorSum(20));
    }

    interface AdvancedArithmetic {
        int divisorSum(int n);
    }

    static class Calculator implements AdvancedArithmetic {
        public int divisorSum(int n) {
            int sum = n;
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    sum = sum + i;
                }
            }
            return sum;
        }
    }

}
