package DATABASE.INFO;


import java.sql.*;

import com.mysql.cj.protocol.Resultset;

import DATABASE.Database;
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
         System.out.println("Jobseekers : "+js+"    Recruiters : "+rc+"Administraters : "+ad)
   }
  public void display_company() throws SQLException{
   int k=1;
   ResultSet rs = st.executeQuery("select distinct company_name from jobs;");
   while(rs.next()){
     System.out.println(k+"."+rs.getString(1)); 
     k++;
   }
  }
 public void display_jobs() throws SQLException{
   int k=1;
   ResultSet rs =st.executeQuery("Select distint job from jobs;");
   System.out.println(k+"."+rs.getString(1));
   k++;
 }
}
