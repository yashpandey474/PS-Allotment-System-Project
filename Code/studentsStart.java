package project;

import java.util.ArrayList;

class studentsStart implements Runnable{
    ArrayList<Thread> students;

    studentsStart(ArrayList<Thread> students){
        this.students = students;
    }

    

    public void run() {
        //Common object to synchronize admin and students
        synchronized(allotmentData.synchLock) {
            //If no further rounds
            while(!allotmentData.getAllotmentComplete()) {
                //if admin hasnt completed a round
                if(!allotmentData.getAllottedFlag()) {
                    try {
                        allotmentData.synchLock.wait();
                    }
                    catch(Exception e) {
                        System.out.println("Interrupted");
                    }
                }
                //Runs each student thread to view results
                for(Thread s: students) {
                    s.run();
                }
                //Ends if no further rounds and students have viewed results
                if(!allotmentData.getIsNextRound() ){
                    allotmentData.setAllotmentComplete(true);
                }
                //Notifies admin thread to allot again if further rounds present and goes on wait
                allotmentData.setAllottedFlag(false);
                allotmentData.synchLock.notify();
            }
        }
    }
}