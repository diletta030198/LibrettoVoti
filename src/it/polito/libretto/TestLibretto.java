package it.polito.libretto;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto libr = new Libretto(); 
		
		libr.add(new Voto(30,"Analisi I",LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(21,"Analisi II",LocalDate.of(2018, 1, 25)));
		libr.add(new Voto(25,"Fisica I",LocalDate.of(2017, 6, 15)));
		libr.add(new Voto(28,"Fisica II",LocalDate.of(2018, 9, 15)));
		libr.add(new Voto(18,"Geometria",LocalDate.of(2017, 1, 15)));
		libr.add(new Voto(20,"Economia",LocalDate.of(2018, 1, 15)));
		libr.add(new Voto(25,"Ricerca Operativa",LocalDate.of(2018, 2, 15)));
		libr.add(new Voto(24,"Complementi di Economia",LocalDate.of(2018, 6, 25)));
		libr.add(new Voto(25,"Logistica",LocalDate.of(2019, 1, 2)));
		libr.add(new Voto(27,"Programmazione a oggeti",LocalDate.of(2019, 2, 15)));
		
	List <Voto> venticinque = libr.cercaVoti(25);
System.out.println(venticinque); 

Voto a1 = libr.cercaEsame("Analisi II"); 
Voto a2 = libr.cercaEsame("Analisi III"); 
System.out.println(a1);
System.out.println (a2); 
	}

}
