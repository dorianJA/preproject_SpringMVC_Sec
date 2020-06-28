package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.dao.CarDAOImpl;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService service;

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(defaultValue = "en") String locale, ModelMap modelMap){
        List<Car> cars = new ArrayList<>();
        cars = service.getCarList();
        String loc = getLocale(locale);
        modelMap.addAttribute("carList",cars);
        modelMap.addAttribute("locale",loc);
        return "cars";
    }

    private String getLocale(String local){
        switch (local){
            case "en": return "CARS";
            case "ru": return "МАШИНЫ";
            default: return "Car list";
        }
    }


}
