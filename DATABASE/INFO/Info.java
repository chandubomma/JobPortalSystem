package DATABASE.INFO;
<<<<<<< HEAD

import java.sql.*;
import DATABASE.Database;
import USER.ADMINISTRATOR.Administrator;
public class Info {
    Database Db=new Database();
    Connection con;
    Statement st;
    public void infoDb() {     
       try {
        con = DriverManager.getConnection(Db.getDbURL(),Db.getDbUserName(),Db.getDbPassword());
         st = con.createStatement();
        } catch (SQLException e) {
       
            e.printStackTrace();
        }
    }
=======
import USER.ADMINISTRATOR.Administrator;
import java.sql.*;
import DATABASE.Database;
public class Info {
    Database Db=new Database();
    Connection con =DriverManager.getConnection(Db.getDbURL(),Db.getDbUserName(),Db.getDbPassword());
    Statement st =   con.createStatement();
 
>>>>>>> ac29f4e189483bbae3486e9edb6aea4ee0660af4
   public void count(Administrator user) throws SQLException{
       
       ResultSet rs =  st.executeQuery("select usertype,count(email) from user group by usertype;");
      
         int js= rs.getInt(2);
         rs.next();
         int rc =rs.getInt(2);
<<<<<<< HEAD
         rs.next();
         int ad =rs.getInt(2);
         int total =js+rc+ad;
         System.out.println("                   Total logins : "+total);
         System.out.println("Jobseekers : "+js+"    Recruiters : "+rc+"Administraters : "+ad);
=======
         int total =js+rc;
         System.out.println("       Total logins : "+total);
         System.out.println("Jobseekers : "+js+"    Recruiters : "+rc);
>>>>>>> ac29f4e189483bbae3486e9edb6aea4ee0660af4
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
 }
<<<<<<< HEAD

=======
>>>>>>> ac29f4e189483bbae3486e9edb6aea4ee0660af4
}
