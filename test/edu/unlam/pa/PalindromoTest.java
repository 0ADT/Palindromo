package edu.unlam.pa;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class PalindromoTest {
	
	Archivo esperado = new Archivo("resource/prueba/esperada/", "");
	Archivo obtenido =  new Archivo("resource/prueba/obtenida/", "");;
	
	@Test
	public void testAzarosos() throws IOException {
		Palindromo palin = new Palindromo("azarosos");
		palin.calcularPalindromos();
		
		esperado.setName("azarosos.out");
		obtenido.setName("azarosos.out");
		Assert.assertEquals(esperado, obtenido);	
		 
	}
	
	@Test
	public void testAmarrar() throws IOException {
		Palindromo palin = new Palindromo("amarrar");
		palin.calcularPalindromos();
		
		esperado.setName("amarrar.out");
		obtenido.setName("amarrar.out");
		Assert.assertEquals(esperado, obtenido);	
		 
	}
	
	@Test
	public void testReconocer() throws IOException {
		Palindromo palin = new Palindromo("reconocer");
		palin.calcularPalindromos();
		
		esperado.setName("reconocer.out");
		obtenido.setName("reconocer.out");
		Assert.assertEquals(esperado, obtenido);	
		 
	}
	
	@Test
	public void testOjoRojo() throws IOException {
		Palindromo palin = new Palindromo("ojorojo");
		palin.calcularPalindromos();
		
		esperado.setName("ojorojo.out");
		obtenido.setName("ojorojo.out");
		Assert.assertEquals(esperado, obtenido);	
		 
	}
}
