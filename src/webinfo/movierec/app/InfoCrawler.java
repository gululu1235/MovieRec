package webinfo.movierec.app;

import java.io.IOException;
import java.text.DecimalFormat;
public class InfoCrawler implements Runnable{
	//TODO: 错误处理，怎么记录访问出错的页面
	MvInfoDown infoDown;
	String threadName;
	int start;
	int end;
	int step;
	public static String infoUrlPattern="http://www.imdb.com/title/tt%s/";
	public InfoCrawler(int s, int e, int st, String n)
	{
		start=s;
		end=e;
		step=st;
		threadName=n;
		infoDown=new MvInfoDown();	
	}
	public void infoCrawl() throws IOException
	{
		for (int i=start;i<end;i+=step)
		{
			String id=new DecimalFormat("0000000").format(i);
			String url=String.format(infoUrlPattern, id);
			infoDown.grabInfo(url);
			System.out.println(threadName+" "+i);
			
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			infoCrawl();
			System.out.println(threadName+" job finished");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String argv[])
	{
		InfoCrawler crawler1=new InfoCrawler(1,10,1,"t1");
		InfoCrawler crawler2=new InfoCrawler(10,20,1,"t2");
		Thread t1=new Thread(crawler1);
		Thread t2=new Thread(crawler2);
		t1.start();
		t2.start();
	}
}
