package com.petmily.backend.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.petmily.backend.shop.domain.Orderlist;
import com.petmily.backend.shop.dto.OrderAdmin;

@Repository
public interface OrderlistRepository extends JpaRepository<Orderlist, Long> {
	
	@Query(nativeQuery=true, value="select o.orderNum, o.orderDate, o.orderState, o.boardNum, o.quantity, "
			+ "o.memberNum, o.cost from orderlist o order by o.orderDate desc")
	List<OrderAdmin> getOrderlist();
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="delete from orderlist where orderNum = :orderNum")
	void deleteByOrderNum(Long orderNum);
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="update orderlist o set o.orderState = :orderState where o.orderNum = :orderNum")
	void updateOrderState(@Param("orderNum") Long orderNum, @Param("orderState") String orderState);

}