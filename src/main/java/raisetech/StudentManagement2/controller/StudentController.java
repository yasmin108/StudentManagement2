package raisetech.StudentManagement2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement2.controller.converter.StudentConverter;
import raisetech.StudentManagement2.data.Student;
import raisetech.StudentManagement2.data.StudentsCourses;
import raisetech.StudentManagement2.domain.StudentDetail;
import raisetech.StudentManagement2.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter=converter;
  }

  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<StudentsCourses> studentsCourses = service.searchStudentsCourseList();

    return converter.convertStudentDetails(students, studentsCourses);

  }


  @GetMapping("/studentsCourseList")
  public List<StudentsCourses> getStudentsCourseList() {

      return service.searchStudentsCourseList();
  }
}