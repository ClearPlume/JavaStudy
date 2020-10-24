package top.fallenangel.crm.model.entity;

import java.io.Serializable;

/**
 * t_dictionary_type 数据字典类型
 *
 * @author 坠天使
 */
public class DictionaryType implements Serializable {
    private Integer dictionaryTypeId;

    /**
     * 数据字典类型名
     */
    private String dictionaryTypeName;

    /**
     * 数据字典类型编号
     */
    private String dictionaryTypeCode;

    /**
     * 数据字典类型是否可用
     */
    private Boolean dictionaryTypeStatus;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "DictionaryType{" +
                "dictionaryTypeId=" + dictionaryTypeId +
                ", dictionaryTypeName='" + dictionaryTypeName + '\'' +
                ", dictionaryTypeCode='" + dictionaryTypeCode + '\'' +
                ", dictionaryTypeStatus=" + dictionaryTypeStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryType that = (DictionaryType) o;

        if (!dictionaryTypeId.equals(that.dictionaryTypeId)) return false;
        if (!dictionaryTypeName.equals(that.dictionaryTypeName)) return false;
        if (!dictionaryTypeCode.equals(that.dictionaryTypeCode)) return false;
        return dictionaryTypeStatus.equals(that.dictionaryTypeStatus);
    }

    @Override
    public int hashCode() {
        int result = dictionaryTypeId.hashCode();
        result = 31 * result + dictionaryTypeName.hashCode();
        result = 31 * result + dictionaryTypeCode.hashCode();
        result = 31 * result + dictionaryTypeStatus.hashCode();
        return result;
    }

    public Integer getDictionaryTypeId() {
        return dictionaryTypeId;
    }

    public void setDictionaryTypeId(Integer dictionaryTypeId) {
        this.dictionaryTypeId = dictionaryTypeId;
    }

    public String getDictionaryTypeName() {
        return dictionaryTypeName;
    }

    public void setDictionaryTypeName(String dictionaryTypeName) {
        this.dictionaryTypeName = dictionaryTypeName;
    }

    public String getDictionaryTypeCode() {
        return dictionaryTypeCode;
    }

    public void setDictionaryTypeCode(String dictionaryTypeCode) {
        this.dictionaryTypeCode = dictionaryTypeCode;
    }

    public Boolean getDictionaryTypeStatus() {
        return dictionaryTypeStatus;
    }

    public void setDictionaryTypeStatus(Boolean dictionaryTypeStatus) {
        this.dictionaryTypeStatus = dictionaryTypeStatus;
    }
}