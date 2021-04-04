package io.ssledz.hackerrank.challenge.doc.d032021;

/**
 * Day 13: Abstract Classes
 * https://www.hackerrank.com/challenges/30-abstract-classes/problem
 */
public class day13 {

    class MyBook extends Book {

        private final int price;

        MyBook(String title, String author, int price) {
            super(title, author);
            this.price = price;
        }

        @Override
        void display() {
            System.out.println(String.format("Title: %s", title));
            System.out.println(String.format("Author: %s", author));
            System.out.println(String.format("Price: %d", price));
        }
    }

    abstract class Book {
        String title;
        String author;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        abstract void display();
    }
}
