package Scraaay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class howmanyTask {
	
	private double number_i = 0;
	private String number_s = null;
	private WebElement element = null;
	private WebDriver driver = null;
	private boolean isTxt;
	
	public int OpenHP_Howmany(WebDriver driver,String Xpath,int youso){
     	this.element = driver.findElement(By.xpath(Xpath));
     	this.number_s = this.element.getText().replaceAll(",", ""); 
     	this.number_i = Integer.parseInt(this.number_s);
     	this.number_i = Math.ceil(this.number_i / youso);
		return (int)this.number_i;
	}

	public boolean Judge(WebDriver driver){
    	 WebDriverWait wait = new WebDriverWait(driver,10);
    	 this.element = driver.findElement(By.className("headingTitle"));
    	 String text = this.element.getText();
    	 boolean isTxt = wait.until(ExpectedConditions.textToBePresentInElement(this.element, text));
    	 return isTxt;
	}
	
	public WebDriver OpenHP(int k){
    	 this.driver = new ChromeDriver();
    	 this.driver.get("https://wowma.jp/category/510801/itemlist?spe_id=c_dw02&page="+k+"&clk="+k);
    	 return driver;
	}
	
	public WebDriver MoveHP(int k,WebDriver driver){
   	 	driver.navigate().to("https://wowma.jp/category/510801/itemlist?spe_id=c_dw02&page="+k+"&clk="+k);
   	 	return driver;
	}

	public void QuitHP(WebDriver driver){
		driver.close();
		driver.quit();
	}
}
