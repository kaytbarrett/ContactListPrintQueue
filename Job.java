/**
 * Katherine (Katie) Barrett
 * EN.605.201.81.SU24
 * Assignment #11 Part 2
 * 
 * References used for this assignment: 
 * Module 11 Office Hours Presentation
 * Module 11 Lectures A-E
 */

public class Job {

    private int id;
    private int printTime;

    // Default constructor with default values
    public Job(){
        this.id = -1;
        this.printTime = -1;
    }

    // Parameterized constructor to initialize a Job with details
    public Job(int id, int printTime){
        this.id = id;
        this.printTime = printTime;
    }

    // Getter for job Id
    public int getId(){
        return id;
    }

    // Returns a string representation of the job details
    public String toString()
    {
        return("Job #: " + id + ", Print time: " + printTime);
    }
    
}
