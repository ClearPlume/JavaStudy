package top.fallenangel.springboot.flip.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.springboot.flip.model.entity.Student;
import top.fallenangel.springboot.flip.service.IStudentService;

@Controller
@RequestMapping("student")
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseBody
    @RequestMapping("edit")
    public Student edit(Integer id) {
        Student student;

        if (id == null) {
            student = new Student();
        } else {
            student = studentService.get(id);
        }
        return student;
    }

    @RequestMapping("save")
    public String save(Student entity) {
        if (entity.getStuId() == null) {
            studentService.save(entity);
        } else {
            studentService.modify(entity);
        }
        return "redirect:/student/list";
    }

    @RequestMapping("delete")
    public String delete(Integer[] id) {
        studentService.delete(id);
        return "redirect:/student/list";
    }

    @RequestMapping("list")
    public PageInfo<Student> list(Student student, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return PageInfo.of(studentService.list(student));
    }
}
