/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familygenealogy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oluwole.bejide
 */
public class FamilyManager {

    /**
     * This is useful for quick search lookup
     */
    private final HashMap<String, FamilyUnit> lineages = new HashMap<String, FamilyUnit>();
    
    private ArrayList<FamilyUnit> lineage = new ArrayList<>();
    
    
    public void generateRandomGenealogy(){
        System.out.println("Generating Family Tree, Please Wait...");
        try {
            //These are the roots of all ancestors, out of which all other families protrude.
            FamilyMember adam = new FamilyMember("Adam", FamilyTree.MALE);
            FamilyMember eve = new FamilyMember("Eve", FamilyTree.FEMALE);
            this.createLineageRoot(adam, eve);
            
            ArrayList<FamilyMember> adamschildren = new ArrayList<>();
            FamilyMember cain = new FamilyMember("Cain", FamilyTree.MALE);
            FamilyMember abel = new FamilyMember("Abel", FamilyTree.MALE);
            FamilyMember zitasah = new FamilyMember("Zitasah", FamilyTree.FEMALE);
            
            //Adam and Eve had three children
            adamschildren.add(cain);
            adamschildren.add(abel);
            adamschildren.add(zitasah);  
            this.populateChildren(lineage, adamschildren);
            
            //Cain died Wifeless, Childless. So pathetic!!! :( :( :( 
            //Abel got married to his wife Abela
            FamilyMember abelWife = new FamilyMember("Abela", FamilyTree.FEMALE);          
            this.gotMarried(abel, abelWife);           
            // Abel and His wife Abela had children Sons
            ArrayList<FamilyUnit> abel_abelWife_parent = new ArrayList<FamilyUnit>();
            abel_abelWife_parent.add(this.locateFamilyUnit("Abel"));
            abel_abelWife_parent.add(this.locateFamilyUnit("Abela"));            
            ArrayList<FamilyMember> abel_ableWife_children = new ArrayList<FamilyMember>();
            FamilyMember dickson = new FamilyMember("Dickson", FamilyTree.MALE);
            FamilyMember maverick = new FamilyMember("Maverick", FamilyTree.MALE);            
            abel_ableWife_children.add(dickson);
            abel_ableWife_children.add(maverick);
            this.populateChildren(abel_abelWife_parent, abel_ableWife_children);
            
            //Zitasah got married to her husband zitasahHusband
            FamilyMember zitasahHusband = new FamilyMember("Zita", FamilyTree.MALE); 
            this.gotMarried(zitasah, zitasahHusband);
            // Zitasah and Her Husband Zita had children 3 Daugthers
            ArrayList<FamilyUnit> zitasah_zitasahHusb_parent = new ArrayList<FamilyUnit>();
            zitasah_zitasahHusb_parent.add(this.locateFamilyUnit("Zita"));
            zitasah_zitasahHusb_parent.add(this.locateFamilyUnit("Zitasah"));            
            ArrayList<FamilyMember> zitasah_zitasahHusb_children = new ArrayList<FamilyMember>();
            FamilyMember semi = new FamilyMember("Semi", FamilyTree.FEMALE);
            FamilyMember seyi = new FamilyMember("Seyi", FamilyTree.FEMALE);  
            FamilyMember sola = new FamilyMember("Sola", FamilyTree.MALE);            
            zitasah_zitasahHusb_children.add(semi);
            zitasah_zitasahHusb_children.add(seyi);
            zitasah_zitasahHusb_children.add(sola);
            this.populateChildren(zitasah_zitasahHusb_parent, zitasah_zitasahHusb_children);            
            
            //Maverick got married
            FamilyMember maverickWife = new FamilyMember("Mavericka", FamilyTree.FEMALE);
            this.gotMarried(maverick, maverickWife);            
            // Maverick and His wife Mavericka had children two daugther and one son
            ArrayList<FamilyUnit> maverick_maverickWife_parent = new ArrayList<FamilyUnit>();
            maverick_maverickWife_parent.add(this.locateFamilyUnit("Maverick"));
            maverick_maverickWife_parent.add(this.locateFamilyUnit("Mavericka"));            
            ArrayList<FamilyMember> maverick_maverickWife_children = new ArrayList<FamilyMember>();
            FamilyMember honey = new FamilyMember("Honey", FamilyTree.FEMALE);
            FamilyMember sophia = new FamilyMember("Sophia", FamilyTree.FEMALE); 
            FamilyMember soko = new FamilyMember("Soko", FamilyTree.MALE);            
            maverick_maverickWife_children.add(honey);
            maverick_maverickWife_children.add(sophia);
            maverick_maverickWife_children.add(soko);
            this.populateChildren(maverick_maverickWife_parent, maverick_maverickWife_children); 
            
            //Dickson got married
            FamilyMember dicksonWife = new FamilyMember("Dicksona", FamilyTree.FEMALE);
            this.gotMarried(dickson, dicksonWife);            
            // Dickson and His wife Dicksona had children two daugther and one son
            ArrayList<FamilyUnit> dickson_dicksonWife_parent = new ArrayList<FamilyUnit>();
            dickson_dicksonWife_parent.add(this.locateFamilyUnit("Dickson"));
            dickson_dicksonWife_parent.add(this.locateFamilyUnit("Dicksona"));            
            ArrayList<FamilyMember> dickson_dicksonWife_children = new ArrayList<FamilyMember>();
            FamilyMember poon = new FamilyMember("Poon", FamilyTree.FEMALE);
            FamilyMember jigawa = new FamilyMember("Jigawa", FamilyTree.MALE); 
            FamilyMember zoluka = new FamilyMember("Zoluka", FamilyTree.MALE);             
            dickson_dicksonWife_children.add(poon);
            dickson_dicksonWife_children.add(jigawa);
            dickson_dicksonWife_children.add(zoluka);
            this.populateChildren(dickson_dicksonWife_parent, dickson_dicksonWife_children);
                        
            //Semi got married to her husband semiHusband
            FamilyMember semiHusband = new FamilyMember("Sem", FamilyTree.MALE); 
            this.gotMarried(semi, semiHusband);
            // Semi and Her Husband Sem had children 1 Daugther
            ArrayList<FamilyUnit> semi_semiHusb_parent = new ArrayList<FamilyUnit>();
            semi_semiHusb_parent.add(this.locateFamilyUnit("Sem"));
            semi_semiHusb_parent.add(this.locateFamilyUnit("Semi"));            
            ArrayList<FamilyMember> semi_semiHusb_children = new ArrayList<FamilyMember>();
            FamilyMember seul = new FamilyMember("Seul", FamilyTree.FEMALE);           
            semi_semiHusb_children.add(semi);
            this.populateChildren(semi_semiHusb_parent, semi_semiHusb_children);  
                        
            //Seyi got married to her husband seyiHusband
            FamilyMember seyiHusband = new FamilyMember("Sey", FamilyTree.MALE); 
            this.gotMarried(seyi, seyiHusband);
            // Semi and Her Husband Sem had children 1 Son
            ArrayList<FamilyUnit> seyi_seyiHusb_parent = new ArrayList<FamilyUnit>();
            seyi_seyiHusb_parent.add(this.locateFamilyUnit("Sey"));
            seyi_seyiHusb_parent.add(this.locateFamilyUnit("Seyi"));            
            ArrayList<FamilyMember> seyi_seyiHusb_children = new ArrayList<FamilyMember>();
            FamilyMember yun = new FamilyMember("Yun", FamilyTree.MALE);           
            seyi_seyiHusb_children.add(yun);
            this.populateChildren(seyi_seyiHusb_parent, seyi_seyiHusb_children); 
                        
            //Sola got married to his wife solaWife
            FamilyMember solaWife = new FamilyMember("Solara", FamilyTree.MALE); 
            this.gotMarried(sola, solaWife);
            // Semi and Her Husband Sem had children 1 Son
            ArrayList<FamilyUnit> sola_solaWife_parent = new ArrayList<FamilyUnit>();
            sola_solaWife_parent.add(this.locateFamilyUnit("Sola"));
            sola_solaWife_parent.add(this.locateFamilyUnit("Solara"));            
            ArrayList<FamilyMember> sola_solaWife_children = new ArrayList<FamilyMember>();
            FamilyMember seun = new FamilyMember("Seun", FamilyTree.MALE);           
            sola_solaWife_children.add(yun);
            this.populateChildren(sola_solaWife_parent, sola_solaWife_children); 
            
              
        } catch (FamilyManagerException ex) {
            ex.getErrMessage();
        }
        this.displayGenealogy();

        
    }
    
