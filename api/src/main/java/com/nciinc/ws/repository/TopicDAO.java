package com.nciinc.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nciinc.ws.domain.Topic;
import com.nciinc.ws.dto.TopicInfo;

@Repository
public interface TopicDAO extends CrudRepository<Topic,Integer> {
	@Query("select new com.nciinc.ws.dto.TopicInfo(t) from Topic t where t.categoryId = :categoryId")
	public List<TopicInfo> getTopicByCategory(@Param("categoryId")int categoryId);
}
