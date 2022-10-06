package com.Atm.ATM;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.stereotype.Component;*/
import org.springframework.stereotype.Service;


@Service
public class AtmService implements IAtm 
{    
	@Autowired
	private AtmRepo atmdao;

// this method is used to withdraw money from bank account 
	@Override
	public Optional<AtmPojo> withdraw(int acno, int amt) 
	{
		AtmPojo a;
		Optional<AtmPojo> entity = atmdao.findById(acno);
		//entity.isPresent()?bal=entity.get().balance:new Atm();
		//entity.balance = entity.balance-amt;
		
		if(entity.isPresent())
		{
			 a=entity.get();
			a.balance=a.balance-amt;
			atmdao.save(a);
		}

		return entity;
	}

	
// this method is used to deposit money in  bank account 
  @Override
	public Optional<AtmPojo> deposit(int acno, int amt)
	{
		
		AtmPojo a;
		Optional<AtmPojo> entity = atmdao.findById(acno);
		/*
		 * Atm entity = atmdao.getOne(acno); entity.balance = entity.balance+amt;
		 */
		if(entity.isPresent())
		{
			 a=entity.get();
			a.balance=a.balance+amt;
			atmdao.save(a);
		}
		/* atmdao.save(entity); */

		return entity;

	}
	

// this method is used to check balance from account 
	@Override
	public Optional <AtmPojo> checkBalance(int accno)
	{
		return atmdao.findById(accno);

	}
	
	
// this method is used to  check details of account 
	@Override
	public Optional<AtmPojo> checkDetails(int a)
	{
		return atmdao.findById(a);

	}

// this method is used to update details in account 
	@Override
	public AtmPojo updateDetails(AtmPojo a) 
	{
		 atmdao.save(a);
		 return a;
		 

	}

// this method is used to create account 
	@Override
	public AtmPojo createAccount(AtmPojo a) 
	{
		 atmdao.save(a);
		 return a;
	}

// this method is used to delete the existing account 
	@Override
    public String deleteAccount(int acno)
    {
        Optional<AtmPojo> entity= atmdao.findById(acno);
        if(entity.isPresent())
        {
            atmdao.delete(entity.get());
            return "Account Deleted Sucessfully";
        }
        return "Accout not found";
    }


}
