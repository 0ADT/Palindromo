package edu.unlam.pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Archivo {
	
	private String path;
	private String name;
	
	public Archivo(String path, String name) {
		
		this.path = path;
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		
		Archivo destino = (Archivo) obj;
		
		File fileOrigen = new File(this.path + this.name);
		File fileDestino = new File(destino.path + destino.name);
		
		Scanner scOrigen = null;
		Scanner scDestino = null;
		
		String cadenaOrigen = null;
		String cadenaDestino = null;
		boolean iguales = true;
		
		try {
			scOrigen = new Scanner(fileOrigen);
			scDestino = new Scanner(fileDestino);
			
			cadenaOrigen = scOrigen.nextLine();
			cadenaDestino = scDestino.nextLine();
			
			while (scOrigen.hasNextLine()  && scDestino.hasNextLine() && iguales) {
				
				cadenaOrigen = scOrigen.nextLine();
				cadenaDestino = scDestino.nextLine();
				
				if (!cadenaOrigen.equals(cadenaDestino))
					iguales = false;
			}
			
		if(scOrigen.hasNextLine() || scDestino.hasNextLine())
			iguales = false;
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scOrigen.close();
			scDestino.close();
		}
		
		return iguales;

	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	
}
