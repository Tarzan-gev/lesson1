package servise;


import model.User;
import org.junit.jupiter.api.*;

import java.util.List;

public class UserServiceTest {

    private static UserService userService;

    @BeforeAll
    static void setup() {
        userService = new UserServiceImpl();
        userService.createUsersTable();
    }

    @AfterEach
    void cleanUp() {
        userService.cleanUsersTable();
    }

    @AfterAll
    static void tearDown() {
        userService.dropUsersTable();
    }

    @Test
    void saveUser_shouldSaveUserToDatabase() {
        String name = "Ivan";
        String lastName = "Petrov";
        byte age = 25;


        userService.saveUser(name, lastName, age);
        List<User> allUsers = userService.getAllUsers();


        Assertions.assertEquals(1, allUsers.size());
        User savedUser = allUsers.getFirst();
        Assertions.assertEquals(name, savedUser.getName());
        Assertions.assertEquals(lastName, savedUser.getLastName());
        Assertions.assertEquals(age, savedUser.getAge());
    }

    @Test
    void removeUserById_shouldRemoveUserFromDatabase() {

        String name = "Elena";
        String lastName = "Sidorova";
        byte age = 30;
        userService.saveUser(name, lastName, age);
        List<User> allUsers = userService.getAllUsers();
        long idToRemove = allUsers.getFirst().getId();


        userService.removeUserById(idToRemove);
        List<User> usersAfterRemoval = userService.getAllUsers();


        Assertions.assertEquals(0, usersAfterRemoval.size());
    }

    @Test
    void getAllUsers() {

        userService.saveUser("Petr", "Ivanov", (byte) 28);
        userService.saveUser("Anna", "Smirnova", (byte) 22);


        List<User> allUsers = userService.getAllUsers();

        Assertions.assertEquals(2, allUsers.size());
    }

    @Test
    void cleanUsersTable() {

        userService.saveUser("Dmitry", "Kuznetsov", (byte) 35);
        userService.getAllUsers();


        userService.cleanUsersTable();
        List<User> usersAfterClean = userService.getAllUsers();


        Assertions.assertEquals(0, usersAfterClean.size());
    }

    @Test
    void createAndDropTable() {

        String name = "Vasia";
        String lastName = "Pupkin";
        byte age = 18;
        userService.saveUser(name, lastName, age);
        Assertions.assertEquals(1, userService.getAllUsers().size());


        userService.dropUsersTable();
        userService.createUsersTable();
        List<User> allUSers = userService.getAllUsers();


        Assertions.assertEquals(0, allUSers.size());
    }


}