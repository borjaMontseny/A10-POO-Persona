import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Data data0 = new Data(30, 12, 2000);
//
//		data0.sumarDia();
//
//		NIF nif0 = new NIF(48000833);
//
//		Persona persona1 = new Persona("Borja", data0, nif0);
//
//		System.out.println("Exemple " + persona1.toString());

		Scanner sc = new Scanner(System.in);

		// He decidit guardar les persones en un array
		Persona[] arrayPersones = new Persona[3];

		// Creem les persones i les anem introduïnt
		for (int i = 0; i < arrayPersones.length; i++) {
			System.out.println("Persona " + (i + 1));
			arrayPersones[i] = crearPersona(sc);
			System.out.println("");
		}

		sc.close();

		// mètode que recorre l'array i fa persona.toString
		mostrarPersones(arrayPersones);

	}

	public static Data crearData(Scanner sc) {

		int dia;
		int mes;

		do {
			System.out.print("Dia: ");
			dia = sc.nextInt();

			System.out.print("Mes: ");
			mes = sc.nextInt();
		} while (!Data.comprovarDataCorrecta(dia, mes));

		System.out.print("Any: ");
		int any = sc.nextInt();

		Data data = new Data(dia, mes, any);

		return data;
	}

	public static NIF crearNIF(Scanner sc) {

		String nifString;
		do {
			System.out.print("NIF: ");
			nifString = sc.next();
			if (nifString.length() != 8) {
				System.out.println("El NIF ha de tenir 8 caràcters.");
			}
		} while (nifString.length() != 8);

		int nifInt = Integer.parseInt(nifString);

		NIF nif = new NIF(nifInt);

		return nif;

	}

	public static Persona crearPersona(Scanner sc) {

		System.out.print("Introdueix un nom: ");
		String nom = sc.next();

		Persona persona = new Persona(nom, crearData(sc), crearNIF(sc));

		return persona;

	}

	public static void mostrarPersones(Persona[] arrayPersones) {
		for (int i = 0; i < arrayPersones.length; i++) {
			System.out.println(arrayPersones[i].toString());
		}
	}

}
