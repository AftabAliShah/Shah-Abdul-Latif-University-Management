package university;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnection {
	Connection con;
	Statement statement;
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_NAME = "salu_db";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String uid = "root";
	private static final String pass = "root";

	public DBConnection() {

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL + DATABASE_NAME, uid, pass);
			statement = con.createStatement();
		} catch (SQLException sqlException) {
			JOptionPane.showMessageDialog(null, "Sql Syntax Error");
			System.out.println("SQl Exception");
		} catch (ClassNotFoundException exception) {
			JOptionPane.showMessageDialog(null, "Import the Jar File || Import the SQL Drivers");
			System.out.println("Jar File Not Found");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error Happened");
		}

	}
}