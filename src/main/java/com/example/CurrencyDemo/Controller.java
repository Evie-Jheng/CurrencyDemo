package com.example.CurrencyDemo;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private CoindeskAPI mCoindeskAPI;
	
	@Autowired
	private CurrencyRepository mCurrencyRepository;
	
	@GetMapping("/coindeskAPI")
	public ResponseEntity<String> getDataCoindeskAPI(){
		JSONObject json = mCoindeskAPI.callCoindeskAPI();
		return new ResponseEntity<>(json.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/currency")
	public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency) {
		try {
			Currency currencyData = mCurrencyRepository
					.save(new Currency(currency.getCode(),currency.getSymbol(),currency.getDescription(),currency.getRate(),currency.getRateFloat()));
			return new ResponseEntity<>(currencyData, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/currency")
	public ResponseEntity<List<Currency>> getCurrency() {
		try {
			List<Currency> currencyList = new ArrayList<Currency>();
			mCurrencyRepository.findAll().forEach(currencyList::add);
			
			if (currencyList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(currencyList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
