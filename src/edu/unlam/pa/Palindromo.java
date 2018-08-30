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
<<<<<<< HEAD
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
	
=======
		
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
	
>>>>>>> b310bdea62eae98df922f774f756844ffc124ab7
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

