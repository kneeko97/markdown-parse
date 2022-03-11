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
    //     assertEquals(4, 2 + 2);
    // }
    // @Test 
    // public void testFile1() throws IOException{
    //     String contents = Files.readString(Path.of("./test-file.md"));
    //     List<String> expect = List.of("https://thiswillwork.com","willworktoo.html");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }
    // @Test
    // public void testFile2() throws IOException{
    //     String contents = Files.readString(Path.of("./test-file-2.md"));
    //     List<String> expect = List.of("https://something.com","some-page.html");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testFile3() throws IOException{
    //     String contents = Files.readString(Path.of("./test-file-3.md"));
    //     List<String> expect = List.of("www.thislinkshouldwork.com","thislinkshouldworkaswell.html");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testFile4() throws IOException{
    //     String contents = Files.readString(Path.of("./test-file-4.md"));
    //     List<String> expect = List.of();
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testFile5() throws IOException{
    //     String contents = Files.readString(Path.of("./image-test.md"));
    //     List<String> expect = List.of( "alink.com");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testSpaceAfterParen() {
    //     String contents = "[title]( space-in-url.com)";
    //     List<String> expect = List.of("space-in-url.com");
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testSpaceBeforeParen() {
    //     String contents = "[title] (space-in-url.com)";
    //     List<String> expect = List.of();
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testExtraBracketImage() {
    //     String contents = "[![title](should-not-count.com)";
    //     List<String> expect = List.of();
    //     assertEquals(expect, MarkdownParse.getLinks(contents));
    // }

    @Test 
    public void snippet1() throws IOException{
        String contents = Files.readString(Path.of("./snippet1.md"));
        List<String> expect = List.of("`google.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void snippet2() throws IOException{
        String contents = Files.readString(Path.of("./snippet2.md"));
        List<String> expect = List.of("a.com", "a.com((", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void snippet3() throws IOException{
        String contents = Files.readString(Path.of("./snippet3.md"));
        List<String> expect = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }
}
