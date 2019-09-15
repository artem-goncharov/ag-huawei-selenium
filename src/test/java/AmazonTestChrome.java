import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import java.util.*;

public class AmazonTestChrome {

        @Test
        public void testAmazonSearch() throws InterruptedException {
            // Specify where to find chromedriver.exe:
            System.setProperty("webdriver.chrome.driver", "./browser_drivers/chromedriver.exe");
            // Wait:
            Thread.sleep(2000);

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

            // Search for all photo cameras description after sorting:
            List<WebElement> photoCamera = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
            System.out.println("Found following amount of goods: " + photoCamera.size());

            System.out.println("----------------------------------------");

            // Define an array where camera's descriptions will be added:
            ArrayList<String> descriptionsArray = new ArrayList<>();

            for (WebElement item : photoCamera) {
                String cameraDescription = item.getText();
                descriptionsArray.add(cameraDescription);
            //    System.out.println(descriptionsArray);
            //    System.out.println(cameraDescription.substring(0, 9));
            }

            // Define what we will be searching for:
            // String checkValue = "Nikon D4S";
            String checkValue = "Nikon D3X";

            for (int i = 0; i < photoCamera.size(); i++) {
                String currentCameraName = descriptionsArray.get(i).substring(0, 9);
                if (i == 1) {
                    System.out.println("We found on the website: " + currentCameraName);
                    // System.out.println("Product topic contains text: Nikon D4S?");
                    System.out.println("Product topic contains text: Nikon D3X?");
                    System.out.println(currentCameraName.equals(checkValue));

                    // Go to the 2nd product page with detailed information:
                    WebElement goToCamera = driver.findElement(By.xpath("//span[text()='"+descriptionsArray.get(i)+"']"));
                    goToCamera.click();
                    // Wait:
                    Thread.sleep(4000);
                }
            }

            // Meantime we can discover all features of the selected product:
            Thread.sleep(18000);
            driver.quit();

            // End of test:
            System.out.println("----------------------------------------");
            System.out.println("|                                      |");
            System.out.println("|             END OF TEST              |");
            System.out.println("|                 ***                  |");
            System.out.println("|     prepared by: Artem Goncharov     |");
            System.out.println("|     performed: 13.09-15.09.2019      |");
            System.out.println("|     email: ag.developer@mail.ru      |");
            System.out.println("|     telephone: +7 977 724-51-25      |");
            System.out.println("|                                      |");
            System.out.println("----------------------------------------");

        }
}
