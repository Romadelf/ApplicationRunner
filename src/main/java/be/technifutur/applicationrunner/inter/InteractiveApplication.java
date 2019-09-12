package be.technifutur.applicationrunner.inter;

public interface InteractiveApplication {

    void start();
    StringBuilder getScreen();
    boolean isFinish();
    void newInput(String input);
    boolean hasLastScreen();
    void stop();

}
