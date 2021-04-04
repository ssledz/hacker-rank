package io.ssledz.hackerrank.challenge.doc.d032021;

import java.util.stream.IntStream;

/**
 * Day 12: Inheritance
 * https://www.hackerrank.com/challenges/30-inheritance/problem
 */
public class day12 {

    class Student extends Person {
        private int[] testScores;

        /*
         *   Class Constructor
         *
         *   @param firstName - A string denoting the Person's first name.
         *   @param lastName - A string denoting the Person's last name.
         *   @param id - An integer denoting the Person's ID number.
         *   @param scores - An array of integers denoting the Person's test scores.
         */
        public Student(String firstName, String lastName, int identification, int[] testScores) {
            super(firstName, lastName, identification);
            this.testScores = testScores;
        }


        /*
         *   Method Name: calculate
         *   @return A character denoting the grade.
         */
        public char calculate() {
            for (int i = 0; i < points.length; i++) {
                double avg = IntStream.of(testScores).average().getAsDouble();
                if (avg >= points[i][0] && avg < points[i][1]) {
                    return grades[i];
                }
            }
            return 'T';
        }

        private final int[][] points = {
                {90, 101},
                {80, 90},
                {70, 80},
                {55, 70},
                {40, 55},
                {0, 40},
        };

        private final char[] grades = {
                'O',
                'E',
                'A',
                'P',
                'D',
                'T'
        };

    }

    class Person {
        protected String firstName;
        protected String lastName;
        protected int idNumber;

        // Constructor
        Person(String firstName, String lastName, int identification) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = identification;
        }

        // Print person data
        public void printPerson() {
            System.out.println(
                    "Name: " + lastName + ", " + firstName
                            + "\nID: " + idNumber);
        }

    }

}
