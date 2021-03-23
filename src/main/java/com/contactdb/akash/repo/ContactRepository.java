package com.contactdb.akash.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contactdb.akash.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Long>{

	boolean existsByNumber(String number);
	List<Contact> findByAddress_CityIgnoreCase(String city);
}
 