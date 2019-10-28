package ru.barsim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.barsim.dto.TimeAndEVN;
import ru.barsim.dto.User;
import ru.barsim.service.TImeAndEVNService;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        TImeAndEVNService tImeAndEVNService = new TImeAndEVNService();

    }
}
