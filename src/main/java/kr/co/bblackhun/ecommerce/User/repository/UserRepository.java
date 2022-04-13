package kr.co.bblackhun.ecommerce.User.repository;

import kr.co.bblackhun.ecommerce.User.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByEmail(String email);
}
