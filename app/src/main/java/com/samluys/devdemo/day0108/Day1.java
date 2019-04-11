package com.samluys.devdemo.day0108;

/**
 * @author luys
 * @describe
 * @date 2019/1/9
 * @email samluys@foxmail.com
 */
public enum Day1 {
    FIRST{
        @Override
        public String getInfo() {
            return "F";
        }
    },SECOND {
        @Override
        public String getInfo() {
            return "S";
        }
    };

    public abstract String getInfo();
}
