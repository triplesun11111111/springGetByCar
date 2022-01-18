package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Lisa", "Garland", "user1@mail.ru"));
      userService.add(new User("James", "Sunderland", "user2@mail.ru"));
      userService.add(new User("Angela", "Orosco", "user3@mail.ru"));

      Car car = new Car(1, "BMW");
      Car car2 = new Car(2, "Audi");
      Car car3 = new Car(3, "Mercedes");

      userService.addCar(car, 1L);
      userService.addCar(car2, 2L);
      userService.addCar(car3, 3L);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Машина = " + user.getCar());
         System.out.println();

         User userByCar = userService.getByCar(user.getCar());
         System.out.println("Получить пользователя по его машине = " + userByCar.getFirstName() + " " + userByCar.getLastName() +
         " " + user.getCar().getModel() + " " + user.getCar().getSeries());
      }
      context.close();
   }
}
