package com.Electronics.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Electronics.Entity.Mobile;
import com.Electronics.Repository.MobileRepository;

@Repository
public class MobileDao {
	
	@Autowired
	MobileRepository mr;
	
	public String postOneMobileDetail(Mobile mob) {
		mr.save(mob);
		return "Posted the given Mobile details successfully";
	}
	
	public String postBulkMobileDetails(List<Mobile> mob) {
		mr.saveAll(mob);
		return "Posted the given Mobile details successfully";
	}
	
	public List<Mobile> getAllMobileDetails() {
		return mr.findAll();
	}
	
	public Optional<Mobile> getOneMobileDetail(int a) {
		return mr.findById(a);
	}
	
	public List<Mobile> getMobileDetailByColor(String a) {
		return mr.getMobileDetailByColor(a);
	}
	
	public List<Mobile> getMobileDetailsIfPriceGreaterThan(int a) {
		return mr.getMobileDetailsIfPriceGreaterThan(a);
	}

	
	
	
	
	

}
