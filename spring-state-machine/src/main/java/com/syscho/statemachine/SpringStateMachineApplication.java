package com.syscho.statemachine;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class SpringStateMachineApplication implements CommandLineRunner {
	
	@Autowired
	OrderManager orderManager;

	public static void main(String[] args) {
		SpringApplication.run(SpringStateMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Order laptop = new Order(1L, "Laptop", BigDecimal.valueOf(1000));
		StateMachine<OrderStates,OrderEvents> laptopStateMachine = orderManager.newOrder( laptop );
		
		System.out.println("Laptop State: " + laptopStateMachine.getState().getId());
		orderManager.fire(laptopStateMachine, OrderEvents.APPROVE);
		 
		System.out.println("Laptop State: " + laptopStateMachine.getState().getId());
		//System.out.println(laptopStateMachine.getExtendedState().getVariables());

		// Mouse PO
		Order mouse = new Order(2L, "Mouse", BigDecimal.valueOf(50));
		StateMachine<OrderStates,OrderEvents> mouseStateMachine = orderManager.newOrder( mouse );

		System.out.println("Mouse State: " + mouseStateMachine.getState().getId());
		orderManager.fire(mouseStateMachine, OrderEvents.APPROVE);
		
		System.out.println("Mouse State: " + mouseStateMachine.getState().getId());
		System.out.println(mouseStateMachine.getExtendedState().getVariables().get("order"));
		
		
		System.out.println( "Mouse Machine Completed:" + mouseStateMachine.isComplete() );
		orderManager.fire(mouseStateMachine, OrderEvents.PROCESS);
		System.out.println("Mouse State: " + mouseStateMachine.getState().getId());
		System.out.println( "Mouse Machine Completed:" + mouseStateMachine.isComplete() );
	}

}