    public String generateGenealogy()throws FamilyManagerException{
        System.out.println("Generating Family Tree for Assignment, Please Wait...");
        try {
            //These are the roots of all ancestors, out of which all other families protrude.
            FamilyMember evan = new FamilyMember("Evan", FamilyTree.MALE);
            FamilyMember diana = new FamilyMember("Diana", FamilyTree.FEMALE);
            this.createLineageRoot(evan, diana);            
            ArrayList<FamilyMember> evanchildren = new ArrayList<>();
            FamilyMember john = new FamilyMember("John", FamilyTree.MALE);
            FamilyMember alex = new FamilyMember("Alex", FamilyTree.MALE);
            FamilyMember joe = new FamilyMember("Joe", FamilyTree.MALE);
            FamilyMember nisha = new FamilyMember("Nisha", FamilyTree.FEMALE);            
            //Evan and Diana's Children
            evanchildren.add(john);
            evanchildren.add(alex);
            evanchildren.add(joe);  
            evanchildren.add(nisha);
            this.populateChildren(lineage, evanchildren);
            
            //John died Wifeless, Childless. So pathetic!!! :( :( :( 
            //Alex got married to his wife Nancy
            FamilyMember nancy = new FamilyMember("Nancy", FamilyTree.FEMALE);          
            this.gotMarried(alex, nancy);           
            // Alex and Nancy's Children
            ArrayList<FamilyUnit> alex_nancy_parent = new ArrayList<FamilyUnit>();
            alex_nancy_parent.add(this.locateFamilyUnit("Alex"));
            alex_nancy_parent.add(this.locateFamilyUnit("Nancy"));            
            ArrayList<FamilyMember> alex_nancy_children = new ArrayList<FamilyMember>();
            FamilyMember jacob = new FamilyMember("Jacob", FamilyTree.MALE);
            FamilyMember shaun = new FamilyMember("Shaun", FamilyTree.MALE);            
            alex_nancy_children.add(jacob);
            alex_nancy_children.add(shaun);
            this.populateChildren(alex_nancy_parent, alex_nancy_children);
            
            //Joe got married to his wife ifi
            FamilyMember niki = new FamilyMember("Niki", FamilyTree.FEMALE); 
            this.gotMarried(joe, niki);
            //Joe and Niki's Children
            ArrayList<FamilyUnit> joe_niki_parent = new ArrayList<FamilyUnit>();
            joe_niki_parent.add(this.locateFamilyUnit("Joe"));
            joe_niki_parent.add(this.locateFamilyUnit("Niki"));            
            ArrayList<FamilyMember> joe_niki_children = new ArrayList<FamilyMember>();
            FamilyMember piers = new FamilyMember("Piers", FamilyTree.MALE); 
            FamilyMember sally = new FamilyMember("Sally", FamilyTree.FEMALE);            
            joe_niki_children.add(piers);
            joe_niki_children.add(sally);
            this.populateChildren(joe_niki_parent, joe_niki_children);            
            
            //Nisha got married to Adam
            FamilyMember adam = new FamilyMember("Adam", FamilyTree.MALE);
            this.gotMarried(nisha, adam);            
            // Nisha and her Husband Adam had children one daugther and one son
            ArrayList<FamilyUnit> adam_nisha_parent = new ArrayList<FamilyUnit>();
            adam_nisha_parent.add(this.locateFamilyUnit("Adam"));
            adam_nisha_parent.add(this.locateFamilyUnit("Nisha"));            
            ArrayList<FamilyMember> adam_nisha_children = new ArrayList<FamilyMember>();
            FamilyMember ruth = new FamilyMember("Ruth", FamilyTree.FEMALE);
            FamilyMember william = new FamilyMember("William", FamilyTree.MALE);  
            FamilyMember paul = new FamilyMember("Paul", FamilyTree.MALE);      
            adam_nisha_children.add(ruth);
            adam_nisha_children.add(paul);
            adam_nisha_children.add(william);
            this.populateChildren(adam_nisha_parent, adam_nisha_children); 
            
            //Jacob got married to Rufi
            FamilyMember rufi = new FamilyMember("Rufi", FamilyTree.FEMALE);
            this.gotMarried(jacob, rufi);            
            // Jacob and Rufi had a Son and A Daugther
            ArrayList<FamilyUnit> jacob_rufi_parent = new ArrayList<FamilyUnit>();
            jacob_rufi_parent.add(this.locateFamilyUnit("Jacob"));
            jacob_rufi_parent.add(this.locateFamilyUnit("Rufi"));            
            ArrayList<FamilyMember> jacob_rufi_children = new ArrayList<FamilyMember>();
            FamilyMember bern = new FamilyMember("Bern", FamilyTree.MALE);
            FamilyMember sophia = new FamilyMember("Sophia", FamilyTree.FEMALE);             
            jacob_rufi_children.add(bern);
            jacob_rufi_children.add(sophia);
            this.populateChildren(jacob_rufi_parent, jacob_rufi_children);
                        
            //Piers got married to Pippa
            FamilyMember pippa = new FamilyMember("Pippa", FamilyTree.FEMALE); 
            this.gotMarried(piers, pippa);
            // Piers and Pippa had a Daugther
            ArrayList<FamilyUnit> piers_pippa_parent = new ArrayList<FamilyUnit>();
            piers_pippa_parent.add(this.locateFamilyUnit("Piers"));
            piers_pippa_parent.add(this.locateFamilyUnit("Pippa"));            
            ArrayList<FamilyMember> piers_pippa_children = new ArrayList<FamilyMember>();
            FamilyMember sarah = new FamilyMember("Sarah", FamilyTree.FEMALE);           
            piers_pippa_children.add(sarah);
            this.populateChildren(piers_pippa_parent, piers_pippa_children);  
                        
            //Sally got married to Owen but did not have Children
            FamilyMember owen = new FamilyMember("Owen", FamilyTree.MALE); 
            this.gotMarried(sally, owen);
                        
            //Ruth got married to Neil but did not have Children
            FamilyMember niel = new FamilyMember("Neil", FamilyTree.MALE); 
            this.gotMarried(ruth, niel);
                        
            //Paul got married to Zoe and had a Son
            FamilyMember zoe = new FamilyMember("Zoe", FamilyTree.FEMALE); 
            this.gotMarried(paul, zoe);
            // Paul and Zoe had a Son
            ArrayList<FamilyUnit> paul_zoe_parent = new ArrayList<FamilyUnit>();
            paul_zoe_parent.add(this.locateFamilyUnit("Paul"));
            paul_zoe_parent.add(this.locateFamilyUnit("Zoe"));            
            ArrayList<FamilyMember> paul_zoe_children = new ArrayList<FamilyMember>();
            FamilyMember roger = new FamilyMember("Roger", FamilyTree.MALE);           
            paul_zoe_children.add(roger);
            this.populateChildren(paul_zoe_parent, paul_zoe_children); 
                        
            //William got married to Rose and had a Son
            FamilyMember rose = new FamilyMember("Rose", FamilyTree.FEMALE); 
            this.gotMarried(william, rose);
            // Piers and Pippa had a Daugther
            ArrayList<FamilyUnit> william_rose_parent = new ArrayList<FamilyUnit>();
            william_rose_parent.add(this.locateFamilyUnit("William"));
            william_rose_parent.add(this.locateFamilyUnit("Rose"));            
            ArrayList<FamilyMember> william_rose_children = new ArrayList<FamilyMember>();
            FamilyMember steve = new FamilyMember("Steve", FamilyTree.MALE);           
            william_rose_children.add(steve);
            this.populateChildren(william_rose_parent, william_rose_children); 
            
            //Sophia got married to George but did not have Children
            FamilyMember george = new FamilyMember("George", FamilyTree.MALE); 
            this.gotMarried(sophia, george); 
            
            //Sarah got married to Peter but did not have Children
            FamilyMember peter = new FamilyMember("Peter", FamilyTree.MALE); 
            this.gotMarried(sarah, peter); 
            
              
        } catch (FamilyManagerException ex) {
            ex.getErrMessage();
        }
        return this.displayGenealogy();

        
    }

