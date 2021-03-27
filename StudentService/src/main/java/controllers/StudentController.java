package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import beans.Student;

@RestController

public class StudentController {
	
	  private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
	  
	static {
		
		schooDB=new HashMap<String, List<Student>>();
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("SHIVA", "1stClass"));
		list.add(new Student("SAI", "2nd Class"));
		list.add(new Student("TRI", "3rd Class"));
		list.add(new Student("Surya", "4th Class"));
		
		schooDB.put("urvi", list);
		
		
		
	}
	
    @RequestMapping(value="/studentDetails/{schoolname}",method = RequestMethod.GET)
	public List<Student> getStudentDetais(@PathVariable String schoolname){
		
		System.out.println("Getting Student details for " + schoolname);
		List<Student> studentList = schooDB.get(schoolname);
		
		if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
		
		
		
		return studentList;
		
	}

}
