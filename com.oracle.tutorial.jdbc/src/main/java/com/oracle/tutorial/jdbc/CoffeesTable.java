package com.oracle.tutorial.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoffeesTable {
	
	public static void viewTable(Connection con) throws SQLException{
		Statement stmt = null;
		String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
		try{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String coffeeName = rs.getString("COF_NAME");
				int supplierID = rs.getInt("SUP_ID");
				float price = rs.getFloat("PRICE");
				int sales = rs.getInt("SALES");
				int total = rs.getInt("TOTAL");
				System.out.println(coffeeName + ", " + supplierID + ", " + price + ", " + sales + ", " + total);
			}
			
		} catch(SQLException e){
			JDBCTutorialUtilities.printSQLException(e);
		}finally{
			if(stmt != null){
				stmt.close();
			}
		}
	}

}
