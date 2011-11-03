package webinfo.movierec.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MovieInfoCls {
	public String name="?";
	public String year="?";
	public String rate="?";
	public String director="?";
	public String writer="?";
	public String stars="?";
	public String description="?";
	public int numReviews=0;
	
	public void printInfo(){
		System.out.print(String.format("name:%s\nyear:%s\nrate:%s\ndirector:%s\nwriter:%s\nstars:%s\ndescription:%s\nreview number:%d\n", name,year,rate,director,writer,stars,description,numReviews));
	}
	
	public void saveToFile(String file)
	{
		FileWriter fw;
		
		try {
			fw=new FileWriter("filse",true);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
