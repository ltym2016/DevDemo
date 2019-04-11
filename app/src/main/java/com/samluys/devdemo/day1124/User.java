package com.samluys.devdemo.day1124;

import android.os.Parcel;
import android.os.Parcelable;

import com.samluys.devdemo.Book;

/**
 * @author luys
 * @describe
 * @date 2018/11/24
 * @email samluys@foxmail.com
 */
public class User implements Parcelable {

    public int userId;
    public String userName;
    public boolean isMale;
    public Book book;


    protected User(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
        book = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
        dest.writeParcelable(book, flags);
    }

}
