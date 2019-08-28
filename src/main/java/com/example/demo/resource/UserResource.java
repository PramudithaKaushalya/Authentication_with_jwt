package com.example.demo.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping(value = "/")
public class UserResource {

	@Autowired
	private UserRepository userRepository; 
	
 	@GetMapping("/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }
    
    @PostMapping(value = "/signup")
    public void signup(@RequestBody User user){
    	userRepository.save(user);
    }
}


//@RequestMapping("/topics/{id}")
//public Topic getTopic(@PathVariable Integer id) {
//    return userRepository.getTopic(id);
//}
//
//@RequestMapping(method=RequestMethod.POST, value="/topics")
//public void addTopic(@RequestBody Topic topic) {
//	userRepository.addTopic(topic);
//}
//
//@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
//public void updateTopic(@RequestBody User topic, @PathVariable Integer id) {
//	userRepository.updateTopic(id, topic);
//}
//
//@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
//public void deleteTopic(@PathVariable Integer id) {
//	userRepository.deleteTopic(id);
//}