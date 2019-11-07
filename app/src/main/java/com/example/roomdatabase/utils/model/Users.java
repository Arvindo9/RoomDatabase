package com.example.roomdatabase.utils.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class Users {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private Long _id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Salary")
    private String salary;

    @ColumnInfo(name = "Designation")
    private String designation;

    @ColumnInfo(name = "Date")
    private String date;

    @ColumnInfo(name = "Mobile")
    private String mobile;

    public Users(String name, String salary, String designation, String date, String mobile) {
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.date = date;
        this.mobile = mobile;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
