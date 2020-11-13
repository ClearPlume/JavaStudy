package top.fallenangel.springboot.flip.model.mapper;


import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.flip.model.entity.Student;

import java.util.List;

@Repository
public interface StudentMapper {
    int insert(Student record);

    int deleteByPrimaryKey(Integer[] id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> selectAll(Student student);
}
