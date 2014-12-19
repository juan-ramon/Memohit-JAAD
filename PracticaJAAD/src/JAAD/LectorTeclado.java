package JAAD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LectorTeclado extends Thread {
	
	private boolean DEBUG=false;
	
	private Memohit memohit;
	
	public LectorTeclado(Memohit memohit)
	{
		super();
		this.memohit=memohit;
	}
	
	@Override
	public void run()
	{
		char leido = 0;
		try{
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			try {
				while(!br.ready())
				{
					Thread.sleep(300);
				}
				leido=br.readLine().charAt(0);
				memohit.tokenLeido(new Token(leido));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void interrupt()
	{
		if(DEBUG)
		{
			System.out.println("TurnoJugador: interrumpido");
		}
		super.interrupt();
	}

}
