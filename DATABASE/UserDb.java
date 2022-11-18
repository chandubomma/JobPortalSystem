package DATABASE;
import java.sql.*;

import USER.User;
import USER.ADMINISTRATOR.Administrator;
import USER.JOBSEEKER.JobSeeker;
import USER.RECRUITER.Recruiter;

public class UserDb  {
    private  Connection connection;
    private  Database database;
    protected  Statement statement;
    protected   ResultSet resultSet;

    public UserDb() {
        database = new Database();
        
       try {
       
        connection = DriverManager.getConnection(database.getDbURL(),database.getDbUserName(),database.getDbPassword());
         statement = connection.createStatement();
        } catch (SQLException e) {
       
            e.printStackTrace();
        }
    }

    public   boolean addUserRecord(User user) throws SQLException{
        String Query = "insert into user values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getGender()+"','"+user.getMobileNumber()+"','"+user.getDateOfBirth()+"','"+user.getUserType()+"','"+user.isLoggedIn()+"')";
        return statement.execute(Query);
    }
     
    public  boolean deleteUserRecord(User user) throws SQLException{
        String Query = "delete from user where email="+user.getEmail();
        return statement.execute(Query);
    }

    public  String getUserPassword(String email) throws SQLException{
        String Query = "select password from user where email = '"+email+"'";
        resultSet = statement.executeQuery(Query);
        resultSet.next();
        return(resultSet.getString("password"));
    }

    public  User getUser(String email) throws SQLException{
        User user;
        String Query = "select * from user where email = '"+email+"'";
        ResultSet rs = statement.executeQuery(Query);
        rs.next();
        String userType = rs.getString("usertype");
        if(userType.toLowerCase().equals("jobseeker")){
            user = new JobSeeker(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("mobilenumber"),rs.getString("dateofbirth"));
            return user;
        }
        if(userType.toLowerCase().equals("recruiter")){
            user = new Recruiter(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("mobilenumber"),rs.getString("dateofbirth"));
            return user;
        }
        if(userType.toLowerCase().equals("administrator")){
            user = new Administrator(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("mobilenumber"),rs.getString("dateofbirth"));
            return user;
        }
        
        return null;
    }
}
