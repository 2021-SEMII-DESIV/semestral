package app;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    int age;
    double gradesAverage;
    List<Integer> grades = new ArrayList<Integer>();

    public void setName(String _name){
        name = _name;
    }

    public String getName(){
        return name;
    }

    public void setGrades(List<Integer> _grades){
        grades = _grades;
        gradesAverage = _grades.stream()
                               .mapToDouble(d -> d)
                               .average()
                               .orElse(0.0);
    }

    public List<Integer> getGrades(){
        return grades;
    }

    public double getGradesAverage(){
        return gradesAverage;
    } 
}