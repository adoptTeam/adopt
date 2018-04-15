package com.cdg.common.enums;

/**
 *  小乖状态枚举
 *
 * @author cuiweilin.
 */
public enum AdoptStateEnum {

    /**
     * 初始化
     */
    INIT(10, "初始化"),

    /**
     * 已付款
     */
    PAYED(20, "已付款"),

    /**
     * 发送中
     */
    SENDING(30, "发送中"),

    /**
     * 体验中
     */
    EXPERIENCING(40, "体验中"),

    /**
     * 申请退还
     */
    APPLY_REFUND(50, "申请退还"),

    /**
     * 已退还
     */
    REFUNDED(60, "已退还"),

    /**
     * 已退还
     */
    DELETED(70, "已删除");

    /**
     * 属性值
     */
    private int value;

    /**
     * 属性描述
     */
    private String desc;

    /**
     * 构造器
     *
     * @param value
     * @param desc
     */
    private AdoptStateEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public byte getValue() {
        return (byte)(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public static void main(String[] args){
        System.out.println(AdoptStateEnum.APPLY_REFUND.getValue());
    }
}
