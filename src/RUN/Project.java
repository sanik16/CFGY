package RUN;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import ui.UI;

import redis.clients.jedis.Jedis;

public class Project {
	
    public static Jedis jedis;


	public static void main(String[] args) throws Exception {
  
    	//getConnection();
    	Redis();
    	UI ui = new UI();
    	ui.show();
    
    }
    
    public static Connection getConnection() throws Exception{
    	try{
    		
    		String driver = "com.mysql.jdbc.Driver";
    		String url = "jdbc:mysql://localhost:3316/cfgym";
    		String username = "root";
    		String password = "Alexander16";
    		Class.forName(driver);
    		
    		Connection conn = DriverManager.getConnection(url,username,password);
    		System.out.println("Connected");
    		return conn;
    		
    	} catch(Exception e) {Component okno = null;
				JOptionPane.showMessageDialog(okno,
						"Can´t connect to database!!!",
						"Inane error",
    		    JOptionPane.ERROR_MESSAGE);
    	}
    	
    	return null;
    	
    }
    
   
    public static void Redis(){
    	      jedis = new Jedis("localhost");
    	      System.out.println("Connection to server sucessfully");
    	      //check whether server is running or not
       	      System.out.println("Server is running: "+jedis.ping());
       	     
    }

	public static Jedis getJedis() {
		return jedis;
	}

	public static void setJedis(Jedis jedis) {
		Project.jedis = jedis;
	}
    
    
}
