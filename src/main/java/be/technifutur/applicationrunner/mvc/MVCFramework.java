package be.technifutur.applicationrunner.mvc;

import be.technifutur.applicationrunner.InteractiveRunner;

public class MVCFramework<Model_> {
    
    public void start(MVCFactory<Model_> appMVCFactory) {
	MVCApplication<Model_> mvcApp = new MVCApplication<Model_>();
	mvcApp.setModel(appMVCFactory.getModel());
	mvcApp.setCtrl(appMVCFactory.getControler());
	mvcApp.setVue(appMVCFactory.getVue());
	InteractiveRunner runner = new InteractiveRunner();
	runner.setApplication(mvcApp);
	runner.run();
    }

}
