package com.company;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	    try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File("/Users/ashishsamanta/IdeaProjects/Day_3_Advanced_Java_Q6/src/com/company/employees.xml"));

            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());

            NodeList nList = document.getElementsByTagName("employee");
            System.out.println("============================");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node node = nList.item(temp);
                System.out.println("");    //Just a separator
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    //Print each employee's detail
                    Element eElement = (Element) node;
                    System.out.println("Employee id : "    + eElement.getAttribute("id"));
                    System.out.println("First Name : "  + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                    System.out.println("Last Name : "   + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                    System.out.println("Location : "    + eElement.getElementsByTagName("location").item(0).getTextContent());
                }
            }
        }catch (Exception exc){
	        exc.printStackTrace();
        }
    }
}
