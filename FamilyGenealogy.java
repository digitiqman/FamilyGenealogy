package familygenealogy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Types;

/**
 *
 * @author DiGiT
 */
public class FamilyGenealogy {

    /**
     * @param args the command line arguments
     */           
    public static void main(String[] args) {
        Scanner keyboard = null;
        /** Greet the user */
        System.err.println("*************************Family Genealogy/Tree*****************************");
        System.err.println("*                      By Bejide Oluwole Daniel                           *");
        System.err.println("***************************************************************************");
        System.err.println("Enter 'quit' at any time to exit program.");
        System.err.println("\n");
        
        System.err.println("New Input Format: Mother=Zodiak Son=Zulu to create Zulu as a son to Zodiak");
        System.err.println("Query Input Format: Person=Trump Relation=Sisters to view all Trump's Sisters ");
        System.err.println("Supported Relationships are: FATHER, MOTHER, BROTHER(S), SISTER(S), SON(S), "
                + "DAUGHTER(S), COUSIN(S), GRANDMOTHER, GRANDFATHER, GRANDSON(S), GRANDDAUGHTER(S),"
                + "AUNT(S), UNCLE(S), NEPHEW(S), NIECE(S), SIBLINGS, PARENT(S), HUSBAND, WIFE) ");
        System.err.println("\n");
        
        System.err.println("Display Genealogy Command: \"ShowFamily\" to display the complete Family Tree");
        System.err.println("\n");      
        
        System.err.println("At the moment, the family tree is blank. "
                + "\nBut, you must populate the family tree with random data for up to three generations to continue. "
                + "\nTo do this input: GenerateFamily. ");                
        
        familygenealogy.FamilyManager digitalfamily = new familygenealogy.FamilyManager();
        try {
            keyboard = new Scanner(System.in);
            while (true) {
                boolean processInput = false;
                String userInput = keyboard.nextLine();
                if (userInput.equalsIgnoreCase("quit")) {
                    System.out.println("Thank you for using our Family tree. Have a great day. ");
                    System.exit(0);
                }
                String arg1_kinship = null;
                String arg1_name = null;
                String arg2_kinship = null;
                String arg2_name = null;
                String[] splittedInput = userInput.trim().split(" ");
                if(null == splittedInput)
                    continue;
                if(splittedInput.length > 2 || splittedInput.length < 1){
                    System.err.println("Invalid format. Please try again...");
                    System.err.println("\n\n");

                    System.err.println("New Input Format: \"Mother=Zodiak Son=Zulu\" to create Zulu as a son to Zodiak");
                    System.err.println("Query Input Format: \"Person=Trump Relation=Sisters\" to view all Trump's Sisters ");
                    System.err.println("Supported Relationships are: FATHER, MOTHER, BROTHER(S), SISTER(S), SON(S), "
                            + "DAUGHTER(S), COUSIN(S), GRANDMOTHER, GRANDFATHER, GRANDSON(S), GRANDDAUGHTER(S),"
                            + "AUNT(S), UNCLE(S), NEPHEW(S), NIECE(S), SIBLINGS, PARENT(S), HUSBAND, WIFE)");
                    System.err.println("Display Genealogy Command: showFamily to display the complete Family Tree");
                    continue;
                }
                if(userInput.equalsIgnoreCase("GenerateFamily")){
                    System.err.println(digitalfamily.generateGenealogy());
                    continue;
                }
                else if (userInput.equalsIgnoreCase("ShowFamily")) {
                    System.out.println(digitalfamily.displayGenealogy());
                    continue;
                } 
                else if(!userInput.contains("Person") && userInput.contains("=") && splittedInput.length == 2){
                    arg1_name = splittedInput[0].trim().split("=")[1];
                    arg1_kinship = splittedInput[0].trim().split("=")[0];
                    arg2_name = splittedInput[1].trim().split("=")[1];
                    arg2_kinship = splittedInput[1].trim().split("=")[0];
                    processInput = true;
                } 
                else if(userInput.contains("Person") && userInput.contains("=") && userInput.contains("Relation")) {
                    for (String namekinshipPair : splittedInput) {
                        String[] params = namekinshipPair.split("=");
                        if (params[0].equalsIgnoreCase("Person")) {
                                arg1_name = params[1];
                        } else if (params[0].equalsIgnoreCase("Relation")) {
                                arg1_kinship = params[1];
                        }
                        processInput = true;
                    }
                } 
                if (processInput) {
                    familygenealogy.FamilyUnit existingFamilyUnit = digitalfamily.locateFamilyUnit(arg1_name);
                    if (existingFamilyUnit == null) {
                        System.out.println(arg1_name + " does not exist on the Family Tree.");
                        System.err.println("Ensure that you have Generated the FamilyTree by Inputting: GenerateFamily.");
                    } else {
                        if (arg2_name != null && arg2_kinship != null) {
                            try {
                                Field validkinship = familygenealogy.FamilyTree.class.getDeclaredField(arg2_kinship.toUpperCase());
                               
                                validkinship.setAccessible(true);                                 
                                try {
                                    digitalfamily.addNewFamilyMember(existingFamilyUnit, arg2_name, (Integer)(validkinship.get(Types.class)));                                                             
                                    System.out.println("Welcome to the family, " + arg2_name+ "! ");
                                } catch (familygenealogy.FamilyManagerException ex) {
                                    System.out.println(ex.getErrMessage());
                                    continue;
                                }   
                            } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {                                    
                                Logger.getLogger(FamilyGenealogy.class.getName()).log(Level.SEVERE, null, e);
                            } catch (NoSuchFieldException ex) {                                    
                                System.err.println("Family Relationship type " + arg2_kinship.toUpperCase() + " not allowed.");
                            }
                        } else if (arg1_kinship != null) {
                            try {                            
                                Field validkinship = familygenealogy.FamilyTree.class.getDeclaredField(arg1_kinship.toUpperCase());
                                validkinship.setAccessible(true);

                                ArrayList<familygenealogy.FamilyMember> familymembers = digitalfamily.locateKinsmen(existingFamilyUnit, (Integer)(validkinship.get(Types.class)));
                                StringBuilder strbuilder = new StringBuilder();
                                strbuilder.append(arg1_kinship + "=");
                                if (familymembers.isEmpty()) {
                                    strbuilder.append(" None.  ");
                                } else {
                                    for (familygenealogy.FamilyMember familymember : familymembers) {
                                        strbuilder.append(familymember.getName()).append(", ");
                                    }
                                }
                                //Remove the last '", "'
                                System.out.println("Output: " + strbuilder.substring(0, strbuilder.length() - 2));
                                   
                            } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
                                    // TODO Auto-generated catch block
                                Logger.getLogger(FamilyGenealogy.class.getName()).log(Level.SEVERE, null, e);
                            } catch (NoSuchFieldException ex) {                                    
                                System.err.println("Family Relationship type " + arg1_kinship.toUpperCase() + " not allowed.");
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid format. Please try again...");
                }
            }
        }
        catch (familygenealogy.FamilyManagerException ex) {
            System.err.println(ex.getErrMessage());
        }        finally {
                if(keyboard != null){ 
                    keyboard.close();
                }
        }


    }

}
    

