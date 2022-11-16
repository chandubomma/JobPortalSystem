package MAIN;

public class UserOutput {
    public static void printHelp(){
        System.out.println("***********************************************************************************************************************");
        System.out.println("There can be multiple command line arguments, be sure first argument always refers to the operation you want to perform");
        System.out.println("For Example : javac MAIN/Main.java login 'useremail' 'password'");
        System.out.println("Below are some command line arguments you can use : ");
        System.out.println("java MAIN/Main login 'useremail' 'password'");
        System.out.println("java MAIN/Main login 'useremail'");
        System.out.println("java MAIN/Main logout 'useremail' ");
        System.out.println("java MAIN/Main viewmyprofile 'useremail'");
        System.out.println("java MAIN/Main viewprofile 'useremail1' 'useremail2' [useremail1 - administrator/recruiter , useremail2 - user]");
        System.out.println("java MAIN/Main viewjobs");
        System.out.println("java MAIN/Main viewmyappliedjobs 'useremail'");
         // add more...
        System.out.println("***********************************************************************************************************************");

       
    }
}
