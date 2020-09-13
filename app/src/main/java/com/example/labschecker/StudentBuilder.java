package com.example.labschecker;

public class StudentBuilder{
    private Student student;
    public   StudentBuilder(Student student){
        this.student = student;
    }
    public StudentBuilder setName(String name){
        student.name=name;
        return this;
    }
    public StudentBuilder setLastName(String lastName){
        student.lastName=lastName;
        return this;
    }
    public StudentBuilder setGroop(String group){
        student.group=group;
        return this;
    }
    public StudentBuilder setDateLastLabs(String date_last_labs){
        student.date_last_labs=date_last_labs;
        return this;
    }
    public StudentBuilder setDateProtectOther(String date_protect_other){
        student.date_protect_other=date_protect_other;
        return this;
    }
    public StudentBuilder setZachValue(int zach_value){
        student.zach_value=zach_value;
        return this;
    }
    public StudentBuilder setMakeLabs(int value_make_labs){
        student.value_make_labs=value_make_labs;
        return this;
    }
    public Student make(){
        return this.student;
    }
}
