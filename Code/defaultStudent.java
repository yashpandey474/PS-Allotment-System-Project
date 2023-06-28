package project;

import java.util.ArrayList;
interface defaultStudentInterface{
	public void setName(String name);
    public void setCgpa(double cgpa);
    public void setBranch(String branch);
    public void setSubjects(ArrayList<String> subjects);
    public void setPreferences(ArrayList<String> preferences);
    public double getCgpa();
    public String getBranch();
    public String getName();
    public String getID();
    public ArrayList<String> getPreferences();
    public ArrayList<String> getSubjects();
    public String toString();
}

interface allottableStudentInterface{
	public void setAllottedInRound(int allottedInRound);
    public int getAllottedInRound();
    public boolean getViewedResults();
    public void setViewedResults(boolean val);
    public void run();
    public void setData(allotmentData data);
    public void viewResult();
}
abstract class defaultStudent implements defaultStudentInterface{
    private double cgpa;
    private String id;

    private String name;
    private String branch;
    private ArrayList<String> subjects = new ArrayList<>();
    private ArrayList <String> preferences = new ArrayList<>();

    defaultStudent(String name, String id, String branch, double cgpa, ArrayList<String> subjects, ArrayList<String> preferences){
        this.name = name;
        this.id = id;
        this.branch = branch;
        this.subjects = subjects;
        this.cgpa = cgpa;
        this.preferences = preferences;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    public void setSubjects(ArrayList<String> subjects) {
    	this.subjects = subjects;
    }
    public void setPreferences(ArrayList<String> preferences) {
    	this.preferences = preferences;
    }
    //Station input from file
    public double getCgpa() {
        return cgpa;
    }
    public String getBranch() {
        return branch;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }
    public ArrayList<String> getPreferences(){
        return preferences;
    }

    public ArrayList<String> getSubjects(){
        return subjects;
    }

    public String toString() {
        return ("NAME: " + name + " ID: " + id + "\n" + " BRANCH: " + branch + " CGPA: " + cgpa + "");
    }
}