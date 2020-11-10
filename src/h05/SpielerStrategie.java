package h05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Erweitert das Interface GefangenenStrategie und implementiert die Moeglichkeit selbst zu spielen.
 */
public class SpielerStrategie implements GefangenenStrategie{


    @Override
    public boolean getNextDecision() {
        int auswahl;
        System.out.println("\n" + "nächste Runde:");
        System.out.println("    0 = kooperieren ; 1 = betruegen");
        System.out.print("Du bist dran: ");
        try {
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()){
                auswahl = sc.nextInt();
                if(auswahl == 0)
                    return false;
                if(auswahl == 1)
                    return true;
                throw new InputMismatchException("");
            }
        } catch (InputMismatchException e){
            System.out.println("Eingabefehler, nochmal probieren ..." + "\n");
            getNextDecision();
        }
        return false;
    }

    @Override
    public void setOpponentsLastDecision(boolean decision) {
        System.out.println();
        if(!decision)
            System.out.println("Dein Gegner hat koopertiert.");
        if(decision)
            System.out.println("Dein Gegner hat dich betrogen!");
    }
}