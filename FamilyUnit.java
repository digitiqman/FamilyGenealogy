/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familygenealogy;
import java.util.ArrayList;
/**
 *
 * @author oluwole.bejide
 */
public class FamilyUnit {
	
        /*
        * List of Potential Family Units (Siblings, Parents, Children
        */
        private ArrayList<FamilyUnit> siblings= new ArrayList<FamilyUnit>(); 
        private ArrayList<FamilyUnit> parents = new ArrayList<FamilyUnit>();
        private ArrayList<FamilyUnit> children= new ArrayList<FamilyUnit>();
        
        /*
        * Personal Details
        */
        private String name;
        private FamilyMember self;
        private FamilyUnit spouse;
	
        /**
         * @constructor Creates a new Family Unit
        */
        public FamilyUnit() {
        }
                
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
        
	/**
	 * @param familymember
	 */
	public void setSelf(FamilyMember familymember) {
		this.self = familymember;
	}
	/**
	 * @return self
	 */
	public FamilyMember getSelf() {
		return self;
	}
        
	/**
	 * @param spouse (Husband/Wife)
	 */
	public void setSpouse(FamilyUnit spouse) {
		this.spouse = spouse;
	}
	/**
	 * @return spouse (Husband/Wife)
	 */
	public FamilyUnit getSpouse() {
		return spouse;
	}
        
	/**
	 * @param child
	 */
	public void addChild(FamilyUnit child) {
		this.children.add(child);
	}        
	/**
	 * @param children
	 */
	public void setChildren(ArrayList<FamilyUnit> children) {
		this.children = children;
	}
	/**
	 * @return children
	 */
	public ArrayList<FamilyUnit> getChildren() {
		return children;
	}
        
	/**
	 * @return siblings
	 */
	public ArrayList<FamilyUnit> getSiblings() {
		return siblings;
	}
	/**
	 * @param siblings
	 */
	public void setSiblings(ArrayList<FamilyUnit> siblings) {
		this.siblings = siblings;
	}
                
        /**
	 * @param parents
	 */
	public void setParents(ArrayList<FamilyUnit> parents) {
		this.parents = parents;
	}
	/**
	 * @return parents
	 */
	public ArrayList<FamilyUnit> getParents() {
		return parents;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(name).append(" ");
                sb.append(spouse != null ? ", spouse="+spouse.getName() : ", No Spouse ");
		if(children != null){
			sb.append(" Children={");
                        children.forEach((eachunit) -> {
                            sb.append(eachunit.getName()).append(" ");
                        });
			sb.append("} ");
		}else{
			sb.append(", No Child ");
		}
		if(siblings != null){
			sb.append(" Siblings=[");
                        siblings.forEach((eachunit) -> {
                            sb.append(eachunit.getName()).append(" ");
                        });
			sb.append("] ");
		}else{
			sb.append(", No Sibling ");

		}                
		if(parents != null){
                    sb.append(", Parents=(");
                    parents.forEach((parentFamilyUnit) -> {
                        sb.append(parentFamilyUnit.getName()).append(" ");
                    });
			sb.append(") ");
		}else{
			sb.append(", No Parent. ");

		}
		return sb.toString();
	}

	
	
	
}
