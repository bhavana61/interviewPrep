package Splitwise.Entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;

    //TO-DO: can add grouplists here 
    //private List<Group> groupsList = new ArrayList<>();

    //Can be added as good to have 
   // UserBalanceSheet userBalanceSheet;


    public User(String userId, String name, String email) {
    this.userId = userId;
    this.name = name;
    this.email = email;
}

    //TO-DO :Group related changes
    // public void addUserToGroup(Group group, User user) {
    //     groupsList.add(group);
    //     group.addUser(user); // maintaining bi-directional relationship???? ante entiii
    // }

    // public void removeUserFromGroup(Group group, User user) {
    //     //Question...ee kinda raasina two lines order change aihe emaina difference untadaa???
    //     group.removeUser(user);
    //     groupsList.remove(group);
    // }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public List<Group> getGroupsList() {
        return groupsList;
    }


    public void setGroupsList(List<Group> groupsList) {
        this.groupsList = groupsList;
    }
   
}

//Notes : 
// Adding private to the objects in the class helps in encapsulation and data maintainability by not showing the staet of objects to the outside world. 
// Only exposed them with the help of getters and setters
