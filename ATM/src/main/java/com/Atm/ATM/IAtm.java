package com.Atm.ATM;

import java.util.Optional;

public interface IAtm 
{
	
	// create interfaces
	Optional<AtmPojo> withdraw (int acno, int amt); // update
	
	Optional<AtmPojo>deposit (int acno, int Atm); //update
	
	Optional<AtmPojo> checkBalance(int accno); // get
	
	Optional<AtmPojo> checkDetails (int accno); // get
	
	AtmPojo updateDetails (AtmPojo a); // update

	AtmPojo createAccount(AtmPojo a);// CREATE
	
	String deleteAccount(int acno); // DELETE


}
