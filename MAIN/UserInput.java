package MAIN;

import java.util.Scanner;


import USER.JOBSEEKER.JobSeeker;
import USER.RECRUITER.Recruiter;

public  class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public JobSeeker scanJobSeekerDetails(JobSeeker jobSeeker){
        System.out.println("Enter First Name : ");
        jobSeeker.setFirstName(scanner.next());
        System.out.println("Enter Last Name : ");
        jobSeeker.setLastName(scanner.next());
        System.out.println("Enter Email : ");
        jobSeeker.setEmail(scanner.next());
        System.out.println("Enter Password : ");
        jobSeeker.setPassword(scanner.next());
        System.out.println("Enter Date Of Birth : ");
        jobSeeker.setDateOfBirth(scanner.next());

     
        return jobSeeker;
    }

    public Recruiter scanRecruiterDetails(Recruiter recruiter){
        System.out.println("Enter First Name : ");
        recruiter.setFirstName(scanner.next());
        System.out.println("Enter Last Name : ");
        recruiter.setLastName(scanner.next());
        System.out.println("Enter Email : ");
        recruiter.setEmail(scanner.next());
        System.out.println("Enter Password : ");
        recruiter.setPassword(scanner.next());
        System.out.println("Enter Date Of Birth : ");
        recruiter.setDateOfBirth(scanner.next());

        return recruiter;
    }
    
}
