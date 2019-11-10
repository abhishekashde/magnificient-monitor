package in.aa.sauce.monitor.magnificentmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MagnificentMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MagnificentMonitorApplication.class, args);
    }
}