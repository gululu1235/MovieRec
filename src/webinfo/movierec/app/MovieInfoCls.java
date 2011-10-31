package webinfo.movierec.app;

public class MovieInfoCls {
	public String name="?";
	public String year="?";
	public String rate="?";
	public String director="?";
	public String writer="?";
	public String stars="?";
	public String description="?";
	
	public void printInfo(){
		System.out.print(String.format("name:%s\nyear:%s\nrate:%s\ndirector:%s\nwriter:%s\nstars:%s\ndescription:%s\n", name,year,rate,director,writer,stars,description));
	}
	
}
