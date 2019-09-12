package be.technifutur.applicationrunner.mvc;

import be.technifutur.applicationrunner.inter.InteractiveApplication;

public class MVCApplication<T> implements InteractiveApplication {

    private Controler<T> ctrl;
    private View<T> vue;
    private T model;
    // donner des instances par défaut ou lancer une exception dans le start si un d'eux est null

    public void setCtrl(Controler<T> ctrl) {
        this.ctrl = ctrl;
    }

    public void setVue(View<T> vue) {
        this.vue = vue;
    }

    public void setModel(T model) {
        this.model = model;
    }

    @Override
    public void start() {
	this.ctrl.setModel(this.model);
	this.ctrl.start();
	this.vue.setModel(this.model);
	this.vue.start();
    }

    @Override
    public StringBuilder getScreen() {
	return this.vue.getScreen();
    }

    @Override
    public boolean isFinish() {
	return this.ctrl.isfinish();
    }

    @Override
    public void newInput(String input) {
	this.ctrl.newInput(input);
    }

    @Override
    public boolean hasLastScreen() {
	return this.ctrl.hasLastScreen();
    }

    @Override
    public void stop() {
	this.ctrl.stop();
	this.vue.stop();
    }

}
