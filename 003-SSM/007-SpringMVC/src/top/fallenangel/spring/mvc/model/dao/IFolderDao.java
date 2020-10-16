package top.fallenangel.spring.mvc.model.dao;

import top.fallenangel.spring.mvc.entity.Folder;

import java.util.List;

public interface IFolderDao {
    int deleteByPrimaryKey(Integer folderId);

    int insert(Folder record);

    int insertSelective(Folder record);

    Folder selectByPrimaryKey(Integer folderId);

    List<Folder> selectAllByUserId(int userId);

    int updateByPrimaryKeySelective(Folder record);

    int updateByPrimaryKey(Folder record);
}