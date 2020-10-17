package top.fallenangel.spring.mvc.model.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.spring.mvc.entity.File;
import top.fallenangel.spring.mvc.entity.Folder;
import top.fallenangel.spring.mvc.model.dao.IFileDao;
import top.fallenangel.spring.mvc.model.dao.IFolderDao;
import top.fallenangel.spring.mvc.model.service.INetDiskService;
import top.fallenangel.spring.mvc.util.Config;
import top.fallenangel.spring.mvc.util.Util;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
    public File getFile(int fileId) {
        return fileDao.selectByPrimaryKey(fileId);
    }

    @Override
    public File getFile(String fileRealName) {
        return fileDao.selectByFileRealName(fileRealName);
    }

    @Override
    public void modifyFolderName(Folder folder) {
        folderDao.updateByPrimaryKey(folder);
    }

    @Override
    public void newFolder(Folder folder) {
        folderDao.insert(folder);
    }

    @Override
    public void newFile(File newFile) {
        fileDao.insert(newFile);
    }

    @Override
    public void deleteFolder(int folderId) {
        AtomicBoolean deletionFailed = new AtomicBoolean(false);

        fileDao.selectAllByFolderId(folderId).forEach(dbFile -> {
            if (!deletionFailed.get()) {
                java.io.File file = new java.io.File(Config.uploadRootPath + java.io.File.separatorChar + "file" + java.io.File.separatorChar + dbFile.getFileRealName());
                if (file.delete()) {
                    Util.debug(dbFile.getFileShowName() + " --> " + dbFile.getFileRealName() + "删除成功");
                } else {
                    Util.debug(dbFile.getFileShowName() + " --> " + dbFile.getFileRealName() + "删除失败");
                    deletionFailed.set(true);
                }
            }
        });
        if (!deletionFailed.get()) {
            fileDao.deleteAllByFolderId(folderId);
            folderDao.deleteByPrimaryKey(folderId);
        }
    }

    @Override
    public void deleteFile(String fileRealName) {
        fileDao.deleteByFileRealName(fileRealName);
    }
}