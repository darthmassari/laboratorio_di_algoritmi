package Appelli.III_Appello_2022_02_22;

import melipack.tree.binarytree.BinaryNode;

public class Ex2 {
    public static <T extends Comparable<? super T>> boolean isAscending(BinaryNode<T> root) {
        if (root.hasLeft()) {
            if (root.getData().compareTo(root.getLeft().getData()) > 0)
                return false;
            isAscending(root.getLeft());
        }
        if (root.hasRight()) {
            if (root.getData().compareTo(root.getRight().getData()) > 0)
                return false;
            isAscending(root.getRight());
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryNode<Integer> root = new BinaryNode<>(1);
        BinaryNode<Integer> rootLeft = new BinaryNode<>(2);
        BinaryNode<Integer> rootRight = new BinaryNode<>(3);

        root.setLeft(rootLeft);
        root.setRight(rootRight);
        System.out.println(isAscending(root));
    }
}