    /**
     * @param lineage
     */
    public void setLineage(ArrayList<FamilyUnit> lineage) {
            this.lineage = lineage;
    }
    /**
     * @return the lineage
     */
    public ArrayList<FamilyUnit> getLineage() {
            return lineage;
    }

    /**
     * @param FamilyMember
     * @return FamilyUnit
     * Create a New family unit and add to the family lineages for fast lookup
     */
    protected FamilyUnit createPotentialFamilyUnit(FamilyMember newmember) {
            FamilyUnit newfamilyunit = new FamilyUnit();
            newfamilyunit.setSelf(newmember);
            newfamilyunit.setName(newmember.getName());
            this.lineages.put(newmember.getName().toLowerCase(), newfamilyunit);
            return newfamilyunit;
    }
    
    /**
     * @param name
     * @return FamilyUnit
     */
    public FamilyUnit locateFamilyUnit(String name) {
            return this.lineages.get(name.toLowerCase());
    }

    /**
     * @param fiancee
     * @param fiance
     * @throws familytree.FamilyManagerException
     */
    public void createLineageRoot(FamilyMember fiance, FamilyMember fiancee) throws FamilyManagerException {
            if(fiancee==null || fiance==null){
                throw new FamilyManagerException("A valid Husband and Wife is needed to make a valid lineage root");
            }
            FamilyUnit husband = createPotentialFamilyUnit(fiance);
            FamilyUnit wife = createPotentialFamilyUnit(fiancee);
            lineage.add(husband);
            lineage.add(wife);
            wife.setSpouse(husband);
            husband.setSpouse(wife);
    }

