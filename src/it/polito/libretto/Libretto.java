package it.polito.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List <Voto> voti;

	public Libretto() {
		this.voti= new ArrayList<Voto>(); 
	} 
	
	public void add (int voto, String corso,LocalDate data) {
		
	}
	
	/**
	 * Aggiunge nuovo voto al libretto
	 * @param v  il {@link  Voto} da aggiugere
	 */
	
public void add (Voto v) {
		voti.add(v); 
	}
/**
 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
 * 
 * @param punti : punteggio di ricerca 
 * @return lista di {@link Voto} aventi quel punteggio passato dal metodo
 */
	
public List<Voto> cercaVoti(int voto){
	List<Voto>result= new ArrayList<Voto>(); 
	
	for (Voto v: this.voti) {
		if(v.getPunti()==voto) {
			result.add(v);
		}
	}
	return result; 
}

/**
 * Ricerca un {@link Voto} relativo al corso di cui � specificato il nome
 * 
 * @param nomeEsame nome del corso da ricercare
 * @return il {@link Voto} corrispondente, oppure null se non esistente
 */

public Voto cercaEsame(String nomeEsame) {
	for(Voto v : this.voti) {
		if(v.getCorso().equals(nomeEsame)) {
			return v; 
		}
		}
		return null; 
	
}

}
