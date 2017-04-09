package prueba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadExcel {

	public static void main(String[] args) {
		ReadExcel re = new ReadExcel();
		re.test();
	}
	
	private void test() {
		String csvFile = "C:\\OMAN\\julin\\excel.csv";
        String line = "";
        String cvsSplitBy = ";";

        try {
        	
        	BufferedReader br = new BufferedReader(new FileReader(csvFile));
        	boolean primero = true;

            while ((line = br.readLine()) != null) {
            	
            	// La primera fila no se toma en cuenta
            	if(!primero){
            		
            		String[] country = line.split(cvsSplitBy);
                    
                	if(country[0].trim().length()>0) {
                		System.out.println("Creando una pieza... ");
                		System.out.print("   Conjunto: " + country[0].trim());                		
                		System.out.print("   Dato1: " + country[1].trim());
                		System.out.print("   Cant. Conj.: " + country[3].trim());
                		System.out.print("   Longitud: " + country[6].trim());
                		System.out.print("   Peso: " + country[8].trim());
                		System.out.print("   Pintura: " + country[9].trim());
                		System.out.println("   Descripcion: " + country[10].trim());
                		
                	} else if (country[2].trim().length()>0) {
            			System.out.println("     Creando una subpieza... ");
            			System.out.print("        Parte: " + country[2].trim());                		
                		System.out.print("        Cant.: " + country[4].trim());
                		System.out.print("        Perfil: " + country[5].trim());
                		System.out.print("        Longitud: " + country[6].trim());
                		System.out.print("        Area: " + country[7].trim());
                		System.out.println("        Peso: " + country[8].trim());
                			
                	} else {
                		System.out.println();
                		System.out.println("                                                                                             Peso total: "+country[8].trim());
                		System.out.println("   -----------------------------------------------------------------------------------------------------------------");
                	}
            		
            	} else {
            		primero = false;
            	}
            }
            
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
