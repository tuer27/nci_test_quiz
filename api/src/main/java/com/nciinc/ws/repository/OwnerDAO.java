package com.nciinc.ws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.nciinc.ws.domain.Owner;

@Repository
public interface OwnerDAO extends CrudRepository<Owner,Integer> {
}
