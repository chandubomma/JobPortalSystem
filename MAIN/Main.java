package MAIN;

import java.sql.SQLException;
import java.util.ArrayList;

import DATABASE.AdministratorDb;

import USER.User;
import USER.RECRUITER.Job;

public class Main{
   private static AdministratorDb administratorDb  = new AdministratorDb();
   private static User user;

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
                   if(user.getUserType().toLowerCase().equals("jobseeker"))jobSeekerMenu();
                    else if(user.getUserType().toLowerCase().equals("recruiter"))recruiterMenu();
                   else if(user.getUserType().toLowerCase().equals("administrator"))administratorMenu();
                   break;
                }
                case 2 : {

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
                jobSeekerProfileMenu();
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

    public static void jobSeekerProfileMenu(){
        UserOutput.printJobSeekerProfileMenu();
        int choice = UserInput.scanChoice();
        switch(choice){

        }
    }

    public static void jobSeekerJobMenu(){
        UserOutput.printJobSeekerJobMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            
        }
    }

    public static void recruiterMenu(){
        UserOutput.printRecruiterMenu();
        int choice = UserInput.scanChoice();
        switch(choice){
            
        }
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
            case "viewjobs" : {

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
        }
        else if(args.length==3){
            if(args[0].toLowerCase().equals("login"))return "login";
        }
        return null;
    }

    public static void logout(){

    }

    public static User login() throws SQLException{
        String email = UserInput.scanEmail();
        String password = UserInput.scanPassword();
        User user = administratorDb .getUser(email);
        if(user==null){
            System.out.println("Invalid Credentials");
           
        }
        if(user.Login(email,password )){
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

}
