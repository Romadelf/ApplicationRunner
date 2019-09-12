package be.technifutur.applicationrunner.mvc;

public interface Controler<T> {

    void start();
    boolean isfinish();
    void newInput(String input);
    boolean hasLastScreen();
    void stop();
    void setModel(T model);
    
}
