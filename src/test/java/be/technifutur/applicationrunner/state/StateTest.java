package be.technifutur.applicationrunner.state;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import be.technifutur.applicationrunner.inter.InteractiveApplication;

class StateTest {

    @Test
    void testStateHaveAnInteractiveApplication() {
	State state = new State();
	InteractiveApplication interAppMock = EasyMock.createMock(InteractiveApplication.class);
	state.setApplication(interAppMock);
	assertSame(interAppMock, state.getApplication());
    }

    @Test
    void testAddFinishTransition() {
	State stateApp = new State();
	Transition transition = new Transition();
	stateApp.addFinishTransition(transition);
	assertTrue(stateApp.getFinishTransitions().contains(transition));
    }
    
}
