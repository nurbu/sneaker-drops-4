package com.pluralsight.sneakerdrops;

import com.pluralsight.sneakerdrops.data.BrandRepository;
import com.pluralsight.sneakerdrops.data.SneakerRepository;
import com.pluralsight.sneakerdrops.models.Brand;
import com.pluralsight.sneakerdrops.models.Sneaker;
import com.pluralsight.sneakerdrops.service.DropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class StartupRunner implements CommandLineRunner {

    private final DropService dropService;
    private final BrandRepository brandRepository;
    private final SneakerRepository sneakerRepository;

    @Autowired
    public StartupRunner(DropService dropService, BrandRepository brandRepository, SneakerRepository sneakerRepository) {
        this.dropService = dropService;
        this.brandRepository = brandRepository;
        this.sneakerRepository = sneakerRepository;

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

        if (sneakerRepository.count() == 0) {
            sneakerRepository.save(new Sneaker("Jordans_1", 200, 1998));
            sneakerRepository.save(new Sneaker("Jordans_4", 300, 2004));
            sneakerRepository.save(new Sneaker("Jordans_11", 150, 2007));
        }
        brandRepository.findAll().forEach(System.out::println);
        sneakerRepository.findAll().forEach(System.out::println);
        
    }
}
