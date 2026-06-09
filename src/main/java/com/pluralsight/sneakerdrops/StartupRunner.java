package com.pluralsight.sneakerdrops;

import com.pluralsight.sneakerdrops.data.BrandRepository;
import com.pluralsight.sneakerdrops.models.Brand;
import com.pluralsight.sneakerdrops.service.DropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class StartupRunner implements CommandLineRunner {

    private final DropService dropService;
    private final BrandRepository brandRepository;

    @Autowired
    public StartupRunner(DropService dropService, BrandRepository brandRepository) {
        this.dropService = dropService;
        this.brandRepository = brandRepository;

    }

    @Override
    public void run(String... args) {
        System.out.println(dropService.getStatus());
        seedData();
    }

    private void seedData() {
        if (brandRepository.count() == 0) {
            brandRepository.save(new Brand("Nike"));
            brandRepository.save(new Brand("Adidas"));
            brandRepository.save(new Brand("New Balance"));
        }
        brandRepository.findAll().forEach(System.out::println);
    }
}
