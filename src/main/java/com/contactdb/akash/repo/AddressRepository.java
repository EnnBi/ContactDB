package com.contactdb.akash.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contactdb.akash.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {

}
