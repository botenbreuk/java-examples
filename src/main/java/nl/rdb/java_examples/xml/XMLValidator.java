package nl.rdb.java_examples.xml;

import java.io.File;
import java.util.Objects;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

import org.xml.sax.SAXException;

@Slf4j
public class XMLValidator {

    @Example
    void xmlValid() {
        String xml = "data/xml/test.xml";
        String xsd = "data/xml/test.xsd";

        xmlIsValid(xml, xsd);
    }

    @Example
    void xmlNotValid() {
        String xml = "data/xml/test.xml";
        String xsd = "data/xml/test-2.xsd";

        xmlIsValid(xml, xsd);
    }

    public void xmlIsValid(String xml, String xsd) {
        XmlErrorHandler xsdErrorHandler = new XmlErrorHandler();
        try {
            Validator validator = initValidator(xsd);
            validator.setErrorHandler(xsdErrorHandler);

            validator.validate(new StreamSource(getFile(xml)));
            log.info("XML true");
        } catch (SAXException e) {
            log.info("XML false");
        } catch (Exception ex) {
            log.error("Error when validating: {}", ex.getMessage());
        }

        xsdErrorHandler.getExceptions()
                .forEach(e -> log.info("Line number: {}, Column number: {}}. {}}", e.getLineNumber(), e.getColumnNumber(), e.getMessage()));
    }

    private Validator initValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(getFile(xsdPath));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }

    private File getFile(String location) {
        return new File(Objects.requireNonNull(getClass().getClassLoader().getResource(location)).getFile());
    }
}
