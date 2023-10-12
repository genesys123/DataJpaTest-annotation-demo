package com.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private CityRepository cityRepository;

    @Override
    public void run(String... args) throws Exception {
    	System.out.println("###############");
        var cities = cityRepository.findByNameEndingWithAndPopulationLessThan("est", 1800000);
        cities.forEach(city -> logger.info("{}", city));
    }
}