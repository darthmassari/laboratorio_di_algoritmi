package Appelli.V_Appello_2022_07_05;

import melipack.network.weighted.Network;

import java.util.Iterator;

public class Ex3<Vertex extends Comparable<? super Vertex>> extends Network<Vertex> {

    public void complete() {
        Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
        Vertex v = itr.next();
        while (itr.hasNext()) {
            Vertex u = itr.next();
            if (!containsEdge(v, u)) addEdge(v, u, 0.0);
            v = u;
        }
    }

}
