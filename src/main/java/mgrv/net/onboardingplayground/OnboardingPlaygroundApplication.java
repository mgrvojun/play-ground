package mgrv.net.onboardingplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnboardingPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnboardingPlaygroundApplication.class, args);
    }
}
