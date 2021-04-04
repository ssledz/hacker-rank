package io.ssledz.hackerrank.challenge.doc.d032021;

/**
 * Day 16: Exceptions - String to Integer
 * https://www.hackerrank.com/challenges/30-exceptions-string-to-integer/problem
 */
public class day16 {

    public static void printInt(String s) {
        try {
            System.out.println(Integer.parseInt(s));
        } catch (Exception e) {
            System.out.println("Bad String");
        }
    }
}
