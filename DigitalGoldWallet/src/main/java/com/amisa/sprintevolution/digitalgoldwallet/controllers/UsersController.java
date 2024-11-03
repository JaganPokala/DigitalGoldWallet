package com.amisa.sprintevolution.digitalgoldwallet.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amisa.sprintevolution.digitalgoldwallet.beans.*;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.*;
import com.amisa.sprintevolution.digitalgoldwallet.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

	@Autowired
	private UserService usrserv;

	public UsersController() {
		super();
	}

	public UsersController(UserService usrserv) {
		super();
		this.usrserv = usrserv;
	}

	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers() {

		List<Users> usrs = usrserv.getAllUsers();
		if (usrs.isEmpty()) {
			throw new NoListFoundException("users not found");
		}
		return new ResponseEntity(usrs, HttpStatus.OK);

	}

	@GetMapping("/{userId}")
	public Users getUserById(@PathVariable int userId) {
		Users user = usrserv.getUserById(userId);
		if (user == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}
		return user;

	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Users>> getUsersByName(@PathVariable("name") String name) {
		List<Users> usr = usrserv.getUsersByName(name);
		if (usr.isEmpty()) {
			throw new UserNameNotFoundException("User with name " + name + " not found");
		}

		return new ResponseEntity<>(usr, HttpStatus.OK);
	}

	@GetMapping("/check_balance/{userId}") // This will map to /api/users/{userId}/balance endpoint
	public float getUserBalance(@PathVariable("userId") int userId) {
		Users user = usrserv.getUserById(userId);
		if (user == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}

		return usrserv.getUserBalance(userId);
	}

	@PostMapping("/add")
	public ResponseEntity<SuccessResponse> addUser(@RequestBody Users newUser) {
		if (newUser.getName().isEmpty() || newUser.getEmail().isEmpty()) {
			throw new ValidationFailedException("Validation Failed");
		}
		Users u1 = usrserv.addUser(newUser);
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "New User added successfully");
		return new ResponseEntity<>(sr, HttpStatus.CREATED);
	}

	// find by city
	@GetMapping("/by_city/{city}")
	public ResponseEntity<List<Users>> getUsersbycity(@PathVariable("city") String city) {
		List<Users> usr = usrserv.getUserBycity(city);
		if (usr.isEmpty()) {
			throw new CityNameNotFoundException("no users found in city " + city);
		}

		return new ResponseEntity<>(usr, HttpStatus.OK);
	}

	// find by state
	@GetMapping("/by_state/{state}")
	public ResponseEntity<List<Users>> getUsersbystate(@PathVariable("state") String state) {
		List<Users> usr = usrserv.getUserBystate(state);
		if (usr.isEmpty()) {
			throw new StateNameNotFoundException("no users found in state " + state);
		}
		return new ResponseEntity<>(usr, HttpStatus.OK);
	}

	@PutMapping("/update/{user_id}")
	public ResponseEntity<SuccessResponse> updateuser(@PathVariable("user_id") int id, @RequestBody Users usr) {
		Users usrr = usrserv.updateuser(id, usr);
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "user details updated");

		if (usrr == null) {
			throw new UserIdNotFoundException("User with ID " + id + " not found");
		}
		return new ResponseEntity<>(sr, HttpStatus.OK);
	}

	@PutMapping("{user_id}/update_balance/{amount}")
	public ResponseEntity<SuccessResponse> updatebalance(@PathVariable("user_id") int id,
			@PathVariable("amount") float bal, @RequestBody Users usr) {

		Users usrr = usrserv.updateBalance(id, bal, usr);
		if (usrr == null) {
			throw new UserIdNotFoundException("User with ID " + id + " not found");
		}
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "balance updated successfully");

		return new ResponseEntity<>(sr, HttpStatus.OK);
	}
	

	@PutMapping("/{userId}/update_address/{addressId}")
	public ResponseEntity<SuccessResponse> updateAddress(@PathVariable("userId") int userId,
			@PathVariable("addressId") int addressId, @RequestBody Users user) {
		Users updatedUser = usrserv.updateAddress(userId, addressId, user);

		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "address updated successfully");
		if (updatedUser == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		} else {
			return new ResponseEntity<>(sr, HttpStatus.OK);
		}
	}

	@GetMapping("/{user_id}/virtual_gold_holdings")
	public ResponseEntity<Float> getTotalVghByUserId(@PathVariable("user_id") int userId) {
		Users usr = usrserv.getUserById(userId);
		if (usr == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}

		float totalVirtualGoldHoldings = usrserv.getTotalVirtualGoldHoldingsByUserId(userId);
		return new ResponseEntity<>(totalVirtualGoldHoldings, HttpStatus.OK);
	}

	@GetMapping("/{user_id}/physical_gold_holding")
	public ResponseEntity<Float> getPghByUserId(@PathVariable("user_id") int userId) {
		Users usr = usrserv.getUserById(userId);
		if (usr == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}

		float physicalholdings = usrserv.getPhysicalGoldHoldingByUserId(userId);
		return new ResponseEntity<>(physicalholdings, HttpStatus.OK);
	}

	@GetMapping("/{user_id}/transaction_history")
	public ResponseEntity<List<Transaction_History>> getTransactionHistoryByUserId(
			@PathVariable("user_id") int userId) {

		Users usr = usrserv.getUserById(userId);
		if (usr == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}
		List<Transaction_History> transactionHistory = usrserv.getTransactionsByUserId(userId);
		return new ResponseEntity<>(transactionHistory, HttpStatus.OK);
	}

	@GetMapping("/{user_id}/payments")
	public ResponseEntity<List<Payments>> getPaymentsByUserId(@PathVariable("user_id") int userId) {

		Users usr = usrserv.getUserById(userId);
		if (usr == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}
		List<Payments> payments = usrserv.getPaymentsByUid(userId);
		return new ResponseEntity<>(payments, HttpStatus.OK);
	}

}
