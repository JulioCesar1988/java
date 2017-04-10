package bd;

public class ParametrosConexion {

	String host;
	String port;
	String bdName;
	String user;
	String pass;
	String driverString = new String("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
	public ParametrosConexion() {
		// TODO Auto-generated constructor stub
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getBdName() {
		return bdName;
	}
	public void setBdName(String bdName) {
		this.bdName = bdName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDriverString() {
		return driverString;
	}
	public void setDriverString(String driverString) {
		this.driverString = driverString;
	}
	public static ParametrosConexion getParametros(){
		ParametrosConexion retorno = new ParametrosConexion();
		retorno.setBdName("xxxxxxxxxxxxxxxxx");
		retorno.setPort("xxxx");
		
		/** Server Producción: SERVERPROTO **/
		retorno.setHost("xxxxxxxx);
		retorno.setUser("xxxxxxxxxx");
		retorno.setPass("xxxxxxxxx");
		
		/** Server Producción: WIN-9B65SB60LJ0 **/
		//retorno.setHost("xxxxxxxx");
		//retorno.setUser("dxxxxxxxxx");
		//retorno.setPass("xxxxxxxxxx");
		
		return retorno;
	}
	
	
}
