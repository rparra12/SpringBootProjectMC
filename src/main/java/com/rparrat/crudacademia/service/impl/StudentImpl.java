package com.rparrat.crudacademia.service.impl;

import com.rparrat.crudacademia.exception.ModelNotFoundException;
import com.rparrat.crudacademia.model.Student;
import com.rparrat.crudacademia.repository.IGenericRepo;
import com.rparrat.crudacademia.repository.IStudentRepo;
import com.rparrat.crudacademia.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {return repo;}

    @Override
    public List<Student> findAllStudentsOrderAge() throws Exception {
        List<Student> students = repo.findAll();
        return students.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .toList();
    }

    /*@Override
    public List<Student> findAllStudents() throws Exception {
        return repo.findAll();
    }

    @Override
    public Student findById(Integer id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID " + id + " not found"));
    }

    @Override
    public Student saveStudent(Student student) throws Exception {
        return repo.save(student);
    }

    @Override
    public Student updateStudent(Integer id, Student student) throws Exception {
        student.setIdStudent(id);

        repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID " + id + " not found"));

        return repo.save(student);
    }

    @Override
    public void deleteStudent(Integer id) throws Exception {

        repo.findById(id).orElseThrow(() -> new ModelNotFoundException("ID " + id + " not found"));

        repo.deleteById(id);
    }*/

}
