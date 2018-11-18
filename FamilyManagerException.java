/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familygenealogy;

/**
 *
 * @author DiGiT
 */
public class FamilyManagerException extends Exception {
    
    private String errmessage;
    public FamilyManagerException(String message) {
	this.errmessage = message;
    }       
    public void setErrMessage(String message){
        this.errmessage = message;
    }
    public String getErrMessage(){
        
        return this.errmessage;
    }
}
