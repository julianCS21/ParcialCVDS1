package juego;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class CuatroEnLineaTest {
	//Creo un objeto de tipo CuatroEnLinea para las pruebas generales
	//Atributo
	private CuatroEnLinea juegoGeneral;
		
	@Before
	public void crearCuatroEnLinea(){
		juegoGeneral = new CuatroEnLinea(8,8,"Nico","Edu");
	}
	
	//Pruebas para corroborar los valores ingresados en el constructor constructor
	
	@Test (expected = Error.class)
	public void errorValorDeColumnas(){
		
		//Construyo un objeto, en el que espere un error
		
		CuatroEnLinea juego = new CuatroEnLinea(4,3,"Nico","Edu");
	}
	
	@Test (expected = Error.class)
	public void errorValorDeFilas(){
		
		//Construyo un objeto, en el que espere un error
		
		CuatroEnLinea juego = new CuatroEnLinea(0,5,"Nico","Edu");
	}
	
	@Test (expected = Error.class)
	public void errorValorDeFilasYColumnas(){
		
		//Construyo un objeto, en el que espere un error
		
		CuatroEnLinea juego = new CuatroEnLinea(0,2,"Nico","Edu");
	}
	
	//Prueba de los métodos
	
	@Test (expected = Error.class)
	public void obtenerCasilleroErrorValorFilaYColumnaMinimo(){
		juegoGeneral.obtenerCasillero(0,0);
	}
	@Test (expected = Error.class)
	public void obtenerCasilleroErrorValorFilaYColumnaMaximo(){
		juegoGeneral.obtenerCasillero(10,10);
	}
	
	@Test
	public void contarFilasTest(){
		int cantidadDeFilas = juegoGeneral.contarFilas();
		
		Assert.assertEquals(8, cantidadDeFilas);
	}
	
	@Test
	public void contarColumnasTest(){
		int cantidadDeColumnas = juegoGeneral.contarColumnas();
		
		Assert.assertEquals(8, cantidadDeColumnas);
	}
}
