package org.bcit.comp2522.winter2023.midterm_takeup.answers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Advanced_02_Tree_Iterator_Ans {
  public static class TreeNode {
    String label;
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String label, int value) {
      this.label = label;
      this.value = value;
    }
  }

  public static class PreOrderIterator implements Iterator<TreeNode> {
    private Stack<TreeNode> stack;

    public PreOrderIterator(TreeNode root) {
      stack = new Stack<>();
      if (root != null) {
        stack.push(root);
      }
    }

    @Override
    public boolean hasNext() {
      return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      TreeNode current = stack.pop();
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
      return current;
    }
  }

  public static class PostOrderIterator implements Iterator<TreeNode> {
    private Stack<TreeNode> stack;

    public PostOrderIterator(TreeNode root) {
      stack = new Stack<>();
      pushToStack(root);
    }

    private void pushToStack(TreeNode node) {
      while (node != null) {
        if (node.right != null) {
          stack.push(node.right);
        }
        stack.push(node);
        node = node.left;
      }
    }

    @Override
    public boolean hasNext() {
      return !stack.isEmpty();
    }

    @Override
    public TreeNode next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      TreeNode current = stack.pop();

      if (!stack.isEmpty() && current.right == stack.peek()) {
        TreeNode rightNode = stack.pop();
        pushToStack(rightNode);
      }

      return current;
    }
  }
}
