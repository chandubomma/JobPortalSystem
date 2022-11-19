package USER.JOBSEEKER;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import DATABASE.JobSeekerDb;
import USER.User;
import USER.RECRUITER.Job;

public class JobSeeker extends User{
    private String userKey;
    private int age;
    private String college;
    private String qualification;
    private int percentage;
    private String skill1;
    private String skill2;
    public JobSeeker(String firstName, String lastName, String email, String password, String gender,
            String mobileNumber, String dateOfBirth, String userType, String isLoggedIn) {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth, userType, isLoggedIn);
    }

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

    public void setEligibleJobs() throws SQLException {
        ResultSet rs = jobSeekerDb.getAllJobs();
        while(rs.next())
        {
            //get details of the job from job database
            Job obj = new Job(rs.getString("id"),rs.getString("jobtitle"),rs.getString("location"),rs.getString("companyname"),rs.getString("deadline"),rs.getInt("numberofvacancies"),rs.getString("skillrequired"),rs.getInt("maxage"),rs.getInt("minexperience"),rs.getString("description"));
            if(obj.isEligible(this))
                this.eligibleJobs.add(obj);
        }
    }

    public void getAppliedJobs() {

     for(Job i : appliedJobs){
        System.out.printf("| %7s | %20s | %20s |",i.getId(),i.getJobTitle(),i.getCompanyName());
     }
    }

    public void setAppliedJobs(ArrayList<Job> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }

    public boolean applyForJob(Job job) throws SQLException{
        appliedJobs.add(job);
        return jobSeekerDb.insertJobApplicant(this, job);
        
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
       if(userPassword.equals(password)){
        this.setLoggedIn("true");
        jobSeekerDb.updateUserLoginStatus(getEmail(), isLoggedIn());
        return true;
    }
       else return false;
        
    }
    public void getDetails(){
      System.out.println("User key : "+getUserKey());   
      System.out.println("Name :"+getFirstName()+" "+getLastName());
      System.out.println("Date of birth : "+getDateOfBirth());
      System.out.println("Age : "+getAge());
      System.out.println("Gender : "+getGender());
      System.out.println("Experience : "+getExperience());
      System.out.println("skills :"+getSkill1()+","+getSkill2()+","+getSkill3());
      System.out.println("Qualification : "+getQualification());
      System.out.println("College : "+getCollege());
      System.out.println("percentage : "+getPercentage()); 
    }
}
