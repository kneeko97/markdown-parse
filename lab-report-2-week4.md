# Week 4: Lab Report 2

## Problem 1:
**Bug: 
The program is flawed because it continues to parse through the remaining text even though it has found all the links. 

**Symptom:
The program crashed and no output was produced because the parser method was stuck in an infinite while loop. It continued to look for another link even though the remaining characters were plain text.

**Solution:
Added a conditional statement for whether brackets are found. If they are not found, then the program breaks out of the while loop and returns the links.

Click link to view [failure incuded input #1](https://github.com/kneeko97/markdown-parse/blob/main/test-file-2.md)

![ouput](symptom1.png)

![fixed-bug-1](Fix-bug-1.png)

## Problem 2: 
**Bug:
The program is flawed because it returns faulty links that do not abide by proper markdown syntax. 

**Symptom: 
The program does not crash but the output is faulty. It displays all three links even though the second "link"  does not follow the desired syntax of []().

**Solution:
Added a conditional statement for whether the index of the open parenthesis is only one greater than the closed bracket. Now, it checks for the format of '](' before adding the link to its list of output.

Click link to view [failure incuded input #2](https://github.com/kneeko97/markdown-parse/blob/main/test-file-3.md)

![ouput](symptom2.png)

![fixed-bug-2](Fix-bug-2.png)

## Probblem 3: 
**Bug:
The program is flawed because it crashes when it cannot find a proper link.

**Symptom:
The program crashed and no output was produced because the parser method was stuck in an infinite while loop. I used print statements to see where the currentIndex was located.

**Solution:
Added conditional statements to checck for index of either parentheses. If it cannot find them, the program will now break from the while loop. This is very similar to problem 1 and they have the same symptoms even though they require different solutions. 

Click link to view [failure incuded input #3](https://github.com/kneeko97/markdown-parse/blob/main/test-file-4.md)

![ouput](symptom3.png)

![fixed-bug-3](Fix-bug-3.png)