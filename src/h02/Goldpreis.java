package h02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Goldpreis {

    private ArrayList<Goldtagespreis> list;

    public Goldpreis(String dateiname) {
        this.storeAllPrices(dateiname);
    }

    private void storeAllPrices(String dateiname) {
        Scanner sc;
        File gold;
        list = new ArrayList<>();
        try {
            gold = new File(dateiname);
            sc = new Scanner(gold);
            while (sc.hasNextLine()) {
                String res = sc.nextLine();
                String[] temp = res.split("\t");
                double preis;
                try {
                    preis = Double.parseDouble(temp[1]);
                } catch (NumberFormatException e) {
                    preis = -1;
                }
                Goldtagespreis goldtagespreis = new Goldtagespreis(temp[0], preis);
                 list.add(goldtagespreis);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getPreis(String datum) {
        return 0;
    }

    public String toString(){
        return list.toString();
    }

    public static void main(String[] args) {
        Goldpreis test = new Goldpreis("/Users/niklasdiekhoner/IdeaProjects/Java_Hausaufgaben/src/h02/gold.txt");
        System.out.println(test.toString());
    }
}
