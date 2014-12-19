package JAAD;

import java.util.*;

//Clase Secuencia
public class Secuencia{
	//Atributos
	private Memohit juego;	
	private List<Token> listaTokens;
	private int posActual=0;
	
	//Constructor
	public Secuencia(Memohit memohit)	{
		listaTokens=new ArrayList<Token>();
		this.juego=memohit;
	}
	
	//Get Tamanio
	public int getTamanio(){
		return listaTokens.size();
	}
	//NOTA JR: se le podría pasar como parametro un token y eliminar el atributo juego de la clase.
	//esto ayudaria bastante al hacer tests de esta clase.
	
	//Finaliza la Secuencia (Sube de Nivel)
		public void incrementa(){
			//Aniade el Token Aleatorio
			Token t = juego.randomToken();
			listaTokens.add(t);
			posActual=0;
		}
	
	//Comprueba si el Token Pulsado es Correcto
	public boolean comprobarToken(Token t){
		boolean result=true;
		if(listaTokens.get(posActual).equals(t)){
			//Acierto (Avanza de Posicion en la Secuencia)
			posActual++;
		}else{
			//Fallo (Termina la Partida)
			result= false;
		}
		return result;
	}
	
	//Comprueba si es el Fin de la Secuencia
	public boolean finSecuencia(){
		return posActual>=listaTokens.size();
	}
	
	public List<Token> getTokens()
	{
		return this.listaTokens;
	}
	

	//Reproduce la Secuencia
	public void reproducir(){
		System.out.println("- NIVEL "+listaTokens.size());
		System.out.println("Reproduciendo Secuencia...");
		//Muestra la Secuencia Completa (1seg. x Nº de Tokens)
		for(Token t : listaTokens)		{
			t.reproduce();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Turno del Jugador (Empieza el Timer)
		System.out.println("Turno del Jugador...");		
	}
	
	
}//Clase Secuencia

