package so.what;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbType 
{
	public static Connection get() throws IllegalArgumentException
	{
		ResourceBundle r = ResourceBundle.getBundle("whichdb");
		String dn = r.getString("dn");
		String url=r.getString("url");
		String userid = r.getString("userid");
		String password = r.getString("password");
		Connection con=null;
		try 
		{
			Class.forName(dn);
			con = DriverManager.getConnection(url,userid,password);
			
		
		} 
		catch (ClassNotFoundException e) 
		{
		// TODO Auto-generated catch block
		throw new IllegalArgumentException("connection not got");
		} // i want to talk in english
catch (SQLException e) 
		{
		// TODO Auto-generated catch block
		throw new IllegalArgumentException("connection not got");
		}
	return con;

	}
}