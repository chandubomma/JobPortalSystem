package USER.JOBSEEKER;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import DATABASE.JobSeekerDb;
import USER.User;
import USER.RECRUITER.Job;
import MAIN.Main;

public class JobSeeker extends User{
    private String userKey;
    private int age;
    private String college;
    private String qualification;
    private int percentage;
    private String skill1;
    private String skill2;
    private String skill3;
    private int experience;
    private static JobSeekerDb jobSeekerDb = new JobSeekerDb();

    ArrayList<Job> eligibleJobs = new ArrayList<Job>();
    ArrayList<Job> appliedJobs = new ArrayList<Job>();  

    public JobSeeker(String firstName, String lastName, String email, String password, String gender,
    String mobileNumber, String dateOfBirth) {
super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
super.setUserType("jobseeker");
} 
    
    public JobSeeker(String firstName, String lastName, String email, String password, String gender, 
                    String mobileNumber, String dateOfBirth, String userKey, String college, String qualification,
                    int percentage, String skill1, String skill2, String skill3, int experience) 
    {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
        this.userKey = userKey;
        this.college = college;
        this.qualification = qualification;
        this.percentage = percentage;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.experience = experience;
        super.setUserType("jobseeker");
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        LocalDate curDate=LocalDate.now();
        DateTimeFormatter jkl=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = curDate.format(jkl);
        String n=formattedDate;
        String n1=n.substring(6,10);
        int i=Integer.parseInt(n1);
        String n2=this.getDateOfBirth().substring(6,10);
        int j=Integer.parseInt(n2);
        this.age =(i-j);
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public String getSkill3() {
        return skill3;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public ArrayList<Job> getEligibleJobs() {
        return eligibleJobs;
    }

    public void setEligibleJobs() {
        int i;
        for(i=0;i<=numberOfJobs;i++)
        {
            //get details of the job from job database
            Job obj=new Job(id, jobTitle, location, companyName, deadline, numberOfJobs, maxAge, minExperience, description)
            if(obj.isEligible(this))
                this.eligibleJobs.add(obj);
        }
    }

    public ArrayList<Job> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(ArrayList<Job> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }

   
    @Override
    public boolean Register() throws SQLException {
        
           return( jobSeekerDb.addUserRecord(this) &&
            jobSeekerDb.addJobSeekerRecord(this));
       
       
    }

    

    @Override
    public boolean Logout() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUser() throws SQLException {
      
            return(jobSeekerDb.deleteUserRecord(this) && jobSeekerDb.deleteJobSeekerRecord(this));
       
    }

    @Override
    public boolean Login(String email, String password) throws SQLException {
       String userPassword = jobSeekerDb.getUserPassword(email);
       if(userPassword.equals(password))return true;
       else return false;
        
    }
}
