package LinkedIn.Entities;

import LinkedIn.Enums.Status;

import java.util.List;

public class Account {
    int id;
    String username;
    String password;

    Status accountStatus;

    String mobile;

    String email;

    List<WorkExperience> experiences;

    List<Education> educations;

    List<Integer> followers;

    List<Integer> following;
}
