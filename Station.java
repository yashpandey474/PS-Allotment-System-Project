package project;

import java.util.ArrayList;

class Station extends defaultStation implements preferenceStationInterface{

    //This class of stations have conditions on allotment, subjects and branches
    private ArrayList<String> branches = new ArrayList<>();
    private ArrayList<String> subjects = new ArrayList<>();
    private int maxStudents;

    Station (String stationId, String location, String company, int stipend, ArrayList<String> branches, ArrayList<String> subjects, int maxStudents){
        super(stationId, location, company, stipend);
        this.branches = branches;
        this.subjects = subjects;
        this.maxStudents = maxStudents;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public ArrayList<String> getSubjects(){
        return subjects;
    }
    public ArrayList<String> getBranches(){
        return branches;
    }
    public boolean isFull() {
        return maxStudents == getNoOfStudents();
    }
    
    public void setMaxStudents(int maxStudents) {
    	this.maxStudents = maxStudents;
    }
    
    public void setSubjects(ArrayList<String> subjects) {
    	this.subjects = subjects;
    }
    
    public void setBranches(ArrayList<String> branches) {
    	this.branches = branches;
    }

    //Before allotting, first checks if student passes branch and subjects criteria
    //And if the station still has slots or not


    public boolean tryAllotting(Student a) {
        if(isFull()) {
            System.out.println(" Station is full.");
            return false;
        }
        if(!(branches.contains(a.getBranch())) && (!branches.isEmpty())) {
            System.out.println(" Student doesn't have important branch.");
            return false;
        }
        ArrayList<String> studentSubjects = a.getSubjects();
        System.out.println(studentSubjects);
        for(String s: subjects) {

            if(!(studentSubjects.contains(s))){
                System.out.println(getNoOfStudents() + getMaxStudents() + " Student doesn't have correct subjects.");
                return false;
            }
        }
        return true;
    }
    public String toString(){
        return(" STATION ID NUMBER: " + getId() + " \tCOMPANY: " + getCompany() + " \tLOCATION: " + getLocation() + " \tSTIPEND: " + getStipend()  + "\nCOURSES REQD. " + subjects + "\nBRANCHES ALLOWED: " + branches);
    }
}


