package dats.dbutils;
import java.sql.*;

public class DbConnection {
	
	private static Connection con;
	
	public static Connection openConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor_db","root","root");
		} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnection()
	{
		try {
			if(con!=null)
				con.close();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
	}
	
//	public static void main(String[] args)
//	{
//		Connection con= openConnection();
//		System.out.println(con);
//	}

}
