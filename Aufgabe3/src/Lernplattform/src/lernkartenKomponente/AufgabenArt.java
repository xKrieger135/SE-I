package lernkartenKomponente;

import persistenz.IPersistenzServices;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class AufgabenArt implements IPersistenzServices{

    private Lueckentext lueckentext;
    private MultipleChoice multipleChoice;
    private SingleChoice singleChoice;

    public Lueckentext getLueckentext() {
        return lueckentext;
    }

    public void setLueckentext(Lueckentext lueckentext) {
        this.lueckentext = lueckentext;
    }

    public MultipleChoice getMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(MultipleChoice multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public SingleChoice getSingleChoice() {
        return singleChoice;
    }

    public void setSingleChoice(SingleChoice singleChoice) {
        this.singleChoice = singleChoice;
    }
}
