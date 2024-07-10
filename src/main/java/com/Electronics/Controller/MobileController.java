package com.Electronics.Controller;

import java.rmi.NotBoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Electronics.Entity.Mobile;
import com.Electronics.Exception.HighPriceRangeException;
import com.Electronics.Exception.NoColorFoundException;
import com.Electronics.Exception.NoSuchBrandException;
import com.Electronics.Exception.PriceException;
import com.Electronics.Service.MobileService;

@RestController
public class MobileController {
	
	@Autowired
	MobileService ms;
	
	@PostMapping(value = "/postBulkMobileDetails")
	public String postBulkMobileDetails(@RequestBody List<Mobile> mob) {
		return ms.postBulkMobileDetails(mob);		
	}
	
	@PostMapping(value = "/postOneMobileDetail")
	public String postOneMobileDetail(@RequestBody Mobile mob) {
		return ms.postOneMobileDetail(mob);
	}
	
	@PostMapping(value = "/postOneMobileDetailWithPriceException")
	public String postOneMobileDetailWithPriceException(@RequestBody Mobile mob) throws PriceException {
		return ms.postOneMobileDetailWithPriceException(mob);
	}
	
	@GetMapping(value = "/getMobileDetailByColor/{a}")
	public List<Mobile> getMobileDetailByColor(@PathVariable String a) throws NoSuchElementException {
		return ms.getMobileDetailByColor(a);
	}

	@GetMapping(value = "/getNoSuchBrand/{f}")
	public List<Mobile> getNoSuchBrandException(@PathVariable String f) throws NoSuchBrandException {
		return ms.getNoSuchBrandException(f);
	}
	
//	@GetMapping(value = "/getNoSuchBrand/{f}")
//	public List<Mobile> getNoSuchBrandException(@PathVariable String f) {
//		return ms.getNoSuchBrandException(f);
//	}
	
	@GetMapping(value = "/getHighPriceException/{a}")
	public List<Mobile> getMobileDetailsIfPriceGreaterThan(@PathVariable int a) throws HighPriceRangeException {
		return ms.getMobileDetailsIfPriceGreaterThan(a);
	}

//	
//	@GetMapping(value = "/getOrElseThrowException/{a}")
//	public Optional<Mobile> getOneMobileDetail(@PathVariable int a) throws NotBoundException {
//		return ms.getOneMobileDetail(a);		
//	}
	
	@GetMapping(value = "/getOrElseThrowException/{a}")
	public List<String> getOneMobileDetail(String a) throws NotBoundException {
		return ms.getOneMobileDetail(a);
	}

}
