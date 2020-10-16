package top.fallenangel.spring.mvc.model.service;

import top.fallenangel.spring.mvc.entity.File;
import top.fallenangel.spring.mvc.entity.Folder;

import java.util.List;

public interface INetDiskService {
    List<Folder> listFolder(int userId);

    List<File> listFile(int folderId);

    Folder getFolder(int folderID);

    void modifyFolderName(Folder folder);

    void newFolder(Folder folder);
}