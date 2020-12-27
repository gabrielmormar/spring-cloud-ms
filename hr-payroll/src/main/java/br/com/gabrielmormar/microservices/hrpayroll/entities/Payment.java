package br.com.gabrielmormar.microservices.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Payment {

	private String name;
	private Double dailyIncome;
	private Integer days;
	private Double total;
	
	public double getTotal() {
		return days * dailyIncome;
	}

	public Payment(String name, Double dailyIncome, Integer days) {
		super();
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}
	
}
