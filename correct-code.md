# Title

```
ArrayList<String> toReturn = new ArrayList<>();
    // find the next [, then find the ], then find the (, then take up to
    // the next )
    int currentIndex = 0;
    while(currentIndex < markdown.length()) {
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

        if (markdown.charAt(nextOpenBracket - 1) == '!') {
            currentIndex = closeParen + 1;
        }
        if(openParen == nextCloseBracket + 1){
            toReturn.add(markdown.substring(openParen + 1, closeParen));
        }
        currentIndex = closeParen + 1;
    }
    return toReturn;
```


1PM MarkdownParse
```
    /* 
    int nextOpenBracket = markdown.indexOf("[", currentIndex);
    if(nextOpenBracket == -1) {
        break;
    }
    if(nextOpenBracket > 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
        break;
    }
    int nextCloseBracket = markdown.indexOf("](", nextOpenBracket);
    if(nextCloseBracket == -1) {
        break;
    }
    int closeParen = markdown.indexOf(")", nextCloseBracket);
    toReturn.add(markdown.substring(nextCloseBracket + 2, closeParen));
    currentIndex = closeParen + 1;
    System.out.println("nextOpenBracket: " + nextOpenBracket);
    System.out.println("nextCloseBracket: " + nextCloseBracket);
    */
```


2PM MarkdownParse
```
    int nextOpenBracket = markdown.indexOf("[", currentIndex);
    // System.out.format("%d\t%d\t%s\n", currentIndex, nextOpenBracket, toReturn);
    int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
    int openParen = markdown.indexOf("(", nextCloseBracket);
    int closeParen = markdown.indexOf(")", openParen);
    if(nextOpenBracket == -1 || nextCloseBracket == -1 ||
                openParen == -1 || closeParen == -1) {
        break;
    }
    if(nextOpenBracket != 0 && markdown.charAt(nextOpenBracket - 1) == '!') {
        currentIndex = currentIndex + 1;
        continue;
    }
    String link = markdown.substring(openParen + 1, closeParen);
    link = link.trim();

    if(link.indexOf(" ") == -1) {
        toReturn.add(link);
    }
    currentIndex = closeParen + 1;
```


2PM REDO MarkdownParse
```
int nextOpenBracket = markdown.indexOf("[", currentIndex);
// System.out.format("%d\t%d\t%s\n", currentIndex, nextOpenBracket, toReturn);
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
```


3PM MarkdownParse
```
    int nextOpenBracket = markdown.indexOf("[", currentIndex);
    System.out.format("%d\t%d\t%s\n", currentIndex, nextOpenBracket, toReturn);
    int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
    int openParen = markdown.indexOf("(", nextCloseBracket);
    int closeParen = markdown.indexOf(")", openParen);
    if(nextOpenBracket == -1 || nextCloseBracket == -1
            || closeParen == -1 || openParen == -1) {
        return toReturn;
    }
    String potentialLink = markdown.substring(openParen + 1, closeParen);
    if(potentialLink.indexOf(" ") == -1 && potentialLink.indexOf("\n") == -1) {
        toReturn.add(potentialLink);
        currentIndex = closeParen + 1;
    }
    else {
        currentIndex = currentIndex + 1;
    }
```