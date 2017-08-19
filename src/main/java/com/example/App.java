package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

//    @Bean
//    public CommandLineRunner test(OwnerDao ownerDao) {
//        return (args) -> {
//            Owner owner = new Owner("uptowncat", "18309226301", "123456", "158668658@qq.com", 1, 2.5);
//            Car car = new Car("A1232", "bmw", "43242.jpg");
//            List<Car> cars = new ArrayList<>();
//            cars.add(car);
//            owner.setCars(cars);
//            ownerDao.save(owner);
//
//            Owner one = ownerDao.findOne(1);
//            System.out.println(one);
//        };
//    }

//    @Bean
//    public CommandLineRunner demo(CustomerRepository repository) {
//        return (args) -> {
//            // save a couple of customers
//            repository.save(new Customer("Jack", "Bauer"));
//            repository.save(new Customer("Chloe", "O'Brian"));
//            repository.save(new Customer("Kim", "Bauer"));
//            repository.save(new Customer("David", "Palmer"));
//            repository.save(new Customer("Michelle", "Dessler"));
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findOne(1L);
//            log.info("Customer found with findOne(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            for (Customer bauer : repository.findByLastName("Bauer")) {
//                log.info(bauer.toString());
//            }
//            log.info("");
//        };
//    }
}
