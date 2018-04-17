package com.cdg.common.enums;

/**
 * 小乖性别
 *
 * @author cuiweilin.
 */
public enum PetSexEnum {

    /**
     * 通过
     */
    SEX_MAN((byte)0, "女"),

    /**
     * 拒绝
     */
    SEX_WOMAN((byte)1, "男");

    /**
     * 属性值
     */
    private Byte value;

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
    private PetSexEnum(Byte value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
