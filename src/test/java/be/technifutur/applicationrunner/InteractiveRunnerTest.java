package be.technifutur.applicationrunner;

import static org.junit.jupiter.api.Assertions.*;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // Version 5 de JUnit

import be.technifutur.applicationrunner.inter.Environnement;
import be.technifutur.applicationrunner.inter.InteractiveApplication;

public class InteractiveRunnerTest {

    private InteractiveRunner runner;
    private InteractiveApplication applicationMock;
    private Environnement environnementMock;
    
    @BeforeEach
    public void init() {
	this.runner = new InteractiveRunner();
	this.applicationMock = EasyMock.strictMock(InteractiveApplication.class);
	this.runner.setApplication(this.applicationMock);
	this.environnementMock = EasyMock.strictMock(Environnement.class);
	runner.setEnv(this.environnementMock);
    }

    @Test
    public void testSetApplicationNotNull() {
	assertAll( // @formatter:off
		() -> assertNotNull(runner.getApplication()),
		() -> assertSame(this.applicationMock, runner.getApplication()) // Compare l'adresse des objets, contrairement à assertEquals
	); // @formatter:on
    }

    @Test
    public void testRunCallsStart() {
	this.applicationMock.start();
	EasyMock.expect(this.applicationMock.isFinish()).andReturn(true);
	EasyMock.expect(this.applicationMock.hasLastScreen()).andReturn(false);
	this.applicationMock.stop();
	EasyMock.replay(this.applicationMock); // Soit prêt!
	this.runner.run();
	EasyMock.verify(this.applicationMock); // Vérifie que le scénario à bien eu lieu
    }

    @Test
    public void testfullCycle() {
	this.applicationMock.start();
	EasyMock.expect(this.applicationMock.isFinish()).andReturn(false);
	EasyMock.expect(this.applicationMock.getScreen()).andReturn(new StringBuilder("Votre nom:"));
	this.environnementMock.print("Votre nom:");
	EasyMock.expect(this.environnementMock.nextLine()).andReturn("toto");
	this.applicationMock.newInput("toto");
	EasyMock.expect(this.applicationMock.isFinish()).andReturn(true);
	EasyMock.expect(this.applicationMock.hasLastScreen()).andReturn(true);
	EasyMock.expect(this.applicationMock.getScreen()).andReturn(new StringBuilder("Au revoir toto"));
	this.environnementMock.print("Au revoir toto");
	this.applicationMock.stop();
	EasyMock.replay(this.environnementMock, this.applicationMock);
	this.runner.run();
	EasyMock.verify(this.environnementMock, this.applicationMock);
    }

}
