// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )

        int currentIndex = 0;
        while(currentIndex < markdown.length()) {

            // int nextOpenBracket = markdown.indexOf("[", currentIndex);
            // // System.out.format("%d\t%d\t%s\n", currentIndex, nextOpenBracket, toReturn);
            // int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            // int openParen = markdown.indexOf("(", nextCloseBracket);
            // int closeParen = markdown.indexOf(")", openParen);
            // if(nextOpenBracket == -1 || nextCloseBracket == -1 ||
            //             openParen == -1 || closeParen == -1) {
            //     break;
            // }
            
            // // check if there is an open bracket in between nextOpenBracket and 
            // // nextCloseBracket. If so continue... (write the if statement)

            // if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
            //     currentIndex = currentIndex + 1;
            //     continue;
            // }

            // // Can't be out of bounds because check of -1 for all indices 
            // // enforces that nextCloseBracket can't be the last character in file
            // if(markdown.charAt(nextCloseBracket + 1) != '('){
            //     currentIndex = nextCloseBracket + 1;
            //     continue;
            // } 

            // String link = markdown.substring(openParen + 1, closeParen).trim();
        
            // if(link.indexOf(" ") == -1) {
            //     toReturn.add(link);
            // }
            // currentIndex = closeParen + 1;
            

            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            if (nextOpenBracket == -1 || nextCloseBracket == -1) {
                    break;
            }
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (openParen == -1 || closeParen == -1) {
                break;
            }  
            
            if(openParen == nextCloseBracket + 1){
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            currentIndex = closeParen + 1;
            // System.out.format("%d\t%d\t%d\t%d\n", currentIndex, nextOpenBracket, nextCloseBracket, closeParen);
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