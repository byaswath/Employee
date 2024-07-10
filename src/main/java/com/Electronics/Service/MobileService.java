package com.Electronics.Service;

import java.rmi.NotBoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Electronics.Dao.MobileDao;
import com.Electronics.Entity.Mobile;
import com.Electronics.Exception.HighPriceRangeException;
import com.Electronics.Exception.NoColorFoundException;
import com.Electronics.Exception.NoSuchBrandException;
import com.Electronics.Exception.PriceException;

@Service
public class MobileService {
	
	@Autowired
	MobileDao md;
	
	public String postBulkMobileDetails(List<Mobile> mob) {
		return md.postBulkMobileDetails(mob);		
	}
	
	public String postOneMobileDetail(Mobile mob) {
		return md.postOneMobileDetail(mob);
	}
	
	public String postOneMobileDetailWithPriceException(Mobile mob) throws PriceException {
		if(mob.getPrice()>60000) {
			throw new PriceException("Price Range is High");
		}
		else {
			return md.postOneMobileDetail(mob);
		}
	}
	
//	public List<Mobile> getMobileDetailByColor(String a) throws NoColorFoundException {
//		if(md.getMobileDetailByColor(a).isEmpty()) {
//			throw new NoColorFoundException("Given Color is not available");
//		}
//		else {
//			return md.getMobileDetailByColor(a);
//		}		
//	}
	
	public List<Mobile> getMobileDetailByColor(String a) throws NoSuchElementException {
		if(md.getMobileDetailByColor(a).isEmpty()) {
			throw new NoSuchElementException("Given Color is not available");
		}
		else {
			return md.getMobileDetailByColor(a);
		}		
	}
	
	public List<Mobile> getNoSuchBrandException(String f) throws NoSuchBrandException {
		List<Mobile> x = md.getAllMobileDetails();
		List<Mobile> noSuchBrand = x.stream().filter(y -> y.getBrand().equals(f)).collect(Collectors.toList());
		if(noSuchBrand.isEmpty()) {
			throw new NoSuchBrandException("The Brand is not Avilable");
		}
		else {
			return noSuchBrand;
		}
	}
	
//	public List<Mobile> getNoSuchBrandException(String f) {
//		List<Mobile> x = md.getAllMobileDetails();
//		List<Mobile> noSuchBrand = x.stream().filter(y -> y.getBrand().equals(f)).collect(Collectors.toList());
////		if(noSuchBrand.isEmpty()) {
////			throw new NoSuchElementException("The Brand is not Avilable");
////		}
////		else {
//			return noSuchBrand;
////		}
//	}
	
	public List<Mobile> getMobileDetailsIfPriceGreaterThan(int a) throws HighPriceRangeException {
		if(md.getMobileDetailsIfPriceGreaterThan(a).isEmpty()) {
			throw new HighPriceRangeException("Price Range is High");
		}
		else {
			return md.getMobileDetailsIfPriceGreaterThan(a);
		}
	}
	
//	public Optional<String> getAllMobileDetails(String a) {
//		List<Mobile> x = Optional.ofNullable(md.getAllMobileDetails())
//                .orElseThrow(() -> new RunTimeException("No mobile details found"));
//		Optional<String> result = x.stream().filter(y -> y.getBrand().equals(a))
//				.map(y -> y.getColor()).collect(Collectors.toList());
//		return result;
//	}
	
//	public Optional<Mobile> getOneMobileDetail(int a) throws NotBoundException {
//		return Optional.of(md.getOneMobileDetail(a).orElseThrow(() -> new NotBoundException("No mobile details found")));		
//	}
	
	public List<String> getOneMobileDetail(String a) throws NotBoundException {
		List<Mobile> x = md.getAllMobileDetails();
		List<String> result = Optional.ofNullable(x.stream().filter(y -> y.getBrand().equals(a)).
				map(y -> y.getColor()).collect(Collectors.toList())).orElseThrow(() -> new NotBoundException("No mobile details found"));
		return result;
	}
	
	

}
