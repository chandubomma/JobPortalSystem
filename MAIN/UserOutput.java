package MAIN;

import USER.RECRUITER.Job;

public class UserOutput {
    public static void printHelp(){
        System.out.println("***********************************************************************************************************************");
        System.out.println("There can be multiple command line arguments, be sure first argument always refers to the operation you want to perform");
        System.out.println("For Example : login 'useremail' 'password'");
        System.out.println("Below are some command line arguments you can use : ");
        System.out.println("login 'useremail' 'password'");
        System.out.println("login 'useremail'");
        System.out.println("logout 'useremail' ");
        System.out.println("viewmyprofile 'useremail'");
        System.out.println("searchprofile 'useremail1' 'useremail2' [useremail1 - administrator/recruiter , useremail2 - user]");
        System.out.println("viewjobs");
        System.out.println("viewmyappliedjobs 'useremail'");
         // add more...
        System.out.println("***********************************************************************************************************************");

       
    }

    public static void printUserLoginMenu(){
        System.out.println("Enter 1 to login");
        System.out.println("Enter 2 to Register");
        System.out.println("Enter 0 to exit");
    }

    public static void printJobSeekerMenu(){
        System.out.println("1 : Profile");
        System.out.println("2 : Job");
        System.out.println("3 : Logout");
    }

    public static void printJobSeekerProfileMenu(){
        System.out.println("1 : View Profile");
        System.out.println("2 : Modify Profile");
    }

    public static void printJobSeekerJobMenu(){
        System.out.println("1 : View Jobs");
        System.out.println("2 : Apply for Job");
        System.out.println("3 : View Applied Jobs");
    }
    
    public static void printRecruiterMenu(){

    }

    public static void printAdministratorMenu(){

    }

    public static void printJobDetails(Job job){
        System.out.println("Job Title : "+job.getJobTitle());
        System.out.println("Job ID : "+job.getId());
        System.out.println("Company Name : "+job.getCompanyName());
        System.out.println("Location : "+job.getLocation());
        System.out.println("Job Description : "+job.getDescription());
        System.out.println("Skills : "+job.getSkillRequired());
        System.out.println("Vacancies : "+job.getNumberOfVacancies());
        System.out.println("Experience : "+job.getMinExperience());
        System.out.println("Last Date : "+job.getDeadline());
    }
}
