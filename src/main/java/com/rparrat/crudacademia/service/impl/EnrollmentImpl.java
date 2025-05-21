package com.rparrat.crudacademia.service.impl;

import com.rparrat.crudacademia.model.Enrollment;
import com.rparrat.crudacademia.model.EnrollmentDetail;
import com.rparrat.crudacademia.repository.IEnrollmentRepo;
import com.rparrat.crudacademia.repository.IGenericRepo;
import com.rparrat.crudacademia.service.IEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class EnrollmentImpl extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepo repo;

    protected IGenericRepo<Enrollment, Integer> getRepo() {return repo;}

    @Override
    public Map<String, List<String>> getEnrollmentsCourseAndStudents() throws Exception {

        Stream<Enrollment> enrollmentStream = repo.findAll().stream();
        Stream<List<EnrollmentDetail>> enrollmentListDetailStream = enrollmentStream.map(Enrollment::getDetails);

        Stream<EnrollmentDetail> enrollmentDetailStream = enrollmentListDetailStream.flatMap(Collection::stream);

        Map<String, List<String>> mapCourseAndStundets = enrollmentDetailStream
                .collect(Collectors.groupingBy(
                        e -> e.getCourse().getName(),
                        Collectors.mapping(e -> e.getEnrollment().getStudent().getFullName(), Collectors.toList()
                        )
                ));

        return mapCourseAndStundets;
    }

    /*@Override
    public List<Enrollment> findAllEnrollments() throws Exception {
        return repo.findAll();
    }

    @Override
    public Enrollment findEnrollmentById(Integer id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + " not found"));
    }

    @Override
    public Enrollment saveEnrollment(Enrollment enrollment) throws Exception {
        return repo.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Integer id, Enrollment enrollment) throws Exception {
        enrollment.setIdEnrollment(id);

        repo.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + " not found"));

        return repo.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Integer id) throws Exception {

        repo.findById(id).orElseThrow(() -> new RuntimeException("ID " + id + " not found"));

        repo.deleteById(id);
    }*/
}
