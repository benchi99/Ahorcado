package ahorcado;

import java.util.Scanner;

public class TestAhorcado {

	public static void printErr(int noErrores) {
		if (noErrores == 1)
			System.out.println("¡Has fallado! Tienes un fallo.");
		else
			System.out.println("¡Has fallado! Tienes " + noErrores + " fallos.");
	}

	public static void main(String[] args) {

		//DECLARACIÓN DE VARIABLES.
		
		boolean debug = false;

		final String LE = "LETRA", RE = "RESUELVO", SA = "SALIR";
		final int MAX_ERRORES = 6;
		int noErrores = 0, noAciertos = 0;
		boolean cambio, victoria = false;

		Scanner entrada = new Scanner(System.in);
		Ahorcado juego = new Ahorcado(0);

		while (noErrores < MAX_ERRORES) {
			cambio = false;

			// CODIGO DEBUG.

			if (debug) {
				System.out.println("DEBUG\nPALABRA: " + juego.getPalabra());
				System.out.println("Nº errores: " + noErrores + "\nNº aciertos: " + noAciertos + "\nCambio: " + cambio + "\nVictoria: " + victoria);
			}

			// COMIENZO DEL PROGRAMA

			if (victoria == false) {
				juego.printMascara();
				if (noAciertos > 0 || noErrores > 0) {
					System.out.println();
					juego.printLetrasUsadas();
				}
				System.out.println("\n¿Letra o resuelves?");
				String elecc = entrada.nextLine().toUpperCase();

				// SI EL USUARIO ESCOGE RESOLVER, PALABRA SE EJECUTA ESTO

				if (elecc.equals(RE)) {
					System.out.println("¿Qué palabra es?");
					elecc = entrada.nextLine().toUpperCase();
					if (elecc.equals(juego.getPalabra())) {
						System.out.println("¡Enhorabuena, has acertado! En efecto, la palabra era '" + juego.getPalabra().toLowerCase() + "'.");
						System.exit(1);
					} else {
						noErrores++;
						printErr(noErrores);
					}

					// SI EL USUARIO ESCOGE METER UNA LETRA, SE EJECUTA ESTO

				} else if (elecc.equals(LE)) {
					System.out.print("Introduzca letra: ");
					elecc = entrada.nextLine().toUpperCase();
					char caract = elecc.charAt(0);
					
					//COMPRUEBA SI LA LETRA SE HA USADO YA O NO
					if (juego.usaLetra(caract)) {
						System.out.println("¡Ya has usado esa letra!");
						noErrores++;
						printErr(noErrores);
					} else {
					
					//SI NO SE HA USADO, COMPRUEBA SI LA LETRA ESTÁ EN LA PALABRA ESCOGIDA.
						for (int i = 0; i < juego.getPalabra().length(); i++) {
							if (caract == juego.getPalabra().charAt(i)) {
								juego.descubreMascara(caract, i);
								cambio = true;
								noAciertos++;
							}
						}
						if (cambio == false) {
							noErrores++;
							printErr(noErrores);
						}
					}

					// SI EL USUARIO ESCRIBE SALIR, SE EJECUTA ESTO

				} else if (elecc.equals(SA)) {
					System.out.println("¡Gracias por jugar!");
					System.exit(0);

					// SI NINGUNA DE LAS OPCIONES SE ESCOGEN, SE EJECUTA ESTO

				} else {
					System.out.println("¡Escoge una opción válida!");
				}
			}

			/*
			 * El juego comprueba siempre al final que si el número de aciertos es igual al
			 * número de letras. Si es así, se rompe el bucle.
			 */

			if (noAciertos == juego.getPalabra().length()) {
				victoria = true;
				break;
			}
		}

		// Comprueba si el booleano victoria es verdadero o no. Si es verdadero, el
		// usuario gana.

		if (victoria) {
			System.out.println("¡Has ganado! ¡La palabra era '" + juego.getPalabra().toLowerCase() + "'.");
		} else {
			System.out.println("Has perdido. COMO HAS PODIDO DEJARLE MORIR, MONSTRUO. La palabra era " + juego.getPalabra().toLowerCase());
		}
		entrada.close();
	}

}
