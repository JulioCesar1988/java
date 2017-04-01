package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conector {

	private String URL;
	Connection conexion = null;

	public Conector(ParametrosConexion p) {
		// TODO Auto-generated constructor stub
		try{
			URL = buildURL(p);
			Class.forName(p.getDriverString());
			conexion = DriverManager.getConnection(URL, p.getUser(), p.getPass());
			System.out.println(URL);
		}
		
		catch(SQLException e){
			System.out.println("ERROR SQL_E");
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR CNFE");
		}
	}

	private String buildURL(ParametrosConexion p){
		String URL = new String();
		
		URL += "jdbc:sqlserver://";
		URL += p.getHost();
		URL += ":";
		URL += p.getPort();
		URL += ";databaseName=";
		URL += p.getBdName();
		URL += ";selectMethod=cursor;";
		
		return URL;
		
	}
	
	public Connection getConnection(){
		return this.conexion;
	}
/*
	public ResultSet executeQuery(String sqlQuery){
		Statement query;
		ResultSet resultado;

		try {
			query = conexion.createStatement();
			resultado = query.executeQuery(sqlQuery);
			return resultado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public int executeInsertPersonal(EmpleadoBean e){
	    PreparedStatement stmt = null;
	    int retorno = 0;
	    
	    try{
	    stmt = conexion.prepareStatement
        ("INSERT INTO personal(nombre, apellido, dni, domicilio, fecha_nac) VALUES (?,?,?,?,?)");

		stmt.setString(1, e.getNombre());
		stmt.setString(2, e.getApellido());
		stmt.setLong(3, e.getDni());
		stmt.setString(4, e.getDomicilio());
		stmt.setString(5, e.getFechaNacimiento());
		retorno =  stmt.executeUpdate();
	    }
	    catch(SQLException ex){
	    	ex.printStackTrace();
	    }
		return retorno;
		
	}
	
	
	public Connection getConexion() {
		return conexion;
	}



	
*/
}
	