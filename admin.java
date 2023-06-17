package project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Admin implements Runnable{

    
    /*Allotment System:
    Step 1. Sort students according to CGPA
    Step 2. Select student with highest CGPA
    Step 3. Try allotting student to first preference
    Step 4, If unable to allot, move to second preference
    Step 5. If no preference allotted to student, put in unableToAllot and next student
    Step 6. If student allotted, change allotment to station and put in Unconfirmed
    Step 7. If student confirms, out of allotment process
    Step 8. If student rejects, try again in unallotted */
    public void run() {
        synchronized(allotmentData.synchLock) {

            while(!allotmentData.getAllotmentComplete()) {
                
                                //Wait for students to view results
                if(allotmentData.getAllottedFlag()) {
                    try{allotmentData.synchLock.wait();}catch(Exception e) {System.out.println("Interrupted");}
                }
                if(allotmentData.getAllotmentComplete()){
                break;
                }
                
                if(allotmentData.getRoundNo() == 1) {
                	ConductRounds conduct = new ConductRounds();
                	conduct.setVisible(true);
                	while(!allotmentData.getIsHasAdminAllotted()) {
                    	try {
                    		Thread.currentThread();
							Thread.sleep(3000);
                    	}
                    	catch(Exception e) {
                    		System.out.println("Admin thread interrupted");
                    	}
                    }
                	allotmentData.setHasAdminAllotted(false);
                	
                	
                }
                
                
                allotStudents();
                //Sets allotment data for all students
                
                //If admin will be conducting further rounds
                
                ConductRounds conduct = new ConductRounds();
                conduct.setVisible(true);
                
                while(!allotmentData.getIsHasAdminAllotted()) {
                	try {
                		Thread.currentThread();
						Thread.sleep(3000);
                	}
                	catch(Exception e) {
                		System.out.println("Admin thread interrupted");
                	}
                }
                
                
//                System.out.println("Want to continue further rounds?");
//                String choice = scan.nextLine();
//
//                if(choice.toLowerCase().contains("no")) {
//                    data.isNextRound = false;
//                }
                allotmentData.setHasAdminAllotted(false);
                allotmentData.setAllottedFlag(true);
                allotmentData.synchLock.notify();
            }
        }
    }

    

    public void allotStudents() {
        System.out.println(allotmentData.unallotted.size());
        Collections.sort(allotmentData.unallotted, new sortStudents()); //Step.1

        ArrayList<String> studentPreferences = new ArrayList<>();
        ArrayList<Student> studentsList = new ArrayList<>();
        
        for(Student s1: allotmentData.unallotted) {
            studentsList.add(s1);;
        }
        
        for(Student s: studentsList){
            studentPreferences = s.getPreferences();
            System.out.println(studentPreferences);

            for(String preference: studentPreferences) {

                for(Station station: allotmentData.allStations) {
                    if(station.getId().equals(preference)) {

                        //Trying Allotment
                        if(station.tryAllotting(s)) {
                            //Possible to allot student in preference
                            station.allot(s.getID());
                            s.setAllottedInRound(allotmentData.getRoundNo());
                            allotmentData.allotted.put(s.getID(), station.getId());
                            allotmentData.unallotted.remove(s);
                            break;
                        }

                        else {
                            //Not possible to allot preference
                            break;
                        }
                    }
                }
                if(allotmentData.allotted.containsKey(s.getID())) {
                    break;
                }

            }
            if(allotmentData.allotted.containsKey(s.getID())) {
                
                continue;
            }

            else {
                
                allotmentData.allotted.put(s.getID(), allotmentData.getDefaultAllotment().getId());
                allotmentData.rejected.add(s.getID());
                allotmentData.unallotted.remove(s);
                continue;
            }
        }
        allotmentData.setRoundNo(allotmentData.getRoundNo() + 1);
        

    }



}


class sortStudents implements Comparator<Student>{
    public int compare(Student a, Student b) {
        return (int)((b.getCgpa()-a.getCgpa())*100);
    }
}
