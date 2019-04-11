package com.samluys.devdemo.color;

/**
 * @author luys
 * @describe
 * @date 2019/3/22
 * @email samluys@foxmail.com
 */
public class ColorEntity {

    private int color;
    private String name;

    public ColorEntity(int color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getColorId() {
        return color;
    }

    public void setColorId(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
