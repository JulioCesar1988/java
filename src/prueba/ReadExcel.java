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
        	
        	line = br.readLine(); // Leo la primera fila con los nombres de las columnas
        	line = br.readLine(); // Leo la primera pieza
        	String pieza = "";
            while (line != null) {
            		
        		String[] country = line.split(cvsSplitBy);
                
            	if(country[0].trim().length()>0) {
            		pieza = country[0].trim();
            		System.out.print("Creando la pieza: " + pieza);
            		System.out.print("   Dato1: " + country[1].trim()); System.out.print("   Cant. Conj.: " + country[3].trim()); 
            		System.out.print("   Longitud: " + country[6].trim()); System.out.print("   Peso: " + country[8].trim()); 
            		System.out.print("   Pintura: " + country[9].trim()); System.out.println("   Descripcion: " + country[10].trim());
            		
            		line = br.readLine();
            		
            	} else if (country[2].trim().length()==0) { // OPCIONAL: se podría quitar este else si se borran los totales del excel
            		System.out.println();
            		System.out.println("                                                                                             Peso total: "+country[8].trim());
            		System.out.println("   -----------------------------------------------------------------------------------------------------------------");
            		
            		line = br.readLine();

            	} else {
            		// Mientras encuentre subpiezas las proceso
            		System.out.println("     Creando subpiezas para la pieza: " + pieza);
	            	while (line != null && country[2].trim().length()>0) {
	        			System.out.print("        Parte: " + country[2].trim());                		
	            		System.out.print("        Cant.: " + country[4].trim());
	            		System.out.print("        Perfil: " + country[5].trim());
	            		System.out.print("        Longitud: " + country[6].trim());
	            		System.out.print("        Area: " + country[7].trim());
	            		System.out.println("        Peso: " + country[8].trim());
	            		
	            		line = br.readLine();
	            		if(line!=null) 
	            			country = line.split(cvsSplitBy);
	            	}
	            	
            	}
            	
            }
            
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
