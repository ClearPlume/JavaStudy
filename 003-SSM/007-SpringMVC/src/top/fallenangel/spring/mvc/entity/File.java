package top.fallenangel.spring.mvc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * t_file 文件
 * @author 坠天使
 */
public class File implements Serializable {
    /**
     * 文件id
     */
    private Integer fileId;

    /**
     * 文件所在文件夹id
     */
    private Integer fileFolderId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件创建时间
     */
    private Date fileCreateDate;

    private static final long serialVersionUID = 1L;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getFileFolderId() {
        return fileFolderId;
    }

    public void setFileFolderId(Integer fileFolderId) {
        this.fileFolderId = fileFolderId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getFileCreateDate() {
        return fileCreateDate;
    }

    public void setFileCreateDate(Date fileCreateDate) {
        this.fileCreateDate = fileCreateDate;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", fileFolderId=" + fileFolderId +
                ", fileName='" + fileName + '\'' +
                ", fileCreateDate=" + fileCreateDate +
                '}';
    }
}