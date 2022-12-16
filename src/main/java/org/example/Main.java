package org.example;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args)throws IOException {


        /*
         * Get the name of the Web site from the user from which the search engine will search for the keywords
         */
        String websiteName =JOptionPane.showInputDialog("Enter the name of the Web Site you want to search for the words!!");

        JOptionPane.showMessageDialog(null,"Loading the keywords in the pages to the Trie");
        /*
         * The name of the web site is passed into the search engine class
         * After which the execution of the search engine class will start
         */
        SearchEngine engine = new SearchEngine("src/main/resources/"+websiteName+".txt");
        String indexTerm =JOptionPane.showInputDialog("All set.\n Type the words you want to search (separated by comma):");
        /*
         *After the structure is prepared the user is asked to enter the keyword to search which is then searched
         */
        try{
            while(!indexTerm.equals("esc") && !indexTerm.equals(null)) {
                String[] indexTermArray = indexTerm.split("[[,]*|[ ]*]+");
                String[] webPages = engine.search(indexTermArray);
                try{
                    if (webPages==null)
                    {
                        JOptionPane.showMessageDialog(null, "Please enter a keyword or query!");

                    }

                    JOptionPane.showMessageDialog( null, webPages );
                }
                catch(NullPointerException e){

                    JOptionPane.showMessageDialog(null,"sorry");
                }

                indexTerm = JOptionPane.showInputDialog("\nyou want to search (separated by comma - \"esc\" to end):");

            }
        }
        catch(NullPointerException e){JOptionPane.showMessageDialog(null,"Thank You");}

        JOptionPane.showMessageDialog(null,"GoodBye");

    }
}