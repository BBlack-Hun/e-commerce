package kr.co.bblackhun.ecommerce.User.repository;

import kr.co.bblackhun.ecommerce.User.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

}
