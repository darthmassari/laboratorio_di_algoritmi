package Appelli.V_Appello_2022_07_05;

import melipack.tree.binarytree.BinaryNode;

public class Ex2 {

    private static int count = 0;

    public static <E> int countInternalNodes(BinaryNode<E> root) {
        if (root != null && (root.hasLeft() || root.hasRight())) {
            count++;
            countInternalNodes(root.getLeft());
            countInternalNodes(root.getRight());
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> rootLeft = new BinaryNode<>(2);
        BinaryNode<Integer> rootRight = new BinaryNode<>(3);
        BinaryNode<Integer> rootLeftLeft = new BinaryNode<>(4);
        BinaryNode<Integer> rootLeftRight = new BinaryNode<>(5);

        root.setLeft(rootLeft);
        root.setRight(rootRight);
        root.getLeft().setLeft(rootLeftLeft);
        root.getLeft().setRight(rootLeftRight);
        System.out.println(countInternalNodes(root));
    }
}
