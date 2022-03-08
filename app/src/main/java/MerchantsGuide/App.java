package MerchantsGuide;

import java.util.Scanner;

/*
 * This class contains the main method that gets executed.
 * The path of a file to be processed can be passed as an argument.
 * If no file path is specified, the input is made line by line by the user.
 */

public class App {

    public static void main(String[] args) {
        String file;
        try{
            InOutHandler inOut = new InOutHandler();
            if (args.length != 0){
                file = args[0];
                inOut.handleFile(file);
            }
            else {
                String line;
                Scanner scan = new Scanner(System.in);
                while (!(line = scan.nextLine()).equals("")) {
                    inOut.handleLine(line);
                }
                scan.close();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
