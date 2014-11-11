package lernkarte;

import persistenz.IPersistenzServices;

import java.util.Collection;

/**
 * Created by patrick_steinhauer on 10.11.2014.
 */
public class Modul implements IPersistenzServices{
    private String name;
    private Collection<Lernkarte> lernkarten;
}
