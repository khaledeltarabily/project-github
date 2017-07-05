/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta;

import java.time.ZonedDateTime;

/**
 *
 * @author khaled-pc
 */
public class Beta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Connection_and_Database_OPerations s=new Connection_and_Database_OPerations();
    s.insert_bells(ZonedDateTime.now().toString(), 32355, "3m 5aled el 8by", 2, null);// TODO code application logic here
        }
    
}
