package com.nciinc.ws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nciinc.ws.domain.TopicCategory;

@Repository
public interface TopicCategoryDAO extends CrudRepository<TopicCategory,Integer> {
}
