/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg6.pkg2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        StringBuffer stringBuffer = new StringBuffer();
        
        try (
             
            FileReader fileReader = new FileReader(".\\src\\data.txt");
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
             
            Scanner scanner = new Scanner(bufferedReader);)
        {
            while(scanner.hasNext())
            {
                stringBuffer.append(scanner.nextLine());
            }          
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            
            ex.printStackTrace();
        }
        
        Scanner scanner = new Scanner(System.in);
        
        String  type = null;
        
        do
        {
            System.out.println("input type");
            
            type = scanner.next();
            
            switch(type)
            {
                case "int":
                    find(stringBuffer.toString(), "[0-9]+");
                break;
                    
                case "double":
                    find(stringBuffer.toString(),"[0-9]+[\\.,]{1}[0-9]+");
                break;
                
                case "string":
                    find(stringBuffer.toString(),"[\\w]+");
                    
                break;             
                
            }
            
            
        }
        while(!type.equals("exit"));
        
        
        
    }
    
    
    public static void  find(String text, String  rule)
    {
        Pattern pattern = Pattern.compile(rule);
        
        Matcher matcher = pattern.matcher(text);
        
        String substring = null;
        
        while(matcher.find())
        {
            int start = matcher.start();
            
            int end = matcher.end();
            
            substring = text.substring(start, end);
            
            System.out.println(substring);           
            
        }
        
        
    }
    
    
}
