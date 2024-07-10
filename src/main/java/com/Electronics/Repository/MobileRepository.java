package com.Electronics.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.Electronics.Entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile,Integer> {
	
	@Query(value = "select mo from Mobile mo where mo.color=:a")
	public List<Mobile> getMobileDetailByColor(@Param ("a")String a); 
	
	@Query(value = "select * from mobi where price>?",nativeQuery=true)
	public List<Mobile> getMobileDetailsIfPriceGreaterThan(int a);
	

}
