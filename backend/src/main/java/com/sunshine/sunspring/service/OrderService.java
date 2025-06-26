package com.sunshine.sunspring.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshine.sunspring.model.Order;
import com.sunshine.sunspring.repository.OrderRepository;

@Service
public class OrderService {

	// this is DI injection
	
	@Autowired
	
	private OrderRepository or;
	
	// this method to fetch all the row from the database
	public List<Order> getAllOrder(){
		
		return or.findAll();
	}
	
	
	// this is method to update row by the id and put row there
	public Order updateOrder(Long id , Order order) {
		order.setOrder_id(id);
		
		return or.save(order);
		
	}
	
	// this is method to create order or post order to the database
	
	
	
	public Order postOrder(Order order) {
		return or.save(order);
	}
	
	// this is method to delete 
	public void deleteOrder(Long id) {
		or.deleteById(id);
	}
	
	// this is the method to find the last data from the database
	public Order getLastOrderByService() {
		return or.findLastOrder();
	}
}
