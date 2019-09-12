package be.technifutur.applicationrunner.mvc;

public interface MVCFactory<Model_> {
    
    Model_ getModel();
    Controler<Model_> getControler();
    View<Model_> getVue();

}
