package schoolrecords;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class Student {

    private String name;
    private List<Mark> markList = new ArrayList<>();

    public Student(String name) {
        isEmpty(name);
        this.name = name;
    }

    private void isEmpty(String name) {
        if ( name == null || name.equals("")) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
    }

    public void grading(Mark mark){
        isEmpty(mark);
        markList.add(mark);
    }

    private void isEmpty(Mark mark) {
        if ( mark == null || mark.equals("")) {
            throw new NullPointerException("Mark must not be null!");
        }
    }

    public double calculateAverage(){
        double avg = 0.0;
        if (markList.size() == 0 ) {
            return 0.0;
        }
        for ( Mark item : markList) {
            avg += item.getMarkType().getValue();
        }
        avg =round((100*avg)/ markList.size())/100.0 ;
        return avg;
    }

    public double calculateSubjectAverage(Subject subject) {
        double avg = 0.0;
        int count = 0;
        if (markList.size() == 0 ) {
            return 0.0;
        }
        for ( Mark item : markList) {
            if ( item.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                count++;
                avg += item.getMarkType().getValue();
            }
        }
        avg = round(100*avg/count)/100.0;
        return avg;
    }

    public String toString() {
        return getName()+" marks: "+markList.get(markList.size()-1).getSubject().getSubjectName()+": "
                +markList.get(markList.size()-1).getMarkType().getName()
                +"("+markList.get(markList.size()-1).getMarkType().getValue()+")";
    }

    public String getName() {
        return name;
    }

    public List<Mark> getMarkList() {
        return markList;
    }
}
