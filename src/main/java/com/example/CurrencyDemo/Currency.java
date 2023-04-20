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
	private int mId;

	@Column(name = "code")
	private String mCode;

	@Column(name = "symbol")
	private String mSymbol;

	@Column(name = "description")
	private String mDescription;

	@Column(name = "rate")
	private String mRate;

	@Column(name = "rate_float")
	private long mRateFloat;

	public Currency() {

	}

	public Currency(String code, String symbol, String description, String rate, long rateFloat) {
		mCode = code;
		mSymbol = symbol;
		mDescription = description;
		mRate = rate;
		mRateFloat = rateFloat;
	}
	
	public String getCode() {
		return mCode;
	}

	public long getId() {
		return mId;
	}

	public String getSymbol() {
		return mSymbol;
	}
	
	public void setCode(String code) {
		mCode = code;
	}
	
	public void setSymbol(String symbol) {
		mSymbol = symbol;
	}

	public void setDescription(String description) {
		mDescription = description;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setRate(String rate) {
		mRate = rate;
	}
	
	public String getRate() {
		return mRate;
	}

	public long getRateFloat() {
		return mRateFloat;
	}
	
	public void setRate_float(long rateFloat) {
		mRateFloat = rateFloat;
	}

	@Override
	public String toString() {
		return "Currency [id=" + mId + ", code=" + mCode + ",symbol=" + mSymbol +", desc=" + mDescription + ", rate=" + mRate + ",rateFloat=" + mRateFloat +"]";
	}
}
