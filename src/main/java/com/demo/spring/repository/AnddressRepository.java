package com.demo.spring.repository;

import com.demo.spring.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByPersonId(Long personId);

    Address findByPersonIdAndMainIsTrue(Long personId);


}
