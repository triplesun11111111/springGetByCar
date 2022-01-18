package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series", nullable = false)
    private int series;

    @Column(name = "model", nullable = false)
    private String model;

    public Car() {
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public Long getId() {
        return id;
    }
    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}';
    }
}
