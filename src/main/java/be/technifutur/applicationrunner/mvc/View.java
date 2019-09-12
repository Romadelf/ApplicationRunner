package be.technifutur.applicationrunner.mvc;

public interface View<T> {

    void start();
    StringBuilder getScreen();
    void stop();
    void setModel(T model);

}
