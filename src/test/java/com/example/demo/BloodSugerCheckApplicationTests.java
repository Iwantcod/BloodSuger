package com.example.demo;

import com.example.demo.Entity.Food;
import com.example.demo.Entity.History;
import com.example.demo.Entity.Plans;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.*;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
class BloodSugerCheckApplicationTests {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private StepRepository stepRepository;
	@Autowired
	private PlansRepository plansRepository;
	@Autowired
	private HistoryRepository historyRepository;
	@Autowired
	private FoodRepository foodRepository;
	@Autowired
	private DetailsRepository detailsRepository;
    @Autowired
    private UserService userService;

	@Test
	void contextLoads() {

		System.out.println(userService.getUserById(102).getUserName());


	}

}
