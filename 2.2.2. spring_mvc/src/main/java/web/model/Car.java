package web.model;


import javax.persistence.*;

//@Entity
//@Table(name = "cars")

public class Car {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int series;
    private int price;

    public Car(String name, int series, int price) {
        this.name = name;
        this.series = series;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", series=" + series +
                ", price=" + price +
                '}';
    }
}
