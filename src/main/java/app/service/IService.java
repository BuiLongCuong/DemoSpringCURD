package app.service;

import app.model.Student;

import java.util.List;

public interface IService<E> {
    void add(E e);
    E findStudentById(int id);
    int findById(int id);
    void delete(int id);
    void update(int id,E e);
    List<E> findAll();
}
