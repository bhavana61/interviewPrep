package Splitwise.Interfaces;

import java.util.List;

import Splitwise.Entities.Group;

public interface IGroupRepository {
    public void saveGroup(Group group);
    public Group getGroup(String groupId);
    public List<Group> getAllGroups();
}
