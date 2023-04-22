public class Course {
    private String name;
    private String startTime;
    private String endTime;
    private String location;

    public Course(String name, String startTime, String endTime, String location){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getstartTime(){
        return startTime;
    }
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }
    public String getEndTime(){
        return endTime;
    }
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    
}
