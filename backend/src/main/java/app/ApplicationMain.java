package app;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;

import java.util.List;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class ApplicationMain {
  static Logger logger = Logger.getLogger(ApplicationMain.class);

  public static void main(String[] args) {
    BasicConfigurator.configure();
    Group group = createGroup();
    get("/estudiantes", (req, res) -> {
      res.type("application/json");
      JSONObject jo = new JSONObject(group);
      return jo;
    });
    // post("/estudiantes", (req, res) -> {
    //   res.type("application/json");
    //   JSONObject body = new JSONObject(req.body());
    //   Student student = new Student();
    //   if(!body.has("name") && !body.has("age")){
    //       return "Invalid request";
    //   }
    //   student.setName(body.getString("name"));
    //   student.setAge(body.getInt("age"));
    //   student.setGrades(getGradesFromJSONArray(body.getJSONArray("grades")));
    //   group.addStudent(student);
    //   JSONObject jo = new JSONObject(group);
    //   return jo;
    // });
  }

  public static List<Integer> getGradesFromJSONArray(JSONArray _grades){
    List<Integer> newGrades = new ArrayList<Integer>();
    for(int i = 0; i < _grades.length(); i++){ newGrades.add(_grades.getInt(i)); }
    return newGrades;
  }

  public static Group createGroup(){
      Group group = new Group();
      group.addStudent(createStudent("Erick Agrazal"));
      group.addStudent(createStudent("Vicente Lopez"));
      group.addStudent(createStudent("Rolando Ramos"));
      group.addStudent(createStudent("Emir Salazar"));
      return group;
  }

  public static Student createStudent(String _name){
      Student student = new Student();
      List<Integer> grades = new ArrayList<Integer>();
      student.setName(_name);
      grades.add(randomInt(80, 100));
      grades.add(randomInt(80, 100));
      grades.add(randomInt(80, 100));
      student.setGrades(grades);
      return student;
  }

  public static int randomInt(int lower, int upper){
      return (int)(Math.random() * ( upper - lower )) + lower;
  }
}