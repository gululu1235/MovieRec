package webinfo.movierec.app;

public class MainCrawler {

	public static int MAX_MOV_ID=2100688;
	public static void main(String argv[])
	{
		for (int i=1;i<=100;i++)
		{
			InfoCrawler crawler=new InfoCrawler(i,MAX_MOV_ID,100,"t"+i);
			Thread t=new Thread(crawler);
			t.start();
		}
	}
}
