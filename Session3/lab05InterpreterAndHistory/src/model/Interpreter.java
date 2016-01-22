package model;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by pghoo on 18/01/2016.
 */
public class Interpreter {

    private InputStream in;
    private PrintStream out;
    private String name;
    private History history;

    public Interpreter(PrintStream out, InputStream in, String name, History history) {
        this.out = out;
        this.in = in;
        this.name = name;
        this.history = history;
    }

    public void run() {
        // loop until “:quit” is read from input stream and store all lines into history
        // store in history name (String) and inputText (String)
        // “:print” outputs whole history
        Scanner sc = new Scanner(in);
        String input;
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            if(input.equals(":quit")) break;
            if(input.equals(":print")) out.println(history);
        }

    }
}
