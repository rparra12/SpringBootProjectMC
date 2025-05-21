package com.rparrat.crudacademia.service.impl;

import com.rparrat.crudacademia.model.Course;
import com.rparrat.crudacademia.repository.ICourseRepo;
import com.rparrat.crudacademia.repository.IGenericRepo;
import com.rparrat.crudacademia.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;

    protected IGenericRepo<Course, Integer> getRepo() {return repo;}

}
