package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.round;

public class ClassRecords {
    private String className;
    private Random random;
    private List<Student> studentList = new ArrayList<>();

    public ClassRecords(String className, Random random) {
        this.className = className;
        this.random = random;
    }

    public boolean addStudent(Student student) {
        for ( Student item : studentList) {
            if (item.getName().equals(student.getName())) {
                return false;
            }
        }
        studentList.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        for ( int i = 0; i < studentList.size(); i++) {
            if (student.getName().equals(studentList.get(i).getName())) {
                studentList.remove(studentList.get(i));
                return true;
            }
        }
        return false;
    }

    public double calculateClassAverage() {
        isEmptyForCalculateClassAverage();

        double avg = 0;
        for (Student item : studentList) {
            //avg += item.
            avg += item.calculateAverage();
        }
        isEmpty(avg);
        avg = avg/studentList.size();
        return avg;
    }

    private void isEmptyForCalculateClassAverage() {
        if ( studentList.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
    }

    private void isEmpty(double avg) {
        if (avg < 0.01) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double avg = 0;
        int count = 0;
        for (Student item : studentList) {
            //avg += item.
            if (item.calculateSubjectAverage(subject) != 0 ) {
                avg += item.calculateSubjectAverage(subject);
                count++;
            }
        }
        avg = round(100*avg/count)/100.0;
        return avg;
    }

    public Student findStudentByName(String name) {
        isEmpty(name);
        isEmpty(studentList);

        for (Student item : studentList) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Student by this name cannot be found! Kiss Rita");
    }

    private void isEmpty(String name) {
        if ( name.equals("")) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
    }

    private void isEmpty(List<Student> studentList) {
        if ( studentList.size() == 0 ) {
            throw new IllegalStateException("No students to search!");
        }
    }

    public Student repetition() {
        int length = studentList.size();
        isEmpty(studentList, length);
        Random rnd = new Random(5);
        int noOfStudent = rnd.nextInt(length);
        return studentList.get(noOfStudent);
    }

    private void isEmpty(List<Student> studentList, int length) {
        if ( length == 0 ) {
            throw new IllegalStateException("No students to select for repetition!");
        }
    }

    public List<StudyResultByName> listStudyResults() {
        //lista - elemei diákonként: diák neve, diák átlaga, alap a studentList,
        // csatolva a studentekhez csatolt calculateSubjectAvarage
        List<StudyResultByName> studyResultList = new ArrayList<>();
        for (Student item : studentList ) {
            studyResultList.add(new StudyResultByName(item.getName(), item.calculateAverage()));
        }
        return studyResultList;
    }

    public String listStudentNames(){
        StringBuilder namesOfStudents = new StringBuilder();
        for ( Student item : studentList) {
            namesOfStudents.append(item.getName()).append(", ");
        }
        namesOfStudents.deleteCharAt(namesOfStudents.lastIndexOf(","));
        int lastChar = namesOfStudents.length();
        namesOfStudents.deleteCharAt(lastChar-1);
        return namesOfStudents.toString();
    }

    public String getClassName() {
        return className;
    }

    public Random getRandom() {
        return random;
    }
}
