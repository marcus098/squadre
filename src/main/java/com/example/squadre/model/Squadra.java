package com.example.squadre.model;

import java.util.ArrayList;
import java.util.List;

public class Squadra {
    private int idSquadra;
    private String nome;
    private List<Giocatore> giocatoreList = new ArrayList<>();

    public Squadra(String nome) {
        this.nome = nome;
    }

    public void addGiocatore(Giocatore giocatore) {
        if (!hasGiocatore(giocatore))
            giocatoreList.add(giocatore);
    }

    public boolean hasGiocatore(Giocatore giocatore) {
        if (giocatoreList.stream().filter(g -> g.getIdGiocatore() == giocatore.getIdGiocatore()).count() == 0)
            return false;
        return true;
    }

    public String getNome() {
        return nome;
    }

    public int getIdSquadra() {
        return idSquadra;
    }

    public List<Giocatore> getGiocatoreList() {
        return giocatoreList;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdSquadra(int idSquadra) {
        this.idSquadra = idSquadra;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "idSquadra=" + idSquadra +
                ", nome='" + nome + '\'' +
                '}';
    }
}
