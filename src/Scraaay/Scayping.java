package Scraaay;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class Scayping {
	private ArrayList<String> priceList = new ArrayList<String>();
	private ArrayList<String> nameList= new ArrayList<String>();
	private ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
	private int p = 0;
	
	public ArrayList<ArrayList<String>> Scrayping() {
		howmanyTask task = new howmanyTask();
		PriceGet get_p = new PriceGet();
		PriceGet get_n = new PriceGet();
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver");
		WebDriver driver = task.OpenHP(1);
		int k = task.OpenHP_Howmany(driver,"//*[@id=\"searchItemList\"]/div[1]/span/span[1]",44);
		System.out.println(k+"ページ分の処理始めるよ～ん");
		for(int i = 1; i < 10; i++) {
			driver = task.MoveHP(i,driver); //9Pで3m25s
			//driver = task.OpenHP(i); 9Pで4m11s
			if(task.Judge(driver)) {
				this.nameList = get_n.PriceList(driver,"searchItemList","productName");
				this.priceList = get_p.PriceList(driver,"searchItemList","price");
			}
		}
		lists.add(nameList);
		lists.add(priceList);
		task.QuitHP(driver); 
		return lists;
	}

	public ArrayList<ArrayList<String>> getLists() {
		return lists;
	}

	public void setLists(ArrayList<ArrayList<String>> lists) {
		this.lists = lists;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

}
