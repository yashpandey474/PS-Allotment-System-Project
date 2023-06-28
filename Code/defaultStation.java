package project;

import java.util.ArrayList;

interface defaultStationInterface{
	public void allot(String id);
	public void unalot(String id);
	public void setLocation(String location);
	public void setCompany(String company);
    public void setStipend(int stipend);
    public int getStipend();
    public String getCompany();
    public String getLocation();
    public String getId();
    public int getNoOfStudents(); 
    public String toString();
}

interface preferenceStationInterface{
	 public int getMaxStudents();
	    public ArrayList<String> getSubjects();
	    public ArrayList<String> getBranches();
	    public boolean isFull();
	    public void setMaxStudents(int maxStudents);
	    public void setSubjects(ArrayList<String> subjects);
	    public void setBranches(ArrayList<String> branches);
	    public boolean tryAllotting(Student a);
	    public String toString();
}
class defaultStation {
    private String stationId;
    private String location;
    private int stipend;
    private String company;
    private int noOfStudents;

    defaultStation(String stationId, String location, String company, int stipend){
        this.stationId = stationId;
        this.location = location;
        this.company = company;
        this.stipend = stipend;
    }
    public void allot(String id) {
     
        noOfStudents+=1;
    }

    public void unallot(String id) {
   
        noOfStudents -=1;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setStipend(int stipend) {
        this.stipend = stipend;
    }
    

    public int getStipend() {
        return stipend;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return stationId;
    }

    public int getNoOfStudents() {
    	return noOfStudents;
    }
    
    public String toString() {
        return(" STATION ID NUMBER: " + stationId + " \tCOMPANY: " + company + " \tLOCATION: " + location + " \tSTIPEND: " + stipend);
    }

} 
