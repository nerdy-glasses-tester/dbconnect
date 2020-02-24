package db;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBconnect {
	public static HashMap<String, Integer> GetSalesTerritoryCount() throws ClassNotFoundException {

		//SQLServerDriver driver = new SQLServerDriver();
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer> ();
		
		
        // Create a variable for the connection string.
        String connectionUrl = 
        		"jdbc:sqlserver://localhost:xxxx;"
        		+"databaseName=AdventureWorks2012;"
        		+"user=sa;"
        		+"password=password;"
                + "loginTimeout=30;";
        
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) 
        {
            String SQL = "select Sales.SalesTerritory.Name as Name, count(Sales.SalesTerritory.Name) as COUNT\n" + 
            		"from Sales.SalesOrderHeader inner join Sales.SalesTerritory \n" + 
            		"on Sales.SalesOrderHeader.TerritoryID=Sales.SalesTerritory.TerritoryID \n" + 
            		"where Sales.SalesOrderHeader.OrderDate between '2010-07-01' and '2011-12-31' \n" + 
            		"group by Sales.SalesTerritory.Name \n" + 
            		"order by count DESC";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("Name") + " " + rs.getString("Count"));
                
                hmap.put(rs.getString("Name"), Integer.parseInt(rs.getString("Count")));
            }
            
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return hmap;
    }
	
	
}
