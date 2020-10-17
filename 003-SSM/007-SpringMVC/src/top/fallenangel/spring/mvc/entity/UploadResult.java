package top.fallenangel.spring.mvc.entity;

public class UploadResult {
    private boolean success;
    private String path;
    private String fileShowName;
    private String fileRealName;
    private long fileSize;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long size) {
        this.fileSize = size;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}