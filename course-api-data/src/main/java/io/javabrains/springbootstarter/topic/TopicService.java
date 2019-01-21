package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

//	private List<Topic> topics = new ArrayList<>(
//			Arrays.asList(
//				      new Topic("politics","Washington Politics","Current affairs at the hill"),		
//				      new Topic("java","Head First Java","Best book for java in market"),		
//				      new Topic("spring","Spring in Action","Covers great examples")		
//						));
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		 .forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		Topic t = topicRepository.findById(id).orElse(null);
		return t;
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void addTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
