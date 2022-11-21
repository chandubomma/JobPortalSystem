package MAIN;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DATABASE.AdministratorDb;
import DATABASE.JobSeekerDb;
import DATABASE.RecruiterDb;
import DATABASE.INFO.Info;
import USER.User;
import USER.ADMINISTRATOR.Administrator;
import USER.JOBSEEKER.JobSeeker;
import USER.RECRUITER.Job;
import USER.RECRUITER.Recruiter;

public class Main{
   private static AdministratorDb administratorDb  = new AdministratorDb();
   private static RecruiterDb recruiterDb = new RecruiterDb();
   private static User user;
   private static JobSeeker jobseeker;
   private static Recrui
    private static Job job;
   private static Administrator  administrator;
   private static Info info = new Info();

    public static void main(String[] args) throws SQLException {
       if(args.length==0)userMenu();
       else userMenu(args);
    }


    public static void userMenu() throws SQLException{
            UserOutput.printUserLoginMenu();
            int choice = UserInput.scanChoice();
            switch(choice){
                case 1 : {
                   user= login();
                   if(user==null)return;
                   if(user.getUserType().toLowerCase().equals("jobseeker")){
                   jobseeker = (JobSeeker) administratorDb.getUser(user.getEmail());
                    jobSeekerMenu();
                }
                    else if(user.getUserType().toLowerCase().equals("recruiter")){
                        recruiter = (Recruiter) administratorDb.getUser(user.getEmail());
                        recruiterMenu();
                    }
                   else if(user.getUserType().toLowerCase().equals("administrator")){
                    administratorMenu();
                }
                   break;
                }
                case 2 : {
                   register();
                }
                
                case 0 : {
                     return;
                }
            }
        
    }

