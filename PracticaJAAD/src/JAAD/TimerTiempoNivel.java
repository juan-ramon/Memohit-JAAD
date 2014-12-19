package JAAD;

public class TimerTiempoNivel extends Thread{
	
	private boolean DEBUG=false;
	
	private long tiempo;
	private Memohit memohit;
	
	public TimerTiempoNivel(long tiempo, Memohit j)
	{
		super();
		this.tiempo=tiempo;
		this.memohit=j;
	}

	public void run() {
		try {
			Thread.sleep(tiempo);
			memohit.finalizaTurno();
		} catch (InterruptedException e) {
			//System.out.println("Interrumpido");
		}
		if(DEBUG)
		{
			System.out.println("TimerTiempoNivel: me muero");
		}
	}
}
