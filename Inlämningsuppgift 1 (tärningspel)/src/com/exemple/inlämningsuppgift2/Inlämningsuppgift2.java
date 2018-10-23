package com.exemple.inlämningsuppgift2;

import java.util.Scanner;

public class Inlämningsuppgift2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int antalKast = 0;
        int spelare;
        boolean spelaVidare = true;
        boolean nyttAntalKast = true;
        boolean acceptabelSpelare = true;
        int[] kastArray;
        int[] spelarArray;
        int position = 0;
        int position2 =0;
        int ledandePosition = 0;
        int ledandeVarde = 0;
        int andraVarde = 0;
        int andraPosition = 0;
        int highscore = 0;
        int highscore2 = 0;


        while (spelaVidare) {
            if (nyttAntalKast) {
                System.out.println("Hur många kast vill ni göra? ");
                antalKast = scan.nextInt();
                highscore = 0;
            }

            System.out.println("Hur många spelare vill ni vara ?");

            spelare = scan.nextInt();
            if (spelare <= 1)
                while (acceptabelSpelare) {
                    System.out.println("Det måste vara mist två spelare, vänligen väl igen: ");
                    spelare = scan.nextInt();
                    if (spelare > 1) {
                        acceptabelSpelare = false;
                    }
                }
            spelarArray = new int[spelare + 1];
            kastArray = new int[spelare + 1];

            // Själva spelet
            for (int i = 1; i <= antalKast; i++) {
                for (int t = 1; t <= spelare; t++) {
                    kastArray[t] = (int) (1 + 6 * Math.random());
                    System.out.println("Spelare " + t + " : Kast: " + i + " är " + kastArray[t]);
                    spelarArray[t] += kastArray[t];
                }
            }

            System.out.println(); // Mellanrum
            for (int player : spelarArray) {
                if (position != 0) {
                    System.out.println("Spelare " + position + " Summa: " + player);
                }
                // Tar ut vem som vann
                if (ledandeVarde < player) {
                    ledandePosition = position;
                    ledandeVarde = player;
                }
                position++;
            }

            // Räknar ut andraplats
            for (int player : spelarArray) {
                if (position2 != 0 && andraVarde < player && player !=ledandeVarde) {
                        andraPosition = position2;
                        andraVarde = player;
                }
                position2 ++;
            }


            System.out.println("\nSpelare " + ledandePosition + " Vann!!");
            System.out.println("Spelare " + andraPosition + " Kom två! \n" );

            if (highscore < ledandeVarde) {
                highscore = ledandeVarde;
            }
            if (highscore2 < andraVarde ) {
                highscore2 = andraVarde;
            }


            System.out.println( "Highscore 1 " + highscore);
            System.out.println("Highscore 2: " + highscore2 +"\n");

            bubbleSort(spelarArray);

                for (int i = 1; i < spelarArray.length; i++) {
                    System.out.print(i + "a Plats "  +  " "+ spelarArray[i] + "\n");

                }

            System.out.println(" \nVill du spela igen? (j/n)");
            Scanner scan2 = new Scanner(System.in);
            String svar = scan2.nextLine();
            if (svar.equals("n")) {
                spelaVidare = false;
            } else {
                System.out.println("Vill du ändra kast ? (j/n)");

                String svar2 = scan2.nextLine();
                if (svar2.equals("n")) {
                    nyttAntalKast = false;

                }
            }
        }
    }
    static void bubbleSort(int[] spelarArray) {


        int n = spelarArray.length;
        int temp = 0;
        for (int i =0  ; i < n; i++) {
            for (int j = 2; j < (n - i); j++) {
                if (spelarArray[j - 1] < spelarArray[j]) {
                    //byter elementen
                    temp = spelarArray[j - 1];
                    spelarArray[j - 1] = spelarArray[j];
                    spelarArray[j] = temp;
                }

            }
        }
    }
}





