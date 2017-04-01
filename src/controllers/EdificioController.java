package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import bd.Conector;
import bd.ParametrosConexion;
import models.EdificioBean;

public class EdificioController {
	Conector c;
	Connection conexion;
	
	public ArrayList<EdificioBean> getEdificiosPorObra(int obra) throws SQLException {
		ArrayList<EdificioBean> listado = new ArrayList<>();
		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_edificios (?)}");
			
			cs.registerOutParameter(1, Types.OTHER);
			System.out.println(obra);
			cs.setInt(2, obra);
			
	
			ResultSet resultado = cs.executeQuery();
			while (resultado.next()) {
				EdificioBean edificio = new EdificioBean();
				edificio.setNombre(resultado.getString(1));
				System.out.println(resultado.getString(1));
				edificio.setObservaciones(resultado.getString(2));
				
				
				
				listado.add(edificio);
				System.out.println("OK3");
				
			}		
			return listado;
		}catch (Exception e) {
		      e.printStackTrace();
		      return listado;
		} finally {
			conexion.close();
		}
	}

	public int insert(EdificioBean edi, int obra_num) throws SQLException {
		
		try {
		
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{call edificios_cargar (?, ?, ?, ?)}");
			cs.setInt(1, obra_num);
			cs.setString(2, edi.getNombre());
			cs.setString(3, edi.getObservaciones());
			
			cs.registerOutParameter(4, Types.INTEGER);
			cs.execute();
			
			return cs.getInt(4);
		}catch (Exception e) {
		      e.printStackTrace();
		      return -1;
		} finally {
			conexion.close();
		}		
	}

	public String[] getListaDeEdificiosParaModificar(int obra) throws SQLException {
		
		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_edificios (?)}");
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, obra);
			
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1));
			}
			String vector [] = pasarAVerctor(lista);
			return vector;
		}catch(Exception e){
			System.out.println("Consulta erronea");
			return null;
		}
		finally{
			conexion.close();
		}
	}
	private String[] pasarAVerctor(ArrayList<String> lista) {
		String vector [] = new String [lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			vector[i] = lista.get(i);	
		}
		return vector;
	}
	public int getEdificioParaModificar(int obra, String nomedificio,EdificioBean edificio) throws SQLException{
		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.edificio_devolver_para_modificar (?,?)}");
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, obra);
			cs.setString(3, nomedificio);
			
			ResultSet resultado = null;
			resultado = cs.executeQuery(); 
			if (resultado.next()) {
				
				edificio.setNombre(resultado.getString(1));
				edificio.setObservaciones(resultado.getString(2));
				
				return 1;
			}else {
				return 0;	
			}
			
		}catch(Exception e){
			System.out.println("Consulta erronea");
			return -1;
		}
		finally{
			conexion.close();
		}
		
	}
public int modificar(EdificioBean edificio, int obra) throws SQLException {
		
		try {
			
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{call edificios_modificar (?, ?, ?, ?)}");
			
			cs.setInt(1, obra);
			cs.setString(2, edificio.getNombre());
			cs.setString(3, edificio.getObservaciones());
			
			
			cs.registerOutParameter(4, Types.INTEGER);
			cs.execute();
			return cs.getInt(4);
		}catch (Exception e) {
		      e.printStackTrace();
		      return -1;
		} finally {
			conexion.close();
		}
	}
	
public int eliminar(String edificio, int obra_num) throws SQLException {
	try {
		c = new Conector(ParametrosConexion.getParametros());
		conexion = c.getConnection();
		CallableStatement cs = conexion.prepareCall("{call edificios_eliminar (?, ?,?)}");
		cs.setInt(1, obra_num);
		cs.setString(2, edificio);
		cs.registerOutParameter(3, Types.INTEGER);
		cs.execute();
		return cs.getInt(3);
	}catch (Exception e) {
	      e.printStackTrace();
	      return -1;
	} finally {
		conexion.close();
	}
}

public int getIdEdificioPorNombre(String nombre, int id_obra) throws SQLException {
	try {
	
		c = new Conector(ParametrosConexion.getParametros());
		conexion = c.getConnection();
		CallableStatement cs = conexion.prepareCall("{call edificio_devolverid (?, ?,?)}");
		cs.setString(1, nombre);
		cs.setInt(2, id_obra);
		cs.registerOutParameter(3, Types.INTEGER);
		cs.execute();
		return cs.getInt(3);
	}catch (Exception e) {
	      e.printStackTrace();
	      return -1;
	} finally {
		conexion.close();
	}		

}
	
}
