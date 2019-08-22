package com.example.demo;

import java.util.*;
import org.springframework.stereotype.Service;

@Service 
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
        new Topic(1,"spring","boot"),
        new Topic(2,"java","code"),
        new Topic(3,"react","js")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(Integer id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get(); 
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(Integer id, Topic topic){
        for(int i=0 ; i<topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

	public void deleteTopic(Integer id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}