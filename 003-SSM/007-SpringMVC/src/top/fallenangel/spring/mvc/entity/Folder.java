package top.fallenangel.spring.mvc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * t_folder 文件夹
 * @author 坠天使
 */
public class Folder implements Serializable {
    /**
     * 文件夹id
     */
    private Integer folderId;

    /**
     * 文件夹所属用户id
     */
    private Integer folderUserId;

    /**
     * 文件夹名称
     */
    private String folderName;

    /**
     * 文件夹创建时间
     */
    private Date folderCreateDate;

    /**
     * 文件夹内的文件数
     */
    private Integer folderFileNum;

    private static final long serialVersionUID = 1L;

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Integer getFolderUserId() {
        return folderUserId;
    }

    public void setFolderUserId(Integer folderUserId) {
        this.folderUserId = folderUserId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Date getFolderCreateDate() {
        return folderCreateDate;
    }

    public void setFolderCreateDate(Date folderCreateDate) {
        this.folderCreateDate = folderCreateDate;
    }

    public Integer getFolderFileNum() {
        return folderFileNum;
    }

    public void setFolderFileNum(Integer folderFileNum) {
        this.folderFileNum = folderFileNum;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "folderId=" + folderId +
                ", folderUserId=" + folderUserId +
                ", folderName='" + folderName + '\'' +
                ", folderCreateDate=" + folderCreateDate +
                ", folderFileNum=" + folderFileNum +
                '}';
    }
}