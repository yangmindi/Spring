package com.atguigu1.config;

import com.atguigu1.bean.Person;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScans(
        value = {
                @ComponentScan(value = "com.atguigu1",includeFilters = {
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
//                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
                },useDefaultFilters = false)
        }
)
public class MainConfig {

    @Bean(value = "person")
    public Person person01(){
        return new Person("lisi",20);
    }
}
