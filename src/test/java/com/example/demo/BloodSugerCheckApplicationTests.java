package com.example.demo;

import com.example.demo.Entity.Food;
import com.example.demo.Entity.History;
import com.example.demo.Entity.Plans;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.*;
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

	@Test
	void contextLoads() {
//		Users user = new Users();
//		user.setUserName("test2");
//		user.setPassword("testPW");
//		user.setUserAddress("testAddress");
//		user.setUserAge(25);
//		user.setUserGender(true);
//		user.setUserBloodSugerLevel(1);
//		usersRepository.save(user);
		Optional<Users> findUser = usersRepository.findById(1);
		Optional<Food> findFood = foodRepository.findById(1);


//		History history = new History();
//		history.setUser(findUser.get());
//		history.setBloodSugerHistory(1);
//		history.setSession("Morning");
//		history.setCheckDate(LocalDate.now());
//		history.setDiseaseLevel(1);
//		historyRepository.save(history);

//		Plans plans = new Plans();
//		plans.setUser(findUser.get());
//		plans.setPlanDate(LocalDate.now());
//		plans.setSession("Dinner");
//		plansRepository.save(plans);

//		Food food = new Food();
//		food.setFoodName("testFood");
//		food.setFoodCategory("testCategory");
//		food.setIngredients("testIngredient1 100g, testIngredient2 50g, testIngredient3 100g");
//		food.setPhosphours_g(1);
//		food.setPotassium_g(1);
//		food.setProtein_g(1);
//		food.setSodium_mg(1);
//		food.setFoodImage(new byte[]{1,2,3,4});
//		foodRepository.save(food);

	}

}
