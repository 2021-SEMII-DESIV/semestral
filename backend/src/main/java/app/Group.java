package app;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Student> students = new ArrayList<Student>();

    public void addStudent(Student _student){
        students.add(_student);
    }

    public List<Student> getGroup(){
        return students;
    }

    public int getCount(){
        return students.size();
    }
}