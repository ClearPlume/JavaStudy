package top.fallenangel.spring.mvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.entity.File;
import top.fallenangel.spring.mvc.entity.UploadResult;
import top.fallenangel.spring.mvc.model.service.IEmployeeService;
import top.fallenangel.spring.mvc.model.service.INetDiskService;
import top.fallenangel.spring.mvc.util.Config;
import top.fallenangel.spring.mvc.util.Util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Controller
public class UploadController {
    private final IEmployeeService employeeService;
    private final INetDiskService netDiskService;

    public UploadController(IEmployeeService employeeService, INetDiskService netDiskService) {
        this.employeeService = employeeService;
        this.netDiskService = netDiskService;
    }

    @RequestMapping("uploadImage")
    @ResponseBody
    public UploadResult uploadImage(MultipartFile image, int empId) {
        Employee employee = employeeService.get(empId);
        String oldFileName = employee.getEmpAvatar();
        UploadResult uploadResult = Util.uploadFile(image, "/img");
        if (uploadResult.isSuccess()) {
            employee.setEmpAvatar(uploadResult.getFileRealName());
            employeeService.modify(employee);
            if (Util.isNotEmpty(oldFileName)) {
                Util.deleteFile(oldFileName, "img");
            }
        }
        return uploadResult;
    }

    @RequestMapping("uploadFile")
    @ResponseBody
    public UploadResult uploadFile(MultipartFile file, int folderId) {
        UploadResult result = Util.uploadFile(file, "/file");
        if (result.isSuccess()) {
            File newFile = new File();
            newFile.setFileShowName(result.getFileShowName());
            newFile.setFileRealName(result.getFileRealName());
            newFile.setFileCreateDate(new Date());
            newFile.setFileFolderId(folderId);
            netDiskService.newFile(newFile);
        }
        return result;
    }

    @RequestMapping("downloadFile")
    public ResponseEntity<byte[]> downloadFile(String fileRealName) throws Exception {
        java.io.File file = new java.io.File(Config.uploadRootPath + java.io.File.separatorChar + "file" + java.io.File.separatorChar + fileRealName);
        HttpHeaders headers = new HttpHeaders();
        File downloadedFile = netDiskService.getFile(fileRealName);
        headers.setContentDispositionFormData("attachment", new String(downloadedFile.getFileShowName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
}