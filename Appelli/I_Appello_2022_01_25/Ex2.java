package Appelli.I_Appello_2022_01_25;

import melipack.tree.binarytree.BinaryNode;

public class Ex2 {
    public static <E> void printLeafs(BinaryNode<E> root) {
        if (!(root.hasLeft() && root.hasRight())) {
            System.out.println(root.getData() + ", ");
            return;
        }
        if (root.hasRight()) printLeafs(root.getRight());
        if (root.hasLeft()) printLeafs(root.getLeft());
    }
}
