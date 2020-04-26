package com.example.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.config.Customer;
import com.example.model.Trader;
import com.example.model.Transaction;

@Service("istioUtilityService")
public class IstioUtilityService {

	private static Map<Integer, Customer> map = new HashMap();
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario", "Milan");
	Trader alan = new Trader("Alan", "Cambridge");
	Trader brian = new Trader("Brian", "Cambridge");
	List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 30000.00),
			new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 7100.00),
			new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 95000.00));
	
	
	
	//5. Are any traders based in Milan?
	//7. What’s the highest value of all the transactions?
	//8. Find the transaction with the smallest value
	
	public  List<Trader> getAllTraders(){
		return Arrays.asList(raoul,mario,alan,brian);
	}
	//1.Find all transactions in the year 2011 and sort them by value (small to high).
	public List<Transaction> getAllTransactionGivenYear(int year){
		System.out.println("Year:::"+year);
		List<Transaction> trans=transactions.stream().filter(t->t.getYear()==year).sorted(Comparator.comparingDouble(Transaction::getValue)).collect(Collectors.toList());
		
		return trans;
	}
	
	//2. What are all the unique cities where the traders work?
	public List<String> getAllTradersCity(){
		
		return transactions.stream().map(trans->trans.getTrader().getCity()).distinct().collect(Collectors.toList());
	}
	//3. Find all traders from Cambridge and sort them by name.
	public List<Trader> getAllTradersByCity(String city){
		
		return transactions.stream().map(t->t.getTrader()).filter(t->t.getCity().equalsIgnoreCase(city)).distinct().sorted(Comparator.comparing(Trader::getCity)).collect(Collectors.toList());
		
	}
	//4. Return a string of all traders’ names sorted alphabetically.
	public String getAllTradersName() {
		return transactions.stream().map(t->t.getTrader().getName()).collect(Collectors.joining(","));
	}
	//6. Print all transactions’ values from the traders living in Cambridge.
	public List<Double> getTransactionValueGivenCity(String city){
		return transactions.stream().filter(t->t.getTrader().getCity().equalsIgnoreCase(city)).map(Transaction::getValue).collect(Collectors.toList());
	}
	
	
	
	
}
