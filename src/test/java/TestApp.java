import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApp {


    @Test
    public void isAlertFromNullInput() {
        App app = new App();
        assertEquals("Wrong input!!!", app.indexing(null));
    }

    @Test
    public void isAlertFromEmptyInput() {
        App app = new App();
        assertEquals("Empty input!!!", app.indexing(""));
    }

    @Test
    public void isOneIndexFromOneLetterWord() {
        App app = new App();
        assertEquals("a: aaa", app.indexing("aaa"));
    }

    @Test
    public void isNoletterSignAreRemoving() {
        App app = new App();
        assertEquals("a: aaa", app.indexing("aaa,:\\.-"));
    }

    @Test
    public void isLetterCaseAreIgnored() {
        App app = new App();
        assertEquals("a: aaaa", app.indexing("AAAA"));
    }

    @Test
    public void isThreeIndexFromThreeLetterWord() {
        String result = "a: abc\n" +
                "b: abc\n" +
                "c: abc";
        App app = new App();
        assertEquals(result, app.indexing("abc"));
    }

    @Test
    public void isTwoIndexFromTwoLetterOneWord() {
        String result = "a: ab\n" +
                "b: ab";
        App app = new App();
        assertEquals(result, app.indexing("ab"));
    }

    @Test
    public void isTwoIndexFromTwoLetterTwoWords() {
        String result = "a: ab\n" +
                "b: ab";
        App app = new App();
        assertEquals(result, app.indexing("ab ab"));
    }

    @Test
    public void isDemoTest() {
        String input = "ala ma kota, kot koduje w Javie Kota";
        String result =
                "a: ala, javie, kota, ma\n" +
                        "d: koduje\n" +
                        "e: javie, koduje\n" +
                        "i: javie\n" +
                        "j: javie, koduje\n" +
                        "k: koduje, kot, kota\n" +
                        "l: ala\n" +
                        "m: ma\n" +
                        "o: koduje, kot, kota\n" +
                        "t: kot, kota\n" +
                        "u: koduje\n" +
                        "v: javie\n" +
                        "w: w";

        App app = new App();
        assertEquals(result, app.indexing(input));
    }


}
