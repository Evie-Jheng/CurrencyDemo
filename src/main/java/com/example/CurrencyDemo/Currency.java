package com.example.CurrencyDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "symbol")
	private String symbol;

	@Column(name = "description")
	private String description;

	@Column(name = "rate")
	private String rate;

	@Column(name = "rate_float")
	private long rateFloat;

	public Currency() {

	}

	public Currency(String code, String symbol, String description, String rate, long rateFloat) {
		this.code = code;
		this.symbol = symbol;
		this.description = description;
		this.rate = rate;
		this.rateFloat = rateFloat;
	}

	public long getId() {
		return id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public long getRateFloat() {
		return rateFloat;
	}

	public void setRateFloat(long rateFloat) {
		this.rateFloat = rateFloat;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", code=" + code + ",symbol=" + symbol +", desc=" + description + ", rate=" + rate + ",rateFloat=" + rateFloat +"]";
	}
}
