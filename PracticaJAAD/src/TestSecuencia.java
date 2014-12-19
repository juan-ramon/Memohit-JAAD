import static org.junit.Assert.*;
import java.util.List;
import org.junit.*;
import JAAD.*;

public class TestSecuencia
{
	//Atributos para la Prueba
	Memohit m;
	Secuencia s;
	
	@Before  
    public void antesDelTest() {  
        /** 
         * El metodo precedido por la etiqueta @Before 
         * es para indicar a JUnit que debe ejecutarlo 
         * antes de ejecutar los Tests que figuran en 
         * esta clase. 
         */  
		m = new Memohit();
		s = new Secuencia(m);
    }  
	
	@Test
	public void testTamanioInicial() {
		//Comprobamos que el tamanio inicial es 0
		assertTrue(s.getTamanio()==0);
	}
	
	@Test
	public void testIncrementaInicial() {
		//Llamamos a 'incrementa()' para aniadir el primer Token y poder empezar
		s.incrementa();//1
		assertTrue(s.getTamanio()==1);
	}
	
	@Test
	public void testCompruebaTokenCorrecto() {
		//Subimos varios niveles, y comprobamos la lista de 3 Tokens
		s.incrementa();//1
		s.incrementa();//2
		s.incrementa();//3
		List<Token> tokens = s.getTokens();
		s.comprobarToken(tokens.get(0));//Comprueba 1
		s.comprobarToken(tokens.get(1));//Comprueba 2
		assertTrue(s.comprobarToken(tokens.get(2)));//Assert Acierta 3
	}
	
	@Test
	public void testPosicion(){
		//Comprobamos que despues de acertar 2 Tokens señalamos a la posicion 2 (3º Token)
		s.incrementa();//1
		s.incrementa();//2
		s.incrementa();//3
		List<Token> tokens = s.getTokens();
		s.comprobarToken(tokens.get(0));//Comprueba 1
		s.comprobarToken(tokens.get(1));//Comprueba 2
		assertTrue(s.getPosicion()==2);
	}
	
	@Test
	public void testCompruebaTokenError() {
		//Fallamos el Token
		s.incrementa();
		Token t = new Token('x');	
		assertFalse(s.comprobarToken(t));//Assert Falla 1
	}
	
	@Test
	public void testFinSecuencia(){
		//Comprobamos que se ha alcanzado el fin de secuencia cuando no quedan más Tokens
		s.incrementa();
		List<Token> tokens = s.getTokens();
		s.comprobarToken(tokens.get(0));
		assertTrue(s.finSecuencia());
	}
	
	@Test
	public void testReiniciaPosicion(){
		//Comprobamos que la posicion vuelve a 0 cuando se avanza de nivel
		s.incrementa();
		assertTrue(s.getPosicion()==0);
	}
}//TestSecuencia (Clase de Prueba)
