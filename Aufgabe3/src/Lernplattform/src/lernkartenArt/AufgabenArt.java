package lernkartenArt;

import persistenz.IPersistenzServices;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class AufgabenArt implements IPersistenzServices{
    private Foto foto;
    private FreiText freiText;
    private Grafik grafik;
    private Lueckentext lueckentext;
    private MultipleChoice multipleChoice;
    private SingleChoice singleChoice;
    private Videos videos;

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public FreiText getFreiText() {
        return freiText;
    }

    public void setFreiText(FreiText freiText) {
        this.freiText = freiText;
    }

    public Grafik getGrafik() {
        return grafik;
    }

    public void setGrafik(Grafik grafik) {
        this.grafik = grafik;
    }

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

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }
}
