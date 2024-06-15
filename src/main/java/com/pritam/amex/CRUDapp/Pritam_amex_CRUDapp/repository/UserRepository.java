package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.repository;

import com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> findByEmailId(String emailId);
}
