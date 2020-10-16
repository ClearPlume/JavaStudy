package top.fallenangel.spring.mvc.model.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.spring.mvc.entity.File;
import top.fallenangel.spring.mvc.entity.Folder;
import top.fallenangel.spring.mvc.model.dao.IFileDao;
import top.fallenangel.spring.mvc.model.dao.IFolderDao;
import top.fallenangel.spring.mvc.model.service.INetDiskService;

import java.util.List;

@Service
public class NetDiskService implements INetDiskService {
    private final IFolderDao folderDao;
    private final IFileDao fileDao;

    public NetDiskService(IFolderDao folderDao, IFileDao fileDao) {
        this.folderDao = folderDao;
        this.fileDao = fileDao;
    }

    @Override
    public List<Folder> listFolder(int userId) {
        return folderDao.selectAllByUserId(userId);
    }

    @Override
    public List<File> listFile(int folderId) {
        return fileDao.selectAllByFolderId(folderId);
    }

    @Override
    public Folder getFolder(int folderID) {
        return folderDao.selectByPrimaryKey(folderID);
    }

    @Override
    public void modifyFolderName(Folder folder) {
        folderDao.updateByPrimaryKey(folder);
    }

    @Override
    public void newFolder(Folder folder) {
        folderDao.insert(folder);
    }
}