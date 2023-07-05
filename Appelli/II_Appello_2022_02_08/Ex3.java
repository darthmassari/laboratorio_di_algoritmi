package Appelli.II_Appello_2022_02_08;

import melipack.network.weighted.Network;

import java.util.Map;

public class Ex3<Vertex extends Comparable<? super Vertex>> extends Network<Vertex> {

    public Network<Vertex> invertiNegativi() {
        Network<Vertex> absNetwork = new Network<>(this);

        for (Vertex v : adjacencyMap.keySet())
            absNetwork.addVertex(v);
        for (Vertex v : adjacencyMap.keySet()) {
            for (Map.Entry<Vertex, Double> entry : adjacencyMap.get(v).entrySet()) {
                if (entry.getValue() >= 0) absNetwork.addEdge(v, entry.getKey(), entry.getValue());
                else absNetwork.addEdge(entry.getKey(), v, -entry.getValue());
            }
        }
        return absNetwork;
    }
}
