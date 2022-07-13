package com.example.squadre.service;

import com.example.squadre.model.Giocatore;
import com.example.squadre.model.Presidente;
import com.example.squadre.model.Squadra;
import com.example.squadre.repository.GiocatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class SquadreService {

    @Autowired
    private GiocatoriRepository giocatoriRepository;
    public List<Giocatore> getGiocatoriSquadre(int squadraID) {
        return giocatoriRepository.getGiocatoriFromSquadra(squadraID);
    }

    public List<Squadra> getSquadre(){
        return giocatoriRepository.getSquadraList();
    }

    public boolean addGiocatore(int idGiocatore, int idSquadra){
        return giocatoriRepository.addGiocatore(idGiocatore, idSquadra);
    }

    public boolean addSquadraToPresidente(int idPresidente, int idSquadra){
        return giocatoriRepository.addSquadraToPresidente(idPresidente, idSquadra);
    }

    public boolean creaGiocatore(Giocatore giocatore){
        return giocatoriRepository.creaGiocatore(giocatore);
    }

    public boolean creaPresidente(Presidente presidente){
        return giocatoriRepository.creaPresidente(presidente);
    }

    public boolean addSquadra(Squadra squadra){
        return giocatoriRepository.addSquadra(squadra);
    }

    public List<Giocatore> cercaGiocatore(String nome){
        return giocatoriRepository.cercaGiocatore(nome);
    }

    public int login(String username, String password){
        return giocatoriRepository.login(username, password);
    }
    public List<Squadra> squadrePresidente(int idPresidente) {
        return giocatoriRepository.squadrePresidente(idPresidente);
    }
}
