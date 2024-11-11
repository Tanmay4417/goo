package com.demo.Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testcases {

	@Test
	public void test() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/index.php");
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		List<WebElement> prod=driver.findElements(By.cssSelector("h2 a"));
		List<String> sorted = new ArrayList();
		for(WebElement p : prod) {
			sorted.add(p.getText());
		}
		
		Collections.sort(sorted);
		System.out.println(sorted);

		
		WebElement name = driver.findElement(By.xpath("(//select[@title='Sort By'])"));
		Select s=new Select(name);
		s.selectByVisibleText("Name");
		
		List<WebElement> sortedprod=driver.findElements(By.cssSelector("h2 a"));
		ArrayList<String> sortedProducts= new ArrayList<String>();
		
		for(WebElement p: sortedprod) {
			sortedProducts.add(p.getText());
		}
		System.out.println(sortedProducts);
		
		Assert.assertEquals(sorted, sortedProducts);
		
		driver.quit();
		
	}
}
