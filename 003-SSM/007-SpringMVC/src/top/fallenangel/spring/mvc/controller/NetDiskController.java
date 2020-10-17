package top.fallenangel.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.fallenangel.spring.mvc.entity.File;
import top.fallenangel.spring.mvc.entity.Folder;
import top.fallenangel.spring.mvc.model.service.INetDiskService;
import top.fallenangel.spring.mvc.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("netDisk")
public class NetDiskController {
    private final INetDiskService netDiskService;

    public NetDiskController(INetDiskService netDiskService) {
        this.netDiskService = netDiskService;
    }

    @RequestMapping("list")
    public void list(ArrayList<Folder> folders) {
        folders.addAll(netDiskService.listFolder(Util.getLoginUserIdFromSession()));
    }

    @RequestMapping("modifyFolderName")
    @ResponseBody
    public Map<String, Object> modifyFolderName(int folderId, String newFolderName) {
        Folder folder = netDiskService.getFolder(folderId);
        folder.setFolderName(newFolderName);
        netDiskService.modifyFolderName(folder);
        Map<String, Object> result = new HashMap<>();
        result.put("newFolderName", newFolderName);
        return result;
    }

    @RequestMapping("newFolder")
    @ResponseBody
    public Map<String, Object> newFolder(String folderName) {
        Folder folder = new Folder();
        folder.setFolderUserId(Util.getLoginUserIdFromSession());
        folder.setFolderName(folderName);
        folder.setFolderCreateDate(new Date());
        folder.setFolderFileNum(0);

        netDiskService.newFolder(folder);
        Map<String, Object> result = new HashMap<>();
        result.put("folderName", folder.getFolderName());
        result.put("folderId", folder.getFolderId());
        return result;
    }

    @RequestMapping("fileList")
    public Map<String, Object> fileList(int folderId, ArrayList<File> files) {
        files.addAll(netDiskService.listFile(folderId));

        Map<String, Object> param = new HashMap<>();
        param.put("folderId", folderId);
        return param;
    }

    @RequestMapping("deleteFolder")
    public String deleteFolder(int folderId) {
        netDiskService.deleteFolder(folderId);
        return "redirect:/netDisk/list";
    }

    @RequestMapping("deleteFile")
    public String deleteFile(String fileRealName) {
        int fileFolderId = netDiskService.getFile(fileRealName).getFileFolderId();
        netDiskService.deleteFile(fileRealName);
        return "redirect:/netDisk/fileList?folderId=" + fileFolderId;
    }
}