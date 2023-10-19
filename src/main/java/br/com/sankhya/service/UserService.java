package br.com.sankhya.service;

import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.sankhya.entity.UserEntity;

@Service
public class UserService implements UserDetailsService {

	private String uri = "http://localhost:8090/authentication-service";
	
	  	@Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    	UserEntity user = null; 
	    	HttpHeaders headers = new HttpHeaders();
			try {  
				
				headers.setContentType(MediaType.APPLICATION_JSON);
				RestTemplate restTemplate = new RestTemplate();
				HttpEntity<String> entity = new HttpEntity<String>(headers); 
				String response = restTemplate.getForObject(uri+"?username="+username, String.class);

				System.out.println(response);
				ObjectMapper mapper = new ObjectMapper();
				
				JsonObject json = JsonParser.parseString(response).getAsJsonObject();
				System.out.println(json);
				String userString = json.get("user").getAsString();
				System.out.println(userString);
				user = mapper.readValue(userString, UserEntity.class);
				System.out.println("user" + user);
	        }catch(Exception e) {
	        	System.out.println(e);
	        }
	        if (user != null) {
	            return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	        } else {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	    }
	   
}
