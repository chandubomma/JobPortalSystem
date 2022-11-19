package DATABASE.INFO;


import java.sql.*;
import java.util.ArrayList;

import DATABASE.UserDb;
import USER.ADMINISTRATOR.Administrator;
public class Info extends UserDb {
  ArrayList<String> Jobs= new ArrayList<String>();
  ArrayList<String> Companies= new ArrayList<String>();
   public void count(Administrator user) throws SQLException{
       
        resultSet =  statement.executeQuery("select usertype,count(email) from user group by usertype;");
      
         int js= resultSet.getInt(2);
         resultSet.next();
         int rc =resultSet.getInt(2);
         resultSet.next();
         int ad =resultSet.getInt(2);
         int total =js+rc+ad;
         System.out.println("                   Total logins : "+total);
         System.out.println("Jobseekers : "+js+"    Recruiters : "+rc+"Administraters : "+ad);
   }
  public void display_company() throws SQLException{
   int k=1;
   ResultSet resultSet = statement.executeQuery("select distinct company_name from jobs;");
   while(resultSet.next()){
    Companies.add(resultSet.getString(1));
     System.out.println(k+"."+resultSet.getString(1)); 
     k++;
   }
  }
 public void display_jobs() throws SQLException{
   int k=1;
   
   ResultSet resultSet =statement.executeQuery("Select distint job from jobs;");
   while(resultSet.next()){
     Jobs.add(resultSet.getString(1));
   System.out.println(k+"."+resultSet.getString(1));
   k++;
   }
 }
}
