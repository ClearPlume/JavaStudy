package top.fallenangel.springboot.flip.model.entity;

/**
 * t_student 学生表
 *
 * @author 坠天使
 */
public class Student {
    private Integer stuId;

    /**
     * 学生姓名
     */
    private String stuName;

    /**
     * 是否已经分享过
     */
    private Boolean stuShared;

    private static final long serialVersionUID = 1L;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Boolean getStuShared() {
        return stuShared;
    }

    public void setStuShared(Boolean stuShared) {
        this.stuShared = stuShared;
    }
}