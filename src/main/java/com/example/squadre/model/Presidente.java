package com.example.squadre.model;

import java.util.ArrayList;
import java.util.List;

public class Presidente {
    private int idPresidente;
    private String username, password;
    private List<Squadra> squadra;

    public Presidente(String username, String password) {
        this.username = username;
        this.password = password;
        squadra = new ArrayList<>();
    }

    public int getIdPresidente() {
        return idPresidente;
    }

    public void setIdPresidente(int idPresidente) {
        this.idPresidente = idPresidente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Squadra> getSquadra() {
        return squadra;
    }

    public boolean hasSquadra(Squadra squadra){
        if (this.squadra.stream().filter(s -> s.getIdSquadra() == squadra.getIdSquadra()).count() == 0)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Presidente{" +
                "idPresidente=" + idPresidente +
                ", username='" + username + '\'' +
                '}';
    }
}
