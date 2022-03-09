import static org.junit.Assert.*;

// import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;


public class MarkdownParseTest {
    public static void getLinksTest(String filename, List<String> expected) {
        try {
            assertEquals(expected, MarkdownParse.getLinks(Files.readString(Path.of(filename))));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks1() {
        List<String> expected = List.of("https://something.com", "some-page.html");
        getLinksTest("test-file.md", expected);
        
        // My tests
        expected = List.of("google.com");
        getLinksTest("new-test.md", expected);
        getLinksTest("new-test2.md", expected);
        expected = List.of();
        getLinksTest("new-test3.md", expected);
        getLinksTest("new-test4.md", expected);
        expected = List.of("google.com");
        getLinksTest("new-test5.md", expected);

        expected = List.of("https://something.com", "some-page.html");
        getLinksTest("test-file2.md", expected);
        expected = List.of();
        getLinksTest("test-file3.md", expected);
        getLinksTest("test-file4.md", expected);
        getLinksTest("test-file5.md", expected);
        expected = List.of("https://something.com");
        getLinksTest("test-file6.md", expected);
        expected = List.of();
        getLinksTest("test-file7.md", expected);
        getLinksTest("test-file8.md", expected);
        getLinksTest("test-file9.md", expected);
        getLinksTest("test-file10.md", expected);
        expected = List.of("should-be-trimmed.com");
        getLinksTest("test-file11.md", expected);
        getLinksTest("test-file12.md", expected);
        expected = List.of();
        // getLinksTest("test-file13.md", expected);
    }

    @Test
    public void testSnippets() {
        List<String> expected = List.of();

        // getLinksTest("test-snippet1.md", expected);
        // getLinksTest("test-snippet2.md", expected);
        getLinksTest("test-snippet3.md", expected);

    }
}