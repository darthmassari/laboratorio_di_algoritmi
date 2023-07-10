package V_Appello_2022_07_05;

import melipack.network.weighted.Network;

import java.util.Map;

public class Ex3<Vertex extends Comparable<? super Vertex>> extends Network<Vertex> {

    public void complete() {
        for (Vertex v : adjacencyMap.keySet()) {
            for (Map.Entry<Vertex, Double> entry : adjacencyMap.get(v).entrySet()) {
                if (!containsEdge(v, entry.getKey())) addEdge(v, entry.getKey(), 0.0);
            }
        }
    }

}
