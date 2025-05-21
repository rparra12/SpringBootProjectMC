package com.rparrat.crudacademia.service;

import com.rparrat.crudacademia.model.Enrollment;

import java.util.List;
import java.util.Map;

public interface IEnrollmentService extends ICRUD<Enrollment, Integer> {

    /*List<Enrollment> findAllEnrollments() throws Exception;
    Enrollment findEnrollmentById(Integer id) throws Exception;
    Enrollment saveEnrollment(Enrollment enrollment) throws Exception;
    Enrollment updateEnrollment(Integer id, Enrollment enrollment) throws Exception;
    void deleteEnrollment(Integer id) throws Exception;*/

    Map<String, List<String>> getEnrollmentsCourseAndStudents() throws Exception;

}
