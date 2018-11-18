/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familygenealogy;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 *
 * @author oluwole.bejide
 */
public class FamilyTree {

    /**
     * @param args the command line arguments
     */
        
    private final LinkedList<FamilyMember> familyTree;
    
    /*
    * Gender
    */
    public static final int MALE = 1;
    public static final int FEMALE = 2;
    
    /*
    * Family Relationships
    */
    public static final int FATHER = 1;
    public static final int MOTHER = 2;
    public static final int HUSBAND = 3;
    public static final int WIFE = 4;
    public static final int SON = 5;
    public static final int SONS = 6;
    public static final int DAUGHTER = 7;
    public static final int DAUGHTERS = 8;
    public static final int BROTHER = 9;
    public static final int BROTHERS = 10;
    public static final int SISTER = 11;
    public static final int SISTERS = 12;
    public static final int GRANDFATHER = 13;
    public static final int GRANDMOTHER = 14;
    public static final int GRANDSON = 15;
    public static final int GRANDSONS = 16;
    public static final int GRANDDAUGHTER = 17;
    public static final int GRANDDAUGHTERS = 18;
    public static final int PARENT = 19;
    public static final int PARENTS = 20;
    public static final int SIBLINGS = 21;
    public static final int UNCLE = 22;
    public static final int UNCLES = 23;
    public static final int AUNT = 24;
    public static final int AUNTS = 25;
    public static final int COUSIN = 26;
    public static final int COUSINS = 27;
    public static final int NEPHEW = 28;
    public static final int NEPHEWS = 29;
    public static final int NIECE = 30;
    public static final int NIECES = 31;
    
    public FamilyTree() {
        this.familyTree = new LinkedList<>();
    }

    public void addFamilyMember(String name) {
        this.familyTree.add(new FamilyMember(name));
    }

    public LinkedList<FamilyMember> getFamilyTree() {
        return familyTree;
    }

    public FamilyMember getFamilyMember(String name) {
        return familyTree.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

//    public ArrayList<FamilyMember> getParents(String child) {            
//        ArrayList<FamilyMember> parents = new ArrayList<>();
//        this.familyTree.stream().forEach(familymember -> {
//                    familymember.getChildren().stream().forEach(children -> {
//                        if (children.getName().equals(child)) {
//                            parents.add(familymember);
//                        }
//                    });
//                });
//        return parents;
//    }    

//    public boolean hasParents(String name) {
//        return !getParents(name).isEmpty();
//    }
}
