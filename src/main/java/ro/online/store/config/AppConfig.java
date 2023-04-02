package ro.online.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.online.store.repository.CategoryRepository;
import ro.online.store.service.CategoryService;
import ro.online.store.utils.CustomFakerUser;

@Configuration
public class AppConfig {

    @Bean
    CustomFakerUser customFakerCategories(){
        return new CustomFakerUser();
    }

    @Bean
    CategoryService categoryService(
            CategoryRepository categoryRepository,
            CustomFakerUser customFakerCategories
    ) {
        return new CategoryService(
                categoryRepository,
                customFakerCategories);
    }
}
