package com.Atm.ATM;
 
//required packages 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*import org.springframework.web.bind.annotation.RequestParam;*/
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AtmController {

	@Autowired
	private IAtm iatm;

	
// methods for withdraw amount 	
	@PostMapping (value ="Atmw/{acno}/{amt}")
	Optional<AtmPojo> withdraw (@PathVariable int acno,@PathVariable int amt)
	{
		Optional<AtmPojo> atmPojo = iatm.withdraw(acno,amt);
		return atmPojo;
	}

// method for deposit amount 
	@PostMapping (value ="/Atmd/{acno}/{amt}")
	Optional<AtmPojo> deposit (@PathVariable ("acno") int acno,@PathVariable("amt") int amt)
	{
		Optional<AtmPojo> atmPojo = iatm.deposit(acno,amt);
		return atmPojo;
	}

 //  method for create user account 
	@PostMapping(value = "/Atm")
	public AtmPojo createAccount (@RequestBody AtmPojo a)
	{
		AtmPojo atmPojo = iatm.createAccount(a);
		return atmPojo;
	}

// method for update user details 
	@PostMapping(value = "/Atm/{acno}")
	AtmPojo updateDetails (@RequestBody AtmPojo a)
	{
		AtmPojo atmPojo = iatm.updateDetails(a);
		return a;
	}	  

// method for check details of user 
	@GetMapping(value ="/Atm/{acno}")
	public AtmPojo checkDetails(@PathVariable int acno)
	{

		Optional<AtmPojo> atmPojo = iatm.checkDetails(acno);
		return atmPojo.isPresent()?atmPojo.get():new AtmPojo(); 
	}

// method for check balance of user 
	@GetMapping(value = "Atmb/{acno}")
	AtmPojo checkBalance(@PathVariable ("acno") int acno)
	{
		Optional<AtmPojo> atmPojo = iatm.checkBalance(acno);
		return atmPojo.isPresent()?atmPojo.get():new AtmPojo();  

	}
	
// method for delete user data 
	@DeleteMapping(value ="Atm/{acno}")
	 String  deleteAccount(@PathVariable  int acno)
	{
		return iatm.deleteAccount(acno);
		
	}
	
    


} 