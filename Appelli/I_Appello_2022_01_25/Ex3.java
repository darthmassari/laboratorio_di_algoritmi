package Appelli.I_Appello_2022_01_25;

import melipack.network.weighted.Network;

import java.util.Map;

/**
 * Aggiungere alla classe Network<> un nuovo metodo public Network<Vertex>
 * transpose() che restituisce una nuova istanza di tipo Network<Vertex> che
 * rappresenta il grafo trasposto al grafo corrente.
 * <p>
 * Si ricorda che dato un grafo G = (V, E), il uso grafo trasposto Gt = (V, Et ) ha
 * gli stessi nodi di G e gli archi orientati in senso opposto, i.e., Et = {(v, u) | (u,
 * v) ∈ E}.
 */
public class Ex3<Vertex extends Comparable<? super Vertex>> extends Network<Vertex> {
    public Network<Vertex> transpose() {
        Network<Vertex> transposed = new Network<>(this);

        for (Vertex v : adjacencyMap.keySet())
            transposed.addVertex(v);
        for (Vertex v : adjacencyMap.keySet()) {
            for (Map.Entry<Vertex, Double> entry : adjacencyMap.get(v).entrySet()) {
                transposed.addEdge(entry.getKey(), v, entry.getValue());
            }
        }
        return transposed;
    }
}
