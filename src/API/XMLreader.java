package API;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XMLreader {
	private ArrayList<FlowModel> listeFlowPuzzle;
	
	

	public XMLreader(String fname){
		
		listeFlowPuzzle = new ArrayList<FlowModel>();
		String color = "";
	
		
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document d =builder.parse(new File(fname));
			
			Element racine = d.getDocumentElement();
			
			
			NodeList racineNoeuds = racine.getChildNodes();
			
			for (int i = 0; i < racineNoeuds.getLength(); i++) {
			
				Element flowpuzzle = (Element) racineNoeuds.item(i);
				Monde M= new Monde(Integer.parseInt(flowpuzzle.getAttribute("width")), Integer.parseInt(flowpuzzle.getAttribute("height")));
				NodeList lines = flowpuzzle.getChildNodes();
				GameState gs = new GameState();
	
				for (int j = 0; j < lines.getLength(); j++) {
					
					Node chemin = lines.item(j);
					NodeList cheminAttributs = chemin.getChildNodes();
					
					
					
					for (int k = 0; k < cheminAttributs.getLength(); k++) {
						
						Element attribut = (Element) cheminAttributs.item(k);
						if (k ==0)						
						color = attribut.getAttribute("value");
											
						if(k !=0){
						
							int x = Integer.parseInt(attribut.getAttribute("x"));
							int y = Integer.parseInt(attribut.getAttribute("y"));
							
							PathUnderBuilding pub = new PathUnderBuilding( M.getCaseTableau( x, y), color);	
							gs.add(pub);
						}
					}			
				}
				FlowModel fl = new FlowModel(M, gs);
				listeFlowPuzzle.add(fl);	
			}			
		}
		catch (Exception e){
		System.out.println(e);
		}
	}
	
public XMLreader(InputStream is){
		
		listeFlowPuzzle = new ArrayList<FlowModel>();
		String color = "";
		
		
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document d =builder.parse(is);
			Element racine = d.getDocumentElement();
			
			
			NodeList racineNoeuds = racine.getChildNodes();
			
			for (int i = 0; i < racineNoeuds.getLength(); i++) {
			
				Element flowpuzzle = (Element) racineNoeuds.item(i);
				Monde M= new Monde(Integer.parseInt(flowpuzzle.getAttribute("width")), Integer.parseInt(flowpuzzle.getAttribute("height")));
				NodeList lines = flowpuzzle.getChildNodes();
				GameState gs = new GameState();
				
				for (int j = 0; j < lines.getLength(); j++) {
					
					Node chemin = lines.item(j);
					NodeList cheminAttributs = chemin.getChildNodes();
					
					for (int k = 0; k < cheminAttributs.getLength(); k++) {
						
						Element attribut = (Element) cheminAttributs.item(k);
						if (k ==0)						
						color = attribut.getAttribute("value");
											
						if(k !=0){
						
							int x = Integer.parseInt(attribut.getAttribute("x"));
							int y = Integer.parseInt(attribut.getAttribute("y"));
							
							PathUnderBuilding pub = new PathUnderBuilding( M.getCaseTableau( x, y), color);	
							gs.add(pub);
						}
					}			
				}
				FlowModel fl = new FlowModel(M, gs);
				listeFlowPuzzle.add(fl);	
			}			
		}
		catch (Exception e){
		System.out.println(e);
		}
	}
	


	public ArrayList<FlowModel> getListeFlowPuzzle() {
		return listeFlowPuzzle;
	}



}
