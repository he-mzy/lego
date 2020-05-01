public class legoset {
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.parsers.DocumentBuilder;
    import org.w3c.dom.Document;
    import org.w3c.dom.NodeList;
    import org.w3c.dom.Node;
    import org.w3c.dom.Element;
    import java.io.File;
    import java.time.*;
    import java.util.*;

    class Main {
        public static void main(String[] args) {
            try
            {
                //creating a constructor of file class and parsing an XML file
                File file = new File("lego.xml");
                //an instance of factory that gives a document builder
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                //an instance of builder to parse the specified xml file
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();
                System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

                String name = doc.getElementsByTagName("name").item(0).getTextContent();

                String theme = doc.getElementsByTagName("theme").item(0).getTextContent();

                String subtheme = doc.getElementsByTagName("subtheme").item(0).getTextContent();

                Year year = Year.parse(doc.getElementsByTagName("year").item(0).getTextContent());

                Integer pieces = Integer.parseInt(doc.getElementsByTagName("pieces").item(0).getTextContent());

                Set<String> tags = new HashSet<String>();

                NodeList tagslist = doc.getElementsByTagName("tags");
                Node tagnode = tagslist.item(0);
                Element el = (Element) tagnode;

                for (int itr = 0; itr < el.getElementsByTagName("tag").getLength(); itr++){
                    tags.add(el.getElementsByTagName("tag").item(itr).getTextContent());
                }

                Double Weight = Double.parseDouble(doc.getElementsByTagName("weight").item(0).getTextContent());



                System.out.println("The Name: "+ name);
                System.out.println("The Theme: "+ theme);
                System.out.println("The SubTheme: "+ subtheme);
                System.out.println("The Year: "+ year);
                System.out.println("The Pieces: "+ pieces);
                System.out.println("The Tags: "+ tags);
                System.out.println("The Weight: "+ Weight);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
