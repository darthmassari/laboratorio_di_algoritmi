package Primi_Parziali.I_Parziale_2021_11_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Cellulare {
    private double carica;
    private int numeroChiamate;
    private final ArrayList<Chiamata> elencoChiamate;

    public Cellulare(double unaCarica) {
        this.carica = unaCarica;
        this.elencoChiamate = new ArrayList<>();
    }

    public double getCarica() {
        return carica;
    }

    public int getNumeroChiamate() {
        return numeroChiamate;
    }

    public ArrayList<Chiamata> getElencoChiamate() {
        return elencoChiamate;
    }

    public void ricarica(double unaRicarica) {
        this.carica += unaRicarica;
    }

    public void chiama(String numeroTel, Date inizioDataOra, int durata) {
        double minutiDurata = (double) durata / 60;
        Chiamata nuovaChiamata = new Chiamata(numeroTel, inizioDataOra, minutiDurata);
        this.carica -= minutiDurata * 0.15;
        this.numeroChiamate++;
        elencoChiamate.add(nuovaChiamata);
    }

    public double TotaleChiamate() {
        return numeroChiamate;
    }

    public ArrayList<Chiamata> getSottoelenco(String numeroTel) {
        ArrayList<Chiamata> sottoElenco = new ArrayList<>();
        for (Chiamata cur : elencoChiamate) {
            if (cur.getNumTel().equals(numeroTel)) sottoElenco.add(cur);
        }
        return sottoElenco;
    }

    public ArrayList<Chiamata> getElencoOrdinatoPerDataOraC() {
        ArrayList<Chiamata> nuovoElenco = new ArrayList<>(this.elencoChiamate);
        Collections.sort(nuovoElenco);
        return nuovoElenco;
    }

    public ArrayList<Chiamata> getElencoOrdinatoPerDataOraD() {
        ArrayList<Chiamata> nuovoElenco = new ArrayList<>(this.elencoChiamate);
        nuovoElenco.sort(Comparator.reverseOrder());
        return nuovoElenco;
    }

    public ArrayList<Chiamata> getElencoOrdinatoPerNumero() {
        ArrayList<Chiamata> nuovoElenco = new ArrayList<>(this.elencoChiamate);
        nuovoElenco.sort(Comparator.comparing(Chiamata::getNumTel));
        return nuovoElenco;
    }

    public ArrayList<Chiamata> getElencoOrdinatoPerDurata() {
        ArrayList<Chiamata> nuovoElenco = new ArrayList<>(this.elencoChiamate);
        nuovoElenco.sort(Comparator.comparingDouble(Chiamata::getDurata));
        return nuovoElenco;
    }
}
