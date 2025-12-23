package com.t11g02.Sidescroller.controller.game;

import com.t11g02.Sidescroller.model.Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScoreKeeper { // Singleton class to keep the High Score
    private static ScoreKeeper instance;

    public static ScoreKeeper getInstance() {
        if (instance == null)
            instance = new ScoreKeeper();
        return instance;
    }

    public void reset() {
        int currentHighScore = read();
        if (Score.getInstance().getScore() > currentHighScore) {
            write();
        }
        Score.getInstance().reset();
    }

    public void write(){
        try {
            FileWriter myWriter = new FileWriter("HighScore.txt");
            myWriter.write(Score.getInstance().getScore() + ""); // write score as string
            myWriter.close();  // must close manually
        } catch (IOException e) {
            System.out.println("File write error");
            e.printStackTrace();
        }
    }

    public int read(){
        File myObj = new File("HighScore.txt");

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
            return myReader.nextInt();
        } catch (FileNotFoundException e) {
            return 0;
        }
    }



}
