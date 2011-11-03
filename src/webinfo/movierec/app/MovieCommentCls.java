package webinfo.movierec.app;

public class MovieCommentCls {
	public String movieID="";
	public String userID="";
	public String username="";
	public String cmtTitle="";
	public String cmtStar="";
	public String cmtContent="";
	
	public void parseUserInfo(String id, String u)
	{
		username=u;
		userID=id.substring(6, id.lastIndexOf("/"));
	}
	
	public void parseStar(String s)
	{
		cmtStar=s;
	}
}
