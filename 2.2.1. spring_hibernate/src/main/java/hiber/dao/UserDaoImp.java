package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Transactional
   @Override
   public User getByCar(String model, int series) {
      try (Session session = sessionFactory.openSession()) {
         String hql = "FROM User u WHERE u.car.model = :model AND u.car.series = :series";
         Query query = session.createQuery(hql, User.class);
         query.setParameter("model", model);
         query.setParameter("series", series);
         return (User) query.getSingleResult();
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public User getById() {
      return sessionFactory.getCurrentSession().get(User.class, 1);
   }

   @Override
   public void update(User user) {
      sessionFactory.getCurrentSession().update(user);
   }

}
