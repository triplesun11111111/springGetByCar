package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void addCar(Car car, long l);
    List<User> listUsers();
    User getByCar(String model, int series);
    void addCarToUser(Car car, long id);

    User getByCar(Car car);
}
