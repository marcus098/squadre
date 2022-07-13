package com.example.squadre.model;

public class Giocatore {
    private int idGiocatore;
    private String nome, cognome;
    private int eta;
    private Squadra squadra;

    public Giocatore(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public void setIdGiocatore(int idGiocatore) {
        this.idGiocatore = idGiocatore;
    }

    public int getIdGiocatore() {
        return idGiocatore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Squadra getSquadra() {
        return squadra;
    }

    public void setSquadra(Squadra squadra) {
        this.squadra = squadra;
    }

    @Override
    public String toString() {
        return "Giocatore{" +
                "idGiocatore=" + idGiocatore +
                ", nome='" + nome + '\'' +
                ", squadra=" + squadra +
                '}';
    }
}
