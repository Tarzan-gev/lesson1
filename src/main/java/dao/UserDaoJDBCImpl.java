package dao;

import com.mysql.cj.util.Util;
import model.User;

import java.sql.Connection;
import java.util.List;

public class UserDaoJDBC implements UserDao{

    private static final Connection conn = Util.getConnection();
    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public void cleanUsersTable() {

    }
}
