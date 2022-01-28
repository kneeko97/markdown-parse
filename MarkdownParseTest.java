//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

//java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    // @Test
    // public void addition() {
    //     assertEquals(2, 1 + 1);
    // }
    @Test 
    public void testFile1() throws IOException{
        String contents = Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://thiswillwork.com","willworktoo.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
    @Test
    public void testFile2() throws IOException{
        String contents = Files.readString(Path.of("./test-file-2.md"));
        List<String> expect = List.of("https://something.com","some-page.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile3() throws IOException{
        String contents = Files.readString(Path.of("./test-file-3.md"));
        List<String> expect = List.of("www.thislinkshouldwork.com","thislinkshouldworkaswell.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile4() throws IOException{
        String contents = Files.readString(Path.of("./image-test.md"));
        List<String> expect = List.of("thisisanimage.png");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}
