package be.technifutur.applicationrunner.state;

import java.util.Collection;

import be.technifutur.applicationrunner.inter.InteractiveApplication;

import java.util.ArrayList;

public class State {
    
    private InteractiveApplication interApp;
    private ArrayList<Transition> finishTransitions = new ArrayList<Transition>();

    public State setApplication(InteractiveApplication interApp) {
	this.interApp = interApp;
	return this;
    }

    public InteractiveApplication getApplication() {
	return this.interApp;
    }
    
    public void addFinishTransition(Transition transition) {
	this.finishTransitions.add(transition);
    }

    public Collection<Transition> getFinishTransitions() {
	return this.finishTransitions;
    }

}
