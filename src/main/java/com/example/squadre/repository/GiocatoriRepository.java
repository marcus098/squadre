package com.example.squadre.repository;

import com.example.squadre.model.Giocatore;
import com.example.squadre.model.Presidente;
import com.example.squadre.model.Squadra;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GiocatoriRepository {
    private List<Squadra> squadraList = new ArrayList<>();
    private List<Giocatore> giocatoreList = new ArrayList<>();
    private List<Presidente> presidenteList = new ArrayList<>();
    private int idGiocatore, idSquadra, idPresidente;

    //- lista dei giocatori di una squadra
    public List<Giocatore> getGiocatoriFromSquadra(int idSquadra) {
        for (Squadra s : squadraList) {
            if (s.getIdSquadra() == idSquadra)
                return s.getGiocatoreList();
        }
        return null;
    }

    // - lista di tutte le squadre
    public List<Squadra> getSquadraList() {
        return squadraList;
    }

    // - aggiungi un giocatore assegnando una squadra
    public boolean addGiocatore(int idGiocatore, int idSquadra) {
        Squadra squadra = squadraList.stream().filter(s -> s.getIdSquadra() == idSquadra).findFirst().get();
        if (squadra == null) {
            return false;
        }
        Giocatore giocatore = giocatoreList.stream().filter(g -> g.getIdGiocatore() == idGiocatore).findFirst().get();
        if (giocatore == null) {
            return false;
        }
        if (squadra.hasGiocatore(giocatore)) {
            return false;
        }
        if (giocatore.getSquadra() != null)
            return false;

        squadra.addGiocatore(giocatore);
        giocatore.setSquadra(squadra);
        return true;
    }

    public boolean creaGiocatore(Giocatore giocatore) {
        giocatore.setIdGiocatore(idGiocatore++);
        giocatoreList.add(giocatore);
        return true;
    }

    public boolean addSquadra(Squadra squadra) {
        if (!squadraList.contains(squadra)) {
            squadra.setIdSquadra(idSquadra++);
            squadraList.add(squadra);
            return true;
        }
        return false;
    }

    // -  ricerca tutti i giocatori in base al nome o cognome
    public List<Giocatore> cercaGiocatore(String nome) {
        return giocatoreList.stream()
                .filter(giocatore -> giocatore.getNome().contains(nome) || giocatore.getCognome().contains(nome))
                .collect(Collectors.toList());
    }

    // creazione presidente
    public boolean creaPresidente(Presidente presidente) {
        presidente.setIdPresidente(idPresidente++);
        presidenteList.add(presidente);
        return true;
    }

    public boolean addSquadraToPresidente(int idPresidente, int idSquadra) {
        Optional<Presidente> presidente = presidenteList.stream().filter(p -> p.getIdPresidente() == idPresidente).findFirst();
        if (presidente.isEmpty())
            return false;
        Optional<Squadra> squadra = squadraList.stream().filter(s -> s.getIdSquadra() == idSquadra).findFirst();
        if (squadra.isEmpty()) {
            return false;
        }
        if (presidente.get().hasSquadra(squadra.get()))
            return false;
        presidente.get().getSquadra().add(squadra.get());
        return true;
    }

    public int login(String username, String password) {
        //Presidente presidente = null;
        Optional<Presidente> presidente = presidenteList.stream()
                .filter(p -> p.getUsername().equals(username) && p.getPassword().equals(password))
                .findFirst();
        if(presidente.isEmpty())
            return -1;
        return presidente.get().getIdPresidente();
    }

    public List<Squadra> squadrePresidente(int idPresidente) {
        Presidente presidente = presidenteList.stream().filter(p -> p.getIdPresidente() == idPresidente).findFirst().get();
        if(presidente!=null){
            return presidente.getSquadra();
        }
        return null;
    }
}
