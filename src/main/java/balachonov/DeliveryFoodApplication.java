package balachonov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DeliveryFoodApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryFoodApplication.class, args);
    }
}
