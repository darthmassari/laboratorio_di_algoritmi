package II_Parziale_2022_01_18;

import melipack.tree.binarytree.BinaryNode;

public class Ex1 {

    public static <E> void printLeafs(BinaryNode<E> root) {
        if (!root.hasLeft() && !root.hasRight()) {
            System.out.println(root.getData() + ", ");
            return;
        }
        if (root.hasLeft()) printLeafs(root.getLeft());
        if (root.hasRight()) printLeafs(root.getRight());
    }
}
