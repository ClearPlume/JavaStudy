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
     * 显示文件名
     */
    private String fileShowName;

    /**
     * 保存文件名
     */
    private String fileRealName;

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

    public String getFileShowName() {
        return fileShowName;
    }

    public void setFileShowName(String fileShowName) {
        this.fileShowName = fileShowName;
    }

    public String getFileRealName() {
        return fileRealName;
    }

    public void setFileRealName(String fileRealName) {
        this.fileRealName = fileRealName;
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
                ", fileName='" + fileShowName + '\'' +
                ", fileCreateDate=" + fileCreateDate +
                '}';
    }
}