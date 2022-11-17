package DATABASE;

import java.sql.ResultSet;
import java.sql.SQLException;

import USER.JOBSEEKER.JobSeeker;
import USER.RECRUITER.Job;

public class JobSeekerDb extends UserDb {
    public  boolean addJobSeekerRecord(JobSeeker jobSeeker) throws SQLException{
        String Query = "insert into jobseeker values('"+jobSeeker.getEmail()+"','"+jobSeeker.getExperience()+"','"+jobSeeker.getQualification()+"','"+jobSeeker.getAge()+"','"+jobSeeker.getCollege()+"','"+jobSeeker.getPercentage()+"','"+jobSeeker.getSkill1()+"','"+jobSeeker.getSkill2()+"','"+jobSeeker.getSkill3()+",)";
        return statement.execute(Query);
    }

    public  boolean deleteJobSeekerRecord(JobSeeker jobSeeker) throws SQLException{
        String Query = "delete from jobseeker where email="+jobSeeker.getEmail();
        return statement.execute(Query);
    }

    public  ResultSet getAllJobs() throws SQLException{
        String Query = "select * from job";
        ResultSet rs = statement.executeQuery(Query);
        return rs;
    }

    public  boolean insertJobApplicant(JobSeeker jobSeeker,Job job) throws SQLException{
        String Query = "insert into applicants values('"+job.getId()+"','"+jobSeeker.getEmail()+"'applied')";
        return statement.execute(Query);
    }

    public  boolean updateUserLoginStatus(String email,boolean status) throws SQLException{
        String Query = "update user set loginstatus ="+status;
        return statement.execute(Query);
    }


    //more methods here
}
