import java.util.ArrayList;
import java.util.Arrays;

public class OmerCounter {
    /* fun generateLists() {
        val arrayList = ArrayList<String>(49)
        for (i in 1..49) {
            arrayList.add(getSefirahOfOmerDayAlgorithmic(i, SEFIRAH_SPELLING_HEBREW))
        }
        arrayList.joinToString(
            ",\n",
            "private static final String[] hebrewSefirosByDay = new String[] {\n",
            "\n};"
        ) {
            "\"${it}\""
        }.println()
        arrayList.clear()
        for (i in 1..49) {
            arrayList.add(getSefirahOfOmerDayAlgorithmic(i, SEFIRAH_SPELLING_ENGLISH_SEFARADI))
        }
        arrayList.joinToString(
            ",\n",
            "private static final String[] englishSefirosByDayTransliteratedSefaradi = new String[] {\n",
            "\n};"
        ) {
            "\"${it}\""
        }.println()
        arrayList.clear()
        for (i in 1..49) {
            arrayList.add(getSefirahOfOmerDayAlgorithmic(i, SEFIRAH_SPELLING_ENGLISH_ASHKENAZI))
        }
        arrayList.joinToString(
            ",\n",
            "private static final String[] englishSefirosByDayTransliteratedAshkenazi = new String[] {\n",
            "\n};"
        ) {
            "\"${it}\""
        }.println()
        arrayList.clear()
        for (i in 1..49) {
            arrayList.add(getSefirahOfOmerDayAlgorithmic(i, SEFIRAH_SPELLING_ENGLISH_TEIMANI))
        }

        arrayList.joinToString(
            ",\n",
            "private static final String[] englishSefirosByDayTransliteratedTeimani = new String[] {\n",
            "\n};"
        ) {
            "\"${it}\""
        }.println()
    }*/

    public static void main(String[] args) {
        testGetSefirahByDayHebrew();
    }

    public static int SEFIRAH_SPELLING_HEBREW = 0;
    public static int SEFIRAH_SPELLING_ENGLISH_ASHKENAZI = 1;
    public static int SEFIRAH_SPELLING_ENGLISH_SEFARADI = 2;
    public static int SEFIRAH_SPELLING_ENGLISH_TEIMANI = 3;

    private static final String[] hebrewSefiros = new String[]{
            "חֶסֶד",
            "גְּבוּרָה",
            "תִּפְאֶרֶת",
            "נֶצַח",
            "הוֹד",
            "יְסוֹד",
            "מַלְכוּת",
    };

    private static final String[] englishSefirosTransliteratedAshkenazi = new String[]{
            "Chesed",
            "Givurah",
            "Tiferes",
            "Netzach",
            "Hod",
            "Yesod",
            "Malchus",
    };
    private static final String[] englishSefirosTransliteratedSefaradi = new String[]{
            "Chesed",
            "Givurah",
            "Tiferet",
            "Netzach",
            "Hod",
            "Yesod",
            "Malchut",
    };

