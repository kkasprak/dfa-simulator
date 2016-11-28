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

        Scanner sc = new Scanner(new File("/Users/KaylaKasprak/Desktop/355proj/src/bigDFA.txt"));
        line1 = sc.nextLine(); //number of states
        line2 = sc.nextLine(); //accepting states
        line3 = sc.nextLine(); //alphabet

        //NUMBER OF STATES
        //Testing that line1 was captured correctly
        System.err.println("line1: " + line1);
        //Tokenize the line
        tokens = line1.split(" ");
        //Save the third index as an int representing the number of states in the DFA
        numOfStates = Integer.parseInt(tokens[3]);
        //Print to test
        System.err.println("NumOfStates: "+numOfStates);

        //ACCEPTING STATES
        System.err.println("Line2: " +line2);
        tokens = line2.split(" ");
        System.err.print("AccStates: ");
        for(int i = 2; i < tokens.length; i++)
        {
            String accState = (tokens[i]);
            acceptingStates.add(accState);
            System.err.print(accState+" ");
        }
        System.err.println();

        //ALPHABET (added to an ArrayList)
        System.err.println("LINE2: " +line3);
        tokens = line3.split(" ");
        String alphString = tokens[1];
        tokensAlph = alphString.split("");
        alphabetSize = tokensAlph.length;
        System.err.println("Alph size: " + alphabetSize);

        System.err.print("Alph: ");
        for(int i = 0; i < tokensAlph.length; i++)
        {
            String alphchar = (tokensAlph[i]);
            alphabet.add(alphchar);
            System.err.print(alphchar+" ");
        }
        //Initialize stateTransitions table now that we know dimensions
        stateTransitions = new String[numOfStates][alphabetSize];
        System.err.print("\n");

        while(sc.hasNext())
        {
            //MULTIDIMENSIONAL ARRAY FOR DFA TABLE (TRANSITIONS)
            //outer 'for' loop is rows (i.e. number of states
            for (int i = 0; i < numOfStates; i++)
            {
                for (int j = 0; j < alphabetSize; j++) {
                    String state1 = sc.next();
                    stateTransitions[i][j] = state1;
                }
            }
//        index = alphabet.indexOf(index);//for an alphabet 01, 0 will be first column
        }
        for (int i = 0; i < numOfStates; i++)
        {
            for (int j = 0; j < alphabetSize; j++) {

                System.err.print(stateTransitions[i][j]+" ");
            }
            System.err.print("\n");
        }

    }

}
