import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "org.example")
@EntityScan(basePackages = "org.example")
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"org.example"})
public class ApplicationHibernateExample {
    public static void main(String args[]){
        SpringApplication.run(ApplicationHibernateExample.class, args);
    }
}
