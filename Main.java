package project;
import java.util.*;

class ProjectSolution{

    public static void main(String[] args) {
        new allotmentData();
        allotmentData.inputDefaultStation();
        while(!allotmentData.getIsDefaultStationInitialized()){
            try {
                Thread.currentThread();
				Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        allotmentData.inputStations();

        while(!allotmentData.getIsAllStationsInitialized()){
            try {
                Thread.currentThread();
				Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        allotmentData.inputStudents();


        while(!allotmentData.getIsAllStudentsInitialized()){
            try {
                Thread.currentThread();
				Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //System.out.println(allotmentData.allStudents);
        //new admin thread
        Admin admin = new Admin();
        Thread adminThread = new Thread(admin);
        adminThread.start();
        //Threads stored in array
        ArrayList<Student> allStudents = allotmentData.allStudents;
        ArrayList<Thread> studentThreads = new ArrayList<>();
        for(Student s: allStudents) {
            studentThreads.add(new Thread(s));
        }
        //Debugging
        
        //Array passed to a runnable object to run them and view results synchronised with admin thread. i.e. view results every time a round ends
        studentsStart studentsstart = new studentsStart(studentThreads);
        
        Thread allStudentsThread = new Thread(studentsstart);
        allStudentsThread.start();
    }
}
//Async, await, promises, fetch api. React.js, react hooks
