package homework.onlineshop.storage;

import homework.onlineshop.enums.UserType;
import homework.onlineshop.model.User;


public class UserStorage {
    private User[] users = new User[10];
    private int size;

    public void add(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
        System.out.println();
    }

    public User getById(String userId) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId().equals(userId)) {
                return users[i];
            }
        }
        return null;
    }

    public User getByEmail(String userEmail) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(userEmail)) {
                return users[i];
            }
        }
        return null;
    }

    public void deleteById(String userId) {
        int indexById = getIndexById(userId);
        if (indexById == -1) {
            System.out.println("User does not exists!");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            users[i - 1] = users[i];
        }
        size--;
        System.out.println("User with \'" + userId + "\' was deleted!!!");
    }


    public User[] getAllUsers() {
        return users;
    }

    public User[] getUsersByEmail(String email) {
        User[] usersByEmail = new User[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (users[i] != null) {
                usersByEmail[j] = users[i];
                j++;
            }
        }
        if (usersByEmail[0] != null) {
            return usersByEmail;
        }
        return null;
    }

    public UserType getUserTypeByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i].getUserType();
            }
        }
        return null;
    }

    public User[] getUsersByPassword(String password) {
        User[] usersByPassword = new User[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (users[i] != null) {
                usersByPassword[j] = users[i];
                j++;
            }
        }
        if (usersByPassword[0] != null) {
            return usersByPassword;
        }
        return null;
    }

    public User[] getUsersByOrderId(String orderId) {
        User[] usersByOrder = new User[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (users[i] != null) {
                usersByOrder[j] = users[i];
                j++;
            }
        }
        if (usersByOrder[0] != null) {
            return usersByOrder;
        }
        return null;
    }

    private int getIndexById(String userId) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId().equals(userId)) {
                return i;
            }
        }
        return -1;
    }

    private void extend() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }
}
