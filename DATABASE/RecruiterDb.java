package DATABASE;

import java.sql.SQLException;

import USER.RECRUITER.Job;
import USER.RECRUITER.Recruiter;

public class RecruiterDb extends UserDb {
    public  boolean addRecruiterRecord(Recruiter recruiter) throws SQLException{
        String Query = "insert into recruiter values('"+recruiter.getEmail()+"','"+recruiter.getCompanyName()+"','"+recruiter.getDesignation()+"')";
        return statement.execute(Query);
    }

    public  boolean deleteRecruiterRecord(Recruiter recruiter) throws SQLException{
        String Query = "delete from recruiter where email="+recruiter.getEmail();
        return statement.execute(Query);
    }

    public  boolean addJobRecord(Job job) throws SQLException{
        String Query = "insert into job values ('"+job.getId()+"','"+job.getJobTitle()+"','"+job.getDescription()+"','"+job.getCompanyName()+"','"+job.getSkillRequired()+"','"+job.getNumberOfVacancies()+"','"+job.getLocation()+"','"+job.getMinExperience()+"','"+job.getMaxAge()+"','"+job.getDeadline()+"')";
        return statement.execute(Query);
    }
    public  boolean updateUserLoginStatus(String email,boolean status) throws SQLException{
        String Query = "update user set loginstatus ="+status;
        return statement.execute(Query);
    }
}
