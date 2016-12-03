/**
 * Created by KaylaKasprak on 11/26/16.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class MySimulator {
    public static void main (String[] args) throws Exception {
        String line1 = "";
        String line2 = "";
        String line3 = "";
        int numOfStates = 0;
        int alphabetSize = 0;
        String[] tokens;
        String[] tokensAlph;
        ArrayList<String> acceptingStates = new ArrayList<>();
        ArrayList<String> alphabet = new ArrayList<>();

        String[][] stateTransitions;
        int index = 0; //for keeping track of index in the alphabet
        int state = 0; //assume state 0 is starting state, update as the input string is read

        String fileName1 = args[0];
        String fileName2 = args[1];
        //System.err.print(fileName1+"\n"+fileName2);
        Scanner sc = new Scanner(new File(fileName1));
        line1 = sc.nextLine(); //number of states
        line2 = sc.nextLine(); //accepting states
        line3 = sc.nextLine(); //alphabet

        //NUMBER OF STATES
        //Testing that line1 was captured correctly
        //
        //System.err.println("line1: " + line1);
        //Tokenize the line
        tokens = line1.split(" ");
        //Save the third index as an int representing the number of states in the DFA
        numOfStates = Integer.parseInt(tokens[3]);
        //Print to test
        //System.err.println("NumOfStates: "+numOfStates);

        //ACCEPTING STATES
        //System.err.println("Line2: " +line2);
        tokens = line2.split(" ");
        //System.err.print("AccStates: ");
        for(int i = 2; i < tokens.length; i++)
        {
            String accState = (tokens[i]);
            acceptingStates.add(accState);
            //System.err.print(accState+" ");
        }
        //System.err.println();

        //ALPHABET (added to an ArrayList)
        //Read in line 2 and tokenize it
        //System.err.println("Line3: " +line3);
        line3 = line3.replace("Alphabet: ", "");
        //System.err.println("line3: "+line3);
        tokensAlph = line3.split("");
        alphabetSize = tokensAlph.length;
        //System.err.println("Alph size: " + alphabetSize);


        //System.err.print("Alph:");
        for(int i = 0; i < tokensAlph.length; i++)
        {
            String alphchar = (tokensAlph[i]);
            alphabet.add(alphchar);
            //System.err.print(alphabet.get(i));
        }
        //Initialize stateTransitions table now that we know dimensions
        stateTransitions = new String[numOfStates][alphabetSize];
        //System.err.print("\n");


        //System.err.print("Entering while loop"+"\n");
        while(sc.hasNext())
        {
            //MULTIDIMENSIONAL ARRAY FOR DFA TABLE (TRANSITIONS)
            //outer 'for' loop is rows (i.e. number of states
            for (int i = 0; i < numOfStates; i++)
            {
                for (int j = 0; j < alphabetSize; j++) {
                    if(sc.hasNext())
                    {
                        String state1 = sc.next();
                        stateTransitions[i][j] = state1;
                        //System.err.print(stateTransitions[i][j]+" ");
                    }
                }
                //System.err.print("\n");
            }
            //System.err.print("out of for loop");
        }
        //System.err.print("OUT OF WHILE "+"\n");
        //PRINT OUT STATE TRANSITIONS[][] TO TEST
//        for (int i = 0; i < numOfStates; i++)
//        {
//            for (int j = 0; j < alphabetSize; j++) {
//
//                System.err.print(stateTransitions[i][j]+" ");
//            }
//            System.err.print("\n");
//        }
        Scanner strsc = new Scanner(new File(fileName2));
        String str = "";
        String[] testStringTokens;
        str = null;

        while(strsc.hasNextLine())
        {


            str = strsc.nextLine();
            if(str.equals("") && acceptingStates.contains("0"))
            {
                System.out.println("accept");
            }
            else if(str.isEmpty())
            {
                System.out.println("reject");
            }
            else {
                //System.err.print("test string:" + str + "\n");
                testStringTokens = str.split("");
                state = 0;

                for (int i = 0; i < testStringTokens.length; i++) {
                    index = alphabet.indexOf(testStringTokens[i]); //index is the alphabet index (cols of state table) of the value of the character
                    //System.err.print("State = " + state + "\n" + " Char = " + testStringTokens[i] + " Index at Char = " + index + "\n");
                    state = Integer.parseInt(stateTransitions[state][index]);
                    //System.err.print("State after char = " + state + "\n");
                }

                if (acceptingStates.contains(Integer.toString(state))) {
                    //System.err.println(str + " accept" + "\n");
                    System.out.println("accept");
                } else {
                    //System.err.println(str + " reject" + "\n");
                    System.out.println("reject");
                }
            }
        }
    }
}
