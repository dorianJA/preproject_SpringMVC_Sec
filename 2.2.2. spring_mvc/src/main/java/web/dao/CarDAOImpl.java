package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CarDAOImpl implements CarDAO {


    @Override
    public List<Car> getCarlist() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW",6,800000));
        cars.add(new Car("AUDI",5,768000));
        cars.add(new Car("Ford",1,460000));
        return cars;
    }
}