    /**
     * Teimanim make a distinction between when a gimmel has a dagesh and when it does not.
     * "J" when it has a dagesh (such as when it starts a sentence), and "Gh" when it does not have a dagesh.
     * See https://en.wikipedia.org/wiki/Yemenite_Hebrew#Distinguishing_features
     * <p>
     * Though, I couldn't find a teimani siddur, but Eidut Hamizrach have a completely different nusach,
     * and don't use the format of "__ shebi __". There are those who use the nusach of ashkenaz with the pronunciation
     * of Teimanim, so maybe that should be an option?
     * <p>
     * Also, I have added ' to mark the presence of a guttural and the need for a separation of syllables.
     * I think other sects may just find it strange.
     */
    private static final String[] englishSefirosTransliteratedTeimani = new String[]{
            "Ḥesed",
            "Jevurah",
            "Tif'ereth",
            "Nessaḥ",
            "Hod",
            "Yesod",
            "Malchuth",
    };
    private static final String[] hebrewSefirosByDay = new String[] {
            "חֶסֶד שֶׁבְּחֶסֶד",
            "גְּבוּרָה שֶׁבְּחֶסֶד",
            "תִּפְאֶרֶת שֶׁבְּחֶסֶד",
            "נֶצַח שֶׁבְּחֶסֶד",
            "הוֹד שֶׁבְּחֶסֶד",
            "יְסוֹד שֶׁבְּחֶסֶד",
            "מַלְכוּת שֶׁבְּחֶסֶד",
            "חֶסֶד שֶׁבִּגְבוּרָה",
            "גְּבוּרָה שֶׁבִּגְבוּרָה",
            "תִּפְאֶרֶת שֶׁבִּגְבוּרָה",
            "נֶצַח שֶׁבִּגְבוּרָה",
            "הוֹד שֶׁבִּגְבוּרָה",
            "יְסוֹד שֶׁבִּגְבוּרָה",
            "מַלְכוּת שֶׁבִּגְבוּרָה",
            "חֶסֶד שֶׁבְּתִפְאֶרֶת",
            "גְּבוּרָה שֶׁבְּתִפְאֶרֶת",
            "תִּפְאֶרֶת שֶׁבְּתִפְאֶרֶת",
            "נֶצַח שֶׁבְּתִפְאֶרֶת",
            "הוֹד שֶׁבְּתִפְאֶרֶת",
            "יְסוֹד שֶׁבְּתִפְאֶרֶת",
            "מַלְכוּת שֶׁבְּתִפְאֶרֶת",
            "חֶסֶד שֶׁבְּנֶצַח",
            "גְּבוּרָה שֶׁבְּנֶצַח",
            "תִּפְאֶרֶת שֶׁבְּנֶצַח",
            "נֶצַח שֶׁבְּנֶצַח",
            "הוֹד שֶׁבְּנֶצַח",
            "יְסוֹד שֶׁבְּנֶצַח",
            "מַלְכוּת שֶׁבְּנֶצַח",
            "חֶסֶד שֶׁבְּהוֹד",
            "גְּבוּרָה שֶׁבְּהוֹד",
            "תִּפְאֶרֶת שֶׁבְּהוֹד",
            "נֶצַח שֶׁבְּהוֹד",
            "הוֹד שֶׁבְּהוֹד",
            "יְסוֹד שֶׁבְּהוֹד",
            "מַלְכוּת שֶׁבְּהוֹד",
            "חֶסֶד שֶׁבְּיְסוֹד",
            "גְּבוּרָה שֶׁבְּיְסוֹד",
            "תִּפְאֶרֶת שֶׁבְּיְסוֹד",
            "נֶצַח שֶׁבְּיְסוֹד",
            "הוֹד שֶׁבְּיְסוֹד",
            "יְסוֹד שֶׁבְּיְסוֹד",
            "מַלְכוּת שֶׁבְּיְסוֹד",
            "חֶסֶד שֶׁבְּמַלְכוּת",
            "גְּבוּרָה שֶׁבְּמַלְכוּת",
            "תִּפְאֶרֶת שֶׁבְּמַלְכוּת",
            "נֶצַח שֶׁבְּמַלְכוּת",
            "הוֹד שֶׁבְּמַלְכוּת",
            "יְסוֹד שֶׁבְּמַלְכוּת",
            "מַלְכוּת שֶׁבְּמַלְכוּת"
    };
    private static final String[] englishSefirosByDayTransliteratedSefaradi = new String[] {
            "Chesed SheBiChesed",
            "Givurah SheBiChesed",
            "Tiferet SheBiChesed",
            "Netzach SheBiChesed",
            "Hod SheBiChesed",
            "Yesod SheBiChesed",
            "Malchut SheBiChesed",
            "Chesed SheBeeGvurah",
            "Givurah SheBeeGvurah",
            "Tiferet SheBeeGvurah",
            "Netzach SheBeeGvurah",
            "Hod SheBeeGvurah",
            "Yesod SheBeeGvurah",
            "Malchut SheBeeGvurah",
            "Chesed SheBiTiferet",
            "Givurah SheBiTiferet",
            "Tiferet SheBiTiferet",
            "Netzach SheBiTiferet",
            "Hod SheBiTiferet",
            "Yesod SheBiTiferet",
            "Malchut SheBiTiferet",
            "Chesed SheBiNetzach",
            "Givurah SheBiNetzach",
            "Tiferet SheBiNetzach",
            "Netzach SheBiNetzach",
            "Hod SheBiNetzach",
            "Yesod SheBiNetzach",
            "Malchut SheBiNetzach",
            "Chesed SheBiHod",
            "Givurah SheBiHod",
            "Tiferet SheBiHod",
            "Netzach SheBiHod",
            "Hod SheBiHod",
            "Yesod SheBiHod",
            "Malchut SheBiHod",
            "Chesed SheBiYesod",
            "Givurah SheBiYesod",
            "Tiferet SheBiYesod",
            "Netzach SheBiYesod",
            "Hod SheBiYesod",
            "Yesod SheBiYesod",
            "Malchut SheBiYesod",
            "Chesed SheBiMalchut",
            "Givurah SheBiMalchut",
            "Tiferet SheBiMalchut",
            "Netzach SheBiMalchut",
            "Hod SheBiMalchut",
            "Yesod SheBiMalchut",
            "Malchut SheBiMalchut"
    };
    private static final String[] englishSefirosByDayTransliteratedAshkenazi = new String[] {
            "Chesed SheBiChesed",
            "Givurah SheBiChesed",
            "Tiferes SheBiChesed",
            "Netzach SheBiChesed",
            "Hod SheBiChesed",
            "Yesod SheBiChesed",
            "Malchus SheBiChesed",
            "Chesed SheBeeGvurah",
            "Givurah SheBeeGvurah",
            "Tiferes SheBeeGvurah",
            "Netzach SheBeeGvurah",
            "Hod SheBeeGvurah",
            "Yesod SheBeeGvurah",
            "Malchus SheBeeGvurah",
            "Chesed SheBiSiferes",
            "Givurah SheBiSiferes",
            "Tiferes SheBiSiferes",
            "Netzach SheBiSiferes",
            "Hod SheBiSiferes",
            "Yesod SheBiSiferes",
            "Malchus SheBiSiferes",
            "Chesed SheBiNetzach",
            "Givurah SheBiNetzach",
            "Tiferes SheBiNetzach",
            "Netzach SheBiNetzach",
            "Hod SheBiNetzach",
            "Yesod SheBiNetzach",
            "Malchus SheBiNetzach",
            "Chesed SheBiHod",
            "Givurah SheBiHod",
            "Tiferes SheBiHod",
            "Netzach SheBiHod",
            "Hod SheBiHod",
            "Yesod SheBiHod",
            "Malchus SheBiHod",
            "Chesed SheBiYesod",
            "Givurah SheBiYesod",
            "Tiferes SheBiYesod",
            "Netzach SheBiYesod",
            "Hod SheBiYesod",
            "Yesod SheBiYesod",
            "Malchus SheBiYesod",
            "Chesed SheBiMalchus",
            "Givurah SheBiMalchus",
            "Tiferes SheBiMalchus",
            "Netzach SheBiMalchus",
            "Hod SheBiMalchus",
            "Yesod SheBiMalchus",
            "Malchus SheBiMalchus"
    };
    private static final String[] englishSefirosByDayTransliteratedTeimani = new String[] {
            "Ḥesed SheBaḤesed",
            "Jevurah SheBaḤesed",
            "Tif'ereth SheBaḤesed",
            "Nessaḥ SheBaḤesed",
            "Hod SheBaḤesed",
            "Yesod SheBaḤesed",
            "Malchuth SheBaḤesed",
            "Ḥesed SheBeeGhvurah",
            "Jevurah SheBeeGhvurah",
            "Tif'ereth SheBeeGhvurah",
            "Nessaḥ SheBeeGhvurah",
            "Hod SheBeeGhvurah",
            "Yesod SheBeeGhvurah",
            "Malchuth SheBeeGhvurah",
            "Ḥesed SheBaThif'ereth",
            "Jevurah SheBaThif'ereth",
            "Tif'ereth SheBaThif'ereth",
            "Nessaḥ SheBaThif'ereth",
            "Hod SheBaThif'ereth",
            "Yesod SheBaThif'ereth",
            "Malchuth SheBaThif'ereth",
            "Ḥesed SheBaNessaḥ",
            "Jevurah SheBaNessaḥ",
            "Tif'ereth SheBaNessaḥ",
            "Nessaḥ SheBaNessaḥ",
            "Hod SheBaNessaḥ",
            "Yesod SheBaNessaḥ",
            "Malchuth SheBaNessaḥ",
            "Ḥesed SheBaHod",
            "Jevurah SheBaHod",
            "Tif'ereth SheBaHod",
            "Nessaḥ SheBaHod",
            "Hod SheBaHod",
            "Yesod SheBaHod",
            "Malchuth SheBaHod",
            "Ḥesed SheBaYesod",
            "Jevurah SheBaYesod",
            "Tif'ereth SheBaYesod",
            "Nessaḥ SheBaYesod",
            "Hod SheBaYesod",
            "Yesod SheBaYesod",
            "Malchuth SheBaYesod",
            "Ḥesed SheBaMalchuth",
            "Jevurah SheBaMalchuth",
            "Tif'ereth SheBaMalchuth",
            "Nessaḥ SheBaMalchuth",
            "Hod SheBaMalchuth",
            "Yesod SheBaMalchuth",
            "Malchuth SheBaMalchuth"
    };

