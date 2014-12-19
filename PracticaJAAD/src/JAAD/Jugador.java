package JAAD;

public class Jugador implements Comparable <Jugador>{
	
	private int puntuacion;
	private String nombre;
	
	public Jugador(int puntuacion, String nombre){
		this.puntuacion=puntuacion;
		this.nombre=nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getPuntuacion(){
		return puntuacion;
	}
	
	public int compareTo(Jugador ju) {
		return ju.getPuntuacion()-puntuacion;
	}
}
