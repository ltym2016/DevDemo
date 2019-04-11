package com.samluys.devdemo.day0108;

/**
 * @author luys
 * @describe
 * @date 2019/1/8
 * @email samluys@foxmail.com
 */
public enum  TestEnum {




    SUCCESS("1","成功"),FAILED("2","失败");

    private String value;
    private String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    TestEnum(String value, String desc) {
        this.desc = desc;
        this.value = value;

    }
}
