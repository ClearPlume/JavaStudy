package top.fallenangel.springboot.flip.service;

import top.fallenangel.springboot.flip.model.entity.Student;

import java.util.List;

public interface IStudentService {
    void save(Student entity);

    void modify(Student entity);

    void delete(Integer[] id);

    Student get(Integer id);
    
    List<Student> list(Student student);

    List<Student> list();
}
