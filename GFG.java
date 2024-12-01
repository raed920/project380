package project380;
import java.sql.*;


import javax.swing.JOptionPane;

public class GFG {
	
	
	public static void main(String arg[]) {
		connectToDatabase();
		Insert_lecturer(12,"saad","qwert",12000);
	}
		public static Connection connectToDatabase() {
			
	        String url = "jdbc:mysql://localhost:3306/mydb";
	        String user = "root";
	        String password = "1234567890Aa";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(url, user, password);
	        } catch (ClassNotFoundException | SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Database connection failed: " + ex.getMessage());
	            return null;
	        }
		}
	        

	        public static void Insert_lecturer(int ID, String FirstName,String LastName,int Salary) {
	        	 try{
	        	 Connection con=DriverManager.getConnection(
	        	 "jdbc:mysql://localhost:3306/mydb","root","1234567890Aa");
	        	 Statement st=con.createStatement();
	        	 String query1="INSERT INTO `lecturer`"
	        	 + " (`LecturerId`, `LecFirstName`, `LecLastName`, `Salary`)"
	        	 + "VALUES('" +ID+"','"+FirstName+"','"+LastName+"','"+Salary+"')";
	        	 st.executeUpdate(query1); // record added.
	        	 con.close();
	        	 }catch(Exception e){ System.out.println(e);}
	        	 }
	        public static void delate_lecturer(int id ) {
	        	 try{
		        	 Connection con=DriverManager.getConnection(
		        	 "jdbc:mysql://localhost:3306/mydb","root","1234567890Aa");
		        	 Statement st=con.createStatement();
		        	 String query1="DELETE FROM `lecturer` WHERE LecturerId="+id;
		        	 st.executeUpdate(query1); // record added.
		        	 con.close();
		        	 }catch(Exception e){ System.out.println(e);}
		        	 }
	        

            public static void Update(int id ,String Fname , String Lname , int salary) {
            	 try{
		        	 Connection con=DriverManager.getConnection(
		        	 "jdbc:mysql://localhost:3306/mydb","root","1234567890Aa");
		        	 Statement st=con.createStatement();
		        	 String query1="UPDATE `lecturer` SET "+"LecFirstName='"+Fname+"', "+"LecLastName='"+Lname+"', Salary="+salary+" WHERE LecturerId="+id;
		        	 st.executeUpdate(query1); 
		        	 System.out.println("updated");

		        	 
		        	 con.close();
		        	 }catch(Exception e){ System.out.println(e);}
		        	 }
            	
            
            public static void Search(int id) {
            	 try{
		        	 Connection con=DriverManager.getConnection(
		        	 "jdbc:mysql://localhost:3306/mydb","root","1234567890Aa");
		        	 Statement st=con.createStatement();
		        	 String query1="SELECT * FROM `lecturer` WHERE LecturerId="+id;
		        	 ResultSet r = st.executeQuery(query1); 
		        	 if(r.next()) {
		        		 int lecturerId = r.getInt("LecturerId");
		                 String firstName = r.getString("LecFirstName");
		                 String lastName = r.getString("LecLastName");
		                 int salary = r.getInt("Salary");
		                 System.out.println("Lecturer ID: " + lecturerId);
		                 System.out.println("First Name: " + firstName);
		                 System.out.println("Last Name: " + lastName);
		                 System.out.println("Salary: " + salary);

		        	 }
		        	 con.close();
		        	 }catch(Exception e){ System.out.println(e);}
		        	 }
            
	        	
}
