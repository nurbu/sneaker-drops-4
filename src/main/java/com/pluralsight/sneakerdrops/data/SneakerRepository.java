package com.pluralsight.sneakerdrops.data;

import com.pluralsight.sneakerdrops.models.Sneaker;
import org.springframework.data.repository.CrudRepository;

public interface SneakerRepository extends CrudRepository<Sneaker, Long> {
}
