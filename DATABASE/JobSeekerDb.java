package DATABASE;

import java.sql.SQLException;

import USER.JOBSEEKER.JobSeeker;

public class JobSeekerDb extends UserDb {
    public boolean addJobSeekerRecord(JobSeeker jobSeeker) throws SQLException{
        String Query = "insert into jobseeker values('"+jobSeeker.getEmail()+"','"+jobSeeker.getExperience()+"','"+jobSeeker.getQualification()+"','"+jobSeeker.getAge()+"','"+jobSeeker.getCollege()+"','"+jobSeeker.getPercentage()+"','"+jobSeeker.getSkill1()+"','"+jobSeeker.getSkill2()+"','"+jobSeeker.getSkill3()+",)";
        return statement.execute(Query);
    }

    public boolean deleteJobSeekerRecord(JobSeeker jobSeeker) throws SQLException{
        String Query = "delete from jobseeker where email="+jobSeeker.getEmail();
        return statement.execute(Query);
    }

    //more methods here
}
