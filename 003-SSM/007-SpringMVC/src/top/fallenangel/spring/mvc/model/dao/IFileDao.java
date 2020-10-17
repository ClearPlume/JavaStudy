package top.fallenangel.spring.mvc.model.dao;

import top.fallenangel.spring.mvc.entity.File;

import java.util.List;

public interface IFileDao {
    int deleteByPrimaryKey(Integer fileId);

    void deleteAllByFolderId(int folderId);

    void deleteByFileRealName(String fileRealName);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Integer fileId);

    File selectByFileRealName(String fileRealName);

    List<File> selectAllByFolderId(int folderId);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}