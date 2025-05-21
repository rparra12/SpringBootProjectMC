package com.rparrat.crudacademia.service.impl;

import com.rparrat.crudacademia.exception.ModelNotFoundException;
import com.rparrat.crudacademia.repository.IGenericRepo;
import com.rparrat.crudacademia.service.ICRUD;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;
import java.util.List;

@RequiredArgsConstructor
public abstract class CRUDImpl <T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID " + id + " not found"));
    }

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {

        String className = t.getClass().getSimpleName();
        String methodName = "setId" + className;
        Method setIdMethod = t.getClass().getMethod(methodName, id.getClass());
        setIdMethod.invoke(t, id);

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID " + id + " not found"));

        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {

        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID " + id + " not found"));

        getRepo().deleteById(id);
    }
}
