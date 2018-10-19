package ahorcado;

import java.util.Random;

public class Ahorcado {

	Random generador = new Random();
	
	private String palabra = null;
	private String[] palabras = new String[] {"SUSPENSO", "TIEMPO", "CANCER", "POUTINE", "WAIFU", "SHANTAE", "GORRO", "JARDINERIA", "TESLO", "ALFALEONO"};
	private char[] mascara = new char[20];
	private char[] letrasUsadas = new char[27];

	
	
	public Ahorcado() {
		palabra = palabras[generador.nextInt(9)];
		
		for (int i = 0; i<palabra.length();i++) {
			mascara[i] = '-';
		}
	}
	
	public Ahorcado(int noPalabra) {
		palabra = palabras[noPalabra];
		
		for (int i = 0; i<palabra.length();i++) {
			mascara[i] = '-';
		}
	}
	
	public void printMascara() {
		for(int i = 0;i<palabra.length();i++) {
			System.out.print(mascara[i]);
		}
	}
	
	public void printLetrasUsadas() {
		for (int i = 0;i<letrasUsadas.length-1;i++) {
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
		
		for (int i = 0; i<letrasUsadas.length-1;i++) {
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
