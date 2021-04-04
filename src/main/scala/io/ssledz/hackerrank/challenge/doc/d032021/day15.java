package io.ssledz.hackerrank.challenge.doc.d032021;

/**
 * Day 15: Linked List
 * https://www.hackerrank.com/challenges/30-linked-list/problem
 */
public class day15 {

    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 1);
        insert(head, 2);
        insert(head, 3);
        insert(head, 4);
        display(head);
    }

    public static Node insert(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(data);
        return head;
    }

    public static void display(Node head) {
        Node start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}
