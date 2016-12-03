/**
 * Created by KaylaKasprak on 11/26/16.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class DFAClosureProperties {
    public static void main (String[] args) throws Exception {
        String line1 = "";
        String line2 = "";
        String line3 = "";
        int numOfStates = 0;
        int alphabetSize = 0;
        String[] tokens;
        String[] tokensAlph;
        ArrayList<String> acceptingStates = new ArrayList<>();
        ArrayList<String> newAcceptingStates = new ArrayList<>();
        ArrayList<Integer> newAcceptingStatesInt = new ArrayList<>();
        ArrayList<String> alphabet = new ArrayList<>();
        ArrayList<String> allStates = new ArrayList<>();

        String[][] stateTransitions;
        int index = 0; //for keeping track of index in the alphabet
        int state = 0; //assume state 0 is starting state, update as the input string is read

        if (args.length == 1) {
            String fileName1 = args[0];
            //String fileName2 = args[1];
            System.out.println(fileName1);
            Scanner sc = new Scanner(new File(fileName1));
            line1 = sc.nextLine(); //number of states
            line2 = sc.nextLine(); //accepting states
            line3 = sc.nextLine(); //alphabet

            //NUMBER OF STATES
            //Testing that line1 was captured correctly
            //
            //System.out.println("line1: " + line1);
            //Tokenize the line
            tokens = line1.split(" ");
            //Save the third index as an int representing the number of states in the DFA
            numOfStates = Integer.parseInt(tokens[3]);
            //Print to test
            System.out.println("Number of States: "+numOfStates);

            //ACCEPTING STATES
            //System.out.println("Line2: " +line2);
            tokens = line2.split(" ");
            //System.out.print("AccStates: ");
            for (int i = 2; i < tokens.length; i++) {
                String accState = (tokens[i]);
                acceptingStates.add(accState);
                //System.out.print(accState+" ");
            }
            //System.out.println();

            //ALPHABET (added to an ArrayList)
            //Read in line 2 and tokenize it
            //System.out.println("Line3: " +line3);
            line3 = line3.replace("Alphabet: ", "");
            //System.out.println("line3: "+line3);
            tokensAlph = line3.split("");
            alphabetSize = tokensAlph.length;
            //System.out.println("Alph size: " + alphabetSize);

            //System.err.print("Alph:");
            for (int i = 0; i < tokensAlph.length; i++) {
                String alphchar = (tokensAlph[i]);
                alphabet.add(alphchar);
                //System.err.print(alphabet.get(i));
            }
            //Initialize stateTransitions table now that we know dimensions
            stateTransitions = new String[numOfStates][alphabetSize];


            //System.err.print("Entering while loop"+"\n");
            while (sc.hasNext()) {
                //MULTIDIMENSIONAL ARRAY FOR DFA TABLE (TRANSITIONS)
                //outer 'for' loop is rows (i.e. number of states
                for (int i = 0; i < numOfStates; i++) {
                    for (int j = 0; j < alphabetSize; j++) {
                        if (sc.hasNext()) {
                            String state1 = sc.next();
                            stateTransitions[i][j] = state1;
                            //System.out.print(stateTransitions[i][j]+" ");
                        }
                    }
                    //System.out.println();
                }
                //System.err.print("out of for loop");
            }
            //System.err.print("OUT OF WHILE "+"\n");
            //PRINT OUT STATE TRANSITIONS[][] TO TEST
            for (int i = 0; i < numOfStates; i++)
            {
                for (int j = 0; j < alphabetSize; j++) {

                    allStates.add(stateTransitions[i][j]);
                }
                //System.err.print("\n");
            }

            //System.out.println("Size of normal accepting states: "+acceptingStates.size());
            //System.out.println("Size of all states: "+allStates.size());
            //add accepting states
            //System.out.println(allStates.size());
            for(int k = 0; k < allStates.size(); k++)
            {
                if(!acceptingStates.contains(allStates.get(k)))
                {
                    if(!newAcceptingStates.contains(allStates.get(k)))
                    {
                        newAcceptingStates.add(allStates.get(k));
                        //System.out.println("adding to new accepting state: " + allStates.get(k));
                    }
                }
            }

            //System.out.println("Size of new accepting states: "+newAcceptingStates.size());
//            System.out.print("Accepting States: ");
//            for(int m = 0; m < newAcceptingStates.size(); m++)
//            {
//                System.out.print(newAcceptingStates.get(m));
//                if(m < newAcceptingStates.size()-1)
//                {
//                    System.out.print(" ");
//                }
//            }

            for(int m = 0; m < newAcceptingStates.size(); m++)
            {
                String s = newAcceptingStates.get(m);
                int si = Integer.parseInt(s);
                newAcceptingStatesInt.add(si);
            }
            Collections.sort(newAcceptingStatesInt);

            System.out.print("Accepting States: ");
            for(int m = 0; m < newAcceptingStatesInt.size(); m++)
            {
                System.out.print(newAcceptingStatesInt.get(m));
                if(m < newAcceptingStatesInt.size()-1)
                {
                    System.out.print(" ");
                }
            }

//            System.out.print("Accepting States: ");
//            for(int m = 0; m < newAcceptingStates.size(); m++)
//            {
//                System.out.print(newAcceptingStates.get(m));
//                if(m < newAcceptingStates.size()-1)
//                {
//                    System.out.print(" ");
//                }
//            }


            System.out.println();
            System.out.println("Alphabet: "+line3);
            for (int i = 0; i < numOfStates; i++) {
                for (int j = 0; j < alphabetSize; j++) {
                    allStates.add(stateTransitions[i][j]);
                    System.out.print(stateTransitions[i][j]+" ");
                }
                System.out.println();
            }

        }//end if 1 arguement
    }
}
