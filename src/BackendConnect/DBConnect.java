package BackendConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//1. Register driver
	 
	 Class.forName("com.mysql.jdbc.Driver");
	 
	 //2. Connection Establish
	 
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
	
	//3. Insert into table
//	String sql = "insert into testtable (username, password) values ('Chyante', 'gyante@123')";
//	Statement stm = conn.createStatement();
//	stm.execute(sql);
//	
//	//4. Clean up environment
//	
//	conn.close();
//	
//	//5. Displaying in console
//    System.out.println("Row added successfully");
    
    //6. View Table in COnsole
    String sql = "select * from testtable";
    Statement stm = conn.createStatement();
    ResultSet rs = stm.executeQuery(sql);
    while (rs.next()) {
    	System.out.println("ID =" +rs.getInt("id"));
    	System.out.println("Username =" +rs.getString("username"));
        System.out.println("Password=" +rs.getString("password"));
        System.out.println("------------------------------------------");
    }
    conn.close();
	
	//7. Update the table
//	String sql = "update testtable set username='bot' where id=1";
//	Statement stm = conn.createStatement();
//	stm.execute(sql);
//	conn.close();
//	System.out.println("Updated successfully");
	
	//8. Delete table
//	String sql = "delete from testtable where id=1";
//	Statement stm = conn.createStatement();
//	stm.execute(sql);
//	conn.close();
//	System.out.println("deleted successfully");
}
}
