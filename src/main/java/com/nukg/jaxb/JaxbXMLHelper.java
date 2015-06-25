package com.nukg.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.nukg.jaxb.pojo.User;

public class JaxbXMLHelper {
	
	public <T> T convertFromXMLToPojo(String userXML, Class<T> type)
			throws Exception {

		StreamSource source = new StreamSource(new StringReader(userXML));

		JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Object obj  = unmarshaller.unmarshal(source, type).getValue();
		return type.cast(obj);
	}
	
	public String convertFromPojoToXML(Object user, Class<?> type)
			throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(type);
		Marshaller marshaller = jaxbContext.createMarshaller();
		StringWriter writer = new StringWriter();
		marshaller.marshal(user, writer);
		return writer.toString();
	}

}
