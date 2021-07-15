import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
abstract class emp{
	int id;
	int sal;
	int age;
	String name;
	String desig;
	Scanner sc=new Scanner(System.in);
	
	emp(String Desig){
		
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Proj","root","Cloud@123$");  
	Scanner sc = new Scanner(System.in);
	
	PreparedStatement pstmt=con.prepareStatement("insert into Proj values(?,?,?,?,?)");

	System.out.print("Enter The ID : ");
	int id=sc.nextInt();

	System.out.print("Enter The Name : ");
	String name=sc.next();
	
	System.out.print("Enter The Age : ");
	int age=sc.nextInt();
	
	System.out.print("Enter The Salary : ");
	int salary =sc.nextInt();
	this.desig=Desig;

	pstmt.setInt(1,id);
	pstmt.setString(2,name);
	pstmt.setInt(3,age);
	pstmt.setInt(4,salary);
	pstmt.setString(5,desig);

	Thread.sleep(5000);
	pstmt.execute();		
	System.out.println("Record Inserted............"); 
	pstmt.close();
	con.close();
}
catch(Exception e){
	System.out.println(e);
}
	
}

	emp(int i , String Desig){
		
	}
}

final class clerk extends emp{

	clerk(String desig)
	{
		super(desig);
	}
	public void display(){
		
	}
	
}

final class developer extends emp{
	developer(String desig)
	{
		super(desig);
	}
}

final class tester extends emp{

	tester(String desig)
	{
		super(desig);
	}
}

class Day3_inhert{
	static String d;
	static void display(String desig){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Proj","root","Cloud@123$");  
			PreparedStatement pstmt=con.prepareStatement("select * from Proj where desig = ?");
			pstmt.setString(1,desig);
			pstmt.execute();
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
			System.out.println(rs.getInt(1)+ " : "+rs.getString(2)+" : "+rs.getInt(3)+ " : "+rs.getInt(4)+ " : "+rs.getString(5));
			}
		
			pstmt.close();
			con.close();
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void raise(String desig){
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Proj","root","Cloud@123$");  
			PreparedStatement pstmt=con.prepareStatement("update Proj set sal=sal + ? where id=? and desig = ?");
			
			System.out.print("Enter The ID : ");
			int id=sc.nextInt();
			
			System.out.println("enter raise by");
			int age = sc.nextInt();
			pstmt.setInt(1,age);
			pstmt.setInt(2,id);
			pstmt.setString(3, desig);
			pstmt.execute();
			con.close();
			
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
		
public static void main(String arg[])
	{
	Scanner sc=new Scanner(System.in);
	int ch;

	do
	{	int c;
		System.out.print("1 Create\t 2 Display\t 3 Raise Salary \t 4 Back \n");
		System.out.print("===>");
		ch=sc.nextInt();	
		
		if(ch==1)
		{
			do
			{
				System.out.println();
				System.out.println("1 Clerk \t 2 Devloper \t 3 Tester \t 4 Exit");
				System.out.print("===>");
				c=sc.nextInt();
				if(c==1)
				{
				System.out.println("Enter details for Clerk");
				clerk ck=new clerk("Clerk");
				
				
				}else if(c==2){
					developer d=new developer("Developer");
					
				}else if(c==3)
				{
					tester t=new tester("Tester");
					
				}
				
			}while(c!=4);
			
		}
		
		else if(ch==2){
			System.out.println("Display Details of\n 1 Clerk \n 2 Developer \n 3 Tetser \n");
			int dc=sc.nextInt();

			if(dc==1){
				System.out.println("---------Details of Clerk ----------");
				display("Clerk");
				}
			else if(dc==2){
				System.out.println("---------Details of Developer ----------");
				display("Developer");
				}
			else if(dc==3){
				System.out.println("---------Details of Tester ----------");
				display("Tester");}		
		}
		
		else if(ch == 3){
			System.out.println("Raise Salaray of\n 1 Clerk \n 2 Developer \n 3 Tetser \n");
			int dc=sc.nextInt();
			
			if(dc==1){
				System.out.println("---------Salary raised of Clerk ----------");
				raise("Clerk");
				}
			
			else if(dc==2){
				System.out.println("---------Salary raised of developer ----------");
				raise("Developer");}
			
			else if(dc==3){
				System.out.println("---------Salary raised of Tester ----------");
				raise("Tester");
				}
		}
System.out.println();
}while(ch!=4);
	
System.out.println("Thank-You");	
}}
