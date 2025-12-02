
import servise.UserService;
import servise.UserServiceImpl;

public class Main {

    private final  static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Ника", "Бинго", (byte) 78);
        userService.saveUser("Эмма", "Бридова", (byte) 74);
        userService.saveUser("Вахо", "Чако", (byte) 59);
        userService.saveUser("Джордж", "Вашигтон ", (byte) 74);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }



}
