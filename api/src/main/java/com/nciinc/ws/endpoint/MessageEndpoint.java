package com.nciinc.ws.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nciinc.ws.domain.Owner;
import com.nciinc.ws.domain.Topic;
import com.nciinc.ws.domain.TopicCategory;
import com.nciinc.ws.dto.TopicCategoryInfo;
import com.nciinc.ws.dto.TopicInfo;
import com.nciinc.ws.repository.OwnerDAO;
import com.nciinc.ws.repository.TopicCategoryDAO;
import com.nciinc.ws.repository.TopicDAO;

import io.swagger.annotations.ApiOperation;

@RestController
public class MessageEndpoint {
	private static final Logger log = LoggerFactory.getLogger(MessageEndpoint.class);

	@Autowired
	TopicCategoryDAO categoryDAO;

	@Autowired
	TopicDAO topicDAO;
	
	@Autowired
	OwnerDAO ownerDAO;

	@ApiOperation(value = "Get the list of all categories")
	@RequestMapping(value = "/category", method = RequestMethod.GET, produces = "application/json")
	public List<TopicCategoryInfo> getCategories() {
		// Return the list of all categories
		ArrayList<TopicCategoryInfo> ret = new ArrayList<TopicCategoryInfo>();
		for (TopicCategory category : categoryDAO.findAll())
			ret.add(new TopicCategoryInfo(category));
		return ret;
	}

	@ApiOperation(value = "Get topic by id")
	@RequestMapping(value = "/topic/{topicId}", method = RequestMethod.GET, produces = "application/json")
	public TopicInfo getTopic(@PathVariable int topicId) {
		// Return the topic
		Topic topic = topicDAO.findOne(topicId);
		if (topic == null) throw new BusinessException("There is no topic associated with id: "+topicId);

		return new TopicInfo(topic);
	}
	

	@ApiOperation(value = "Create topic")
	@RequestMapping(value = "/topic", method = RequestMethod.POST, consumes = "application/json")
	public void createTopic(@Valid @RequestBody TopicInfo input) {
		// Validate whether the category exists
		TopicCategory category = categoryDAO.findOne(input.getCategoryId());
		if (category == null) throw new BusinessException("The category ID: "+input.getCategoryId()+" is not a valid category ID");

		for(Owner owner: input.getOwners()){
			Owner o = ownerDAO.findOne(owner.getId());
			if(o==null) throw new BusinessException("There is no owner associated with id: "+owner.getId());
		}
		
		// Create topic
		Topic topic = new Topic(input);

		// Save the topic
		topicDAO.save(topic);
	}

	@ApiOperation(value = "Update topic")
	@RequestMapping(value = "/topic/{topicId}", method = RequestMethod.POST, consumes = "application/json")
	public void updateTopic(@PathVariable int topicId, @Valid @RequestBody TopicInfo input) {
		// Find the topic
		Topic topic = topicDAO.findOne(topicId);
		if (topic == null) throw new BusinessException("There is no topic associated with id: "+topicId);

		// Validate whether the category exists
		TopicCategory category = categoryDAO.findOne(input.getCategoryId());
		if (category == null) throw new BusinessException("The category ID: "+input.getCategoryId()+" is not a valid category ID");

		for(Owner owner: input.getOwners()){
			Owner o = ownerDAO.findOne(owner.getId());
			if(o==null) throw new BusinessException("There is no owner associated with id: "+owner.getId());
		}
		
		// Update the topic
		topic.update(input);

		// Save the topic
		topicDAO.save(topic);
	}
	
	@ApiOperation(value = "Control topic status")
	//@RequestMapping(value = "/topicStatus/{topicId}", method = RequestMethod.POST, consumes = "application/json")
	@RequestMapping(value = "/topicStatus/{topicId}", method = RequestMethod.POST)
	public void activeTopic(@PathVariable int topicId, @RequestParam(value="active") boolean activeFlag) {
		// Find the topic
		Topic topic = topicDAO.findOne(topicId);
		if (topic == null) throw new BusinessException("There is no topic associated with id: "+topicId);

		// set activeFlag
		topic.setActiveFlag(activeFlag);
		
		// Save the topic
		topicDAO.save(topic);
	}


	@ApiOperation(value = "Get the list of all topics by category")
	@RequestMapping(value = "/topic/bycategory/{categoryId}", method = RequestMethod.GET, produces = "application/json")
	public List<TopicInfo> getCategoriesByTopic(@PathVariable int categoryId) {
		// Return the list of topics by category
		return topicDAO.getTopicByCategory(categoryId);
	}
}
