package com.aspire.demo;
  
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        testCassandra1();
        // hello world
    }
    
    
    private static void testCassandra1() {
    	
    	String host = "127.0.0.1";
    	SimpleCassandraClient cc = new SimpleCassandraClient();
    	cc.connect(host); 
    	Session s = cc.getSession("demo_keyspace"); 
    	 
    	ResultSet rs = (ResultSet) s.execute("select * from demo_log");
    	for (Row r : rs) {
    	    System.out.println( r.getString("log_id"));
    	}
    } 
}
