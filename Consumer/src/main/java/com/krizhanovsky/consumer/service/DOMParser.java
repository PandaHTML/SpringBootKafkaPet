package com.krizhanovsky.consumer.service;

import com.krizhanovsky.consumer.entity.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class DOMParser {

    public static Person parse(String data){


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try{
            doc = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(data)));
        }catch (Exception e){
            System.out.println("Open parsing error: " + e);
            return null;
        }

        NodeList listPerson = doc.getElementsByTagName("person");

        Person person = new Person();

        for(int i=0;i< listPerson.getLength();i++){
            Node item = listPerson.item(i);
            if(item.getNodeType() != Node.ELEMENT_NODE) continue;
            Element element = (Element)item;

            person.setAge(Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
            person.setName(element.getElementsByTagName("name").item(0).getTextContent());
            person.setSurname(element.getElementsByTagName("surname").item(0).getTextContent());

        }
        return person;
    }
}
