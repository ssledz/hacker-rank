package io.ssledz.hackerrank.challenge.doc.d032021;

import io.Source;
import scala.collection.Iterator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Day 23: BST Level-Order Traversal
 * https://www.hackerrank.com/challenges/30-binary-trees/problem
 */
public class day23 {

    public static void main(String[] args) {
        Iterator<String> lines = Source.stdin().getLines();
        int n = Integer.parseInt(lines.next());
        Node root = null;
        while (lines.hasNext()) {
            int x = Integer.parseInt(lines.next());
            root = insert(root, x);
        }

        levelOrder(root);
    }

    static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data);
            System.out.print(" ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
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
