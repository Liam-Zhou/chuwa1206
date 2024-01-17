package learn.spring.bankstatement.config;

import learn.spring.bankstatement.entity.Account;
import learn.spring.bankstatement.entity.User;
import learn.spring.bankstatement.payload.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class CommonConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        /*
        modelMapper.addMappings(new PropertyMap<User, UserDto>() {
            @Override
            protected void configure() {
                // map().setFullName(source.getFirstName() + " " + source.getLastName());
                map().setAccounts(source.getAccounts().stream().map(Account::getAccountId).collect(Collectors.toSet()));
            }
        });

         */
        return modelMapper;
    }
}
