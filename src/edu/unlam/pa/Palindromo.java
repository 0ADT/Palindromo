package edu.unlam.pa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Palindromo {

	public static void main(String[] args) throws IOException {
		File entrada = new File("PALIN.IN");
		Scanner sc = new Scanner(entrada);
		String palabra = sc.next();
		
		sc.close();
		
		PrintWriter salida = new PrintWriter(new FileWriter("PALIN.out"));
	
		/* Compruebo que hayan dos palabras que sean palindromos
		 * en la palabra leida del archivo PALIN.in.
		 * Leo desde el inicio hasta i para encontrar la primer palabra
		 * y luego desde i + 1 hasta el final.
		 * */
		if(!tieneDosPalabrasDistinguidas(palabra))
			salida.println("NO SE PUEDE");
		else {
			for(int i = 1; i < palabra.length(); i ++) {				
				if(sePuedeCortarPaladra(palabra, i)) {
					//primera palabra
					salida.print(palabra.substring(0, i));
					
					if(esPalindromo(palabra.substring(0, i)))						
						salida.print(" palindromo");
					
					if(esPalindromo(palabra.substring(1, i)))
						salida.print(" i-palindromo");
					
					if(esPalindromo(palabra.substring(0, i - 1)))
						salida.print(" d-palindromo");
							
					//segunda palabra
					salida.println();
					salida.print(palabra.substring(i));
					
					if(esPalindromo(palabra.substring(i)))
						salida.print(" palindromo");
							
					if(esPalindromo(palabra.substring(i + 1)))
						salida.print(" i-palindromo");
							
					if(esPalindromo(palabra.substring(i, palabra.length() - 1)))
						salida.print(" d-palindromo");
					
					salida.println();
				}//fin if(sePuedeCortarPaladra(palabra, i))
			}//fin for
		}//fin else (!tieneDosPalabrasDistinguidas(palabra))
		
		salida.close();
	}
	
	public static boolean sePuedeCortarPaladra(String palabra, int corte) {
		return (esPalindromo(palabra.substring(0, corte)) ||//izquierda
				esPalindromo(palabra.substring(1, corte)) ||
				esPalindromo(palabra.substring(0, corte - 1))) && //derecha
				(esPalindromo(palabra.substring(corte)) ||
				esPalindromo(palabra.substring(corte + 1)) ||
				esPalindromo(palabra.substring(corte, palabra.length() - 1)));
	}
	
	/*	Si al menos tiene un par de palabras significativas
	 * 	retorno true, de lo contrario false
	 * */
	public static boolean tieneDosPalabrasDistinguidas(String palabra) {
		for(int i = 2; i < palabra.length(); i ++) {
			if(esPalindromo(palabra.substring(0, i)) ||//izquierda
				esPalindromo(palabra.substring(1, i)) ||
				esPalindromo(palabra.substring(0, i - 1)) && //derecha
				esPalindromo(palabra.substring(i)) ||
				esPalindromo(palabra.substring(i + 1)) ||
				esPalindromo(palabra.substring(i, palabra.length() - 1)))
				return true;
			
		}
		
		return false;
	}
	
	public static boolean esPalindromo(String palabra) {
		int coincidencias = 0;
		
		if(palabra.length() < 2)
			return false;
		
		if(palabra.length() == 2)
			return palabra.charAt(0) == palabra.charAt(1);
		
		for(int i = 0; i < palabra.length(); i ++) {			
			if(palabra.charAt(i) == palabra.charAt(palabra.length() - 1 - i)) {
				coincidencias ++;
			}
		}
		
		return coincidencias == palabra.length() && coincidencias >= 2;
	}
}

