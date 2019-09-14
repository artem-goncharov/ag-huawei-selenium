import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

public class AmazonTestChrome {

        @Test
        public void testAmazonSearch() throws InterruptedException {
            // Specify where to find chromedriver.exe:
            System.setProperty("webdriver.chrome.driver", "./browser_drivers/chromedriver.exe");

            // Go to Amazon.com:
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.amazon.com/");
            // Wait:
            Thread.sleep(4000);

            // Let's search for our Nikon camera:
            WebElement searchBox = driver.findElement(By.name("field-keywords"));
            searchBox.sendKeys("Nikon");
            // Wait:
            Thread.sleep(4000);
            searchBox.submit();

            // See what's in the sorting variants list:
            WebElement sortChange = driver.findElement(By.id("a-autoid-0"));
            sortChange.click();
            // Wait:
            Thread.sleep(4000);

            // Apply sorting on price - High to Low:
            WebElement priceSort = driver.findElement(By.id("s-result-sort-select_2"));
            priceSort.click();
            // Wait:
            Thread.sleep(4000);

            // Enjoying results and then quit:
            Thread.sleep(12000);  // Let the user actually see something!
            driver.quit();
        }

}
