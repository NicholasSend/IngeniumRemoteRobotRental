package com.ingenium.double3rental.repositories;

import com.ingenium.double3rental.entities.RentalSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalSessionRepository extends CrudRepository<RentalSession, Long> {
    RentalSession findById(long id);
}
