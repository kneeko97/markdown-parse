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