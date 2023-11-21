package homework.onlineshop.storage;

import homework.onlineshop.enums.UserType;
import homework.onlineshop.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserStorage implements Serializable {
    private Map<String, User> users = new HashMap<>();

    public void add(String userId, User user) {
        users.put(userId, user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void removeUser(String userId) {
        users.remove(userId);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void print() {
        for (User user : users.values()) {
            System.out.println(user);
        }
        System.out.println();
    }

    public User getByEmail(String userEmail) {
        for (User user : users.values()) {
            if (user.getEmail().equals(userEmail)) {
                return user;
            }
        }
        return null;
    }

    public void deleteById(String userId) {
        if (!users.containsKey(userId)) {
            System.out.println("User does not exist!");
            return;
        }
        users.remove(userId);
        StorageSerializeUtil.serializeUserStorage(this);
        System.out.println("User with \'" + userId + "\' was deleted!!!");
    }

    public User[] getAllUsers() {
        return users.values().toArray(new User[0]);
    }

    public User[] getUsersByEmail(String email) {
        List<User> matchingUsers = new ArrayList<>();
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                matchingUsers.add(user);
            }
        }
        return matchingUsers.toArray(new User[0]);
    }


    public UserType getUserTypeByEmail(String email) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user.getUserType();
            }
        }
        return null;
    }

    // unsolved method
//    public User getUserByOrderId(String orderId) {
//    }
}
