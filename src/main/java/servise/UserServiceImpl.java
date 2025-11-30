package servise;

import dao.UserDao;
import dao.UserDaoJDBC;
import model.User;

import java.util.List;

public class UserServiceEmp implements UserService{
    UserDao userDao = new UserDaoJDBC();

    @Override
    public void createUsersTable() {
        userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.dropUsersTable();
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
