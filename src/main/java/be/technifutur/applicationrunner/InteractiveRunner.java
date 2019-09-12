package be.technifutur.applicationrunner;

import be.technifutur.applicationrunner.exception.NullEnvironnementException;
import be.technifutur.applicationrunner.inter.Environnement;
import be.technifutur.applicationrunner.inter.InteractiveApplication;

public class InteractiveRunner implements Runnable {

    private InteractiveApplication application;
    private Environnement env = new ConsoleEnvironnement();
    
    private void showScreen() {
	this.env.print(this.application.getScreen().toString());
    }

    @Override
    public void run() {
	if (this.application != null) {
	    this.application.start();
	    while (!this.application.isFinish()) {
		this.showScreen();
		this.application.newInput(this.env.nextLine());
	    }
	    if (this.application.hasLastScreen()) {
		this.showScreen();
	    }
	    this.application.stop();
	}
    }

    public InteractiveApplication getApplication() {
	return this.application;
    }

    public void setApplication(InteractiveApplication application) {
	this.application = application;
    }

    public Environnement getEnv() {
	return this.env;
    }

    public void setEnv(Environnement env) {
	if (env != null) {
	    this.env = env;
	} else {
	    throw new NullEnvironnementException();
	}
    }

}
