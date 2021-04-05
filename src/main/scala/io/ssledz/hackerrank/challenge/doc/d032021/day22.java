package io.ssledz.hackerrank.challenge.doc.d032021;

import io.Source;
import scala.collection.Iterator;

/**
 * Day 22: Binary Search Trees
 * https://www.hackerrank.com/challenges/30-binary-search-trees/problem
 */
public class day22 {

    public static void main(String[] args) {
        Iterator<String> lines = Source.stdin().getLines();
        int n = Integer.parseInt(lines.next());
        Node root = null;
        while (lines.hasNext()) {
            int x = Integer.parseInt(lines.next());
            root = insert(root, x);
        }

        System.out.println(getHeight(root));
    }

    public static int getHeight(Node root) {
        return getHeight(root, 0);
    }

    public static int getHeight(Node root, int acc) {
        if (root == null) {
            return acc - 1;
        }
        int h1 = getHeight(root.left, acc + 1);
        int h2 = getHeight(root.right, acc + 1);
        return Math.max(h1, h2);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
