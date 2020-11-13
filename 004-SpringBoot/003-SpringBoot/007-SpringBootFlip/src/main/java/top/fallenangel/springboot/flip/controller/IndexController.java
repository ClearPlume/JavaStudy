package top.fallenangel.springboot.flip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import top.fallenangel.springboot.flip.model.entity.Student;
import top.fallenangel.springboot.flip.service.IStudentService;

import java.util.ArrayList;

@Controller
public class IndexController {
    private final IStudentService studentService;

    public IndexController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("index")
    public String index(ArrayList<Student> students) {
        students.addAll(studentService.list());
        return "flip";
    }
}
