package JAAD.Test;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.*;
import JAAD.*;

public class TestRanking
{
	//Atributos para la Prueba
	Ranking r = new Ranking();
	
	@Before  
    public void antesDelTest() {  
        /** 
         * El metodo precedido por la etiqueta @Before 
         * es para indicar a JUnit que debe ejecutarlo 
         * antes de ejecutar los Tests que figuran en 
         * esta clase. 
         */
		//r = new Ranking();
    }  
	
	@Test
	public void testCompruebaNo() {
		//Comprobamos que la puntuacion no es suficiente para ingresar al ranking
		assertFalse(r.comprobar(1));
	}
	
	@Test
	public void testCompruebaSi() {
		//Comprobamos que la puntuacion es suficiente para ingresar al ranking
		assertTrue(r.comprobar(8));
	}
	
	@Test
	public void testAniade() {
		//Comprobamos que el jugador es ahora el 4º en el ranking
		r.anadePuntuacion(8,"Pablo");
		List<Jugador> rankingDespues = r.getRanking();
		assertTrue(rankingDespues.get(3).getNombre()=="Pablo");
	}
	
	@Test
	public void testUltimoFuera() {
		//Comprobamos que el que era 5º, ya no está
		Jugador quintoAntes = r.getRanking().get(4);
		r.anadePuntuacion(8,"Pablo");
		assertTrue(r.getRanking().get(4).getNombre()!=quintoAntes.getNombre());
	}
	
	@Test
	public void testDesciende() {
		//Comprobamos que el que era 4º, ahora es 5º
		Jugador cuartoAntes = r.getRanking().get(3);
		r.anadePuntuacion(8,"Pablo");
		assertTrue(r.getRanking().get(4).getNombre()==cuartoAntes.getNombre());
	}
}//TestRanking (Clase de Prueba)
