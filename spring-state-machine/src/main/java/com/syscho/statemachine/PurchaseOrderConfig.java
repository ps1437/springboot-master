package com.syscho.statemachine;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

@Configuration
@EnableStateMachineFactory

public class PurchaseOrderConfig extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents> {

	@Override
	public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states) throws Exception {
		states.withStates().initial(OrderStates.CREATED).end(OrderStates.APPROVED).end(OrderStates.DENIED)
				.end(OrderStates.CANCELLED).end(OrderStates.PROCESSED);
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions) throws Exception {
		transitions.withExternal()
		        .source(OrderStates.CREATED).target(OrderStates.APPROVED).event(OrderEvents.APPROVE)
				.guard(budgetGuard(BigDecimal.valueOf(100))).action(approveAction())
				 .and()
				 .withExternal()
				.source(OrderStates.CREATED).target(OrderStates.DENIED).event(OrderEvents.DENY).action(denyAction())
				.and().withExternal().source(OrderStates.APPROVED).target(OrderStates.PROCESSED)
				.event(OrderEvents.PROCESS).and().withExternal().source(OrderStates.APPROVED)
				.target(OrderStates.CANCELLED).event(OrderEvents.CANCEL);
	}

	public Guard<OrderStates, OrderEvents> budgetGuard(final BigDecimal limit) {
		return new Guard<OrderStates, OrderEvents>() {
			

			@Override
			public boolean evaluate(StateContext<OrderStates, OrderEvents> context) {
				System.out.println("PurchaseOrderConfig.budgetGuard(...).new Guard() {...}.evaluate()");
				Order order = findOrder(context.getExtendedState());
				if (order != null) {
					return order.getBudget().compareTo(limit) == -1;
				}
				return false;
			}
		};
	}

	private Action<OrderStates, OrderEvents> denyAction() {

		return null;
	}

	public Action<OrderStates, OrderEvents> approveAction() {
		return new Action<OrderStates, OrderEvents>() {
			@Override
			public void execute(StateContext<OrderStates, OrderEvents> context) {
				System.out.println("PurchaseOrderConfig.approveAction().new Action() {...}.execute()");
				Order order = findOrder(context.getExtendedState());
				if (order != null) {
					order.setNumber((int) (Math.random() * 100000));
					order.setApprovalDate(new Date());
				}
			}
		};
	}

	private Order findOrder(ExtendedState extendedState) {
		for (Object obj : extendedState.getVariables().values()) {
			if (obj instanceof Order) {
				return (Order) obj;
			}
		}
		return null;
	}
}
