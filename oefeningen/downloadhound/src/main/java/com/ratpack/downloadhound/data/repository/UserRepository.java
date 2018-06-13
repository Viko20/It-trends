package com.ratpack.downloadhound.data.repository;

import com.ratpack.downloadhound.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUserAccount(String account);
    User findByEmail(String email);
}
