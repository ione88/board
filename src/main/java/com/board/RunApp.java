package com.board;

import java.util.ArrayList;

public class RunApp {

    public static void main(String[] args) {
        if (Helper.isEmpty(args)) {
            System.out.print("ERROR: Run program without required param: directory");
            return;
        }

        ArrayList<String> boards = new Boards().parse(args[0]);
        if (Helper.isEmpty(boards)) {
            System.out.print("WARN: Wrong or Empty directory");
            return;
        }

        for (String board : boards) {
            System.out.println(board);
        }
        // System.out.println("INFO: Successfully processed " + boards.size() + " files ");
    }
}
