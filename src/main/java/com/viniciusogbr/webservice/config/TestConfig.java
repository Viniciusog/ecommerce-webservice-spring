package com.viniciusogbr.webservice.config;


import com.viniciusogbr.webservice.entities.Category;
import com.viniciusogbr.webservice.entities.Order;
import com.viniciusogbr.webservice.entities.User;
import com.viniciusogbr.webservice.entities.enums.OrderStatus;
import com.viniciusogbr.webservice.repositories.CategoryRepository;
import com.viniciusogbr.webservice.repositories.OrderRepository;
import com.viniciusogbr.webservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") //Esse nome deve ser igual ao definido no arquivo application-test.properties
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //Tudo o que estiver dentro desse método será executado quando o programa iniciar
    @Override
    public void run(String... args) throws Exception {
        //Inserir conteúdo no banco de dados
        User u1 = new User(null, "Maria Brown",
                "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green",
                "alex@gmail.com", "977777777", "123456");

        //-----------------------------------------------

        //Horário UTC - Greenwich
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        //-----------------------------------------------

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2, cat3));
    }
}