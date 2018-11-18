/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familygenealogy;

import java.util.Objects;
import java.util.ArrayList;

/**
 *
 * @author oluwole.bejide
 */

/*
* FamilyMember is the object to represent whosoever is a member of the family
* be it Male Or Female, Young or Old.
*/
public class FamilyMember {
    
    
    private String name;
    private int gender;
    
    /**
    * @param name
    */
    public FamilyMember(String name) {
        super();
        this.name = name.toLowerCase();
        this.gender = FamilyTree.MALE; //Set default gender as male
    }
    
    /**
    * @param name
    * @param gender
    */
    public FamilyMember(String name, int gender) {
        super();
        this.name = name.toLowerCase();
        this.gender = gender; //Set default gender as male
    }    
    
    /**
    * @param gender
    */
    public void setGender(int gender){
        this.gender = gender;
    }
    /**
    * @return gender
    */
    public int getGender(){
        return this.gender;
    }  
    
    /**
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * @return name
    */
    public String getName(){
        return this.name;
    }     
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FamilyMember other = (FamilyMember) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
            return " {{name=" + this.name + ", gender=" + this.gender + "}} ";
    }
        
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
}
