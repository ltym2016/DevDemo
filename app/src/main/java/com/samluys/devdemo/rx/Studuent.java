package com.samluys.devdemo.rx;

import java.util.List;

/**
 * @author luys
 * @describe
 * @date 2019/4/10
 * @email samluys@foxmail.com
 */
public class Studuent {

    private String name;

    private List<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
