/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.xmlbeans;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.util.Iterator;

/**
 * A SoapMarshaller object is used to convert Java objects to SOAP encoded XML documents.
 * The object is not thread safe and should not be shared between threads.
 * It can however be shared across different invocations of
 * Marshaller.marshalType() for a given document.
 */
public interface SoapMarshaller
{
    /**
     * Write an XML representation of the Java object to the provided output.
     *
     * It is the responsibility of the caller to ensure that
     * obj is an instanceof javaType
     *
     * As of this writing (11/22/2003), this method will NOT write
     * a START_DOCUMENT or END_DOCUMENT element.
     * The first event written will be a START_ELEMENT event.
     *
     * <ul>
     * <li>A collection instance that should be used as an error listener during
     * compilation, as described in {@link XmlOptions#setErrorListener}.</li>
     * </ul>
     *
     * @param writer
     * @param obj
     * @param elementName
     * @param schemaType
     * @param javaType the java type in the format returned by Class.getName()
     * @throws XmlException
     */
    void marshalType(XMLStreamWriter writer,
                     Object obj,
                     QName elementName,
                     QName schemaType,
                     String javaType,
                     XmlOptions options)
        throws XmlException;



    /**
     * Get the multiply referenced objects, usually written after the other parts.
     *
     * <ul>
     * <li>A collection instance that should be used as an error listener during
     * compilation, as described in {@link XmlOptions#setErrorListener}.</li>
     * </ul>
     *
     * @param options
     * @throws XmlException
     */
    void marshalReferenced(XMLStreamWriter writer,
                           XmlOptions options)
        throws XmlException;



    /**
     * Get an XMLStreamReader object that represents the given java type.

     * It is the responsibility of the caller to ensure that
     * obj is an instanceof javaType

     * The returned reader will NOT contain a
     * START_DOCUMENT or END_DOCUMENT element.
     * The reader's first event is a START_ELEMENT event.
     *
     * <ul>
     * <li>A collection instance that should be used as an error listener during
     * compilation, as described in {@link XmlOptions#setErrorListener}.</li>
     * </ul>
     *
     * @param obj
     * @param elementName
     * @param schemaType
     * @param javaType the java type in the format returned by Class.getName()
     * @param options
     * @return
     * @throws XmlException
     */
    XMLStreamReader marshalType(Object obj,
                                QName elementName,
                                QName schemaType,
                                String javaType,
                                XmlOptions options)
        throws XmlException;


    /**
     * Get the multiply referenced objects, usually written after the other parts.
     *
     * Returns an Iterator of XMLStreamReader objects, each reader
     * represting an object that has been referred to more than once.
     *
     *
     * <ul>
     * <li>A collection instance that should be used as an error listener during
     * compilation, as described in {@link XmlOptions#setErrorListener}.</li>
     * </ul>
     *
     * @param options
     * @return
     * @throws XmlException
     */
    Iterator marshalReferenced(XmlOptions options)
        throws XmlException;


}