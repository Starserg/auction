package ru.zhulidin.auction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zhulidin.auction.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String Email);

    User findByActivationCode(String code);

    User findByToken(String token);
}
