package project;

import java.util.ArrayList;


class Student extends defaultStudent implements Runnable, allottableStudentInterface{

    allotmentData data;
    private int allottedInRound;
    private boolean viewedResults;

    Student(String name, String id, String branch, double cgpa, ArrayList<String> subjects, ArrayList<String> preferencesAL){
        super(name, id, branch, cgpa, subjects, preferencesAL);
    }

    public void setAllottedInRound(int allottedInRound){
        this.allottedInRound = allottedInRound;
    }

    public int getAllottedInRound(){
        return allottedInRound;
    }
    public boolean getViewedResults() {
    	return viewedResults;
    }
    
    public void setViewedResults(boolean val) {
    	this.viewedResults = val;
    }
    public void run() {
        System.out.println("\tStudent Results Page");
        System.out.println("Name: " + getName() + "\tBranch: " + getBranch() + "\tCGPA: "  + getCgpa());
        viewResult();
        if(!allotmentData.getIsNextRound() ){
            allotmentData.setAllotmentComplete(true);
        }
    }

    public void setData(allotmentData data) {
        this.data = data;
    }
    public void viewResult() {

        new ViewResults(getID()).setVisible(true);
        while(!viewedResults){
            try {
                Thread.currentThread();
				Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        viewedResults=false;

    }


}