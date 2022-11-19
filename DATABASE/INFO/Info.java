package DATABASE.INFO;


import java.sql.*;
import java.util.ArrayList;

import DATABASE.UserDb;
import USER.ADMINISTRATOR.Administrator;
import USER.RECRUITER.Recruiter;
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
 public void viewapplicants(Recruiter recruiter,String job_id) throws SQLException{
   ResultSet rs = statement.executeQuery("select * from user where email_id in (select email_id from applicants where company_name ='"+job_id+"';");

   while(rs.next()){
  System.out.printf("| %20s | %20s | %6s | %11s | %30s | %11s |",rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(7),rs.getString(3),rs.getString(6));
   }
   rs = statement.executeQuery("select Count(email_id) from applicants where job_id = '"+job_id+"';");
  }
  public void getProfile(String email_id) throws SQLException{
    ResultSet rs = statement.executeQuery("select * from Jobseeker where email_id='"+email_id+"';");
    rs.next();
    System.out.println("Email :"+rs.getString("email_id"));
    }
  }

