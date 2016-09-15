package com.mganderson.discounts.example;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.mganderson.discounts.model.Customer;
import com.mganderson.discounts.model.Order;
import com.mganderson.discounts.model.Product;

public class OrderPricingRulesTest {

	private KieContainer kContainer = KieServices.Factory.get().newKieClasspathContainer();

	@Test
	public void testPennsylvaniaDiscount() {
		KieSession kSession = kContainer.newKieSession("discounts-ksession");

		// stage our data to excercise our rule
		Customer customer = new Customer();
		customer.setResidentState("PA");

		Product product = new Product();
		product.setCost( new BigDecimal( 20 ) );

		Order order = new Order();
		order.setCustomer( customer );
		order.setProduct( product );

		// insert facts into the session and execute the rules
		kSession.insert( order );
		kSession.insert( customer );
		kSession.insert( product );
		kSession.fireAllRules();
		
		/// between here and the next line of code several rules could fire, 

		Collection<Order> orders = (Collection<Order>) kSession.getObjects(new ClassObjectFilter(Order.class));
		assertEquals(1, orders.size());
		Order results = (Order) orders.toArray()[0];
		assertEquals(new BigDecimal(18), results.getCost());

		kSession.dispose();

	}
	
	@Test
	public void testDefaultPricing() {
		KieSession kSession = kContainer.newKieSession("discounts-ksession");

		// stage our data to excercise our rule
		Customer customer = new Customer();
		customer.setResidentState("TX");

		Product product = new Product();
		product.setCost( new BigDecimal( 20 ) );

		Order order = new Order();
		order.setCustomer( customer );
		order.setProduct( product );

		// insert facts into the session and execute the rules
		kSession.insert( order );
		kSession.insert( customer );
		kSession.insert( product );
		kSession.fireAllRules();
		
		/// between here and the next line of code several rules could fire, 

		Collection<Order> orders = (Collection<Order>) kSession.getObjects(new ClassObjectFilter(Order.class));
		assertEquals(1, orders.size());
		Order results = (Order) orders.toArray()[0];
		assertEquals(new BigDecimal(20), results.getCost());

		kSession.dispose();

	}
}