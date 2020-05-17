import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringFinderTest {


    @Test
    public void testFindOneCharString(){
        List<String> dataset = Arrays.asList("hello");

        StringFinder f = new StringFinder(dataset);

        List<String> list = f.find("l");
        assertEquals(list.size(),1);
        assertEquals(list.get(0), "hello");
    }

    @Test
    public void testNotFindOneCharString(){
        List<String> dataset = Arrays.asList("hello");

        StringFinder f = new StringFinder(dataset);

        List<String> list = f.find("s");
        assertEquals(list.size(),0);
    }

    @Test
    public void testNotFindExpressionString(){
        List<String> dataset = Arrays.asList("hello");

        StringFinder f = new StringFinder(dataset);

        List<String> list = f.find("eo");
        assertEquals(list.size(),1);
        assertEquals(list.get(0), "hello");
    }


    @Test
    public void test3(){
        List<String> dataset = Arrays.asList("hello", "haha");

        StringFinder f = new StringFinder(dataset);

        List<String> list = f.find("ha");
        assertEquals(list.size(),1);
        assertEquals(list.get(0), "haha");
    }


    @Test
    public void test4(){
        List<String> dataset = Arrays.asList("YouIdiot", "GoAwayYouIdiot");

        StringFinder f = new StringFinder(dataset);

        List<String> list = f.find("YouIdiot");
        assertEquals(list.size(),2);
        assertTrue(list.contains("YouIdiot"));
        assertTrue(list.contains("GoAwayYouIdiot"));

    }
    @Test
    public void test5(){
        List<String> dataset = Arrays.asList("You Idiot", "GoAwayYouIdiot","HelloMan");

        StringFinder f = new StringFinder(dataset);

        List<String> list = f.find("YouIdiot");
        assertEquals(list.size(),2);
        assertTrue(list.contains("GoAwayYouIdiot"));
        assertTrue(list.contains("You Idiot"));
    }


    @Test
    public void test6() {
        List<String> dataset = Arrays.asList("ViewerControl", "ViewerMetaControlManager", "MainViewerManager");

        StringFinder f = new StringFinder(dataset);

        {
            List<String> list = f.find("Control");
            assertEquals(list.size(), 2);
            assertTrue(list.contains("ViewerControl"));
            assertTrue(list.contains("ViewerMetaControlManager"));
        }
        {
            List<String> list = f.find("Manager");
            assertEquals(list.size(), 2);
            assertTrue(list.contains("MainViewerManager"));
            assertTrue(list.contains("ViewerMetaControlManager"));

        }
        {
            List<String> list = f.find("Viewer");
            assertEquals(list.size(), 3);
            assertTrue(list.contains("MainViewerManager"));
            assertTrue(list.contains("ViewerMetaControlManager"));
            assertTrue(list.contains("ViewerControl"));
        }

    }

}


/*
    hello => [][][][]

 */