package DATABASE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import USER.User;
import USER.ADMINISTRATOR.Administrator;
import USER.JOBSEEKER.JobSeeker;
import USER.RECRUITER.Recruiter;

public class AdministratorDb extends UserDb {
    public   boolean addAdministratorRecord(Administrator administrator) throws SQLException{
        String Query = "insert into administrator values('"+administrator.getEmail()+"','"+administrator.getAdministratorKey()+"')";
        return statement.execute(Query);
    }

    public  boolean deleteAdministratorRecord(Administrator administrator) throws SQLException{
        String Query = "delete from administrator where email="+administrator.getEmail();
        return statement.execute(Query);
    }

    public  ArrayList<JobSeeker> getAllJobSeekers() throws SQLException{
        String Query = "select * from user where type = 'jobseeker'";
        ResultSet rs = statement.executeQuery(Query);
        ArrayList<JobSeeker> userList  = new ArrayList<>();
        while(resultSet.next()){
            userList.add(new JobSeeker(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("mobilenumber"),rs.getString("dateofbirth")));
        }
        return userList;
    }

    public  User getUser(String email) throws SQLException{
        User user;
        String Query = "select * from user where email = '"+email+"'";
        ResultSet rs = statement.executeQuery(Query);
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
