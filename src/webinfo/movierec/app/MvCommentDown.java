package webinfo.movierec.app;

import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MvCommentDown {
	/*
	 * get all the comments together with user information from a given url
	 * para: url of the comment page of a movie
	 * return : a list of MovieInfoCls structure, each contains a comment and corresponding user information
	 */
	public static List<MovieCommentCls> grabCmtInfo(String url) throws IOException
	{	
		Document doc = Jsoup.connect(url).userAgent("Mozilla/4.76").get();
		Element eMainDiv=doc.getElementById("tn15content");
		Elements tmptds=eMainDiv.getElementsByTag("td");
		Element eCmtCount=null;
		for (Element e:tmptds)
		{		
			if (e.text().indexOf("reviews")!=-1)
			{
				eCmtCount=e;
				break;
			}
		}
		int viewCount=Integer.parseInt(eCmtCount.text().split(" ")[0]);
		Elements eCmts=doc.getElementsByTag("p");
		ArrayList<MovieCommentCls> cmtList=new ArrayList<MovieCommentCls>();
		for (int i=0;i<viewCount;i++)
		{
			MovieCommentCls info=new MovieCommentCls();
			
			Element cmtTSU=eCmts.get(2*i+1);
			Element cmtTitle=cmtTSU.getElementsByTag("b").first();
			Element cmtStar=cmtTSU.getElementsByTag("img").first();
			Element cmtUser=cmtTSU.getElementsByTag("a").first();
			info.cmtTitle=cmtTitle.text();
			info.parseStar(cmtStar.html());
			info.parseUserInfo(cmtUser.html());
			
			Element cmtMain=eCmts.get(2*i+2);
			info.cmtContent=cmtMain.text();
			
			cmtList.add(info);
			
		}
		return cmtList;

	}
	public static void main(String[] args) {
		
		try {
			
			List<MovieCommentCls> ret=grabCmtInfo("http://www.imdb.com/title/tt1615147/reviews?filter=best;spoiler=hide;filter=best;spoiler=hide;start=0;count=30000");
			int k=0;

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
}
