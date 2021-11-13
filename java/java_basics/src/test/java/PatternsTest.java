import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatternsTest {
    private Patterns patterns;

    @Before
    public void setUp(){
        patterns = new Patterns();
    }

    @Test
    public  void numberPyramidTest(){
        patterns.printNumberPiramid(6);
    }

    @Test
    public void alphabetPyramidTest(){
        patterns.printAlphabetPyramid('G');
    }

    @Test
    public  void starBoxTest(){
        patterns.printDollarBox(4);
    }

    @Test
    public  void starBoxTestWithSize8(){
        patterns.printDollarBox(8);
    }



}
