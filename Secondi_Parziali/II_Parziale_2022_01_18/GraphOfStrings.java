package Secondi_Parziali.II_Parziale_2022_01_18;

import melipack.network.weighted.Network;

import java.util.Random;

public class GraphOfStrings {

    private final Network<String> graph;

    public GraphOfStrings(String[] V, int max) {
        graph = new Network<>();
        Random r = new Random();

        for (String v : V) {
            graph.addVertex(v);
            for (String u : V) {
                if (!v.equals(u)) {
                    if (u.length() < v.length()) graph.addEdge(u, v, (double) r.nextInt(max));
                }
            }
        }
    }

    public double meanEdgeWeight() {
        double mean = 0;

        for (String u : graph) {
            for (String v : graph.neighbors(u)) {
                Double w = graph.getEdgeWeight(u, v);
                if (w != null) mean += w;
            }
        }
        return mean / graph.edgeSize();
    }
}
