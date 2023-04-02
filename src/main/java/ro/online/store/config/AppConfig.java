package ro.online.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.online.store.repository.CategoryRepository;
import ro.online.store.service.CategoryService;

@Configuration
public class AppConfig {

    @Bean
    CategoryService categoryService(CategoryRepository categoryRepository){
        return new CategoryService(categoryRepository);
    }
}
