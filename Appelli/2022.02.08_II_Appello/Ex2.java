package Appelli.II_Appello_2022_02_08;

import melipack.tree.binarytree.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex2 {

    public static <E> ArrayList<E> listOfNodes(LinkedBinaryTree<E> t) {
        ArrayList<E> list = new ArrayList<>();
        Iterator<E> itr = t.iteratorLevelOrder();
        while (itr.hasNext()) {
            list.add(itr.next());
        }
        return list;
    }
}
