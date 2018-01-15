package top.young.analysis.configure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import top.young.analysis.entity.User;

@Configuration
@PropertySource("classpath:application.yml")
public class ConfigureText {

    @Bean(name = "user")
    public User user(){
        return new User("马加特","male");
    }

    @Value("${prop.test}")
    private String singer;

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
