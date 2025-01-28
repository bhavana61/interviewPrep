package Splitwise.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.Entities.Group;
import Splitwise.Interfaces.IGroupRepository;

public class InMemoryGroupRepository implements IGroupRepository{

    private Map<String, Group> groups = new HashMap<>();

    @Override
    public void saveGroup(Group group) {
        groups.put(group.getGroupId(), group);
    }

    @Override
    public Group getGroup(String groupId) {
        return groups.get(groupId);
    }

    @Override
    public List<Group> getAllGroups() {
        return new ArrayList<>(groups.values());
    }
}
