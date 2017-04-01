package views;

import java.sql.SQLException;
import java.util.ArrayList;

import controllers.AreaController;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AreaController c = new AreaController();
		

	  try {
		  
	String[] lista = c.getListaDeAreas();
		
     System.out.println(lista.length);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		

	}

}
