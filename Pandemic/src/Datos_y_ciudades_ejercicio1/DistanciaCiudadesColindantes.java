package Datos_y_Ciudades_ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DistanciaCiudadesColindantes {

public static void main(String [] args) {
	
	String nombreFichero1 = "ciudades.txt";
	String nombreFichero2 = "ciudadesRedactadas.txt";
	
	String nomCiudad = " ";
	int[]  arraynum = new int [3];
	String [] arrayciudad = new String[0];
	
	int[]  arraynum2 = new int [3];
	
	try {

		FileReader fileReader = new FileReader(nombreFichero1);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		FileWriter fileWriter = new FileWriter(nombreFichero2, true);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		String Linia = null ;
			
		do{
			
				//Linia sera una variable que almacenara el contenido de la primera linia del script.
				Linia = bufferedReader.readLine(); 
				
			if(Linia != null ){
				//Con split aremos que nos particione el String Linia en 4 partes separadas por ';'.
					String [] partes = Linia.split(";");
					 
					// metodo para asignarle al string el nombre de la ciudad.
					
					nomCiudad = partes[0];
					
					// metodo para asignarle al Array de int's la ubicación de la ciudad.

					arraynum[0] = Integer.parseInt(partes[1]);
					arraynum[1] = Integer.parseInt(partes[2].split(",")[0]);
					arraynum[2] = Integer.parseInt(partes[2].split(",")[1]);
					
					// metodo para asignarle al Array de String's Los nombres de ciudades Colindantes separadas por una ','.
					String [] ciudades = partes[3].split(",");
					arrayciudad = ciudades;
					
					//Texto que imprimira el lector de ficheros por cada linia leida con las variables anteriores.
					System.out.println();
					System.out.println("La Ciudad " +nomCiudad+ " esta en las cordenadas ("+arraynum[1]+" "+arraynum[2]+") sus ciudades colindantes son :");
					bufferedWriter.write("La Ciudad " +nomCiudad+ " esta en las cordenadas ("+arraynum[1]+" "+arraynum[2]+") sus ciudades colindantes son :");
					bufferedWriter.newLine();
					System.out.println();
					
							String ciudadColindante;
							String [] BuscarColindante;
							
							for(int i = 0; i < arrayciudad.length; i++){
								ciudadColindante = arrayciudad[i];								 
								try {
									FileReader fileReader2 = new FileReader(nombreFichero1);
									BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
									
										do {
											Linia = bufferedReader2.readLine();
											 BuscarColindante = Linia.split(";");
											
											if(BuscarColindante[0].equals(ciudadColindante)){
												arraynum2[1] = Integer.parseInt(BuscarColindante[2].split(",")[0]);
												arraynum2[2] = Integer.parseInt(BuscarColindante[2].split(",")[1]);
												
												//altura y base de Ciutat Originaria		
											int base1 = arraynum[1]; int altura1 = arraynum[2]; 		
												//altura y base de Ciutat Colindant
											int base2 = arraynum2[1]; int altura2 = arraynum2[2];
												//Calcul VECTOR
											int BASE = base1 - base2;	int ALTURA = altura1 - altura2;
												//Calcul Distancia VECTOR
											Double DISTANCIA = Math.sqrt(BASE * BASE + ALTURA * ALTURA);
											
											System.out.println("# "+arrayciudad[i]+", que esta a una distancia de "+DISTANCIA+" Km" );
											bufferedWriter.write("# "+arrayciudad[i]+", que esta a una distancia de "+DISTANCIA+" Km" );
											bufferedWriter.newLine();
												
												if(Linia != null ) {
													bufferedReader2.close();
													fileReader2.close();

												}
													
											}	
											
										}while(!BuscarColindante[0].equals(ciudadColindante));
										
										
								} catch (EOFException e1) {
									System.out.println("Has llegado al final");
								} catch (IOException e2) {	
								}	
							}
					
			}else if(Linia == null){
				
			}
		
		}while (Linia != null);
		bufferedWriter.close();
		fileWriter.close();
			
	} catch (EOFException e1) {
		System.out.println("Has llegado al final");
	} catch (IOException e2) {

	}
}


}