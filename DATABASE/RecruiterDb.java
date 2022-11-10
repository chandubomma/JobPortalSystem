package DATABASE;

import java.sql.SQLException;

import USER.RECRUITER.Job;
import USER.RECRUITER.Recruiter;

public class RecruiterDb extends UserDb {

   public boolean addJob(Job job) throws SQLException{
        String Query =( "insert into job values ('"+job.getId()+"','"+job.getJobTitle()+"','"+job.getLocation()+"','"+job.getCompanyName()+"','"+
       job.getDeadline()+"','"+job.getNumberOfVacancies()+"','"+job.getSkillRequired()+"','"+job.getMaxAge()+"','"+job.getMinExperience()+"','"+job.getDescription()+"','"+job.isActive()+"'" );
        return statement.execute(Query);

   }

   public boolean deleteJob(String jobID) throws SQLException{
        String Query = "delete from job where id = '"+jobID+"'";
        return statement.execute(Query);
   }

}


