package top.fallenangel.crm.model.entity;

import org.springframework.format.annotation.DateTimeFormat;
import top.fallenangel.crm.template.impl.BaseEntity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * t_deal 交易
 *
 * @author 坠天使
 */
public class Deal extends BaseEntity implements Serializable {
    private Integer dealId;

    private Clue clue;

    private MarketActivity activity;

    /**
     * 联系人
     */
    private Linkman linkman;

    /**
     * 交易号
     */
    private String dealNo;

    /**
     * 交易名称
     */
    private String dealName;

    /**
     * 交易内容
     */
    private String dealContent;

    /**
     * 交易阶段
     */
    private String dealStage;

    /**
     * 交易类型
     */
    private Integer dealType;

    /**
     * 预计交易时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dealPlanTime;

    /**
     * 实际交易时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dealActualTime;

    /**
     * 交易金额
     */
    private Double dealAmount;

    /**
     * 交易来源
     */
    private Integer dealSource;

    /**
     * 交易方式
     */
    private Integer dealWay;

    private DealStage[] dealStages;

    private static final long serialVersionUID = 1L;

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Clue getClue() {
        return clue;
    }

    public void setClue(Clue clue) {
        this.clue = clue;
    }

    public MarketActivity getActivity() {
        return activity;
    }

    public void setActivity(MarketActivity activity) {
        this.activity = activity;
    }

    public Linkman getLinkman() {
        return linkman;
    }

    public void setLinkman(Linkman linkman) {
        this.linkman = linkman;
    }

    public String getDealNo() {
        return dealNo;
    }

    public void setDealNo(String dealNo) {
        this.dealNo = dealNo;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealContent() {
        return dealContent;
    }

    public void setDealContent(String dealContent) {
        this.dealContent = dealContent;
    }

    public String getDealStage() {
        return dealStage;
    }

    public void setDealStage(String dealStage) {
        this.dealStage = dealStage;
    }

    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public Date getDealPlanTime() {
        return dealPlanTime;
    }

    public void setDealPlanTime(Date dealPlanTime) {
        this.dealPlanTime = dealPlanTime;
    }

    public Date getDealActualTime() {
        return dealActualTime;
    }

    public void setDealActualTime(Date dealActualTime) {
        this.dealActualTime = dealActualTime;
    }

    public Double getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(Double dealAmount) {
        this.dealAmount = dealAmount;
    }

    public Integer getDealSource() {
        return dealSource;
    }

    public void setDealSource(Integer dealSource) {
        this.dealSource = dealSource;
    }

    public Integer getDealWay() {
        return dealWay;
    }

    public void setDealWay(Integer dealWay) {
        this.dealWay = dealWay;
    }

    public DealStage[] getDealStages() {
        return dealStages;
    }

    public void setDealStages(DealStage[] dealStages) {
        this.dealStages = dealStages;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "dealId=" + dealId +
                ", clue=" + clue +
                ", activity=" + activity +
                ", linkman=" + linkman +
                ", dealNo='" + dealNo + '\'' +
                ", dealName='" + dealName + '\'' +
                ", dealContent='" + dealContent + '\'' +
                ", dealType=" + dealType +
                ", dealPlanTime=" + dealPlanTime +
                ", dealActualTime=" + dealActualTime +
                ", dealAmount=" + dealAmount +
                ", dealSource=" + dealSource +
                ", dealWay=" + dealWay +
                ", dealStages=" + Arrays.toString(dealStages) +
                ", " + super.toString() +
                '}';
    }
}