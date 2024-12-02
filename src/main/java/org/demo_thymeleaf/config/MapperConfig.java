package org.demo_thymeleaf.config;

import org.demo_thymeleaf.dto.Employee;
import org.demo_thymeleaf.dto.IEmployee;
import org.demo_thymeleaf.util.CommonFunc;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDate;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);


        TypeMap<IEmployee, Employee> typeMap = modelMapper.createTypeMap(IEmployee.class, Employee.class);

        // Configure custom mappings
        Converter<Timestamp, LocalDate> converter = c -> CommonFunc.convertTimeStampToLocalDate(c.getSource());
        typeMap.addMappings(
                mapper -> mapper.using(converter).map(IEmployee::getBirth, Employee::setBirth)
        );

        return modelMapper;
    }

}
