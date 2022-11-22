package DATABASE.INFO;


import java.sql.*;

import DATABASE.UserDb;
import USER.ADMINISTRATOR.Administrator;
public class Info extends UserDb {

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
     System.out.println(k+"."+resultSet.getString(1)); 
     k++;
   }
  }
 public void display_jobs() throws SQLException{
   ResultSet rs =statement.executeQuery("Select * from job;");
   System.out.println("--------------------------------------------------------------------------");
   System.out.printf("| %5s| %20s| %20s| %20s|\n","ID","Job title","loacation","company");
   System.out.println("--------------------------------------------------------------------------");
   while(rs.next()){
   System.out.printf("| %5s| %20s| %20s| %20s|\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
   }
   System.out.println("--------------------------------------------------------------------------");
 }
 public void dispay_users(Administrator user) throws SQLException{
  int c=0;
  ResultSet rs =statement.executeQuery("select * from users;");
  while(rs.next()){
    System.out.printf("| %30s| %20s| %10s",rs.getString("email"),rs.getString("usertype"),rs.getString("loginstatus"));
    if(rs.getString("loginstatus")=="1"){
      c++;
    }
  }
  System.out.println("Active users : "+c);
 }
}
