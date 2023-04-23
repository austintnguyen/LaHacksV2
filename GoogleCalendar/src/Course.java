public class Course {
    private String name;
    private String startTime;
    private String endTime;
    private String location;
    private String type;

    public Course(String name, String startTime, String endTime, String location, String type) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public String getstartTime() {
        return startTime;
    }

    public String getendTime() {
        return endTime;
    }

    public int getendTimeFirstHalf() {
        String s = endTime.substring(0, 2);
        int i = Integer.parseInt(s);
        return i;
    }

    public int getendTimeSecondHalf() {
        String s = endTime.substring(3, 5);
        int i = Integer.parseInt(s);
        return i;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public void print() {

        System.out.printf("Name: %s\nStart Time: %s\nendTime: " +
                "%s\nLocation: %s\nType: %s\n", name, startTime, endTime, location, type);

    }

}
