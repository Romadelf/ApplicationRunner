package be.technifutur.applicationrunner.state;

import be.technifutur.applicationrunner.inter.InteractiveApplication;

public class EmptyApplication implements InteractiveApplication {
    
    private static EmptyApplication singleton;
    
    private EmptyApplication() {
	super();
    }
    
    public static EmptyApplication getSingleton() {
	if (EmptyApplication.singleton == null) {
	    EmptyApplication.singleton = new EmptyApplication();
	}
	return EmptyApplication.singleton; 
    }

    @Override
    public void start() {
    }

    @Override
    public StringBuilder getScreen() {
	return new StringBuilder("");
    }

    @Override
    public boolean isFinish() {
	return true;
    }

    @Override
    public void newInput(String input) {
    }

    @Override
    public boolean hasLastScreen() {
	return false;
    }

    @Override
    public void stop() {
    }

}
