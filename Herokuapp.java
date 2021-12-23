import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Herokuapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Hover
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sdetmindc122\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[25]/a")).click();
		List<WebElement> images = driver.findElements(By.cssSelector(".figure"));
		Actions action = new Actions(driver);
		for(WebElement image:images) {
			action.moveToElement(image).perform();
			System.out.println(image.findElement(By.cssSelector(".figcaption")).getText());
		}
		
		driver.navigate().back();
		//checkboxes
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
		driver.navigate().back();
		
		//inputs
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[27]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys("1234");
		driver.navigate().back();
		
		//Dropdown
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]")).click();
		driver.navigate().back();
		
		//FileUpload
		driver.findElement(By.linkText("File Upload")).click();
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\sdetmindc122\\Desktop\\file.txt");
		driver.findElement(By.id("file-submit")).click();
		System.out.println("File Uploaded!");
	    driver.get("http://the-internet.herokuapp.com/");
		
		//Sortable Data Tables
	    driver.findElement(By.linkText("Sortable Data Tables")).click();
	    System.out.println("Email id: " +driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr[4]/td[5]")).getText());
		driver.navigate().back();
		
		//Key Presses
		driver.findElement(By.linkText("Key Presses")).click();
		Actions act = new Actions(driver);
		act.sendKeys("N").perform();
		System.out.println(driver.findElement(By.cssSelector("p#result")).getText());
		driver.navigate().back();
		
		//Multiple Windows
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		System.out.println(driver.findElement(By.className("example")).getText());
		driver.get("http://the-internet.herokuapp.com/");
		
		//Context Menu
		driver.findElement(By.xpath("//a[contains(text(),'Context Menu')]")).click();
		driver.findElement(By.xpath("//*[@id=\"hot-spot\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/script")).click();
		
		driver.quit();
		
		
		
		

	}

}
