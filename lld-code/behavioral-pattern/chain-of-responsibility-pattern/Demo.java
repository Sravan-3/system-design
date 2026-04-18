import java.io.IOException;
import java.util.Scanner;

public class Demo {

    private static Scanner scanner = new Scanner(System.in);
    private static Server server;

    private static void init(){
        server = new Server();

        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = Middleware.link(
            new ThrottlingMiddleware(2), 
            new UserExistsMiddleware(server),
            new RoleCheckMiddleware()
        );

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException{

        init();

        boolean success = false;

        do{
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Input password: ");
            String password = scanner.nextLine();
            success = server.login(email, password);
        }while(!success);

        scanner.close();
        
    }
}
