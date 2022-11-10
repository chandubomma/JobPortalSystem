package DATABASE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import USER.User;
import USER.ADMINISTRATOR.Administrator;
import USER.JOBSEEKER.JobSeeker;
import USER.RECRUITER.Recruiter;

public class AdministratorDb extends UserDb {
    public boolean addAdministratorRecord(Administrator administrator) throws SQLException{
        String Query = "insert into administrator values('"+administrator.getEmail()+"','"+administrator.getAdministratorKey()+"')";
        return statement.execute(Query);
    }

    public boolean deleteAdministratorRecord(Administrator administrator) throws SQLException{
        String Query = "delete from administrator where email="+administrator.getEmail();
        return statement.execute(Query);
    }

    public ArrayList<JobSeeker> getAllJobSeekers() throws SQLException{
        String Query = "select * from user where type = 'jobseeker'";
        
        ResultSet rs = statement.executeQuery(Query);
       
        ArrayList<JobSeeker> jobSeekerList  = new ArrayList<>();
        while(rs.next()){
            String Query2 = "select * from jobseeker where email = '"+rs.getString("email")+"'";
            ResultSet rs2 = statement.executeQuery(Query2);
            jobSeekerList.add(new JobSeeker(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("mobilenumber"),rs.getString("dateofbirth")
            ,rs2.getString("college"),rs2.getString("qualification"),rs2.getFloat("percentage"),rs2.getString("skill1"),rs2.getString("skill2"),rs2.getString("skill3"),rs2.getString("experience")));
        }
        return jobSeekerList;
    }

    public ArrayList<Recruiter> getAllRecruiters() throws SQLException{
        String Query = "select * from user where type = 'recruiter'";
        
        ResultSet rs = statement.executeQuery(Query);
       
        ArrayList<Recruiter> recruiterList  = new ArrayList<>();
        while(rs.next()){
           
            recruiterList.add(new Recruiter(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("password"),rs.getString("gender"),rs.getString("mobilenumber"),rs.getString("dateofbirth")));
            
        }
        return recruiterList;
    }
}
