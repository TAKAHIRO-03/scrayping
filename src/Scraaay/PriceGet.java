package Scraaay;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceGet {
	
	private WebElement element = null;
	private java.util.List<org.openqa.selenium.WebElement> WebElementNameList = null;
	private ArrayList<String> nums = new ArrayList<String>();//[1]

	public ArrayList<String> PriceList(WebDriver driver,String id,String TargetName){ 
	 this.element = driver.findElement(By.id(id));
	 this.WebElementNameList = this.element.findElements(By.className(TargetName));
	 for (int i = 0; i < this.WebElementNameList.size(); i++) {
  	 	this.nums.add(this.WebElementNameList.get(i).getText());
  	 }
	 return this.nums;
	}	

}
