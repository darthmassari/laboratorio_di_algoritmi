package IV_Appello_2022_06_14;

import melipack.network.weighted.Network;

import java.util.Iterator;
import java.util.Map;

public class Ex2<Vertex extends Comparable<? super Vertex> & Map.Entry<Vertex, Double>> extends Network<Vertex> {

    public void transpose() {
        Iterator<Vertex> itr = adjacencyMap.keySet().iterator();
        Vertex v = itr.next();
        while (itr.hasNext()) {
            Vertex u = itr.next();
            if (containsEdge(v, u)) {
                Double weight = getEdgeWeight(v, u);
                removeEdge(v, u);
                addEdge(u, v, weight);
            }
            v = u;
        }
    }

}
