# Week 4: Lab Report 1

## Bug 1:
** Bug - The program is flawed because it continues to parse through the remaining text even though it has found all the links. 
** Symptom - The program crashed and no output was produced because the parser method was stuck in an infinite while loop. It continued to look for another link even though the remaining characters were plain text.
** Solution - Added a conditional statement for whether brackets are found. If they are not found, then the program breaks out of the while loop and returns the links.

Click link to view [failure incuded input #1](https://github.com/kneeko97/markdown-parse/blob/main/test-file-2.md)

![ouput](symptom1.png)

![fixed-bug-1](Fix-bug-1.png)

## Bug 2: 

Click link to view [failure incuded input #2](https://github.com/kneeko97/markdown-parse/blob/main/test-file-3.md)

![ouput](symptom2.png)

![fixed-bug-2](Fix-bug-2.png)

## Bug 3: 

Click link to view [failure incuded input #3](https://github.com/kneeko97/markdown-parse/blob/main/test-file-4.md)

![ouput](symptom3.png)

![fixed-bug-3](Fix-bug-3.png)