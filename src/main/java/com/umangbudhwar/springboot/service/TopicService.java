package com.umangbudhwar.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.umangbudhwar.springboot.bean.Topic;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework", "Spring Framework Description"),
			new Topic("javascript","JavaScript", "JavaScript Description"),
			new Topic("java","Core Java", "Core Java Description")
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i = 0; i <= topics.size()-1; i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		/*int deleteIndex = -9;
		for(int i = 0; i <= topics.size()-1; i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				deleteIndex = i;
				break;
			}
		}
		topics.remove(deleteIndex);*/
		topics.removeIf(t -> t.getId().equals(id));
	}
}
