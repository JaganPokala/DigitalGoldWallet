package com.amisa.sprintevolution.digitalgoldwallet.controllers.thymeleaf;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.amisa.sprintevolution.digitalgoldwallet.beans.Payments;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Transaction_History;
import com.amisa.sprintevolution.digitalgoldwallet.beans.Users;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.CityNameNotFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.NoListFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.StateNameNotFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.SuccessResponse;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.UserIdNotFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.UserNameNotFoundException;
import com.amisa.sprintevolution.digitalgoldwallet.exceptionclasses.ValidationFailedException;
import com.amisa.sprintevolution.digitalgoldwallet.services.UserService;

@Controller
@RequestMapping("/api")
public class UsersThymeleaf {

	@Autowired
	UserService usrserv;

	@GetMapping("/alluserss")
	public String retrieveByUserId(Model model) {
		List<Users> user = usrserv.getAllUsers();
		if (user.isEmpty()) {
			throw new NoListFoundException("users not found");
		}
		model.addAttribute("user", user);
		return "alluserdetails";
	}

	@GetMapping("/userss")
	public String showdetailsforuserid() {
		return "user-form";
	}

	@GetMapping("/userss/id")
	public String retrieveByUserId(@RequestParam("id") int userId, Model model) {
		Users user = usrserv.getUserById(userId);
		if (user == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}
		model.addAttribute("user", user);
		return "userdetails";
	}

	@GetMapping("/byname")
	public String showdetailsbyname() {
		return "user-name-form";
	}

	@GetMapping("/byname/name")
	public String retrieveByName(@RequestParam("name") String name, Model model) {
		List<Users> user = usrserv.getUsersByName(name);
		if (user.isEmpty()) {
			throw new UserNameNotFoundException("User with name " + name + " not found");
		}
		model.addAttribute("user", user);
		return "user-name-details";
	}

	@GetMapping("/bybal")
	public String showbalancebyid() {
		return "bal-id-form";
	}

	@GetMapping("/bybal/id")
	public String retrieveBalbyId(@RequestParam("id") int userId, Model model) {
		Users user = usrserv.getUserById(userId);

		if (user == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}

		float bal = usrserv.getUserBalance(userId);
		model.addAttribute("bal", bal);
		return "bal-details";
	}

	@GetMapping("/bycity")
	public String showdetailsbycity() {
		return "user-city-form";
	}

	@GetMapping("/bycity/city")
	public String retrieveByCity(@RequestParam("city") String city, Model model) {
		List<Users> user = usrserv.getUserBycity(city);
		if (user.isEmpty()) {
			throw new CityNameNotFoundException("no users found in city " + city);
		}
		model.addAttribute("user", user);
		return "user-city-details";
	}

	@GetMapping("/bystate")
	public String showDetailsByState() {
		return "user-state-form";
	}

	@GetMapping("/bystate/state")
	public String retrieveByState(@RequestParam("state") String state, Model model) {
		List<Users> user = usrserv.getUserBystate(state);
		if (user.isEmpty()) {
			throw new StateNameNotFoundException("no users found in state " + state);
		}
		model.addAttribute("user", user);
		return "user-state-details";
	}

	@GetMapping("/vgt")
	public String showVgtById() {
		return "vgt-id-form";
	}

	@GetMapping("/vgt/id")
	public String retrieveVgtById(@RequestParam("id") int userId, Model model) {
		Users user = usrserv.getUserById(userId);
		if (user == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}

		float vgh = usrserv.getTotalVirtualGoldHoldingsByUserId(userId);
		model.addAttribute("vgh", vgh);
		return "vgt-id-details";
	}

	@GetMapping("/pgt")
	public String showPhtById() {
		return "pgt-id-form";
	}

	@GetMapping("/pgt/id")
	public String retrievePhtById(@RequestParam("id") int userId, Model model) {
		Users usr = usrserv.getUserById(userId);
		if (usr == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}

		float pgt = usrserv.getPhysicalGoldHoldingByUserId(userId);
		model.addAttribute("pgt", pgt);
		return "pgt-id-details";
	}

	@GetMapping("/th")
	public String showPaysById() {
		return "pays-id-form";
	}

	@GetMapping("/th/id")
	public String retrievePaymentsById(@RequestParam("id") int userId, Model model) {
		Users usr = usrserv.getUserById(userId);
		if (usr == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}
		List<Transaction_History> th = usrserv.getTransactionsByUserId(userId);
		model.addAttribute("th", th);
		return "pays-id-details";
	}

	@GetMapping("/pays")
	public String showHistoryById() {
		return "th-id-form";
	}

	@GetMapping("/pays/id")
	public String retrieveHistoryById(@RequestParam("id") int userId, Model model) {
		Users usr = usrserv.getUserById(userId);
		if (usr == null) {
			throw new UserIdNotFoundException("User with ID " + userId + " not found");
		}
		List<Payments> pays = usrserv.getPaymentsByUid(userId);
		model.addAttribute("pays", pays);
		return "th-id-details";
	}

	@GetMapping("/adduser")
    public String showaddUsers(Model model) {
		Users user = new Users();
		model.addAttribute("user",user);
        return "adduser-form";
    }
	
	
	//endpoint-5 /api/posts/{postid}/likes/add/{userid}
	@PostMapping("/posts/users/add")
	public String addlike(Model model,@ModelAttribute("like") Users u) {
		if (u.getName().isEmpty() || u.getEmail().isEmpty()) {
			throw new ValidationFailedException("Validation Failed");
		}
		Users user = usrserv.addUser(u);
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "New User added successfully");
		model.addAttribute("user", user);
		return "addeddetails";

	}

	@GetMapping("/updateuserss")
	public String showUpdateUser(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "updateuser-form";
	}

	@GetMapping("/update/user")
	public String updateUsers(@RequestParam("user_id") int user_id, @ModelAttribute("user") Users user, Model model) {
		Users usrr = usrserv.updateuser(user_id, user);
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "user details updated");

		if (usrr == null) {
			throw new UserIdNotFoundException("User with ID " + user_id + " not found");
		}
		model.addAttribute("successResponse", sr);
		return "uppdateduser";
	}

	@GetMapping("/updatebal")
	public String showUpdateBalanceForm(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "update-balance-form";
	}

	@GetMapping("/update/balance")
	public String updatebal(@RequestParam("user_id") int user_id, @ModelAttribute("user") Users user, Model model) {
		Users usrr = usrserv.updateuser(user_id, user);
		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "user details updated");

		if (usrr == null) {
			throw new UserIdNotFoundException("User with ID " + user_id + " not found");
		}
		model.addAttribute("successResponse", sr);
		return "uppdatedbal";
	}

	@GetMapping("/updateaddr")
	public String showUpdateAddressForm(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "update-addr-form";
	}

	@GetMapping("/update/addr")
	public String updateAddr(@RequestParam("user_id") int user_id, @RequestParam("addressId") int addressId,
			@ModelAttribute("user") Users user, Model model) {
		Users updatedUser = usrserv.updateAddress(user_id, addressId, user);

		SuccessResponse sr = new SuccessResponse(LocalDate.now(), "address updated successfully");
		if (updatedUser == null) {
			throw new UserIdNotFoundException("User with ID " + user_id + " not found");
		}
		model.addAttribute("successResponse", sr);
		return "uppdatedaddr";
	}

}