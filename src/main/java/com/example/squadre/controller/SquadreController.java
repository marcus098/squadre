package com.example.squadre.controller;

import com.example.squadre.model.Giocatore;
import com.example.squadre.model.Presidente;
import com.example.squadre.model.Squadra;
import com.example.squadre.service.SquadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;




import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class SquadreController {
    @Autowired
    private SquadreService squadreService;

    @PostMapping("/creaGiocatore")
    public String creaGiocatore(@RequestBody Giocatore giocatore) {
        if (squadreService.creaGiocatore(giocatore))
            return "success";
        return "failed";
    }

    //1) /api/giocatori/{squadraID}   - lista dei giocatori di una squadra
    @GetMapping("/giocatori/{squadraID}")
    public String getGiocatoriSquadre(@PathVariable("squadraID") int squadraID) {
        String str = "Giocatori: /n";
        for (Giocatore g : squadreService.getGiocatoriSquadre(squadraID)) {
            str += g + "";
        }
        return str;
        //return squadreService.getGiocatoriSquadre(squadraID);
    }

    //2) /api/squadre                    - lista di tutte le squadre
    @GetMapping("/squadre")
    public String getSquadre() {
        String str = "";
        for (Squadra s : squadreService.getSquadre()) {
            str += s + "";
        }
        return str;
        //String s = squadreService.getSquadre();
    }

    //3) /api/giocatori/add            - aggiungi un giocatore assegnando una squadra
    @GetMapping("/addGiocatore/{giocatoreID}/{squadraID}")
    public String addGiocatore(@PathVariable("giocatoreID") int giocatoreID, @PathVariable("squadraID") int squadraID) {
        if (squadreService.addGiocatore(giocatoreID, squadraID))
            return "success";
        else
            return "failed";
    }

    //Aggiungi Squadra
    @GetMapping("/addSquadra/{nome}")
    public String addSquadra(@PathVariable("nome") String nome) {
        if (squadreService.addSquadra(new Squadra(nome)))
            return "success";
        return "failed";
    }

    //4) /api/giocatori/search        -  ricerca tutti i giocatori in base al nome o cognome
    @GetMapping("/cercaGiocatore/{nome}")
    public String cercaGiocatori(@PathVariable("nome") String nome) {
        String str = "";
        for (Giocatore g : squadreService.cercaGiocatore(nome)) {
            str += g + " ";
        }
        return str;
    }

    //5) /api/presidenti/registrazione     - registrazione di un presidente
    @PostMapping("/creaPresidente")
    public String creaPresidente(@RequestBody Presidente presidente) {
        if (squadreService.creaPresidente(presidente))
            return "success";
        return "failed";
    }

    @GetMapping("/addPresidente/{presidenteID}/{squadraID}")
    public String squadraToPresidente(@PathVariable("presidenteID") int presidenteID, @PathVariable("squadraID") int squadraID) {
        if (squadreService.addSquadraToPresidente(presidenteID, squadraID))
            return "success";
        return "failed";
    }

    //6) /api/presidenti/login - effettuare il login tramite username e password e restituire l'id
    @PostMapping("/login")
    public String login(@RequestBody Presidente presidente) {
        int id = squadreService.login(presidente.getUsername(), presidente.getPassword());
        System.out.println("id: " + id);
        if (id == -1)
            return "Failed";
        return id + "";
    }

    //7) /api/squadre/  - usando l'id del presidente nell'header, visualizzare solo le proprie squadre
    @GetMapping("/squadrePresidente")
    public String squadrePresidente(@RequestHeader("idPresidente") int idPresidente){
        String str = "";
        for(Squadra s : squadreService.squadrePresidente(idPresidente))
            str += s + "";
        return str;
    }

}