    /**
     * @param fiance
     * @param fiancee
     * @throws familytree.FamilyManagerException
     */
    public void gotMarried(FamilyMember fromthisfamily, FamilyMember fromanotherfamily) throws FamilyManagerException {
            if(fromanotherfamily==null || fromthisfamily==null){
                throw new FamilyManagerException("A valid Husband and Wife is needed to make a valid marriage");
            }
            FamilyUnit marriable = this.locateFamilyUnit(fromthisfamily.getName()); //This could be a marriageable son or daughter in our family
            if (marriable == null) {
                throw new FamilyManagerException(fromthisfamily.getName() + " does not seem to be from this Family. Where did " + fromanotherfamily.getName() + " get " + fromthisfamily.getName() + "from? :):)");
            } else {
                FamilyUnit marriableanotherfamily = createPotentialFamilyUnit(fromanotherfamily); //This could be a son or daughter from an external family who is marriageble.
                marriableanotherfamily.setSpouse(marriable);
                marriable.setSpouse(marriableanotherfamily);
            }
    }

    /**
     * @param parents
     * @param children
     * @throws familytree.FamilyManagerException
     */
    public void populateChildren(ArrayList<FamilyUnit> parents, ArrayList<FamilyMember> children) throws FamilyManagerException {
        if(children != null && parents != null) {
            ArrayList<FamilyUnit> allChildren = new ArrayList<>();
            //For every child aportion the parents
            for (FamilyMember eachchild : children) {
                FamilyUnit child = createPotentialFamilyUnit(eachchild);
                child.setParents(parents);
                //Add new child to list to be aportioned to each parents later.
                allChildren.add(child);
            }
            //For each parent, save a copy of all the children
            for (FamilyUnit parent : parents) {
                    parent.setChildren(allChildren);
            }
            //Save a copy of all the children as siblings in each child
            for (FamilyUnit eachchild : allChildren) {
                
                ArrayList<FamilyUnit> eachchildsiblings = eachchild.getSiblings();
                if (eachchildsiblings != null) {
                    for (FamilyUnit child : allChildren) {
                        if (!eachchild.getName().equalsIgnoreCase(child.getName())) {
                                eachchildsiblings.add(child);
                        }
                    }                  
                } else {
                    eachchildsiblings = new ArrayList<FamilyUnit>();
                }
            }
        }else {
            throw new FamilyManagerException("An existing set of children must have existing parent");
        }

    }
    
