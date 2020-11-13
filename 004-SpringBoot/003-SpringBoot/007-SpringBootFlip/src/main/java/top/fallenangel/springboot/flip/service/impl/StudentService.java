package top.fallenangel.springboot.flip.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.springboot.flip.model.entity.Student;
import top.fallenangel.springboot.flip.model.mapper.StudentMapper;
import top.fallenangel.springboot.flip.service.IStudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public void save(Student entity) {
        studentMapper.insertSelective(entity);
    }

    @Override
    public void modify(Student entity) {
        studentMapper.updateByPrimaryKey(entity);
    }

    @Override
    public void delete(Integer[] id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student get(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> list(Student student) {
        return studentMapper.selectAll(student);
    }

    @Override
    public List<Student> list() {
        List<Student> students = new ArrayList<>();

        studentMapper.selectAll(new Student()).forEach(stu -> {
            if (!stu.getStuShared()) {
                students.add(stu);
            }
        });
        Collections.shuffle(students);
        return students;
    }
}
