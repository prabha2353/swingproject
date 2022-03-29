package swingJDBCproj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
create table logindetails
(
   userid varchar(20),
   password varchar(15)
);

insert into logindetails(userid,password) values('admin','pass');


create table userdetails
(
    name varchar(25),
    email varchar(25),
    mobile varchar(25),
    address varchar(25),
    city varchar(25),
    gender varchar(25),
    interests varchar(25),
    dob varchar(25)
);
*/

public class BackEndForDBOperation 
{
	public boolean loginCheck(String uid, String pass)
	{
	   PreparedStatement pst =null;
	   ResultSet rs = null;
	   Connection mysqlconnection = null;
	   
	   boolean status = false;
	   
	   try
	   {
		  mysqlconnection = DBMySQLConnect.getMySQLConnection();
		   	   
	      String logincheckquery = "select * from logindetails where userid=? and password=?";
		  	   
		  pst = mysqlconnection.prepareStatement(logincheckquery);
		  pst.setString(1, uid);
		  pst.setString(2, pass);
				   
		  rs = pst.executeQuery();
			
		  if(rs.next())
		  {
			status= true;
		  }
		}catch(SQLException e) 
		 {
		     e.printStackTrace();
		   	 //System.out.println("Can't Insert Record - Database Problem");
		 }
		 finally 
		 {
		    try 
		    {
			   if (pst != null)
			      pst.close();
			   if(rs != null)
				  rs.close();
			   if(mysqlconnection != null)
			      mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		  } 	
		  
		  return status;
     }
	
	public int insertRecord(UserModel userobj)
	{
	  PreparedStatement pst =null;
      Connection mysqlconnection = null;
      try
      {
   	     mysqlconnection = DBMySQLConnect.getMySQLConnection();
   	   
   	   //Step 3 PREPARE QUERY
   	     String insertquery = "insert into userdetails(name,email,mobile,address,city,gender,interests,dob) values(?,?,?,?,?,?,?,?)";
  	   
   	     pst = mysqlconnection.prepareStatement(insertquery);
		 pst.setString(1, userobj.getName());
		 pst.setString(2, userobj.getEmail());
		 pst.setString(3, userobj.getMobile());
		 pst.setString(4, userobj.getAddress());
		 pst.setString(5, userobj.getCity());
		 pst.setString(6, userobj.getGender());
		 pst.setString(7, userobj.getInterests());
		 pst.setString(8, userobj.getDob());
		   
		 int replycountfromdb = pst.executeUpdate();
		 
		 return replycountfromdb;
  
   	 }catch(SQLException e) 
      {
   		e.printStackTrace();
   		System.out.println("Can't Insert Record - Database Problem");
      }
      finally 
      {
       	try 
       	{
		  if (pst != null)
		    pst.close();
		  if(mysqlconnection != null)
		    mysqlconnection.close();
		} catch (SQLException e) {e.printStackTrace();}
	   } 
	return 0;
    }
		
	public int deleteRecord(String email)
    {
	   PreparedStatement pst =null;
	   Connection mysqlconnection = null;
	   try
	   {
	      mysqlconnection = DBMySQLConnect.getMySQLConnection();
	   	   
	      //Step 3 PREPARE QUERY
	      String delquery = "delete from userdetails where email =?";
	  	   
	   	  pst = mysqlconnection.prepareStatement(delquery);
		  pst.setString(1, email);
			 
		  int replycountfromdb = pst.executeUpdate();
			 
		  return replycountfromdb;
	  
	   	 }catch(SQLException e) 
	      {
	   		e.printStackTrace();
	   		System.out.println("Can't Delete Record - Database Problem");
	      }
	      finally 
	      {
	       	try 
	       	{
			  if (pst != null)
			    pst.close();
			  if(mysqlconnection != null)
			    mysqlconnection.close();
			} catch (SQLException e) {e.printStackTrace();}
		   } 
		return 0;
		
    }
		
	/*public void updateRecord()
	{}
		
	public ArrayList<EmpModel> displayAllRecord()
	{
	  PreparedStatement pst =null;
	  ResultSet rs = null;
	  Connection mysqlconnection = null;
	  
	  ArrayList<EmpModel> emplist = new ArrayList<EmpModel>();
	  
	  try
	  {
	    mysqlconnection = DBConnect.getConnection();
	   	   
        String insertquery = "select * from emp1";
	  	   
		pst = mysqlconnection.prepareStatement(insertquery);
			   
		rs = pst.executeQuery();
		
		while(rs.next())
		{
			EmpModel eobj = new EmpModel();
			eobj.setEmpid(rs.getInt(1));
			eobj.setEmpname(rs.getString(2));
			eobj.setEmailid(rs.getString(3));
			eobj.setPassword(rs.getString(4));
			eobj.setCity(rs.getString(5));
			eobj.setSalary(rs.getDouble(6));
			
			//ADD Obj into ArrayList
			emplist.add(eobj);
		}
	  }catch(SQLException e) 
	   {
	     //e.printStackTrace();
	   	 System.out.println("Can't Insert Record - Database Problem");
	   }
	   finally 
	   {
	     try 
	     {
		   if (pst != null)
		    pst.close();
		   if(mysqlconnection != null)
		    mysqlconnection.close();
		 } catch (SQLException e) {e.printStackTrace();}
	   } 	
	  
	  return emplist;
	}
		
	public void searchRecord()
	{}
   */
}