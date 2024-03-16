package findSilco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Decodificar {

    public static void main(String[] args) {

        String nombreFichero = "ciudades.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(";");
                String[] coordenadas = datos[2].split(",");
                String[] ciudadExtra = datos[3].split(",");

                String ciudad = datos[0];
                int[] coordenadasInt = {Integer.parseInt(datos[1]), Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1])};

                System.out.print("Silco actúa en " + ciudad + " con los numeros " +
                        coordenadasInt[0] + ", " + coordenadasInt[1] + " y " + coordenadasInt[2] +
                        ", y cuyas ciudades colindantes son ");

                for (int i = 0; i < ciudadExtra.length; i++) {
                    if (i != ciudadExtra.length - 1) {
                        System.out.print(ciudadExtra[i] + " - ");
                    } else {
                        System.out.print(ciudadExtra[i] + ".");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Ha habido un error al intentar abrir el fichero" + e);
        }
    }
}
