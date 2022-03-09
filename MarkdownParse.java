// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkdownParse {

    static int findCloseParen(String markdown, int openParen) {
        int closeParen = openParen + 1;
        int openParenCount = 1;
        while (openParenCount > 0 && closeParen < markdown.length()) {
            if (markdown.charAt(closeParen) == '(') {
                openParenCount++;
            } else if (markdown.charAt(closeParen) == ')') {
                openParenCount--;
            }
            closeParen++;
        }
        if(openParenCount == 0) {
          return closeParen - 1;
        }
        else {
          return -1;
        }

    }
    public static Map<String, List<String>> getLinks(File dirOrFile) throws IOException {
        Map<String, List<String>> result = new HashMap<>();
        if(dirOrFile.isDirectory()) {
            int counter = 0;
            for(File f: dirOrFile.listFiles()) {
                result.putAll(getLinks(f));
                counter++;
                System.out.println(counter);
            }
            return result;
        }
        else {
            Path p = dirOrFile.toPath();
            int lastDot = p.toString().lastIndexOf(".");
            if(lastDot == -1 || !p.toString().substring(lastDot).equals(".md")) {
                return result;
            }
            ArrayList<String> links = getLinks(Files.readString(p));
            result.put(dirOrFile.getPath(), links);
            return result;
        }
    }
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )

        int currentIndex = 0;
        while(currentIndex < markdown.length()) {

            int nextOpenBracket = markdown.indexOf("[", currentIndex);
       
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(nextOpenBracket == -1 || nextCloseBracket == -1 ||
                        openParen == -1 || closeParen == -1) {
                break;
            }
            
            // check if there is an open bracket in between nextOpenBracket and 
            // nextCloseBracket. If so continue... (write the if statement)

            if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
                currentIndex = currentIndex + 1;
                continue;
            }

            // Can't be out of bounds because check of -1 for all indices 
            // enforces that nextCloseBracket can't be the last character in file
            if(markdown.charAt(nextCloseBracket + 1) != '('){
                currentIndex = nextCloseBracket + 1;
                continue;
            } 

            String link = markdown.substring(openParen + 1, closeParen).trim();
        
            if(link.indexOf(" ") == -1) {
                toReturn.add(link);
            }
            currentIndex = closeParen + 1;
            
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
        // Path fileName = Path.of(args[0]);
        // String contents = Files.readString(fileName);
        // ArrayList<String> links = getLinks(contents);
        // System.out.println(links);

        Path file = Path.of(args[0]);
        File fileName = file.toFile();

        if(fileName.isDirectory()){
            Map<String, List<String>> links = getLinks(fileName);
            System.out.println(links);
        }
        else{
            ArrayList<String> links = getLinks(Files.readString(file));
            System.out.println(links);
        }
        
    }
}
