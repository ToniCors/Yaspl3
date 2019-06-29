package parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import astNodes.ProgramOP;

public class XMLBuilder implements Visitor{
	
	private Document doc;
	
	public XMLBuilder() throws Exception {
		
		initDocument();		
	}

	
	public void initDocument() throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.newDocument();
	}
	
	public void exportDocument(File file) throws Exception {
		
	      Transformer transformer = TransformerFactory.newInstance().newTransformer();
	      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	      transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	      transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	      transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
	      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
	     DOMSource source = new DOMSource(doc);
	     StreamResult result = new StreamResult(file);
	     transformer.transform(source, result);
		
	}
	
	public Document getDocument() {
		return doc;
	}
	
	public void setDocument(Document d) {
		this.doc = d;
	}
	
	// doc = ((ProgramOP)visitable).buildXMLast(doc); 

	
	@Override
	public void visit(Visitable visitable) {

		String className = visitable.getClass().getName();
		//System.out.println("class name "+ className);
		switch (className) {
		case "astNodes.ProgramOP": 
		break;
		case "astNodes.VarDecelOP": 
			break;
		case "astNodes.VarInitOP": 
			break;
		case "astNodes.ProcDecelOP": 
			break;
		case "astNodes.ParOP": 
			break;
		case "astNodes.BodyOP": 
			break;
		case "astNodes.ReadOP": 
			break;
		case "astNodes.WriteOP": 
			break;
		case "astNodes.AssignOP": 
			break;
		case "astNodes.CallOP": 
			break;
		case "astNodes.WhileOP": 
			break;
		case "astNodes.IfThenElseOp": 
			break;
		case "astNodes.IfThenOp": 
			break;
		case "astNodes.CompStatOP": 
			break;
		case "astNodes.AddOP": 
			break;
		case "astNodes.DiffOP": 
			break;
		case "astNodes.MulOP": 
			break;
		case "astNodes.DivOP": 
			break;
		case "astNodes.OrOP": 
			break;
		case "astNodes.AndOP": 
			break;
		case "astNodes.NotOP": 
			break;
		case "astNodes.UminusOP": 
			break;
		case "astNodes.GtOP": 
			break;
		case "astNodes.GeOP": 
			break;
		case "astNodes.LtOP": 
			break;
		case "astNodes.LeOP": 
			break;
		case "astNodes.EqOP": 
			break;
		case "astNodes.Identifier": 
			break;
		case "astNodes.StringConst": 
			break;
		case "astNodes.CharConst": 
			break;
		case "astNodes.DoubleConst": 
			break;
		case "astNodes.IntConst": 
			break;
		case "astNodes.BooleanConst": 
			break;

		default:
			break;
		}
		
	}

	
	
	
	
}
