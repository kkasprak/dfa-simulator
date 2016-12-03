## Kayla Kasprak Project - Simulator and Closure Properties (bolos)

This project (dfa-simulator) has two classes. 

MySimulator.java, will take in two arguments: the path to a file containing a DFA description and the path to a file containing a sequence of strings. MySimulator.java will output "accept" or "reject" depending on whether the string is recognized by the language of the DFA. Passes all tests in the script as noted in comments.txt.

DFAClosureProperties.java, given one argument that is the file path containing the description of a DFA, will output the description of the complement DFA. Functionality for two arguments is not yet implemented. All test cases for Complement pass (tested by passing in the file path via arguments in Intellij configuration), including randomHexDFA, handoutDFA, bigDFA, and bigDFA-comp.

Script is failing with the following error:
/Users/KaylaKasprak/Desktop/dfa-simulator/project-test/bin/DFAequiv: /Users/KaylaKasprak/Desktop/dfa-simulator/project-test/bin/DFAequiv: cannot execute binary file
ProjectTest.hs: readCreateProcess: /Users/KaylaKasprak/Desktop/dfa-simulator/project-test/bin/DFAequiv "/Users/KaylaKasprak/Desktop/dfa-simulator/project-test/test-suite/boolop/randomHexDFA-comp.txt" "/Users/KaylaKasprak/Desktop/dfa-simulator/randomHexDFA-comp.txt1010275441457850878.tmp" (exit 126): failed

I tried “chmod -x DFAequiv” to no avail. It doesn’t seem to be a permissions error.