    public static void jobSeekerMenu() throws SQLException{
        UserOutput.printJobSeekerMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            case 1 : {
                profileMenu();
                break;
            }
            case 2 : {
                jobSeekerJobMenu();
                break;
            }
            case 3 : {
                logout();
                userMenu();
                break;
            }
        }
    }

    public static void profileMenu() throws SQLException{
        UserOutput.printProfileMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            case 1 : {
                
                viewUserProfile();
                break;
            }
            case 2 : {
                modifyUserProfile();
                break;
            }
            case 3 : {
               exitProfile();
            } 
        }
    }

    public static void viewUserProfile() {
         if(user.getUserType().equalsIgnoreCase("jobseeker")){
           jobseeker.getDetails(); 
         }
         if(user.getUserType().equalsIgnoreCase("recruiter")){
            recruiter.getDetails();
         }
     }
    public static void modifyUserProfile() throws SQLException{
        if(user.getUserType().equalsIgnoreCase("jobseeker")){
            UserInput.modifyJobseeker(jobseeker); 
          }
        if(user.getUserType().equalsIgnoreCase("recruiter")){
            UserInput.modifyRecruiter(recruiter); 
          }
    }
    public static void exitProfile() throws SQLException{
        if(user.getUserType().equalsIgnoreCase("jobseeker")){
            jobSeekerMenu(); 
          }
          if(user.getUserType().equalsIgnoreCase("recruiter")){
              recruiterMenu();        
        }
    }

    public static void jobSeekerJobMenu() throws SQLException{
        while(true){
        UserOutput.printJobSeekerJobMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            case 1 : info.display_jobs();
            break;
            case 2 : UserInput.applyjobs(jobseeker);
            break;
            case 3 : jobseeker.getAppliedJobs();
            break;
            case 4 : jobSeekerMenu();
            break;
            default : System.out.println("Invalid credential! try again");
        }
        if(choice==4){
           break; 
        }
        }
    }

    public static void recruiterMenu() throws SQLException{
        UserOutput.printRecruiterMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            case 1 : {
               profileMenu();
               break;
            }
            case 2 : {
                recruiterJobMenu();
                break;
            }
            case 3 : {
                applicationsMenu();
                break;
            }
            case 4 : {
                logout();
                userMenu();
                break;
            }
        }
    }

    public static void recruiterJobMenu() throws SQLException{
        UserOutput.printRecruiterJobMenu();
        int choice = UserInput.scanChoice();
        
        switch(choice){
            case 1 :{
                viewJobs(recruiter);
                break;
            }
            case 2 : {
                job = UserInput.scanJobDetails();
                recruiter.postJob(job);
            }
            case 3 : {

            }
            case 4 : {

            }
            case 5 : {
                recruiterMenu();
                break;
            }
        }
    }

    public static void applicationsMenu(){

    }

    public static void administratorMenu(){
        UserOutput.printAdministratorMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            
        }
    }

    public static void userMenu(String[] args) throws SQLException{
        String arg = commandArgs(args);
        switch(arg){
            case "help" : {
                UserOutput.printHelp();
                break;
            }
            case "login" : {
              user = login(args);
                break;
            }
            case "login1" : {
               user = login1(args);
                break;
            }
            case "logout" : {

            }
            case "registeradministrator" : {
                registerAdministrator(args[1]);
                break;
            }
            case "registerrecruiter" : {
                registerRecruiter(args[1]);
            }
            case "registerjobseeker" : {
                registerJobSeeker(args[1]);
                break;
            }
            case "viewjobs" : {
                viewJobs();
                break;
            }
           
        }
    }

    public static String commandArgs(String[] args){
        if(args.length == 0)return null;
        else if(args.length == 1){
            if(args[0].toLowerCase().equals("help"))return "help";
            else if(args[0].toLowerCase().equals("viewjobs"))return "viewjobs";
        }
        else if(args.length == 2){
            if(args[0].toLowerCase().equals("login"))return "login1";
            if(args[0].equalsIgnoreCase("logout"))return "logout";
        }
        else if(args.length==3){
            if(args[0].toLowerCase().equals("login"))return "login";
            if(args[0].equalsIgnoreCase("register") && args[1].equalsIgnoreCase("administrator"))return "registeradministrator";
            if(args[0].equalsIgnoreCase("register") && args[1].equalsIgnoreCase("recruiter"))return "registerrecruiter";
            if(args[0].equalsIgnoreCase("register") && args[1].equalsIgnoreCase("jobseeker"))return "registerjobseeker";
        }
        return null;
    }

    public static void logout() throws SQLException{
        user.Logout();
    }

    public static void registerRecruiter(String csvFilePath) throws SQLException{
        recruiter = new Recruiter();
        if(recruiter.Register(csvFilePath)){
            System.out.println("Registration Successfull!");
            recruiter.getDetails();
        }
        else System.out.println("Registration failed!");
    }

    public static void registerJobSeeker(String csvFilePath) throws SQLException{
        jobseeker = new JobSeeker();
        if(jobseeker.Register(csvFilePath)){
            System.out.println("Registration Successfull!");
            jobseeker.getDetails();
        }
        else System.out.println("Registration failed!");
    }

    public static void registerAdministrator(String csvFilePath) throws SQLException{
        administrator = new Administrator();
        if(administrator.Register(csvFilePath)){
            System.out.println("Registration Successfull!");
           
        }
        else System.out.println("Registration failed!");
    }

    public static User login() throws SQLException{
        String email = UserInput.scanEmail();
        String password = UserInput.scanPassword();
        User user = administratorDb .getUser(email);
        if(user==null){
            System.out.println("Invalid Credentials");
           
        }
       else if(user.Login(email,password )){
            System.out.println("Login Successful!");
            
        }else{
            System.out.println("Wrong Password! Try Again!");
        }
        return user;
    }

    

    public static User login(String[] args) throws SQLException{
        User user = administratorDb .getUser(args[1]);
        if(user==null){
            System.out.println("Invalid Credentials");
           
        }
        if(user.Login(args[1],args[2] )){
            System.out.println("Login Successful!");
            
        }else{
            System.out.println("Try Again!");
        }
        return user;
    }
    
    public static void register() throws SQLException{
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("1.Jobseeker  2.Recruiter");
               System.out.println("Choose the usertype :");
               int choice= in.nextInt();
               if(choice==1){
                jobseeker=UserInput.scanJobSeekerDetails();
                jobseeker.Register();
                jobSeekerMenu();
               }
        }
    }

    public static User login1(String[] args) throws SQLException{
        String password = UserInput.scanPassword();
        User user = administratorDb .getUser(args[1]);
        if(user==null){
            System.out.println("Invalid Credentials");
        
        }
        if(user.Login(args[1], password)){
            System.out.println("Login Successful!");
        }else{
            System.out.println("Try Again!");
        }
        return user;
    }

    public static void viewJobs() throws SQLException{
        ArrayList<Job> jobList = administratorDb.getAllJobs();
        for(Job job : jobList){
            UserOutput.printJobDetails(job);
            System.out.println("***********************************************************************************************************");
        }
    }

    public static void viewJobs(Recruiter recruiter) throws SQLException{
        ArrayList<Job> jobList = recruiterDb.getJobsPosted(recruiter.getCompanyName());
        UserOutput.printJobTitles(jobList);
        int choice = UserInput.scanChoice();
        if(choice >=1 && choice <= jobList.size())UserOutput.printJobDetails(jobList.get(choice));
        else if(choice == jobList.size()+1){
            for(Job job : jobList){
                UserOutput.printJobDetails(job);
                System.out.println("***********************************************************************************************************");
            }
        }
        else System.out.println("Invalid Choice!");
    }

   

}
