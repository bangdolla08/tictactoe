package org.tic.tac.toe;

import java.util.Scanner;

public class IoService {

    public static Integer getInputInteger(String message) {
        Integer integer = null;
        Boolean retryMethode = false;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(message);
                integer = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please Input Number value");
                retryMethode = isWantToRetry();
            }
        } while (retryMethode);
        if (integer == null) {
            messageAndExitApps("Thank you for using this application");
        }
        return integer;
    }

    public static Integer getInputInteger(String message, Integer maxximum) {
        Boolean retryMethode = false;
        Integer integer=null;
        do {
             integer = getInputInteger(message);
            retryMethode = integer < 1 || integer > maxximum;
            if (retryMethode) {
                System.out.println("Please Input Number value in range 1 to " + maxximum);
            }
        } while (retryMethode);
        return integer;
    }

    public static String getInputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void messageAndExitApps(String message) {
        System.out.println(message);
        System.exit(0);
    }

    public static Boolean isWantToRetry() {
        Boolean isYesOrNo = false;
        char c;
        do {
            System.out.print("Are you want to retry (y/n)?  ");
            Scanner scanner = new Scanner(System.in);
            c = scanner.next().toCharArray()[0];
            isYesOrNo = (c == 'y' || c == 'n');
            if (!isYesOrNo) {
                System.out.println("in this part we only accept y/n");
            }
        } while (!isYesOrNo);
        return c == 'y';
    }

}
