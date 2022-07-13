package com.example.squadre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
Creare i seguenti endpoint:

1) /api/giocatori/{squadraID}   - lista dei giocatori di una squadra
2) /api/squadre                    - lista di tutte le squadre
3) /api/giocatori/add            - aggiungi un giocatore assegnando una squadra
4) /api/giocatori/search        -  ricerca tutti i giocatori in base al nome o cognome

Nota 4 punto: La parola cercata deve essere contenuta. Esempio cercando "er" si ottiente: giocatore con nome "Sergio" e giocatore "Merola".

PUNTO BONUS
Gestione presidenti. Realizzare creazione e login di un presidente associandogli una o più squadre.

5) /api/presidenti/registrazione     - registrazione di un presidente
6) /api/presidenti/login               - effettuare il login tramite username e password e restituire l'id
7) /api/squadre/                    - usando l'id del presidente nell'header, visualizzare solo le proprie squadre
 */
@SpringBootApplication
public class SquadreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquadreApplication.class, args);
	}

}