    /**     * 
     * @param familyunit
     * @param kinship
     * @return ArrayList<FamilyMember>
     */
    public ArrayList<FamilyMember> locateKinsmen(FamilyUnit familyunit, int kinship) {
        ArrayList<FamilyMember> familymembers = new ArrayList<FamilyMember>();
        ArrayList<FamilyUnit> siblings = familyunit.getSiblings();
        ArrayList<FamilyUnit> children = familyunit.getChildren();
        FamilyUnit spouse = familyunit.getSpouse();
        ArrayList<FamilyUnit> parents = familyunit.getParents();
        switch(kinship){
            case FamilyTree.PARENT:
            case FamilyTree.PARENTS:
                if (parents != null) {
                    for (FamilyUnit parent : parents) {
                        familymembers.add(parent.getSelf());
                    }
                }
                break;
            case FamilyTree.SISTER:
            case FamilyTree.SISTERS:
                if (siblings != null) {
                    for (FamilyUnit sibling : siblings) {
                        if (sibling.getSelf().getGender() == FamilyTree.FEMALE) {
                            familymembers.add(sibling.getSelf());
                        }
                    }
                }
                break;
            case FamilyTree.BROTHER:
            case FamilyTree.BROTHERS:
                if (siblings != null) {
                    for (FamilyUnit sibling : siblings) {
                        if (sibling.getSelf().getGender() == FamilyTree.MALE) {
                                familymembers.add(sibling.getSelf());
                        }
                    }
                }
                break;
            case FamilyTree.SIBLINGS:
                if (siblings != null) {
                    siblings.forEach((sibling) -> {
                        familymembers.add(sibling.getSelf());
                    });
                }
                break;
            case FamilyTree.DAUGHTER:
            case FamilyTree.DAUGHTERS:
                if (children != null) {
                    for (FamilyUnit child : children) {
                        if (child.getSelf().getGender() == FamilyTree.FEMALE) {
                                familymembers.add(child.getSelf());
                        }
                    }
                }
                break;
            case FamilyTree.SON:
            case FamilyTree.SONS:
                if (children != null) {
                    for (FamilyUnit child : children) {
                        if (child.getSelf().getGender() == FamilyTree.MALE) {
                                familymembers.add(child.getSelf());
                        }
                    }
                }
                break;
            case FamilyTree.WIFE:
                if (spouse != null) {
                    if(spouse.getSelf().getGender() == FamilyTree.FEMALE){
                        familymembers.add(spouse.getSelf());
                    }
                }
                break;
            case FamilyTree.HUSBAND:
                if (spouse != null) {
                    if(spouse.getSelf().getGender() == FamilyTree.MALE){
                        familymembers.add(spouse.getSelf());
                    }
                }
                break;
            case FamilyTree.FATHER:
                if (parents != null) {
                    for (FamilyUnit parent : parents) {
                        if (parent.getSelf().getGender() == FamilyTree.MALE) {
                                familymembers.add(parent.getSelf());
                        }
                    }
                }
                break;
            case FamilyTree.MOTHER:
                if (parents != null) {
                    for (FamilyUnit parent : parents) {
                        if (parent.getSelf().getGender() == FamilyTree.FEMALE) {
                                familymembers.add(parent.getSelf());
                        }
                    }
                }
                break;
            case FamilyTree.GRANDFATHER:
                if (parents != null) {
                    for (FamilyUnit parent : parents) {
                        ArrayList<FamilyUnit> parentparents = parent.getParents();
                        if(parentparents != null){
                            for (FamilyUnit parentparent : parentparents) {
                                if (parentparent.getSelf().getGender() == FamilyTree.MALE) {
                                        familymembers.add(parentparent.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
            case FamilyTree.GRANDMOTHER:
                if (parents != null) {
                    for (FamilyUnit parent : parents) {
                        ArrayList<FamilyUnit> parentparents = parent.getParents();
                        if(parentparents != null){
                            for (FamilyUnit parentparent : parentparents) {
                                if (parentparent.getSelf().getGender() == FamilyTree.FEMALE) {
                                        familymembers.add(parentparent.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
            case FamilyTree.GRANDSON:
            case FamilyTree.GRANDSONS:
                if (children != null) {
                    for (FamilyUnit child : children) {
                        ArrayList<FamilyUnit> childrenchildren = child.getChildren();
                        if(childrenchildren != null){
                            for (FamilyUnit childchild : childrenchildren) {
                                if (childchild.getSelf().getGender() == FamilyTree.MALE) {
                                        familymembers.add(childchild.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
            case FamilyTree.GRANDDAUGHTER:
            case FamilyTree.GRANDDAUGHTERS:
                if (children != null) {
                    for (FamilyUnit child : children) {
                        ArrayList<FamilyUnit> childrenchildren = child.getChildren();
                        if(childrenchildren != null){
                            for (FamilyUnit childchild : childrenchildren) {
                                if (childchild.getSelf().getGender() == FamilyTree.FEMALE) {
                                        familymembers.add(childchild.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
            case FamilyTree.UNCLE:
            case FamilyTree.UNCLES:
                if (parents != null) {
                    for (FamilyUnit parent : parents) {
                        ArrayList<FamilyUnit> parentsiblings = parent.getSiblings();
                        if(parentsiblings != null){
                            for (FamilyUnit parentsibling : parentsiblings) {
                                if (parentsibling.getSelf().getGender() == FamilyTree.MALE) {
                                        familymembers.add(parentsibling.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
            case FamilyTree.AUNT:
            case FamilyTree.AUNTS:
                if (parents != null) {
                    for (FamilyUnit parent : parents) {
                        ArrayList<FamilyUnit> parentsiblings = parent.getSiblings();
                        if(parentsiblings != null){
                            for (FamilyUnit parentsibling : parentsiblings) {
                                if (parentsibling.getSelf().getGender() == FamilyTree.FEMALE) {
                                        familymembers.add(parentsibling.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
            case FamilyTree.COUSIN:
            case FamilyTree.COUSINS:
                if (parents != null) {
                    for (FamilyUnit parent : parents) {
                        ArrayList<FamilyUnit> parentsiblings = parent.getSiblings();
                        if(parentsiblings != null){
                            for (FamilyUnit parentsibling : parentsiblings) {
                                 ArrayList<FamilyUnit> parentsiblingschildren = parentsibling.getChildren();
                                 for (FamilyUnit parentsiblingschild : parentsiblingschildren) {
                                        familymembers.add(parentsiblingschild.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
            case FamilyTree.NEPHEW:
            case FamilyTree.NEPHEWS:
                if (siblings != null) {
                    for (FamilyUnit sibling : siblings) {
                        ArrayList<FamilyUnit> siblingchildren = sibling.getChildren();
                        if(siblingchildren != null){
                            for (FamilyUnit siblingchild : siblingchildren) {
                                if (siblingchild.getSelf().getGender() == FamilyTree.MALE) {
                                        familymembers.add(siblingchild.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
            case FamilyTree.NIECE:
            case FamilyTree.NIECES:
                if (siblings != null) {
                    for (FamilyUnit sibling : siblings) {
                        ArrayList<FamilyUnit> siblingchildren = sibling.getChildren();
                        if(siblingchildren != null){
                            for (FamilyUnit siblingchild : siblingchildren) {
                                if (siblingchild.getSelf().getGender() == FamilyTree.FEMALE) {
                                        familymembers.add(siblingchild.getSelf());
                                }
                            }
                        }
                    }
                }
                break;
        }             

        return familymembers;

    }

    /**
     * @param existingmember
     * @param membername
     * @param kinship
     * Add new member into the family from the bottom of the family tree
     * @throws familytree.FamilyManagerException
     */
    public void addNewFamilyMember(FamilyUnit existingmember, String membername, int kinship) throws FamilyManagerException{
            FamilyUnit FamilyUnit = this.locateFamilyUnit(membername);
            boolean isPartner = false;
            if (FamilyUnit != null) {
                throw new FamilyManagerException(membername + " is already a member of the family!");                    
            } else {
                switch(kinship){
                    case FamilyTree.WIFE:
                        FamilyUnit wifey = this.createPotentialFamilyUnit(new FamilyMember(membername, FamilyTree.FEMALE));
                        if (wifey != null && existingmember != null) {                            
                            if(existingmember.getSpouse() != null){
                                throw new FamilyManagerException(existingmember.getName() + " is Married Already. Polygamy not allowed. :):)");
                            }
                            if(existingmember.getSelf().getGender() == FamilyTree.FEMALE){
                                throw new FamilyManagerException(existingmember.getName() + " can only marry a man ;) ;)");
                            }
                            existingmember.setSpouse(wifey);
                            wifey.setSpouse(existingmember);
                        }
                        else{
                            throw new FamilyManagerException("Both Husband and Wife should exist.");
                        }
                        break;
                    case FamilyTree.HUSBAND:
                        FamilyUnit hubby = this.createPotentialFamilyUnit(new FamilyMember(membername, FamilyTree.MALE));
                        if (hubby != null && existingmember != null) {                            
                            if(existingmember.getSpouse() != null){
                                throw new FamilyManagerException(existingmember.getName() + " is Married Already. Polygamy not allowed. :):)");
                            }
                            if(existingmember.getSelf().getGender() == FamilyTree.MALE){
                                throw new FamilyManagerException(existingmember.getName() + " can only marry a woman ;) ;)");
                            }
                            existingmember.setSpouse(hubby);
                            hubby.setSpouse(existingmember);
                        }
                        else{
                            throw new FamilyManagerException("Both Husband and Wife should exist.");
                        }
                        break;
                    case FamilyTree.SON:
                        FamilyUnit newson = this.createPotentialFamilyUnit(new FamilyMember(membername, FamilyTree.MALE));     
                        if(newson != null && existingmember != null){                                 
                            if(existingmember.getSpouse() == null){
                                throw new FamilyManagerException(existingmember.getName() + " must be married before having a Son. Adoption not allowed. ;) ;)");
                            }                                           
                            //Set Father and Mother for newly created son
                            newson.getParents().add(existingmember);
                            newson.getParents().add(existingmember.getSpouse());

                            //Inform the remaining older children that they have a new brother
                            ArrayList<FamilyUnit> olderChildren = existingmember.getChildren();
                            if(olderChildren != null){
                                for (FamilyUnit eachchild : olderChildren) {
                                    //Inform each elder child that he/she has a brother                                
                                    eachchild.getSiblings().add(newson);
                                    //inform the new son that he has a new sibling
                                    newson.getSiblings().add(eachchild);
                                }
                            }
                            existingmember.getChildren().add(newson);
                        }
                        else{
                            throw new FamilyManagerException("Both Parent and Son should exist.");
                        }
                        break;
                    case FamilyTree.DAUGHTER:
                        FamilyUnit newdaughter = this.createPotentialFamilyUnit(new FamilyMember(membername, FamilyTree.FEMALE));
                        if(newdaughter != null && existingmember != null){                                 
                            if(existingmember.getSpouse() == null){
                                throw new FamilyManagerException(existingmember.getName() + " must be married before having a Daugther. Adoption not allowed. ;) ;)");
                            }    
                            //Set Father and Mother for newly created son
                            newdaughter.getParents().add(existingmember);
                            newdaughter.getParents().add(existingmember.getSpouse());

                            //Inform the remaining older children that they have a new brother
                            ArrayList<FamilyUnit> olderChildren = existingmember.getChildren();
                            if(olderChildren != null){
                                for (FamilyUnit eachchild : olderChildren) {
                                    //Inform each elder child that he/she has a brother                                
                                    eachchild.getSiblings().add(newdaughter);
                                    //inform the new son that he has a new sibling
                                    newdaughter.getSiblings().add(eachchild);
                                }
                            }
                            existingmember.getChildren().add(newdaughter);
                        }
                        break;
                    default:
                        throw new FamilyManagerException("Only A Husband, A Wife, A Son and A Daugther can be added to the Family tree");                        
                }
            }

    }
    
    
    /**
     * @return string
     */
    public String displayGenealogy() {
        StringBuilder strbuilder = new StringBuilder();
        for (FamilyUnit familyunit : lineage) {
            strbuilder.append(familyunit.toString()).append("\n");
            int initiallevel = 1;
            showDescendants(initiallevel, strbuilder, familyunit.getChildren());
        }
        return strbuilder.toString();
    }
    public void showDescendants(int familylevel, StringBuilder strbuilder, ArrayList<FamilyUnit> children){      
        int depth = familylevel;
        if (children != null) {
            for (FamilyUnit child : children) {
                do{
                    strbuilder.append("\t");
                    depth--;
                }while(depth > 0);
                ++depth;
                strbuilder.append(child.toString()).append("\n");
                showDescendants(depth, strbuilder, child.getChildren());
            }
        } 
        else {
                depth--;
        }
    }


    
}
