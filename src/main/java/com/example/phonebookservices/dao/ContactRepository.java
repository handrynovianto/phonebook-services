package com.example.phonebookservices.dao;

import com.example.phonebookservices.dto.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository <Contact, Long> {

    Optional<Object> findByPhone(String phone);
}
