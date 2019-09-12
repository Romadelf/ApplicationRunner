package be.technifutur.applicationrunner.state;

import be.technifutur.applicationrunner.inter.InteractiveApplication;

public class StateMachine implements InteractiveApplication {
    
    private State initialState = emptyApplicationStateFactory();
    private State finalState = emptyApplicationStateFactory();
    
    private State emptyApplicationStateFactory() {
	return new State().setApplication(EmptyApplication.getSingleton());
    }

    public State getInitialState() {
	return this.initialState;
    }

    public State getFinalState() {
	return this.finalState;
    }

    @Override
    public void start() {
	// TODO Auto-generated method stub

    }

    @Override
    public StringBuilder getScreen() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean isFinish() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void newInput(String input) {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean hasLastScreen() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public void stop() {
	// TODO Auto-generated method stub

    }

}
