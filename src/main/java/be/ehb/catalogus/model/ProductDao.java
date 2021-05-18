package be.ehb.catalogus.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
