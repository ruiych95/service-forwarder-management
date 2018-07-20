package th.co.tac.cns.app.service.forwarder.management.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLParser {

	public static <T> String marshal(T object) throws Exception {
		StringWriter writer = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(object.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // Fixed marshal without root element
		m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		m.marshal(object, writer);
		return writer.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T unmarshal(String xml, Class<T> clazz) throws Exception {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller m = context.createUnmarshaller();
		return (T) m.unmarshal(new StringReader(xml));
	}
	
	public static String removeNewLineAndTab(String str) {
		if ( str == null ) {
			return "";
		}
		
		str = str.replaceAll("(\r\n|\r|\n|\n\r)", "");
		str = str.replaceAll(">\\s*<", "><");
		return str;
	}
}
