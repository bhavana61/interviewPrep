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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

    
}
