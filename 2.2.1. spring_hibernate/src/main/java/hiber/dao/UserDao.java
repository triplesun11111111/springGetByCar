package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao {
   @Transactional
   User getByCar(String model, int series);
   void add(User user);
   List<User> listUsers();

   void add(Car car);

   User getById();
   void update(User user);
}
