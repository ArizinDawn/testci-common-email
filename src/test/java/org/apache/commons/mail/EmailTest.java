/*
 * Test function list for the 10 given functions out of the Email.java file in Main.
 * By: Justin Johnson
 */

package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.HashMap;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
public class EmailTest 
{
	//Filled test email list, 4 items
	private static final String[] TEST_EMAILS = {"xyz@xx.com", "xx.yp@r.org",
	"dhafjhkfffffff@alkfdkfja.com.bd", "jj@jj.jj"};
	
	// Concrete Email Class for test purposes
	private EmailDummy email;
	
	//Setup function
	@Before
	public void setUpEmailTest() throws Exception
	{
		email = new EmailDummy();
	}
	
	
	
	
	
	//Q.1, Tests the addBcc(String...) class
	//Two functions allow for 100% coverage on addBcc(String...) function
	@Test
	public void testAddBcc() throws Exception
	{
		//Tests an array of emails with data in them
		email.addBcc(TEST_EMAILS);
		assertEquals(4, email.getBccAddresses().size());
	
	}
	
	@Test
	public void testAddBccNull() throws Exception
	{
		try
		{
			//Tests an empty array of emails
			String[] emptyEmails = {};
			email.addBcc(emptyEmails);
		}
		catch (EmailException e)
		{
			
		}
		
	
	}
	
	
	
	
	
	
	//Q.2, Tests the addCc(String) class
	//One function allows for 100% coverage on addCc(String) function
	@Test
	public void testAddCc() throws Exception
	{
		//Tests a valid cc name
		email.addCc("xyz@xx.com");
	}
	
	
	
	
	
	//Q.3, Tests the addHeader(String name, String value) class
	//Three functions allow for 100% coverage on addHeader(String name, String value) function
	@Test
	public void testAddHeader() throws Exception
	{
		//Tests a valid header format
		email.addHeader("xyz@xx.com", "7");
	}
	
	@Test
	public void testAddHeaderValueNull() throws Exception
	{
		try 
		{
			//Tests header with a null on value
			email.addHeader("xyz@xx.com", null);
		}
		catch (IllegalArgumentException e)
		{
			
		}
	
	}
	
	@Test
	public void testAddHeaderNameNull() throws Exception
	{
		try 
		{
			//Tests header with a null on name
			email.addHeader(null, "7");	
		}
		catch (IllegalArgumentException e)
		{
			
		}
		
	}
	
	
	
	
	
	
	//Q.4, Tests the addReplyTo(String email, String name) class
	//One function allows for 100% coverage on addReplyTo(String email, String name) function	
	@Test
	public void testAddReplyTo() throws Exception
	{
		//Tests the function with the initialized email and viable dummy data
		email.addReplyTo("xyz@xx.com", "John Doe");
	}
	
	
	
	
	
	
	//Q.5, Tests the buildMimeMessage() class
	//Could not get the full coverage with my function, stuck at 39.2% coverage, not meeting the 70% requirements.
	//Ran out of time.
	@Test
	public void testBuildMimeMessage() throws Exception
	{
		try 
		{
			//Initialize various InternetAddresses to be plugged into the Mime Message
			InternetAddress sender = new InternetAddress("John Road", "myPersonalValue", "gdaD");
			InternetAddress listUser = new InternetAddress("John Rad", "myPersonalValu", "gda");
			InternetAddress ccUser = new InternetAddress("John Rod", "myPersonalVal", "gd");
			InternetAddress bccUser = new InternetAddress("John Roa", "myPersonalVa", "g");
			InternetAddress replyListUser = new InternetAddress();
			List<InternetAddress> toList = new ArrayList<InternetAddress>();
			List<InternetAddress> ccList = new ArrayList<InternetAddress>();
			List<InternetAddress> bccList = new ArrayList<InternetAddress>();
			List<InternetAddress> replyList = new ArrayList<InternetAddress>();
			
			Date newDate = new Date();
			
			
			//Set up valid session
			Properties prop = new Properties(); 
			prop.setProperty("MAIL_HOST", "localhost");
			Session scn = Session.getInstance(prop);
			
			//Apply the initialized variables to the email mime message
			email.setHostName("localhost");
			email.fromAddress = sender;
			
			toList.add(listUser);			
			email.toList = toList;
			ccList.add(ccUser);
			email.ccList = ccList;
			bccList.add(bccUser);
			email.bccList = bccList;
			replyList.add(replyListUser);
			email.replyList = replyList;
			
			
					
			//Create mime message
			email.createMimeMessage(scn);	
			email.buildMimeMessage();
			
		}
		catch (EmailException e)
		{
			
		}
		catch (NullPointerException i)
		{
			
		}
		
		
	}
	
	
	@Test
	public void testBuildMimeMessageWithoutSession() throws Exception
	{
		Properties prop = new Properties(); 
		prop.setProperty("MAIL_HOST", "localhost");
		Session scn = Session.getInstance(prop);
		
		email.createMimeMessage(scn);
		email.getMimeMessage();
	}
	
	
	//Q.6, Tests the getHostName() class
	//Two functions allow for 82.4% coverage on getHostName() function	
	@Test
	public void testGetHostNameWithSession() throws Exception
	{
		//Testing a hose with an active session
		Properties prop = new Properties(); 
		prop.setProperty("MAIL_HOST", "localhost");
		Session scn = Session.getInstance(prop);
		
		email.setMailSession(scn);		
		String hostname = email.getHostName();
							
	}
	
