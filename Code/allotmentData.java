package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class allotmentData{
    //List of all students, stations etc.
    static ArrayList<Student> allStudents;
    static ArrayList<Station> allStations;
    static ArrayList<Student> unallotted;
    static ArrayList<String> rejected;

    private static boolean isDefaultStationInitialized = false;
    private static boolean isAllStationsInitialized = false;
    private static boolean isAllStudentsInitialized = false;
    private static boolean hasAdminAllotted = false;
//    private static boolean preferencesSet = false;
    
    private static boolean allottedFlag = false; //used to wait/notify, when admin completes a round, set true
    private static boolean isNextRound = true; //used to tell if admin is conducting more rounds
    private static boolean allotmentComplete = false; //set to true after user views results of final round

    static HashMap<String, String> confirmed; //list of students who confirmed allotment
    static HashMap<String, String> allotted; //list of currently unconfirmed but allotted students

    static Object synchLock = 1; //used to synchronize Admin and student threads

    private static int roundNo;
    private static defaultStation defaultAllotment; //default station to be allotted if a student cannot be allotted any of his preferences, instead of rejection

    allotmentData(){
        allStudents = new ArrayList<>();
        allStations = new ArrayList<>();
        unallotted=new ArrayList<>();
        rejected = new ArrayList<>();
        confirmed = new HashMap<>();
        allotted = new HashMap<>();
        roundNo = 1;

    }
    public static defaultStation getDefaultAllotment() {
    	return defaultAllotment;
    }
   
    public static int getRoundNo() {
    	return roundNo;
    }
    public static boolean getIsDefaultStationInitialized() {
    	return isDefaultStationInitialized;
    }
    public static boolean getIsAllStationsInitialized() {
    	return isAllStationsInitialized;
    }
    public static boolean getIsAllStudentsInitialized() {
    	return isAllStudentsInitialized;
    }
    public static boolean getAllottedFlag() {
    	return allottedFlag;
    }
    public static boolean getIsNextRound() {
    	return isNextRound;
    }
    public static boolean getAllotmentComplete() {
    	return allotmentComplete;
    }
    
    public static void setDefaultAllotment(defaultStation val) {
    	defaultAllotment = val;
    }
    public static void setRoundNo(int val) {
    	roundNo = val;
    }
    public static void setIsDefaultStationInitialized(boolean val ) {
    	isDefaultStationInitialized = val;
    }
    public static void setIsAllStationsInitialized(boolean val) {
    	isAllStationsInitialized = val;
    }
    public static void setIsAllStudentsInitialized(boolean val) {
    	isAllStudentsInitialized=  val;
    }
    public static void setAllottedFlag(boolean val) {
    	allottedFlag = val;
    }
    public static void setIsNextRound(boolean val) {
    	isNextRound = val;
    }
    public static void setAllotmentComplete(boolean val) {
    	allotmentComplete = val;
    }
    
    
    public static String viewStudents() {
    	String str = "";
    	int i =1;
    	for(Student s: allStudents) {
    		str+= "\n" + i + ". " + s;
    		i++;
    	}
    	return str;
    }
    public static void unallot(String stationId, String id) {
    	for(Station s: allStations) {
    		if(s.getId().equals(stationId)) {
    			s.unallot(id);
    		}
    	}
    }
    public static void addStation(Station s) {
        allStations.add(s);
    }
    public static String viewAllotments() {
    	String str = "";
    	int i = 1;
    	
    	if(allotted.isEmpty()&&confirmed.isEmpty()) {
    		for(Student stu: unallotted) {
    			str+= "\n" + i + ". STUDENT" + stu + "\nUNALLOTTED";
    		}
    	}
    	for(Map.Entry<String, String> set: allotted.entrySet()) {
    		str+="\n" + i + ". STUDENT: " + getStudent(set.getKey()) + " \nUNCONFIRMED ALLOTMENT: " + getStation(set.getValue());
    		i++;
    	}
    	
    	for(Map.Entry<String, String> set:confirmed.entrySet()) {
    		str+="\n" + i + ". STUDENT: " + getStudent(set.getKey()) + "\nCONFIRMED ALLOTMENT: " + getStation(set.getValue());
    	}
    	return str;
    }
    public static Student getStudent(String id){
        for(Student student : allStudents){
            if (student.getID().equals(id)) {return student;}
        }
        return null;
    }

    public static defaultStation getStation(String id){
        if(defaultAllotment.getId().equals(id)){
            return defaultAllotment;
        }
        for(Station s: allStations){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }
    public static void setDefaultStation(defaultStation s){
        defaultAllotment = s;
    }
    public int getRound() {
        return roundNo;
    }
    public static void addStudent(Student s){
        allStudents.add(s);
        unallotted.add(s);
    }

    public static String viewStations() {
        int i = 1;
        String str = "";
        
        for(Station s: allStations) {
            str+=("\n"+i + "." + s);
            i++;
        }
        str+=("\n"+i+"."+defaultAllotment.toString());
        return str;
    }


    public static int noOfFreeStations() {
    	int  i = 0;
    	for(Station s: allStations) {
    		if(!s.isFull()) {
    			i++;
    		}
    	}
    	return i;
    }
    public static int noOfFullStations() {
    	int i = 0;
    	for(Station s: allStations) {
    		if(s.isFull()) {
    			i++;
    		}
    	}
    	return i;
    }
    
    public static String viewAllotmentReport() {
    	String str = "";
    	str+="\nROUNDS CONDUCTED: " + (roundNo-1);
    	str+="\nTOTAL STUDENTS: " + allStudents.size();
    	str+="\nTOTAL STATIONS: " + allStations.size();
    	str+="\nUNALLOTTED STUDENTS: " + unallotted.size();
    	str+="\nSTATIONS FILLED: " + noOfFullStations();
    	str+="\nSTATIONS WITH AVAILABLE SLOTS: " + noOfFreeStations();
    	return str;
    }
//    public void viewUnallotted() {
//        int i = 1;
//        Collections.sort(unallotted, new sortStudents());
//        System.out.println(unallotted.size());
//        for(Student s: unallotted) {
//            System.out.println(i + "."  + " Name: "+ s.getName() + "\tID: "+ s.getID()+ " \tCGPA: " + s.getCgpa() + " \tBRANCH: " + s.getBranch());
//            i++;
//        }
//    }

    public static void inputStations() {
        StationInput input = new StationInput();
        input.setVisible(true);

    }

    public static void inputDefaultStation(){
        DefaultStationInput input = new DefaultStationInput();
        input.setVisible(true);
    }

    public static void inputStudents() {
        StudentInput input = new StudentInput();
        input.setVisible(true);
    }

	public static boolean getIsHasAdminAllotted() {
		return hasAdminAllotted;
	}

	public static void setHasAdminAllotted(boolean hasAdminAllotted) {
		allotmentData.hasAdminAllotted = hasAdminAllotted;
	}


}