    public static String getSefirahOfOmerDayArray(int omerDay, int spellingFlag) {
        return getArrayOfSefirosByDayBasedOnSpelling(spellingFlag)[omerDay - 1]; //e.g. hebrewSefirosByDay[omerDay-1]
    }

    public static String getSefirahOfOmerDayAlgorithmic(int omerDay, int spellingFlag) {
        int sefirahDayAdjustedForIndex = omerDay - 1;
        int primarySefirahIndex = sefirahDayAdjustedForIndex % 7;
        int secondarySefirahIndex = sefirahDayAdjustedForIndex / 7;
        String[] array = getArrayOfSefirosBasedOnSpelling(spellingFlag);
        return array[primarySefirahIndex] +
                " " +
                getSefirahPrefix(secondarySefirahIndex, spellingFlag) +
                getOuterSefirahString(spellingFlag, secondarySefirahIndex, array);
    }

    private static String getOuterSefirahString(int spellingFlag, int secondarySefirahIndex, String[] array) {
        if (secondarySefirahIndex == 1) return getGevurahAsOuterSefirahString(spellingFlag);
        else if (secondarySefirahIndex == 2) return getTiferesAsOuterSefirahString(spellingFlag);
        else return array[secondarySefirahIndex];
    }

    /**
     * Grammatically, the gimmel of gevurah when it is preceded by "SheBee" bears a shevah nach and does not have a dagesh, so the string must be changed accordingly.
     */
    private static String getGevurahAsOuterSefirahString(int spellingFlag) {
        if (spellingFlag == SEFIRAH_SPELLING_HEBREW) return "גְבוּרָה";
        return spellingFlag == SEFIRAH_SPELLING_ENGLISH_TEIMANI ? "Ghvurah" : "Gvurah"; //see comment on [englishSefirosTransliteratedTeimani]
    }

