package Appelli.III_Appello_2022_02_22;

import melipack.network.weighted.Network;

public class Ex3 {

    public static Network<String> NetworkOfStrings(String[] V) {
        Network<String> network = new Network<>();

        for (String v : V) {
            network.addVertex(v);
        }
        for (String v : V) {
            for (String u : V) {
                double weight = v.length() + u.length();
                network.addEdge(v, u, weight);
            }
        }
        return network;
    }
}
