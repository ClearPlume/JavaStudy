package top.fallenangel.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.springboot.entity.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("test")
    public String test(Model model) {
        List<String> courses = new ArrayList<>();
        courses.add("java");
        courses.add("mysql");
        courses.add("html");
        courses.add("css");
        courses.add("javascript");
        courses.add("maven");
        courses.add("mybatis");
        courses.add("spring");
        courses.add("SpringMVC");
        model.addAttribute("courses", courses);

        Map<Integer, Test> testMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Test test = new Test();
            test.setText("这是第" + i + "个Test");
            testMap.put(i, test);
        }
        model.addAttribute("testMap", testMap);

        Test[] tests = new Test[5];
        for (int i = 0; i < tests.length; i++) {
            tests[i] = new Test();
            tests[i].setText("Test数组中的第" + i + "个");
        }
        model.addAttribute("tests", tests);

        List<Map<Integer, List<Test>>> testMapList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<Integer, List<Test>> testMapInList = new HashMap<>();
            List<Test> testList = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                Test test = new Test();
                test.setText("第" + j + "个test");
                testList.add(test);
            }

            testMapInList.put(i, testList);
            testMapList.add(testMapInList);
        }
        model.addAttribute("testMapList", testMapList);
        return "test";
    }
}
