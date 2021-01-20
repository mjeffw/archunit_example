package org.clean.hexarch.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUtils {
  public static String objectToXML(Object object) throws JAXBException {
    String xmlContent = null;

    // Create JAXB Context
    JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

    // Create Marshaller
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    // Required formatting??
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    // Print XML String to Console
    StringWriter sw = new StringWriter();

    // Write XML to StringWriter
    jaxbMarshaller.marshal(object, sw);

    // Verify XML Content
    xmlContent = sw.toString();
    log.debug("jaxbObjectToXML() object={}", xmlContent);

    return xmlContent;
  }

  public static Object xmlToObject(Object object, String xmlfile) throws JAXBException {
    Source xml = new StreamSource(TestUtils.class.getClassLoader().getResourceAsStream(xmlfile));

    // Create JAXB Context
    JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

    // Create Marshaller
    Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();

    // Write XML to StringWriter
    object = jaxbMarshaller.unmarshal(xml);

    return object;
  }
}
