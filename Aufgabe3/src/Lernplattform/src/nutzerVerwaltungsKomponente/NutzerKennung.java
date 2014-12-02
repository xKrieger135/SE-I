package nutzerVerwaltungsKomponente;

import java.util.regex.Pattern;

public class NutzerKennung {
    private String kennung;

    public String getKennung() {
        return kennung;
    }

    public NutzerKennung(String kennung) {
        if (isValidKennung(kennung)) {
            this.kennung = kennung;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean isValidKennung(String TestKennung) {
        Pattern ptr;
        ptr = Pattern.compile("/([a-z]{3}\\d{3})/");
        return ptr.matcher(TestKennung).matches();
    }

    public boolean equals(Object o) {
        return kennung.equals(o);
    }
}
