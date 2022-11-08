package USER.JOBSEEKER;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import USER.User;
import USER.RECRUITER.Job;
import MAIN.Main;
import java.sql.*;

public class JobSeeker extends User{
    private String jobSeekerKey;
    private int age;
    private String college;
    private String qualification;
    private int percentage;
    private String skill1;
    private String skill2;
    private String skill3;
    private int experience;

    ArrayList<Job> eligibleJobs = new ArrayList<Job>();
    ArrayList<Job> appliedJobs = new ArrayList<Job>();
    public Connection con;
    public Statement stmt;
    
    public JobSeeker(String userKey, String firstName, String lastName, String email, String password, String gender, String mobileNumber, String dateOfBirth, String college, String qualification, int percentage, String skill1, String skill2, String skill3, int experience) 
    {
        super(firstName, lastName, email, password, gender, mobileNumber, dateOfBirth);
        this.jobSeekerKey = userKey;
        this.college = college;
        this.qualification = qualification;
        this.percentage = percentage;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.experience = experience;
        this.setAge();
        this.setEligibleJobs();  
    }

    public String getJobSeekerKey() {
        return jobSeekerKey;
    }

    public void setJobSeekerKey(String userKey) {
        this.jobSeekerKey = userKey;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        LocalDate curDate=LocalDate.now();
        DateTimeFormatter jkl=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = curDate.format(jkl);
        String n=formattedDate;
        String n1=n.substring(0,4);
        int i=Integer.parseInt(n1);
        String n2=this.getDateOfBirth().substring(0,4);
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
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/jobportalsystem","root","182001");   
            stmt=con.createStatement();  
            String query="select * from job";
            ResultSet rs= stmt.executeQuery(query);
            while(rs.next())
            {
                Job obj = new Job(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
                if(obj.isEligible(this))
                    this.eligibleJobs.add(obj);
            }    
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }
    }
    public ArrayList<Job> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(ArrayList<Job> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }

    @Override
    public boolean Login() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Register() {
        try{    
            Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/jobportalsystem","root","182001");   
            Statement stmt=con.createStatement();  
            String query=String.format("insert into jobSeeker values('"+this.getJobSeekerKey()+"','"+this.getFirstName()+"','"+this.getLastName()+"','"+this.getEmail()+"','"+this.getPassword()+"','"+this.getGender()+"','"+this.getMobileNumber()+"','"+this.getDateOfBirth()+"','"+this.getCollege()+"','"+this.getQualification()+"','"+this.getPercentage()+"','"+this.getSkill1()+"','"+this.getSkill2()+"','"+this.getSkill3()+"','"+this.getExperience()+"')");
            stmt.executeUpdate(query);  
            con.close();
            return true;
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean Logout() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteUser() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean applyJob(String id)
    {
        try
        {
            String query="select * from job";
            ResultSet rs= stmt.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString(1).equals(id))
                {
                    Job obj = new Job(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
                    if(obj.isEligible(this))
                    {
                        obj.apply(this);
                        return true;
                    }
                }
            }
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }
        return false;
    }
}
