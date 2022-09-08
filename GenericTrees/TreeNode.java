package GenericTrees;

import LinkedList.Node;

import java.util.ArrayList;

public class TreeNode<T> extends Node<Integer> {

    T data;
    ArrayList<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<TreeNode<T>>();
    }
}
