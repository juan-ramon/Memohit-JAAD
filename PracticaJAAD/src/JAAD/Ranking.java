package JAAD;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
	
	private final static int tamano=5;
	private List<Jugador> ranking ;
	
	public Ranking(){
		ranking= new ArrayList<Jugador>();
		
		ranking.add(new Jugador(10,"Julio"));
		ranking.add(new Jugador(9,"Alba"));
		ranking.add(new Jugador(8,"Africa"));
		ranking.add(new Jugador(7,"Daniel"));
		ranking.add(new Jugador(1,"Juan Ramon"));
	}
	
	public boolean comprobar(int  punt){
		boolean puntuacionAlta=false;
		for(int i=0 ;(i<ranking.size() && !puntuacionAlta); i++){
			if(ranking.get(i).getPuntuacion()<punt){
				puntuacionAlta=true;
			}
		}
		return puntuacionAlta;
	}
	
	public void anadePuntuacion(int puntuacion, String nombre)
	{
		//si estoy en el ranking
		if(comprobar(puntuacion))
		{
			//System.out.println("Ranking: "+nombre+":"+puntuacion);
			boolean anadido=false;
			Jugador j=new Jugador(puntuacion, nombre);
			for(int i=0; (i < ranking.size() & !anadido ); i++ )
			{
				if(j.getPuntuacion() > ranking.get(i).getPuntuacion())
				{
					ranking.add(i,j);
					anadido=true;
					if(ranking.size()>tamano)
						ranking.remove(ranking.size()-1);
				}
			}
		}
	}
	
//	public void anadeARanking(int puntuacion, int posicion){
//		if(posicion<0||puntuacion<0){
//			System.out.println("La posición o la puntuación es errónea");
//		}else{
//			System.out.println("La posicion que me llega es "+posicion);
//			List<Jugador> nueva = new ArrayList<Jugador>();
//			for(int i=0; i<posicion;i++){
//				nueva.add(ranking.get(i));
//			}
//			
//			
//			System.out.println("Introduzca su nombre: ");
//			Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
//			String nomJugador = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
//			Jugador nuevo = new Jugador(puntuacion, nomJugador);
//			nueva.add(nuevo);
//			for(int i=posicion;i<=tamano;i++){
//				nueva.add(ranking.get(i));
//			}
//			ranking=nueva;
//		}
//	}
	
	public void imprimirRanking(){
		System.out.println("Ranking");
		System.out.println("Nombre          Puntuacion");
		for (int i = 0; i<ranking.size();i++){
			System.out.println(ranking.get(i).getNombre()+"           "+ranking.get(i).getPuntuacion());
		}
	}
	
	public List<Jugador> getRanking(){
		return ranking;
	}
}

