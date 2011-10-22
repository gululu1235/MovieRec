package webinfo.movierec.app;

import java.net.*;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PageDowload {
	public static String getPage(String u) throws IOException {
		URL url = new URL(u);
		URLConnection yc = url.openConnection();
		yc.addRequestProperty("User-Agent", "Mozilla/4.76"); 
		BufferedReader in = new BufferedReader(new InputStreamReader(
				yc.getInputStream()));
		String inputLine;
		String content="";
		while ((inputLine = in.readLine()) != null)
			content+=inputLine+"\n";
		in.close();
		return content;
	}
	public static MovieInfo grabInfo(String url) throws IOException
	{	
		Document doc = Jsoup.connect(url).userAgent("Mozilla/4.76").get();
		Element e_overview=doc.getElementById("overview-top");
		Elements e_rate=e_overview.getElementsByClass("star-box-giga-star");		
		Elements e_nameyear=e_overview.getElementsByAttributeValue("itemprop", "name");
		
		Elements e_des=e_overview.getElementsByAttributeValue("itemprop", "description");
		Elements e_director=e_overview.getElementsByAttributeValue("itemprop", "director");
		Elements boxinfos=e_overview.getElementsByClass("txt-block");
		MovieInfo info=new MovieInfo();
		if (boxinfos!=null)
		{
			for (Element e:boxinfos)
			{
				if (e.text().startsWith("Writer"))
					info.writer=e.text().substring(7);
				else if (e.text().startsWith("Stars"))
					info.stars=e.text().substring(7);
			}
		}		
		if (e_nameyear!=null) {
			info.name=e_nameyear.get(0).text();
			Element link = e_nameyear.select("a").first();
			Element yearlink=e_nameyear.select("a").first();
			info.year=link.text();
		}
		if (e_rate!=null)
			info.rate=e_rate.text();
		if (e_director!=null)
			info.director=e_director.text();
		if (e_des!=null)
			info.description=e_des.text();
		return info;
		
	}
	public static void main(String[] args) {
		
		try {
			grabInfo("http://www.imdb.com/title/tt1521197/").printInfo();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
}
