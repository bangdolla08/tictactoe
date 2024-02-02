package org.tic.tac.toe;

import java.io.IOException;
import java.util.Scanner;

public class IoService {


    public IoService() {
    }

    public Integer getInputInteger(String message) {
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
            System.out.println("Thank you for using this application");
            System.exit(0);
        }
        return integer;
    }

    public Boolean isWantToRetry() {
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
