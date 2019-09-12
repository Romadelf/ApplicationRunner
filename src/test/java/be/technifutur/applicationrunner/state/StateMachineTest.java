package be.technifutur.applicationrunner.state;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import be.technifutur.applicationrunner.inter.InteractiveApplication;

class StateMachineTest {

    @Test
    void testStateMachineIsInteractiveApplicationAndHasEmptyDifferentInitialAndFinalStates() {
	StateMachine stateMachine = new StateMachine();
	@SuppressWarnings("unused")
	InteractiveApplication interAppStateMachine = stateMachine;
	State initialState = stateMachine.getInitialState();
	State finalState = stateMachine.getFinalState();
	assertNotNull(initialState);
	assertNotNull(finalState);
	assertNotSame(initialState, finalState);
	assertSame(initialState.getApplication(), EmptyApplication.getSingleton());
	assertSame(finalState.getApplication(), EmptyApplication.getSingleton());
    }
    
    @Test // TODO ...
    void testDelegateMethod() {/*
	// Préparation
	State state = new State();
	InteractiveApplication interAppMock = EasyMock.createMock(InteractiveApplication.class);
	state.setApplication(interAppMock);

	// Scénario
	interAppMock.start();
	EasyMock.expect(interAppMock.getScreen()).andReturn(new StringBuilder("toto"));
	interAppMock.newInput("dédé");
	EasyMock.expect(interAppMock.isFinish()).andReturn(true);
	EasyMock.expect(interAppMock.hasLastScreen()).andReturn(false);
	interAppMock.stop();
	EasyMock.replay(interAppMock);

	// Exécution
//	state.start();
//	assertEquals(new StringBuilder("toto").toString(), state.getScreen().toString());
//	state.newInput("dédé");
//	state.isFinish();
//	state.hasLastScreen();
//	state.stop();

	// Vérification
	EasyMock.verify(interAppMock);*/
    }

}
