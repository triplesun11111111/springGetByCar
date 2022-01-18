package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void addCar(Car car, long l) {
      userDao.add(car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public User getByCar(String model, int series) {
      return userDao.getByCar(model, series);
   }

   @Override
   public void addCarToUser(Car car, long id) {
      User user = userDao.getById();
      if (user != null) {
         user.setCar(car);
         car.setUser(user);
         userDao.update(user);
      } else {
         throw new IllegalArgumentException("Пользователь не найден! " + id);
      }
   }

   @Override
   public User getByCar(Car car) {
      return userDao.getByCar(car.getModel(), car.getSeries());
   }
}
