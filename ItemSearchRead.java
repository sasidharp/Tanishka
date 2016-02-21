package com.example.sasidhar.tanishka;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by sasidhar on 13/2/16.
 */
public class ItemSearchRead extends DefaultHandler{

public void process_result() throws ProdAPI_ItemSearchException {
//  Get the SAX Process Factory
    SAXParserFactory factory = SAXParserFactory.newInstance();
//  Get the SAX Processor
    try{
        SAXParser saxParser = factory.newSAXParser();
        DefaultHandler handler = new DefaultHandler();

    }
    catch ( Exception e){
        throw new ProdAPI_ItemSearchException("Error Parsing Resopnse");
    }
}
    /**
     * Receive notification of the beginning of the document.
     * <p>
     * <p>By default, do nothing.  Application writers may override this
     * method in a subclass to take specific actions at the beginning
     * of a document (such as allocating the root node of a tree or
     * creating an output file).</p>
     *
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see ContentHandler#startDocument
     */
    public void startDocument() throws SAXException {
    }

    /**
     * Receive notification of the end of the document.
     * <p>
     * <p>By default, do nothing.  Application writers may override this
     * method in a subclass to take specific actions at the end
     * of a document (such as finalising a tree or closing an output
     * file).</p>
     *
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see ContentHandler#endDocument
     */
    public void endDocument() throws SAXException {
    }

    /**
     * Receive notification of the start of an element.
     * <p>
     * <p>By default, do nothing.  Application writers may override this
     * method in a subclass to take specific actions at the start of
     * each element (such as allocating a new tree node or writing
     * output to a file).</p>
     *
     * @param uri        The Namespace URI, or the empty string if the
     *                   element has no Namespace URI or if Namespace
     *                   processing is not being performed.
     * @param localName  The local name (without prefix), or the
     *                   empty string if Namespace processing is not being
     *                   performed.
     * @param qName      The qualified name (with prefix), or the
     *                   empty string if qualified names are not available.
     * @param attributes The attributes attached to the element.  If
     *                   there are no attributes, it shall be an empty
     *                   Attributes object.
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see ContentHandler#startElement
     */

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    }

    /**
     * Receive notification of the end of an element.
     * <p>
     * <p>By default, do nothing.  Application writers may override this
     * method in a subclass to take specific actions at the end of
     * each element (such as finalising a tree node or writing
     * output to a file).</p>
     *
     * @param uri       The Namespace URI, or the empty string if the
     *                  element has no Namespace URI or if Namespace
     *                  processing is not being performed.
     * @param localName The local name (without prefix), or the
     *                  empty string if Namespace processing is not being
     *                  performed.
     * @param qName     The qualified name (with prefix), or the
     *                  empty string if qualified names are not available.
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see ContentHandler#endElement
     */
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    /**
     * Receive notification of character data inside an element.
     * <p>
     * <p>By default, do nothing.  Application writers may override this
     * method to take specific actions for each chunk of character data
     * (such as adding the data to a node or buffer, or printing it to
     * a file).</p>
     *
     * @param ch     The characters.
     * @param start  The start position in the character array.
     * @param length The number of characters to use from the
     *               character array.
     * @throws SAXException Any SAX exception, possibly
     *                      wrapping another exception.
     * @see ContentHandler#characters
     */
    public void characters(char[] ch, int start, int length) throws SAXException {
    }
}
