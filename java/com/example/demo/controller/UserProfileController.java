package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserProfile;

@RestController
public class UserProfileController {

	private Map<String, UserProfile> userMap;
	
	@PostConstruct //Spring framework이 UserProfileController클래스 인스턴스를 만들고 그 직후 호출됨
	public void init() {
		userMap = new HashMap<String, UserProfile>();
		userMap.put("1", new UserProfile("1", "홍길동", "11-1111", "서울시 강남구 대치1동"));
		userMap.put("2", new UserProfile("2", "홍길자", "11-1112", "서울시 강남구 대치2동"));
		userMap.put("3", new UserProfile("3", "홍길순", "11-1113", "서울시 강남구 대치3동"));
	}
	
	//id를 인자로 받아서 해당 유저파일의 정보를 json파일로 전달하는 API
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() { //기존에 가지고있던 map을 List로 바꾸어서 return
		return new ArrayList<UserProfile>(userMap.values());
	}
	
	//데이터를 생성하는 api를 put방식으로 구현하자.
	@PutMapping("/user/{id}") //path로 정보를 다 보내도 되지만 보통은 한두가지 간단한 parameter들만 path에서 이용된다.
	public void putUserProfile(@PathVariable("id") String id,@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) { //일반적인 경우에는 RequestParam이라는 형태로 http의 프로토콜의 parameter형태로 보냄 
		UserProfile userProfile = new UserProfile(id, name, phone, address);
		userMap.put(id, userProfile);
	}
	
	@PostMapping("/user/{id}") //post방식으로 수정 api 구현.
	public void postUserProfile(@PathVariable("id") String id,@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		UserProfile userProfile = userMap.get(id);
		userProfile.setName(name);
		userProfile.setPhone(phone);
		userProfile.setAddress(address);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		userMap.remove(id);
	}
}
