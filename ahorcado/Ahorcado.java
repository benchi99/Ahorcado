package ahorcado;

import java.util.Random;

public class Ahorcado {

	Random generador = new Random();
	
	private String palabra = null;
	private String[] palabras = new String[] {"SUSPENSO", "TIEMPO", "CANCER", "POUTINE", "WAIFU", "SHANTAE", "GORRO", "JARDINERIA", "TESLO", "ALFALEONO"};
	private char[] mascara = new char[20];
	private char[] letrasUsadas = new char[27];

	//CONSTRUCTOR QUE ESCOGE UNA PALABRA ALEATORIA Y GENERA LA MÁSCARA.
	
	public Ahorcado() {
		palabra = palabras[generador.nextInt(9)];
		
		for (int i = 0; i<palabra.length();i++) {
			mascara[i] = '-';
		}
	}
	
	//CONSTRUCTOR QUE COGE UNA PALABRA A PETICIÓN DEL USUARIO, Y GENERA LA MÁSCARA PARA ESA PALABRA.
	
	public Ahorcado(int noPalabra) {
		palabra = palabras[noPalabra];
		
		for (int i = 0; i<palabra.length();i++) {
			mascara[i] = '-';
		}
	}
	
	//IMPRIME LA MÁSCARA
	
	public void printMascara() {
		for(int i = 0;i<palabra.length();i++) {
			System.out.print(mascara[i]);
		}
	}
	
	//IMPRIME LAS LETRAS YA USADAS.
	
	public void printLetrasUsadas() {
		for (int i = 0;i<letrasUsadas.length-1;i++) {
			System.out.print(letrasUsadas[i]);
		}
	}
	
	//CUANDO EL USUARIO ACIERTA UNA O VARIAS LETRAS, MUESTRA LAS LETRAS EN LA MASCARA.
	
	public void descubreMascara(char caracter, int posicion) {
		mascara[posicion] = caracter;
	}
	
	//DEVUELVE LA PALABRA ESCOGIDA.
	
	public String getPalabra() {
		return this.palabra;
	}
	
	//SE ENCARGA DE COMPROBAR SI LA LETRA ESPECIFICADA ESTÁ EN LA PALABRA O NO.
	
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
