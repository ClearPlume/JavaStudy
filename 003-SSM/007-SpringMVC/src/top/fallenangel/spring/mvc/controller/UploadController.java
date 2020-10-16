package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.entity.UploadResult;
import top.fallenangel.spring.mvc.model.service.IEmployeeService;
import top.fallenangel.spring.mvc.util.Util;

@Controller
public class UploadController {
    private final IEmployeeService employeeService;

    public UploadController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("uploadImage")
    @ResponseBody
    public UploadResult uploadImage(MultipartFile image, int empId) {
        Employee employee = employeeService.get(empId);
        String oldFileName = employee.getEmpAvatar();
        UploadResult uploadResult = Util.uploadFile(image, "/img");
        if (uploadResult.isSuccess()) {
            employee.setEmpAvatar(uploadResult.getFileName());
            employeeService.modify(employee);
            if (Util.isNotEmpty(oldFileName)) {
                Util.deleteFile(oldFileName);
            }
        }
        return uploadResult;
    }
}