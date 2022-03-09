// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkdownParse {
    // lol
    // public static ArrayList<String> getLinks(String markdown) {
    //     ArrayList<String> toReturn = new ArrayList<>();
    //     // find the next [, then find the ], then find the (, then take up to
    //     // the next )
    //     int currentIndex = 0;
    //     System.out.println(currentIndex);
    //     int lastClosedParen = markdown.lastIndexOf(")");
    //     while(currentIndex < markdown.length()) {
    //         int nextOpenBracket = markdown.indexOf("[", currentIndex);
    //         int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
    //         int openParen = markdown.indexOf("(", nextCloseBracket);
    //         int closeParen = markdown.indexOf(")", openParen);
    //         toReturn.add(markdown.substring(openParen + 1, closeParen));
    //         currentIndex = closeParen + 1;
    //         System.out.println(currentIndex);
    //         if (closeParen == lastClosedParen) {
    //             break;
    //         }
    //     }
    //     return toReturn;
    // }

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        String regex = "(?<!!)\\[.+\\]+\\((.*)\\)";
        Matcher matcher = Pattern.compile(regex).matcher(markdown);

        while(matcher.find()) {
            // toReturn.add(matcher.group(1));
            toReturn.add(matcher.group(1).replaceAll(" ", ""));
        }

        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
        
    }
}
