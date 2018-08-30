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
		boolean palindromoIzquierdo = false, palindromoDerecho = false, escribioArchivo = false;
		String palabraIzquierda, palabraDerecha;
	
		/*	Busco palindromos a ambos lados de un corte "i".
		 * 	Si existen, escribo en el archivo los string
		 * 	que estan cargados con la palabra y el tipo
		 * 	de palindromo.
		 * 	Si no existen solo se escribirá en el archivo
		 * 	la leyenda "NO SE PUEDE"
		 * */
		for(int i = 1; i < palabra.length(); i ++) {
			//lado izquierdo del corte
			palabraIzquierda = palabra.substring(0, i);
			
			if(esPalindromo(palabra.substring(0, i))) {					
				palabraIzquierda += (" palindromo");
				palindromoIzquierdo = true;
			}
				
			if(esPalindromo(palabra.substring(1, i))) {
				palabraIzquierda += (" i-palindromo");
				palindromoIzquierdo = true;
			}
				
			if(esPalindromo(palabra.substring(0, i - 1))) {
				palabraIzquierda += (" d-palindromo");
				palindromoIzquierdo = true;
			}
			
			//lado derecho del corte
			palabraDerecha = palabra.substring(i);
			
			if(esPalindromo(palabra.substring(i))) {
				palabraDerecha += (" palindromo");
				palindromoDerecho = true;
			}
						
			if(esPalindromo(palabra.substring(i + 1))) {
				palabraDerecha += (" i-palindromo");
				palindromoDerecho = true;
			}
						
			if(esPalindromo(palabra.substring(i, palabra.length() - 1))) {
				palabraDerecha += (" d-palindromo");
				palindromoDerecho = true;
			}
			
			//pregunto si hay palindromos de los dos lados del corte
			if(palindromoIzquierdo && palindromoDerecho) {
				salida.println(palabraIzquierda);
				salida.println(palabraDerecha);
				escribioArchivo = true;
			}			
			
			palindromoIzquierdo = palindromoDerecho = false;
		}//fin for
		
		if(!escribioArchivo)
			salida.print("NO SE PUEDE");
			
		salida.close();
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

