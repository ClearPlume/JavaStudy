package top.fallenangel.spring.mvc.model.dao;

import top.fallenangel.spring.mvc.entity.File;

import java.util.List;

public interface IFileDao {
    int deleteByPrimaryKey(Integer fileId);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(Integer fileId);

    List<File> selectAllByFolderId(int folderId);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}