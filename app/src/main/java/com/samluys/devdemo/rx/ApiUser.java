package com.samluys.devdemo.rx;

/**
 * @author luys
 * @describe
 * @date 2019/4/12
 * @email samluys@foxmail.com
 */
public class ApiUser {
    public long id;
    public String firstname;
    public String lastname;

    @Override
    public String toString() {
        return "ApiUser{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
