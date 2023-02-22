package toto;

import java.util.Arrays;
import java.util.List;

public final class Animals {

    public static final String THERE_WAS_AN_OLD_LADY_WHO_SWALLOWED_A = "There was an old lady who swallowed a ";
    public static final String SHE_SWALLOWED_THE = "She swallowed the ";
    public static final String I_DON_T_KNOW_WHY_SHE_SWALLOWED_A = "I don't know why she swallowed a ";
    public static final String TO_CATCH_THE = " to catch the ";
    public static final String PERHAPS_SHE_LL_DIE = " - perhaps she'll die!";
    private final List<Animal> animals;

    public Animals(Animal... animals) {
        this.animals = Arrays.asList(animals);
    }

    public String sing() {
        String song = "";
                song = getString(song, 0, animals.size() - 1);
                song = getString(song, 1, animals.size() - 1);
                song = getString(song, 2, animals.size() - 1);
                song = getString(song, 3, animals.size() - 1);
                song = getString(song, 4, animals.size() - 1);
                song = getString(song, 5, animals.size() - 1);

                song += THERE_WAS_AN_OLD_LADY_WHO_SWALLOWED_A + animals.get(6) + "...\n";
                song += animals.get(6).rhyme();
                for (int i = 6; i > 0; i--) {
                    if(i == 6)
                        break;
                    song += SHE_SWALLOWED_THE + animals.get(i) + TO_CATCH_THE + animals.get(i - 1) + (i == 1 ? ';' : ',') + "\n";
                }
                song += "...She's dead, of course!";

        return song;
    }

    private String getString(String song, int index, int lastIndex) {
        song += THERE_WAS_AN_OLD_LADY_WHO_SWALLOWED_A + animals.get(index) + (index == 0 ? '.' : ';') + "\n" +
        animals.get(index).rhyme();

        for (int i = index; i > 0; i--) {
            if(i == lastIndex)
                break;
            song += SHE_SWALLOWED_THE + animals.get(i) + TO_CATCH_THE + animals.get(i - 1) + (i == 1 ? ';' : ',') + "\n";
        }
        song += I_DON_T_KNOW_WHY_SHE_SWALLOWED_A + animals.get(0) + PERHAPS_SHE_LL_DIE + "\n";
        song += "\n";
        return song;
    }

}