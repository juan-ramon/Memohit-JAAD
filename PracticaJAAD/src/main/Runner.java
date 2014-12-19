package main;

import java.util.Scanner;

import JAAD.Memohit;

public class Runner {
	
	private static Scanner in;
	
	public static void main(String[] args) {
		in=new Scanner(System.in);
		Memohit memohit = new Memohit();
		mainMenu(memohit);
	}

	private static void mainMenu(Memohit memohit) {
		while(true)
		{
			//MENU
			System.out.println("\nMENU: Presiona para elegir");
			System.out.println("1. Mostrar Ranking");
			System.out.println("2. Inicia Juego");
			System.out.println("3. Cierra Juego");
			//lee eleccion
			int eleccion = in.nextInt();
			//Mostrar Ranking
			if(eleccion==1){
				memohit.getRanking().imprimirRanking();
				//Inicia el juego
			}else if(eleccion==2){
				iniciaJuego(memohit);
				//Salir del Juego
			}else{
				System.out.println("ADIOS");
				System.exit(0); 
			}
		}
	}

	private static void iniciaJuego(Memohit memohit) {
		memohit.iniciaPartida();
		do{
			memohit.siguienteNivel();
		}while(memohit.turnoUser());
		
		System.out.println("GAME OVER\n");
		
		if(memohit.combruebaPuntuaciónRanking())
		{
			
			System.out.println("PUNTUACION ALTA");
			System.out.println("INTRODUCE NOMBRE: ");

			Scanner scan=new Scanner(System.in);
		    String nombre = scan.next();
		    
		    memohit.insertarPuntuaciónEnRanking(nombre);
		}
		
		memohit.getRanking().imprimirRanking();
	}
}
