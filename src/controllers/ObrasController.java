package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import bd.Conector;
import bd.ParametrosConexion;
import models.ObraBean;



public class ObrasController {

	Conector c;
	Connection conexion;

	public int insert(ObraBean obra, String usuario) throws SQLException {

		try {
		
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{call obra_cargar (?, ?, ?, ?, ?, ?, ?,?,?,?)}");
			cs.setInt(1, obra.getNumero());
			cs.setString(2, obra.getNombre());
			cs.setString(3, obra.getFirma());
			cs.setString(4, obra.getCuit());
			cs.setString(5, obra.getCalle());
			cs.setString(6, obra.getLocalidad());
			cs.setString(7, obra.getProvincia());
			cs.setString(8, obra.getPais());
			cs.setString(9, usuario);
			
			
			
			cs.registerOutParameter(10, Types.INTEGER);
			cs.execute();
			return cs.getInt(10);
		}catch (Exception e) {
		      e.printStackTrace();
		      return -1;
		} finally {
			conexion.close();
		}		
	}
	
	
	public ArrayList<ObraBean> getTodas() throws SQLException{
		try{
			String queryString = "SELECT * FROM Obras;";
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			PreparedStatement query = (PreparedStatement) conexion.prepareStatement(queryString);
			ResultSet resultados = query.executeQuery();
			
			ArrayList<ObraBean> obras = new ArrayList<ObraBean>();
			while(resultados.next()){
				ObraBean obra = new ObraBean();
				obra.setTodo(resultados.getInt(1), resultados.getInt(2), resultados.getString(3), resultados.getString(4), resultados.getString(5),
						resultados.getString(6), resultados.getString(7));
			
				obras.add(obra);
			}

			return obras;
		//	return resultados;
		}catch(Exception e){
			System.out.println("Consulta erronea");
			return null;
		}
		finally{
			conexion.close();
		}
		
	}
	
	public void imprimirListaDeObras( ArrayList<ObraBean> lista) {
		ObraBean aux;
		for (int i = 0; i < lista.size(); i++) {
			aux = lista.get(i);
			System.out.println(aux.getId_obra() + " " + aux.getNumero() + " " + aux.getNombre() + " " + 
					aux.getCalle() + " " + aux.getLocalidad() + " " + aux.getProvincia() + " " + 
					aux.getPais());
		}
	}


	public String[] getListaDeObra() throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_combobox ()}");
			
			cs.registerOutParameter(1, Types.OTHER);
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1)+" - "+resultado.getString(2));
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
	
	public String[] getListaDeObraRemitosDespachadas() throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_combobox_remitos_despachadas ()}");
			
			cs.registerOutParameter(1, Types.OTHER);
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1)+" - "+resultado.getString(2));
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
	
	public String[] getListaDeObraTareasPendientes() throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_combobox_tareas_pendientes ()}");
			
			cs.registerOutParameter(1, Types.OTHER);
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1)+" - "+resultado.getString(2));
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
	public String[] getListaDeObraTareasFinalizadas() throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_combobox_tareas_finalizadas2 ()}");
			
			cs.registerOutParameter(1, Types.OTHER);
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1)+" - "+resultado.getString(2));
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
	
	public String[] getListaDeObra(String elemento, String correlatividad) throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_combobox_por_elemento_correlatividad (?,?)}");
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setString(2, elemento);
			cs.setString(3, correlatividad);
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1)+" - "+resultado.getString(2));
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


	public String[] getDatosObra(int numO) throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver (?)}");
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, numO);
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1));
				lista.add(resultado.getString(2));
				lista.add(resultado.getString(3));
				lista.add(resultado.getString(4));
				lista.add(resultado.getString(5));
				lista.add(resultado.getString(6));
				lista.add(resultado.getString(7));
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


	public int insert2(ObraBean obra, String usuario) throws SQLException {
		try {
		
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{call obra_modificar (?, ?, ?, ?, ?, ?,?,?,?,?)}");
			cs.setInt(1, obra.getNumero());
			cs.setString(2, obra.getNombre());
			cs.setString(3, obra.getFirma());
			cs.setString(4, obra.getCuit());
			cs.setString(5, obra.getCalle());
			cs.setString(6, obra.getLocalidad());
			cs.setString(7, obra.getProvincia());
			cs.setString(8, obra.getPais());
			cs.setString(9, usuario);
			
			
			
			cs.registerOutParameter(10, Types.INTEGER);
			cs.execute();
			return cs.getInt(10);
		}catch (Exception e) {
		      e.printStackTrace();
		      return -1;
		} finally {
			conexion.close();
		}		
	
	}
	
	public int getIdObraPorId(int numObra) throws SQLException {
		try {
		
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{call obra_devolverid (?, ?)}");
			cs.setInt(1, numObra);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.execute();
			return cs.getInt(2);
		}catch (Exception e) {
		      e.printStackTrace();
		      return -1;
		} finally {
			conexion.close();
		}		
	
	}
	
	public ObraBean getObraPorNumero (int numObra) throws SQLException {
		ObraBean obra = new ObraBean();
		try {
		
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{call obra_devolver (?)}");
			cs.setInt(1, numObra);
			cs.execute();
			ResultSet resultado = cs.executeQuery();
			if(resultado.next()){
				obra.setNombre(resultado.getString(1));
				obra.setFirma(resultado.getString(2));
				obra.setCuit(resultado.getString(3));
				obra.setCalle(resultado.getString(4));
				obra.setLocalidad(resultado.getString(5));
				obra.setProvincia(resultado.getString(6));
				obra.setPais(resultado.getString(7));
				obra.setNumero(numObra);
				return obra;
			} else {
				return null;
			}
			
		}catch (Exception e) {
		      e.printStackTrace();
		      return null;
		} finally {
			conexion.close();
		}		
	
	}
	
	public String[] getListaDeObraDesaprobar() throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_combobox_desaprobar ()}");
			
			cs.registerOutParameter(1, Types.OTHER);
			
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1)+" - "+resultado.getString(2));
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
	
	public String[] getListaDeObraDesaprobarCtrlProd() throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_combobox_desaprobar_ctrl_prod ()}");
			
			cs.registerOutParameter(1, Types.OTHER);
			
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1)+" - "+resultado.getString(2));
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
	public String[] getListaDeObraTareasFinalizadasDias() throws SQLException {

		try{
			c = new Conector(ParametrosConexion.getParametros());
			conexion = c.getConnection();
			CallableStatement cs = conexion.prepareCall("{ ? = call dbo.obra_devolver_combobox_tareas_finalizadas3 ()}");
			
			cs.registerOutParameter(1, Types.OTHER);
	
			ResultSet resultado = cs.executeQuery();
			ArrayList<String> lista = new ArrayList<String>();
			while(resultado.next()){
				lista.add(resultado.getString(1)+" - "+resultado.getString(2));
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
	
}


	
	
