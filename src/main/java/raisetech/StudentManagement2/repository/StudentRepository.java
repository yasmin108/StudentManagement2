package raisetech.StudentManagement2.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement2.data.Student;
import raisetech.StudentManagement2.data.StudentsCourses;


@Mapper
public interface StudentRepository {

@Select("SELECT*FROM students ")
  List<Student> search();

@Select("SELECT*FROM students_courses")
  List<StudentsCourses> searchStudentsCourses();

@Insert("INSERT INTO students(name,furigana,nickname,email,region,age,gender,remark,is_deleted)" +
        " VALUES(#{name},#{furigana},#{nickname},#{email},#{region},#{age},#{gender},#{remark},false)")
@Options(useGeneratedKeys = true,keyProperty = "id")
void registerStudent(Student student);
  }



