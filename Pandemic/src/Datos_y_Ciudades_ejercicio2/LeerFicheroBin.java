package Datos_y_Ciudades_ejercicio2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

public class LeerFicheroBin { 
	
	public static String[] array = new String[4];

	
public static void main(String[] args){

	String nombreFichero = "CCP.bin";
	
		try {
			
			FileInputStream fileInputStream = new FileInputStream(nombreFichero);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			do {
				//Leemos las Instrucciones de los datos que se tienen que obtener el archivo CCP.bin
				String PrimeraLinia = dataInputStream.readUTF();
				System.out.println(PrimeraLinia);
				
				//Leemos los datos de las enfermedades ( CODIGO / NOMBRE / COLOR )
				for(int i = 0; i < 4; i++){
					System.out.println();
					System.out.println("Enfermedad "+i+" :");
					int CodigoEnfermedad = dataInputStream.readInt();
					System.out.println(CodigoEnfermedad);
					String NombreEnfermedad = dataInputStream.readUTF();
					array[i] = NombreEnfermedad;
					System.out.println(NombreEnfermedad);
					String ColorEnfermedad = dataInputStream.readUTF();
					System.out.println(ColorEnfermedad);
				}
				
				//Leemos cordenadas X e Y que son las dimensiones del MAPA
				System.out.println();
				int CordenadaX = dataInputStream.readInt();		
				System.out.println("CORDENADAS X: "+CordenadaX+" ");
				int CordenadaY = dataInputStream.readInt();
				System.out.println("CORDENADAS Y: "+CordenadaY);
				
			} while (true);
		//Cuando el programa acabe, saltar� esta excepci�n	
	}catch(EOFException e1) {
		System.out.println("Fichero le�do correctamente");
		System.out.println();
	} catch (FileNotFoundException e) {
		System.out.println("Ficheor no encontrado " + e);
		System.out.println();
	} catch (IOException e) {
		System.out.println("Ha habido un error de lectura " + e);
		System.out.println();
	}

		
		String nombreFichero1 = "CiudadesConEnfermedades.txt";
		String nombreFichero2 = "ciudades-enfermedad.bin";

			String Linia = null;
			String NombreEnfermedad = " ";
			String CiudadInicio= " ";
			
			try {
				
				FileReader fileReader = new FileReader(nombreFichero1);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				FileOutputStream fileOutputStream = new FileOutputStream(nombreFichero2);
				DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
					
				Linia = bufferedReader.readLine();
				
				
				do {
					
					if(Linia != null){
						
						String[] Informacion = Linia.split(";");
						
						//Nombre Ciudad infectada
						 CiudadInicio = Informacion[0];
						//Tipo de Infeccion
						int Infect = Integer.parseInt(Informacion[1]);
							
							if(Infect <= array.length){
								 NombreEnfermedad = array[Infect];
							}
							
						dataOutputStream.writeUTF("CIUDAD: "+CiudadInicio);		
						dataOutputStream.writeUTF("INFECCION: "+ NombreEnfermedad);
						
					}else if(Linia == null){
						dataOutputStream.close();
						dataOutputStream.close();
					}
					
					Linia = bufferedReader.readLine();
					
				}while(Linia != null);
			
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
			
				FileInputStream fi = new FileInputStream(nombreFichero2);
				DataInputStream di = new DataInputStream(fi);
				while (true) {
					
					 CiudadInicio = di.readUTF();
					System.out.println(CiudadInicio);
					
					 NombreEnfermedad = di.readUTF();
					System.out.println(NombreEnfermedad);
					System.out.println();
				}
			
			} catch (EOFException e1) {
				System.out.println("Has llegado al final");
			} catch (IOException e2) {
				
			}

}

}