    /**
     * Grammatically, the tuf of tiferes when it is preceded by "SheBee" bears a shevah nach and does not have a dagesh, so the string must be changed accordingly.
     */
    private static String getTiferesAsOuterSefirahString(int spellingFlag) {
        if (spellingFlag == SEFIRAH_SPELLING_HEBREW) return "תִפְאֶרֶת";
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_TEIMANI)
            return "Thif'ereth";//see comment on [englishSefirosTransliteratedTeimani]
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_ASHKENAZI) return "Siferes";
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_SEFARADI) return "Tiferet";
        else return "תִפְאֶרֶת";//should this throw an error?
    }

    private static String[] getArrayOfSefirosBasedOnSpelling(int spellingFlag) {
        if (spellingFlag == SEFIRAH_SPELLING_HEBREW) return hebrewSefiros;
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_ASHKENAZI) return englishSefirosTransliteratedAshkenazi;
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_SEFARADI) return englishSefirosTransliteratedSefaradi;
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_TEIMANI) return englishSefirosTransliteratedTeimani;
        else return hebrewSefiros;//should this throw an error?
    }

    private static String[] getArrayOfSefirosByDayBasedOnSpelling(int spellingFlag) {
        if (spellingFlag == SEFIRAH_SPELLING_HEBREW) return hebrewSefirosByDay;
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_ASHKENAZI) return englishSefirosByDayTransliteratedAshkenazi;
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_SEFARADI) return englishSefirosByDayTransliteratedSefaradi;
        else if (spellingFlag == SEFIRAH_SPELLING_ENGLISH_TEIMANI) return englishSefirosByDayTransliteratedTeimani;
        else return hebrewSefirosByDay;//should this throw an error?
    }

    /**
     * Returns the prefix to the second sefirah, e.g. "SheBi", without spaces on either end.
     */
    private static String getSefirahPrefix(int secondarySefirahIndex, int spellingFlag) {
        return secondarySefirahIndex == 1 ?
                (spellingFlag == SEFIRAH_SPELLING_HEBREW ? "שֶׁבִּ" : "SheBee") :
                (spellingFlag == SEFIRAH_SPELLING_HEBREW ? "שֶׁבְּ" :
                        (spellingFlag == SEFIRAH_SPELLING_ENGLISH_TEIMANI ? "SheBa" /*Teimanim pronounce shivah as ashkenazi patach*/ : "SheBi")
                );
    }

    /**
     * Returns the outer sefirah of the day of the omer.
     * For example, if it is the second day of the omer - which is Givurah within Chesed -  this will return Chesed
     */
    public static String getOuterSefirahOfOmerDay(int omerDay, int spellingFlag) {
        return getArrayOfSefirosBasedOnSpelling(spellingFlag)[(omerDay - 1) % 7];
    }

    /**
     * Returns the inner sefirah of the day of the omer.
     * For example, if it is the second day of the omer - which is Givurah within Chesed -  this will return Givurah
     */
    public static String getInnerSefirahOfOmerDay(int omerDay, int spellingFlag) {
        return getArrayOfSefirosBasedOnSpelling(spellingFlag)[(omerDay - 1) / 7];
    }

    static void testGetSefirahByDayHebrew() {
        ArrayList<String> list = new ArrayList<>(49);
        for (int i = 1; i < 50; i++) {
            list.add(getSefirahOfOmerDayAlgorithmic(i, SEFIRAH_SPELLING_HEBREW));
        }
        System.out.println("Test passed: " + Arrays.equals(list.toArray(), hebrewSefirosByDay));
    }
}
