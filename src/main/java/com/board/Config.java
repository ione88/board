package com.board;

import java.util.ArrayList;

public class Config {
    private ArrayList<Coords> cardCoord;
    // TODO: take config from file JSON
    public Config() {
        cardCoord = new ArrayList<>();
        cardCoord.add(new Coords(146, 592));
        cardCoord.add(new Coords(218, 592));
        cardCoord.add(new Coords(290, 592));
        cardCoord.add(new Coords(362, 592));
        cardCoord.add(new Coords(434, 592));
    }

    public Coords getCardCoord(int indexCard) {
        return cardCoord.get(indexCard);
    }

    public String getValueCardFromInteger(int valueCardScalar) {
        switch (valueCardScalar) {
            case 20708352: return "2";
            case 19922432:
            case 19920896:
            case 19921920: return "3";
            case 6782144: return "4";
            case 28310656:
            case 32495616:
            case 33544192:
            case 32496640: return "5";
            case 32505024:
            case 32504960:
            case 15727808: return "6";
            case 17527296:
            case 20668928:
            case 20668416:
            case 18575872: return "7";
            case 32242688:
            case 32504896:
            case 33290240:
            case 32242752: return "8";
            case 32243072:
            case 33290624:
            case 32242048: return "9";
            case 570378878:
            case 569855614:
            case 570388094:
            case 569330302:
            case 569331326:
            case 570379902: return "T";
            case 3274752:
            case 4192256:
            case 2226176: return "J";
            case 15327215:
            case 15589359:
            case 32104431:
            case 32104430: return "Q";
            case 32930400: return "K";
            case 116340832:
            case 49248480:
            case 49231968:
            case 7305440: return "A";
            default: return "ERROR: unknown Card Value (DEBUG INFO: " + valueCardScalar + ")";
        }
    }

    public String getSuitCardFromInteger(int suitCardScalar) {
        switch (suitCardScalar) {
            case 7838816:
            case 7838817: return "d";
            case 7838753:
            case 7838752: return "c";
            case 7445729:
            case 7445731: return "h";
            case 3382369:
            case 7576672:
            case 7576673: return "s";

            default: return "ERROR: unknown Card suit (DEBUG INFO: " + suitCardScalar + ")";
        }
    }
}
