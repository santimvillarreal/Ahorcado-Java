import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {

        // Clase scanner para recibir entrada
        Scanner scanner = new Scanner(System.in);

        // Declaración de variables necesarias
        String palabraSecreta = "remodelacion";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean acertado = false;

        // Arreglo
        char[] letras = new char[palabraSecreta.length()];

        // Bucle para asignar valor a los indices
        for (int i = 0; i < letras.length; i++) {
            letras[i] = '_';
        }

        boolean subioIntento = false;

        while(!acertado && intentos < intentosMaximos){
            System.out.println("Palabra adivinar: " + String.valueOf(letras)+ " (" + palabraSecreta.length() + " letras)");
            if(!subioIntento){
                System.out.println("Numero de intentos disponibles = " + (intentosMaximos - intentos));
            }
            System.out.println("Introduce una palabra o letra >");
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                // Condicional
                if(palabraSecreta.charAt(i) == letra){
                    letras[i] = letra;
                    letraCorrecta = true;
                    subioIntento = false;
                }
            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
                subioIntento = true;
            }

            if(String.valueOf(letras).equals(palabraSecreta)){
                acertado = true;
                System.out.println("¡Felicitaciones! Adivinaste la palabra: " + palabraSecreta);
            }
        }
        if(!acertado){
            System.out.println("Te quedaste sin intentos. GAME OVER.");
        }
        scanner.close();
    }
}
