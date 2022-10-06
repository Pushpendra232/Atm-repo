package com.Atm.ATM;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtmRepo extends JpaRepository<AtmPojo, Integer> {

}
