package cn.test;

import cn.zx.beans.Student;
import cn.zx.dao.StudentDaoImpl;
import cn.zx.dao.dao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentDaoImplTest {
    dao dao;

    @Before
    public void before(){
        dao = new StudentDaoImpl();
    }
    @Test
    public void insertStudent() {
        Student student = new Student("张与",96,5);
        dao.insertStudent(student);
    }

    @Test
    public void insertStudentCacheId() {
        Student student = new Student("张ii",96,77);
        System.out.println("前"+student);
        dao.insertStudentCacheId(student);
        System.out.println("后"+student);
    }

    @Test
    public void deleteStudent() {
        dao.deleteStudent(1);
    }

    @Test
    public void updateStudent() {
        Student student = new Student("赵邢",96,77);
        student.setId(2);
        dao.updateStudent(student);
    }

    @Test
    public void selectAllStudents() {
       List<Student> students =  dao.selectAllStudents();
       if(students != null){
           for (Student student : students){
               System.out.println(student);
           }
       }
    }

    @Test
    public void selectAllStudentsMap() {
       Map<String,Object> map =  dao.selectAllStudentsMap();
        System.out.println(map.get("张ii"));
    }

    @Test
    public void selectStudentById() {
        Student student = dao.selectStudentById(2);
        System.out.println(student);

    }

    @Test
    public void selectStudentsByName() {
        List<Student> students =  dao.selectStudentsByName("张");
        if(students != null){
            for (Student student : students){
                System.out.println(student);
            }
        }
    }
}