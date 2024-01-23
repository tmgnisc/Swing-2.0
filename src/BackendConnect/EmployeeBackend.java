package BackendConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeBackend {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// here we register the driver
	Class.forName("com.mysql.jdbc.Driver");
	
	//Connection Build or Connection establish
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "");
	
	//Answer number 1
//	// insert details in table
//	String sql = "insert into employeetable(emp_name, emp_age, emp_phone, emp_salary) values ('Raghav', '20', '98180000', '15000'),   ('Roshani', '22', '98485000', '5000'), ('Achyut', '25', '9874561', '25000'), ('Ashlesha', '20', '9856789', '14000')";
//	Statement stm = conn.createStatement();
//	stm.execute(sql);
//	
//	conn.close();
	
	
	//Answer number 2
//	String sql = "select * from employeetable";
//	Statement stm = conn.createStatement();
//	ResultSet rs = stm.executeQuery(sql);
//	while (rs.next()) {
//		System.out.println("Employee id=" +rs.getInt("emp_id"));
//		System.out.println("Employee name=" +rs.getString("emp_name"));
//		System.out.println("Employee age=" +rs.getInt("emp_age"));
//		System.out.println("Employee phone=" +rs.getInt("emp_phone"));
//		System.out.println("Empoyee salary=" +rs.getInt("emp_salary"));
//		System.out.println("---------------------------------------------------------------------");
//		
//				
//	}
//	
//	conn.close();
//	
	
	//Answer number 3
//	String sql = "delete from employeetable where emp_id=7";
//	Statement stm = conn.createStatement();
//	stm.execute(sql);
//	conn.close();
//	System.out.println("deleted success");
	
	
	//Answer number 4
//	String sql = "delete from employeetable where emp_name= 'Achyut'";
//	Statement stm= conn.createStatement();
//	stm.execute(sql);
//	conn.close();
//	System.out.println("Deleted");
	
   //Answer number 5
	
	String sql = "update employeetable set emp_salary=100000 where emp_name= 'Ashlesha'";
	Statement stm = conn.createStatement();
	stm.execute(sql);
	conn.close();
	System.out.println("Updated");
	}

}
