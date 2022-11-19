package MAIN;

import java.sql.SQLException;
import java.util.Scanner;


import USER.JOBSEEKER.JobSeeker;
import USER.RECRUITER.Job;
import USER.RECRUITER.Recruiter;

public  class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static JobSeeker scanJobSeekerDetails(JobSeeker jobSeeker){
        System.out.print("Enter First Name : ");
        jobSeeker.setFirstName(scanner.next());
        System.out.print("Enter Last Name : ");
        jobSeeker.setLastName(scanner.next());
        System.out.print("Enter Email : ");
        jobSeeker.setEmail(scanner.next());
        System.out.print("Enter Password : ");
        jobSeeker.setPassword(scanner.next());
        System.out.print("Enter Date Of Birth : ");
        jobSeeker.setDateOfBirth(scanner.next());

     
        return jobSeeker;
    }

    public static Recruiter scanRecruiterDetails(Recruiter recruiter){
        System.out.print("Enter First Name : ");
        recruiter.setFirstName(scanner.next());
        System.out.print("Enter Last Name : ");
        recruiter.setLastName(scanner.next());
        System.out.print("Enter Email : ");
        recruiter.setEmail(scanner.next());
        System.out.print("Enter Password : ");
        recruiter.setPassword(scanner.next());
        System.out.print("Enter Date Of Birth : ");
        recruiter.setDateOfBirth(scanner.next());

        return recruiter;
    }

    public static String scanPassword(){
        System.out.print("Enter Password : ");
        String password = scanner.next();
        return password;
    }

    public static int scanChoice(){
        System.out.print("Enter Choice : ");
        int choice = scanner.nextInt();
        return choice;
    }
    public static String scanEmail(){
        System.out.print("Enter Email : ");
        String email = scanner.next();
        return email;
    }
    public static void applyjobs(JobSeeker user) throws SQLException{
       System.out.print("Enter job ID : ");
       String ID = scanner.next();
       boolean flag=false;
        user.setEligibleJobs();
       for(Job i : user.getEligibleJobs()){
        if(i.getId().equals(ID)){
            if(user.applyForJob(i)){
             System.out.println("****Application successful****"); 
            }
            else {
             System.out.println("****Application failed****");   
            }
            flag=true;
            break;
        }
        if(!flag){
         System.out.println("you aren't eligible for the job");   
        }
       }
    }
}
