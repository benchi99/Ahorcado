package ahorcadoF;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AhorcadoF {

	//VARIABLES Y ARRAYS
	
	private String palabra = null;
	//private String[] palabras = new String[] { "SUSPENSO", "TIEMPO", "CANCER", "POUTINE", "WAIFU", "SHANTAE", "GORRO","JARDINERIA", "TESLO", "ALFALEONO" };
	private char[] mascara = new char[45];
	private char[] letrasUsadas = new char[27];

	//CONSTRUCTOR NON-ARG
	
	public AhorcadoF() {
		Random generador = new Random();
		Scanner entrada = null;
		try {
			entrada = new Scanner(new File ("palabras.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("¡No existe el archivo 'palabras.txt'! Crea uno para poder comenzar.");
			System.exit(0);
		}
		ArrayList<String> AListPalabras = new ArrayList<String>();
		
		while(entrada.hasNext()) {
			AListPalabras.add(entrada.next());
		}
		
		entrada.close();
		
		//palabra = palabras[generador.nextInt(9)];

		palabra = AListPalabras.get(generador.nextInt(AListPalabras.size())).toUpperCase();
		
		for (int i = 0; i < palabra.length(); i++) {
			mascara[i] = '-';
		}
	}

	//CONSTRUCTOR CON PALABRA DEFINIDA.
	
	public AhorcadoF(int noPalabra) {
		Scanner entrada = null;
		try {
			 entrada = new Scanner(new File ("palabras.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("¡No existe el archivo 'palabras.txt'! Crea uno para poder comenzar.");
			System.exit(0);
		}
		ArrayList<String> AListPalabras = new ArrayList<String>();
		
		while (entrada.hasNext()) {
			AListPalabras.add(entrada.next());
		}
		entrada.close();
		
		palabra = AListPalabras.get(noPalabra).toUpperCase();

		for (int i = 0; i < palabra.length(); i++) {
			mascara[i] = '-';
		}
	}

	public void printMascara() {
		for (int i = 0; i < palabra.length(); i++) {
			System.out.print(mascara[i]);
		}
	}

	public void printLetrasUsadas() {
		for (int i = 0; i < letrasUsadas.length - 1; i++) {
			System.out.print(letrasUsadas[i]);
		}
	}

	public void descubreMascara(char caracter, int posicion) {
		mascara[posicion] = caracter;
	}

	public String getPalabra() {
		return this.palabra;
	}

	public boolean usaLetra(char letra) {

		boolean error = false;

		for (int i = 0; i < letrasUsadas.length - 1; i++) {
			if (letrasUsadas[i] == letra) {
				error = true;
				break;
			} else if (letrasUsadas[i] == 0) {
				letrasUsadas[i] = letra;
				break;
			}
		}

		return error;
	}
}
