package be.technifutur.applicationrunner;

import java.util.Scanner;

import be.technifutur.applicationrunner.inter.Environnement;

public class ConsoleEnvironnement implements Environnement {

    private Scanner scanner = new Scanner(System.in);
    
    @Override
    public void print(CharSequence out) {
	System.out.print(out);
    }

    @Override
    public String nextLine() {
	return this.scanner.nextLine();
    }

}
