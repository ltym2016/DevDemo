package com.samluys.devdemo.day0108;

/**
 * @author luys
 * @describe
 * @date 2019/1/9
 * @email samluys@foxmail.com
 */
public enum Day {

    MONDAY("1"),
    TUESDAY("2"),
    WEDNESDAY("3"),
    THURSDAY("4"),
    FRIDAY("5"),
    SATURDAY("6"),
    SUNDAY("7");


    private String desc;

    Day(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
