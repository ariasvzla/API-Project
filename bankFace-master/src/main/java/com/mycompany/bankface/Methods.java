/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankface;
import java.util.Random;

/**
 *
 * @author Elian Arias
 */
public class Methods {
    Random rand = new Random();
     private int sortcode;
     private int accountnumber;
   
    
    
    public Methods(){
        
   
    }
    
    public void Generatesortcode (){
        
        
      //create a randon number for account and sort code
        sortcode = (int )(Math.random() * 50000 + 18888);
        accountnumber= (int)(Math.random() * 993333330 + 88833338);
 
    }
    public int getSortCode(){
        
        return sortcode;
    }
    public int getAccountNumber(){
        return accountnumber;
    }
    
    
}
