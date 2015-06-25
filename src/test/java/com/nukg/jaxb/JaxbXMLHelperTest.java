package com.nukg.jaxb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nukg.dao.unit.BaseUnitTester;
import com.nukg.jaxb.pojo.Address;
import com.nukg.jaxb.pojo.Addresses;
import com.nukg.jaxb.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
public class JaxbXMLHelperTest extends BaseUnitTester {
	
	 private static Log log = LogFactory.getLog(JaxbXMLHelperTest.class);

	 
	@Test
	public void testConvertFromXMLToPojo() throws Exception {
		/* 
		 This is the sample xml
		<?xml version="1.0"?>
		<User>
	      <id>1234</id>
	      <name>Stevens</name>
	      <phone>555555</phone>
	      
	      <addresses>
	      	<address>
	      	  <type>home</type>
	      	  <street>park st</street>
	      	  <city>Edison</city>
	      	  <state>NJ</state>
	      	  <zip>76877</zip>
	        </address>
	      	    
	      	<address>
	      	  <type>work</type>
	      	  <street> 100 th st</street>
	      	  <city>New York</city>
	      	  <state>NY</state>
	      	  <zip>10022</zip>
	      	</address>
	      	    
	      </addresses>
	    </User>
	*/
		
		
		String xml  = getSampleXML();
		
		JaxbXMLHelper jaxbHelper = new JaxbXMLHelper();
		User user = jaxbHelper.convertFromXMLToPojo(xml, User.class);
		
		log.debug("user name:"+user.getName());

		log.debug("phone:"+user.getPhone());
		
		for(Address address:user.getAddresses().getAddress()){
			log.debug("Address type:"+address.getType());
			log.debug("Address Street:"+address.getStreet());
			log.debug("Address City:"+address.getCity());
			log.debug("Address State:"+address.getState());
			log.debug("Address Zip:"+address.getZip());
			
		}
		
		
				
	}

	@Test
	public void testConvertFromPojoToXML() throws Exception {

		User user = new User();
		user.setUserid("1234");
		user.setName("Stevens");
		user.setPhone("5555555");
		
		Addresses addresses = new Addresses();
		
		Address homeAddress = new Address();
		homeAddress.setType("home");
		homeAddress.setStreet("Park St");
		homeAddress.setCity("Edison");
		homeAddress.setState("NJ");
		homeAddress.setZip("76877");
		
		Address officeAddress = new Address();
		officeAddress.setType("work");
		officeAddress.setStreet("100 th St");
		officeAddress.setCity("New York");
		officeAddress.setState("NY");
		officeAddress.setZip("10022");
		
		Address[] addrArray = new Address[2];
		addrArray[0] = homeAddress;
		addrArray[1] = officeAddress;
		
		
		addresses.setAddress(addrArray);
		
		user.setAddresses(addresses);
		
		
		JaxbXMLHelper jaxbHelper = new JaxbXMLHelper();
		String userXML = jaxbHelper.convertFromPojoToXML(user, User.class);
		
		log.debug("user xml:"+userXML);
	

	}

	private String getSampleXML() {
		String xml = "<?xml version=\"1.0\"?>"
				+ "<User><id>1234</id>"
				+ "<name>Stevens</name><phone>555555</phone><addresses><address><type>home</type><street>park st</street>"
				+ "<city>Edison</city><state>NJ</state><zip>76877</zip></address><address><type>work</type><street> 100 th st</street>"
				+ "<city>New York</city><state>NY</state><zip>10022</zip></address></addresses></User>";
		return xml;

	}
}