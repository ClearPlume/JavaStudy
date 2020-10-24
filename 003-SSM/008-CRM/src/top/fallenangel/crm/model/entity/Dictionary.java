package top.fallenangel.crm.model.entity;

import java.io.Serializable;

/**
 * t_dictionary 数据字典
 *
 * @author 坠天使
 */
public class Dictionary implements Serializable {
    private Integer dictionaryId;

    /**
     * 数据字典类型
     */
    private DictionaryType dictionaryType;

    /**
     * 数据值
     */
    private String dictionaryValue;

    /**
     * 数据的序号
     */
    private Integer dictionaryOrder;

    /**
     * 是否可用
     */
    private Boolean dictionaryStatus;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionaryId=" + dictionaryId +
                ", dictionaryType=" + dictionaryType +
                ", dictionaryValue='" + dictionaryValue + '\'' +
                ", dictionaryOrder=" + dictionaryOrder +
                ", dictionaryStatus=" + dictionaryStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dictionary that = (Dictionary) o;

        if (!dictionaryId.equals(that.dictionaryId)) return false;
        if (!dictionaryType.equals(that.dictionaryType)) return false;
        if (!dictionaryValue.equals(that.dictionaryValue)) return false;
        if (!dictionaryOrder.equals(that.dictionaryOrder)) return false;
        return dictionaryStatus.equals(that.dictionaryStatus);
    }

    @Override
    public int hashCode() {
        int result = dictionaryId.hashCode();
        result = 31 * result + dictionaryType.hashCode();
        result = 31 * result + dictionaryValue.hashCode();
        result = 31 * result + dictionaryOrder.hashCode();
        result = 31 * result + dictionaryStatus.hashCode();
        return result;
    }

    public Integer getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Integer dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public String getDictionaryValue() {
        return dictionaryValue;
    }

    public void setDictionaryValue(String dictionaryValue) {
        this.dictionaryValue = dictionaryValue;
    }

    public Integer getDictionaryOrder() {
        return dictionaryOrder;
    }

    public void setDictionaryOrder(Integer dictionaryOrder) {
        this.dictionaryOrder = dictionaryOrder;
    }

    public Boolean getDictionaryStatus() {
        return dictionaryStatus;
    }

    public void setDictionaryStatus(Boolean dictionaryStatus) {
        this.dictionaryStatus = dictionaryStatus;
    }

    public DictionaryType getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(DictionaryType dictionaryType) {
        this.dictionaryType = dictionaryType;
    }
}