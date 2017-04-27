package API;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import android.content.Context;

public class HTMLParser implements Runnable {
	Context context;
	
	public HTMLParser(Context context) {
		super();
		this.context=context;
	}
	
	@Override
	public void run() {

		int i;char c; String lecture="";
		
	
		Document doc;

			try {
				doc = Jsoup.connect("http://grimau.dynamic-dns.net/flowfree/").get();
		
				
		Element link = doc.select("a[href]").get(8);
		String linkHref = link.attr("href");
			
		linkHref="http://grimau.dynamic-dns.net/flowfree/"+linkHref;
		
		
	
		try {
			InputStream istream = new URL(linkHref).openStream();

			 while((i=istream.read())!=-1){
				  c=(char)i;
				  lecture+=c;
			  }	
			FileOutputStream fostream = context.openFileOutput("sample_internet.xml", Context.MODE_PRIVATE);
			
			
			fostream.write(lecture.getBytes()); 
			fostream.close();
			istream.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

}