	@Test
	public void testGetHostNameWithoutSession() throws Exception
	{
		//Testing a host without an active session
		String dummyName = new String();
		email.setHostName(dummyName);
		email.getHostName();
		
	}
	
	
	
	
	
	//Q.7, Tests the getMailSession() class
	//Three functions allow for 72.0% coverage on getMailSession() function
	@Test
	public void testGetMailSessionWithSession() throws Exception
	{
		//Testing function while providing a session
		Properties prop = new Properties(); 
		prop.setProperty("MAIL_HOST", "localhost");
		Session scn = Session.getInstance(prop);
		
		email.setMailSession(scn);
		email.getMailSession();
	}
	
	@Test
	public void testGetMailSessionWithoutSession() throws Exception
	{
		//Testing function without providing a session
		try
		{
			email.getMailSession();
		}
		catch (EmailException e)
		{
			
		}
	}
	
	@Test
	public void testGetMailSessionWithoutSession2() throws Exception
	{
		//Testing function without providing a session, but with providing a host name
		try
		{
			email.setHostName("localhost");
			email.getMailSession();
		}
		catch (EmailException e)
		{
			
		}
	}
	
	
	
	//Q.8, Tests the getSentDate() class
	//Two functions allow for 100% coverage on getSentDate() function
	@Test
	public void testGetSentDate() throws Exception
	{
		//Tests function with an initialized date
			Date newDate = new Date(9,10,19,7,9,10);
			email.setSentDate(newDate);
			email.getSentDate();
			
	}
	
	@Test
	public void testGetSentDateWithoutData() throws Exception
	{
		//Tests function with a null date
			email.getSentDate();
	}
		
	
	
	
	
	//Q.9, Tests the getSocketConnectionTimeout() class
	//One function allows for 100% coverage on getSocketConnectionTimeout() function	
	@Test
	public void testGetSocketConnectionTimeout() throws Exception
	{
		//Tests the function with the initialized email
			email.getSocketConnectionTimeout();
	}
		
	
	
	
	//Q.10, Tests the setFrom(String email) class
	//One function allows for 100% coverage on setFrom() function	
	@Test
	public void testSetFrom() throws Exception
	{
		//Tests the function with the initialized email and viable data
			email.setFrom("xyz@xx.com");
	}
		
	
	
	
	
	//Teardown function
	@After
	public void tearDownEmailTest() throws Exception
	{
		//Teardown mostly uneccesary, section placed here so it is accessible if needed in the future if code is modified
	}
}
