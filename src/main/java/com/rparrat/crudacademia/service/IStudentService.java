package com.rparrat.crudacademia.service;

import com.rparrat.crudacademia.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer> {

    /*List<Student> findAllStudents() throws Exception;
    Student findById(Integer id) throws Exception;
    Student saveStudent(Student student) throws Exception;
    Student updateStudent(Integer id, Student student) throws Exception;
    void deleteStudent(Integer id) throws Exception;*/

    List<Student> findAllStudentsOrderAge() throws Exception;

}
