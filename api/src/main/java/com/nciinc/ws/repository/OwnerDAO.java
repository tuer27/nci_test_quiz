package com.nciinc.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nciinc.ws.domain.Owner;
import com.nciinc.ws.dto.OwnerInfo;

@Repository
public interface OwnerDAO extends CrudRepository<Owner,Integer> {
	@Query("select new com.nciinc.ws.dto.OwnerInfo(o) from Owner o where o.topicId = :topicId")
	public List<OwnerInfo> getOwnerByTopic(@Param("topicId")int topicId);
}
