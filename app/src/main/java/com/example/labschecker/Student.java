package com.example.labschecker;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    public String name;
    String lastName;
    String group;
    String date_last_labs;
    String date_protect_other;
    int zach_value;
    int value_make_labs;
    public  Student (){

    }

    public Student(Parcel in) {
        zach_value = in.readInt();
        value_make_labs = in.readInt();
        name = in.readString();
        lastName = in.readString();
        group = in.readString();
        date_last_labs = in.readString();
        date_protect_other = in.readString();


    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public String getDate_last_labs() {
        return date_last_labs;
    }

    public String getDate_protect_other() {
        return date_protect_other;
    }


    public int getZach_value() {
        return zach_value;
    }

    public int getValue_make_labs() {
        return value_make_labs;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(zach_value);
        parcel.writeInt(value_make_labs);
        parcel.writeString(name);
        parcel.writeString(lastName);
        parcel.writeString(group);
        parcel.writeString(date_last_labs);
        parcel.writeString(date_protect_other);
    }
}
