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
        for (int i = 0; i < animals.size(); i++)
            song = refrain(song, i, animals.size() - 1);

        return song;
    }

    private String refrain(String song, int index, int lastIndex) {
        String separator = seperator(index, lastIndex);

        song += THERE_WAS_AN_OLD_LADY_WHO_SWALLOWED_A + animals.get(index) + separator + "\n" +
                animals.get(index).rhyme();

        for (int i = index; i > 0; i--) {
            if(i == lastIndex)
                break;
            String sep = ",";
            if (i == 1) {
                sep = ";";
            }

            song += SHE_SWALLOWED_THE + animals.get(i) + TO_CATCH_THE + animals.get(i - 1) + sep + "\n";
        }
        if (index == lastIndex)
            song += "...She's dead, of course!";
        else {
            song += I_DON_T_KNOW_WHY_SHE_SWALLOWED_A + animals.get(0) + PERHAPS_SHE_LL_DIE + "\n";
            song += "\n";
        }
        return song;
    }

    private static String seperator(int index, int lastIndex) {
        String separator = ";";
        if (index == lastIndex) {
            separator = "...";
        }
        else if (index == 0) {
            separator = ".";
        }
        return separator;
    }

}