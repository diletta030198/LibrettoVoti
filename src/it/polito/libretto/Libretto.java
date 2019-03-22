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
	 * @return {@code true} se ha aggiunto il voto, 
	 * {@code false} se non è riuscito ad aggiungere il voto
	 */
	
public boolean add (Voto v) {
	if(this.esisteGiaVoto(v)==false  && this.votoInConflitto(v)==false)
	{
			voti.add(v); 
		return true; 
	}
	else 
		return false; 
	
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
 * Ricerca un {@link Voto} relativo al corso di cui è specificato il nome
 * 
 * @param nomeEsame nome del corso da ricercare
 * @return il {@link Voto} corrispondente, oppure null se non esistente
 */

public Voto cercaEsame(String nomeEsame) {
	/*for(Voto v : this.voti) {
		if(v.getCorso().equals(nomeEsame)) {
			return v; 
		}
		}
		return null; */
	Voto voto= new Voto(0,nomeEsame,null); 
	int pos= this.voti.indexOf(voto);
	if(pos==-1)
		return null; 
	else 
		return this.voti.get(pos); 
}
/**
 * Dato un {@link Voto},determina se esiste già un voto con uguale corso e uguale punteggio
 * 
 * @param v
 * @return {@code true}, se ha trovato un corso e punteggio uguale,
 *  {@code false} se non ha trovato il corso, oppure l'ha trovato con voto diverso
 */

public boolean esisteGiaVoto(Voto v) {
	int pos= this.voti.indexOf(v); 
	if(pos==-1) {
		return false;
		
	}
	else {
		return v.getPunti()==this.voti.get(pos).getPunti(); 
	}
}

/**
 * Mi dice se il {@link Voto} {@code v} è in conflitto con uno dei voti esistenti. 
 * se il voto none eiste, non c'è conflitto. Se esiste ed ha un punteggio diverso, 
 * c'è conflitto. 
 * 
 * @param v
 * @return {@code true} se il voto esiste ed ha un punteggio diverso,
 *       {@code false} se il voto non esiste,oppure esiste ma ha lo stesso
 *       punteggio
 */
public boolean votoInConflitto(Voto v) {
	int pos= this.voti.indexOf(v); 
	if(pos==-1)
		return false; 
	else 
		return (v.getPunti()!= this.voti.get(pos).getPunti()); 
}

public String toString() {
	return this.voti.toString(); 
}

public Libretto librettoMigliorato() {
	Libretto nuovo = new Libretto(); 
	for(Voto v: this.voti) {
		nuovo.add(v.clone()); 
	}
	for(Voto v: nuovo.voti) {
		int punti = v.getPunti(); 
		if(punti<24)
			punti=punti+1; 
		else if(punti <=28)
			punti=punti+2; 
		v.setPunti(punti);
	}
	return nuovo; 
}

public  void cancellaVotiScarsi() {
	List <Voto> cancella= new ArrayList<Voto>(); 
	for(Voto v: this.voti) {
		if(v.getPunti()<24)
		 cancella.add(v); 
	}
	this.voti.removeAll(cancella); 
}

}
