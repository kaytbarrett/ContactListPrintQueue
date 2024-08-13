/**
 * Katherine (Katie) Barrett
 * EN.605.201.81.SU24
 * Assignment #11 Part 2
 * 
 * References used for this assignment: 
 * Module 11 Office Hours Presentation
 * Module 11 Lectures A-E
 * Stack Overflow for this: Integer.parseInt(input.readLine().trim());
 */

import java.util.*;
import java.io.*;

public class PrintQueue {
    public static void main (String [] args){
        // Initialize variables
        Random randomGenerator = new Random();
        LinkedList<Job> jobs = new LinkedList<>();
        int choice = 1;
        int jobId = 0;
        boolean queue = true;

        try(BufferedReader input = new BufferedReader(new InputStreamReader(System.in))){

            while (queue){

                // Print menu to user
                System.out.println("\nMenu:");
                System.out.println("1. Add a job to the queue");
                System.out.println("0. Quit and display jobs");
                System.out.print("Enter your choice (0 or 1): ");

                // This is needed because of the buffered reader (rather than input.nextInt() which is used for the scanner)
                choice = Integer.parseInt(input.readLine().trim());
                System.out.println();

                switch (choice){
                    case 1:
                        // Generate a random print time
                        // I know the presentation says randomGenerator.nextInt(1000) + 10
                        // But I was seeing results with printTime 1009, so to this is how I am able to get print times of 10 - 1000
                        int printTime = randomGenerator.nextInt(991) + 10;
                        
                        // Create a new job and add it to the queue
                        Job newJob = new Job(++jobId, printTime);
                        jobs.add(newJob);
                        
                        // Notify the user of job added 
                        System.out.println("Added job number " + newJob.getId());
                        System.out.println();
                        break;

                    case 0:
                        // Quit and display jobs
                        System.out.println("Jobs in the queue:");
                        for (Job job : jobs) {
                            System.out.println(job);
                        }
                        System.out.println();
                        queue = false;
                        break;

                    default: 
                        System.out.println("Please enter 1 or 0\n");
                        break;
                }
                    
            }
            
        }catch (IOException e){
            System.out.println("IOException caught:" + e);
        }

    }
}
