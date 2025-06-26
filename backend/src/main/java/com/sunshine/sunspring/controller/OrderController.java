package com.sunshine.sunspring.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunshine.sunspring.model.Order;
import com.sunshine.sunspring.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	// this is DI injection
	
	@Autowired
	private OrderService or;
	
	// this method to fetch all the row from the database
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrder(){
		List<Order> order=or.getAllOrder();
		return ResponseEntity.ok(order);
	}
	
	// this is method to update row by the id and put row therer
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable Long id , @RequestBody Order order) {
		Order myOrder=or.updateOrder(id, order);
		return new ResponseEntity<>(myOrder,HttpStatus.ACCEPTED);
		
	}
	
	// this is method to create order or post order to the database
	
	@PostMapping
	public ResponseEntity<Order> postOrder(@RequestBody Order order) {
		Order myOrder=or.postOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(myOrder);
		
	}
	
	// this is method to delete 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		or.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
  // this is the method to find the last data from the database
	@GetMapping("/last")
	public ResponseEntity<Order> getLastOrderByController(){
		return ResponseEntity.ok(or.getLastOrderByService());
	}
}
