package ru.zhulidin.auction.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.zhulidin.auction.entities.Product;
import ru.zhulidin.auction.entities.User;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findByName(String name);

    List<Product> findAllByName(String name);
    List<Product> findAllByNameLike(String name);
    List<Product> findAllByNameLikeAndAvailable(String name, boolean available);

    List<Product> findAllByAvailable(boolean available);



    List<Product> findByOwner(User user);
    List<Product> findByBuyer(User user);
}
