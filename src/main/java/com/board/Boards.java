package com.board;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Boards {
    Config config;
    BufferedImage image;

    public Boards() {
        config = new Config();
    }

    public ArrayList<String> parse(String dir){
        File path = new File(dir);
        if (path.listFiles() == null || path.listFiles().length == 0) {
            return new ArrayList<>();
        }
        ArrayList<String> boards = new ArrayList<>();
        for (File file : path.listFiles()) {
            String board = file.getName() + " - " + parseBoard(file);
            boards.add(board);
        }
        return boards;
    }

    private StringBuilder parseBoard(File file) {
        StringBuilder board = new StringBuilder();
        try {
            image = ImageIO.read(file);
            for (int indexCard = 0; indexCard < 5; indexCard++) {
                int valueCardScalar = getValueCard(indexCard);
                if (valueCardScalar > 1073741822 || valueCardScalar < 0) {
                    break;
                }
                board.append(config.getValueCardFromInteger(valueCardScalar));
                int suitCardScalar = getSuitCard(indexCard);
                board.append(config.getSuitCardFromInteger(suitCardScalar));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return board;
    }

    private int getValueCard(int indexCard) {
        int valueCardScalar = 0;
         for (int offsetX = 0; offsetX < 6; offsetX++) {
             for (int offsetY = 0; offsetY < 5; offsetY++) {
                 valueCardScalar = valueCardScalar * 2 + getPxValue(config.getCardCoord(indexCard).getX() + offsetX * 5, config.getCardCoord(indexCard).getY() + offsetY * 5);
             }
         }
        return valueCardScalar;
    }

    private int getSuitCard(int indexCard) {
        int suitCardScalar = 0;
        for (int offsetX = 6; offsetX < 11; offsetX++) {
            for (int offsetY = 7; offsetY < 12; offsetY++) {
                suitCardScalar = suitCardScalar * 2 + getPxValue(config.getCardCoord(indexCard).getX() + offsetX * 5, config.getCardCoord(indexCard).getY() + offsetY * 5);
            }
        }
        return suitCardScalar;
    }

    private int getPxValue(int x, int y) {
        int weight = 0;
        for (int offsetX = 0; offsetX < 5; offsetX++) {
            for (int offsetY = 0; offsetY < 5; offsetY++) {
                weight += isBlankPx(x + offsetX, y + offsetY);
            }
        }
        return (weight > 8) ? 1 : 0;

    }

    private int isBlankPx(int x, int y) {
        int red   = (image.getRGB(x, y) & 0x00ff0000) >> 16;
        int green = (image.getRGB(x, y) & 0x0000ff00) >> 8;
        int blue  =  image.getRGB(x, y) & 0x000000ff;
        if ((red == 120 && green == 120 && blue == 120) ||
        (red == 255 && green == 255 && blue == 255)){
            return 0;
        }
        return 1;
    }
}
