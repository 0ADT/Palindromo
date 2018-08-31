package edu.unlam.pa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Palindromo {

	private String nombre;

	public Palindromo(String nombre) {
		this.nombre = nombre;
	}

	public void calcularPalindromos() throws IOException {
		File entrada = new File("resource/prueba/entrada/" + this.nombre + ".in");
		Scanner sc = new Scanner(entrada);
		String palabra = sc.next();
		sc.close();

		PrintWriter salida = new PrintWriter(new FileWriter("resource/prueba/obtenida/" + this.nombre + ".out"));
		String palabraIzquierda, palabraDerecha;
		int tipoPalabraIzq = 0;
		int tipoPalabraDer = 0;
		boolean huboAcierto = false;
		/*
		 * Busco palindromos a ambos lados de un corte "i". Si existen, escribo en el
		 * archivo los string que estan cargados con la palabra y el tipo de palindromo.
		 * Si no existen solo se escribirá en el archivo la leyenda "NO SE PUEDE"
		 */
		
		//analisis de la palabra completa
		
		tipoPalabraIzq = esPalabraDistinguida(palabra);
		
		if(tipoPalabraIzq >0)
			huboAcierto = true;
			
		if (tipoPalabraIzq == 1)
			salida.println(palabra + " palindromo");
		else if (tipoPalabraIzq == 2)
			salida.println(palabra + " i-palindromo");
		else if (tipoPalabraIzq == 3)
			salida.println(palabra + " d-palindromo");
		else if (tipoPalabraIzq == 4)
			salida.println(palabra + " i-palindromo d-palindromo");
		
		
		for (int i = 2; i < palabra.length()-1 ; i++) {	//for de los cortes
			
			
			palabraIzquierda = palabra.substring(0,i);
			palabraDerecha = palabra.substring(i, palabra.length());
			tipoPalabraIzq = esPalabraDistinguida(palabraIzquierda);
			tipoPalabraDer = esPalabraDistinguida(palabraDerecha);

			
			if(tipoPalabraIzq > 0 && tipoPalabraDer > 0) {//si las dos son palabras distinguidas
				huboAcierto = true;
				
				if (tipoPalabraIzq == 1)
					salida.println(palabraIzquierda + " palindromo");
				else if(tipoPalabraIzq == 2) 
					salida.println(palabraIzquierda + " i-palindromo");
				else if(tipoPalabraIzq == 3) 
					salida.println(palabraIzquierda + " d-palindromo");
				else if(tipoPalabraIzq == 4) 
					salida.println(palabraIzquierda + " i-palindromo d-palindromo");
				
				if (tipoPalabraDer == 1)
					salida.println(palabraDerecha + " palindromo");
				else if(tipoPalabraDer == 2) 
					salida.println(palabraDerecha + " i-palindromo");
				else if(tipoPalabraDer == 3) 
					salida.println(palabraDerecha + " d-palindromo");
				else if(tipoPalabraDer == 4) 
					salida.println(palabraDerecha + " i-palindromo d-palindromo");
			}
			

		} // fin for

		if (!huboAcierto)
			salida.print("NO SE PUEDE");

		salida.close();
	}

	
	
	
	
	public static int esPalabraDistinguida(String palabra) {

		/*retornos: 
	 	-1 para una palabra que NO es distinguida.
		 1 palindromo
		 2 i-palindromo
		 3 d-palindromo
		 4 i-palindromo y d-palindromo a la vez
		 */
		
		char[] palabraAnalizada = palabra.toCharArray();	//lo paso a un array de char
		int limSup = palabraAnalizada.length -1;
		int limInf = 0;
		int devolucion = -1;
		
		if (limSup == 1) 
			if(palabraAnalizada[0] == palabraAnalizada[1])
				return devolucion = 1;
			else return devolucion = -1;
		
		
		//palindromo
		while(limInf < limSup && palabraAnalizada[limInf] == palabraAnalizada[limSup])
		{
			limInf++; 
			limSup--;
		}
		
		if(limInf>=limSup)
			return devolucion = 1;
		
		
		//reseteo i-palindromo
		limSup = palabraAnalizada.length -1;
		limInf = 1;
		
		//i-palindromo
		
		while(limInf < limSup && palabraAnalizada[limInf] == palabraAnalizada[limSup])
		{
			limInf++;
			limSup--;
		}
		
		if(limInf>=limSup)
			devolucion = 2;
		
		//reseteo d-palindromo
		limSup = palabraAnalizada.length -2;
		limInf = 0;
		
		while(limInf < limSup && palabraAnalizada[limInf] == palabraAnalizada[limSup])
		{
			limInf++;
			limSup--;
		}
		
		if(limInf>=limSup)
			if(devolucion == 2)			//si ya era i-palindromo, retorno 4 porque tambien es d-palindromo
				return devolucion = 4;
			else
				return devolucion = 3;	//sino retorno 3 porque solo es d-palindromo
		
		return devolucion;
	}
}

