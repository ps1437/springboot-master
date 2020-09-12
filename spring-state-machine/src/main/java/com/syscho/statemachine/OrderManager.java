package com.syscho.statemachine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.access.StateMachineAccess;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Service;

@Service
public class OrderManager {
	@Autowired
	StateMachineFactory<OrderStates, OrderEvents> factory;

	public StateMachine<OrderStates, OrderEvents> newOrder(Order order) {
		StateMachine<OrderStates, OrderEvents> stateMachine = factory.getStateMachine("PO-" + order.getId());
		stateMachine.stop();
		stateMachine.getStateMachineAccessor()
		.doWithAllRegions(access->reset(access));
		stateMachine.getExtendedState().getVariables().put("order", order);
		stateMachine.start();
		return stateMachine;
	}

	private void reset(StateMachineAccess<OrderStates, OrderEvents> access) {
		access.resetStateMachine(new DefaultStateMachineContext<OrderStates, OrderEvents>(null, null, null, null));
	}

	public boolean fire(StateMachine<OrderStates, OrderEvents> stateMachine, OrderEvents event) {
		return stateMachine.sendEvent(event);
	}

	@SuppressWarnings("unchecked")
	public List<Transition<OrderStates, OrderEvents>> getTransitions(
			StateMachine<OrderStates, OrderEvents> stateMachine) {

		List<Transition<OrderStates, OrderEvents>> transitions = new ArrayList<>();

		for (Object objTrans : stateMachine.getTransitions()) {
			Transition<OrderStates, OrderEvents> transition = (Transition<OrderStates, OrderEvents>) objTrans;

			if (transition.getSource().getId().equals(stateMachine.getState().getId())) {
				transitions.add(transition);
			}
		}

		return transitions;
	}
}
