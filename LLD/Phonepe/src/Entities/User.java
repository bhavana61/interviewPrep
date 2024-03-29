package Entities;

import Enums.DepartmentName;

public class User {
    public int userId;
    public String userName;
    public DepartmentName departmentName;

    public User(int id, String name, DepartmentName departmentName) {
        this.userId = id;
        this.userName = name;
        this.departmentName = departmentName;
    }
}
