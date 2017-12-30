/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO-PC
 */
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
 
public class ChatServer {
public static void main (String[] argv) {
    try {
	    	System.setSecurityManager(new RMISecurityManager());
	    	Scanner s=new Scanner(System.in);
	    	System.out.println("Enter Your name and press Enter:");
	    	String name=s.nextLine().trim();
 
	    	Chat server = new Chat(name);	
 
	    	Naming.rebind("rmi://localhost/ABC", server);
 
	    	System.out.println("[System] Chat Remote Object is ready:");
 
	    	while(true){
	    		String msg=s.nextLine().trim();
	    		if (server.getClient()!=null){
	    			ChatInterface client=server.getClient();
	    			msg="["+server.getName()+"] "+msg;
	    			client.send(msg);
	    		}	
	    	}
 
    	}catch (Exception e) {
    		System.out.println("[System] Server failed: " + e);
   	}
	}
}
