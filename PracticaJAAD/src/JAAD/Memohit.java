package JAAD;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Memohit {
	
	private char[] LETRAS={'a','s','d','f'};
	private final static long TIEMPO_X_TURNO=1000;// 1 seg
	
	private Ranking ranking;
	private Secuencia secuencia;
	private List<Token> tokens;
	
	private boolean finTurno;
	private Token ultimoTokenLeido;
	
	private int nivel;
	
	private TimerTiempoNivel timerTiempo;
	private LectorTeclado lectorTeclado;
	
	public Memohit(){
		
		this.ranking=new Ranking();
		tokens=new ArrayList<Token>();
		for(int i=0; i < LETRAS.length; i++)
		{
			tokens.add(new Token(LETRAS[i]));
		}
	}
	
	public Token randomToken()
	{
		Random generador =  new  Random (); 
		int numRandom = generador . nextInt ( 4 );
		return new Token(LETRAS[numRandom]);
	}

	public void iniciaPartida(){
		secuencia = new Secuencia(this);
		nivel=0;
	}
	
	public void siguienteNivel()
	{
		nivel++;
		secuencia.incrementa();
		secuencia.reproducir();
	}
	
	public boolean turnoUser()
	{
		this.finTurno=false;
		boolean nivelSuperado=false;
		boolean noFallo=true;
		System.out.println("Tiempo: " + this.calculaTiempoNivel()+" ms");
		this.timerTiempo=new TimerTiempoNivel(this.calculaTiempoNivel(), this);
		this.timerTiempo.start();
		while(!finTurno & noFallo & !secuencia.finSecuencia())
		{
			try {
				
				esperaToken();

				if(this.ultimoTokenLeido!=null)
				{
					noFallo=secuencia.comprobarToken(this.ultimoTokenLeido);
					//System.out.println("token correcto: "+noFallo);
				}
			} catch (InterruptedException e) {	
			}
		}
		if(secuencia.finSecuencia() && noFallo && !finTurno)
		{
			nivelSuperado=true;
			this.timerTiempo.interrupt();
		}
		if(!noFallo)
		{
			this.timerTiempo.interrupt();
		}
		
		return nivelSuperado;
	}
	
	public synchronized void esperaToken() throws InterruptedException
	{
		this.ultimoTokenLeido=null;
		this.lectorTeclado=new LectorTeclado(this);
		this.lectorTeclado.start();
		wait();
	}
	
	public synchronized void tokenLeido(Token t)
	{
		//System.out.println("TokenLeido :"+t.getValor());
		this.ultimoTokenLeido=t;
		notify();
	}
	
	public synchronized void finalizaTurno()
	{
		this.finTurno=true;
		this.ultimoTokenLeido=null;
		//System.out.println("Memohit: me intento despertar");
		this.notify();
	}

	private long calculaTiempoNivel() {
		
		return TIEMPO_X_TURNO*(secuencia.getTamanio()+1)+5000;
	}
	
	public boolean combruebaPuntuaciónRanking()
	{
		return ranking.comprobar(nivel);
	}
	
	public void insertarPuntuaciónEnRanking(String nombre)
	{
		//System.out.println("Inserto "+nombre+ ":"+nivel);
		this.ranking.anadePuntuacion(nivel, nombre);
	}
	
	///////////////////SETTERS Y GETTERS/////////////////////

	public Ranking getRanking() {
		return ranking;
	}

	public Secuencia getSecuencia() {
		return secuencia;
	}

	public void setSecuencia(Secuencia secuencia) {
		this.secuencia = secuencia;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}
	
}
