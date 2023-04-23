

import java.util.ArrayList;

public class StringParse{

    private String data;
    private ArrayList<Course> courseList;

    public StringParse(String data){
        this.data = data;
        courseList = new ArrayList<>();
    }

    public String toMilitaryTime(String time){

        String militaryTime;
        String secondHalf;

        String[] timeSplit = time.split(":");

        int newHour = Integer.parseInt(timeSplit[0]);

        if(timeSplit[1].contains("pm")){
            newHour+=12;
            secondHalf = timeSplit[1].replace("pm","");
        }else{
            secondHalf = timeSplit[1].replace("am","");
        }

        

        militaryTime = String.format("%02d", newHour) + ":" + secondHalf;

        return militaryTime;

    }

    public void parseData(){

        String[] lines = data.split("\n");

        for(String line : lines){

            System.out.println(line);

        }

        for(int timeI = 0; timeI < lines.length; timeI+=3){

            int classI = timeI+1;
            int roomI = timeI+2;

            String name;
            String startTime;
            String endTime;
            String location;
            String type;

            String[] bothTimes = lines[timeI].split(" - ");

            startTime = bothTimes[0];
            endTime = bothTimes[1];

            String[] classNAT = lines[classI].split(" - ");

            name = classNAT[0];
            type = classNAT[1];

            location = lines[roomI];

            Course course = new Course(name,toMilitaryTime(startTime),
            toMilitaryTime(endTime),location,type);

            courseList.add(course);

        }
        
    }

    public ArrayList<Course> getCourseList(){
        return courseList;
    }

    public static void main(String[] args){

        String s = "9:00pm - 9:50pm\nCSE 105 - Lecture\nWLH 2001\n" +
        "11:00am - 3:05pm\nECON 150 - Lecture\nPrice Center";
        
        StringParse sP = new StringParse(s);
        sP.parseData();


        System.out.println("Size: " +sP.courseList.size());
        for(int i = 0;i < sP.courseList.size(); i++){

            sP.getCourseList().get(i).print();

        }


    }


}

