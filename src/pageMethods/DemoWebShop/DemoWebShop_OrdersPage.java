package pageMethods.DemoWebShop;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import pageMethods.BaseClass;
import utilities.Constant;
import utilities.ExcelUtilities;
import utilities.Log;

public class DemoWebShop_OrdersPage {
	static WebDriver driver=BaseClass.getDriver();
	public static final String orders="//div[@class='order-list']/div";
	
	public static void getNumberOfOrders() {
		int totalorders = driver.findElements(By.xpath(orders)).size();
		Log.info("Total number of orders placed are:" + totalorders);
		
	}
	
	public static void selectSpecificOrder() throws Exception{
		List<WebElement> orders = driver.findElements(By.xpath()); 
        for(int i=1;i<=orders.size();i++){
           
       	 System.out.print(orders.get(i));
       	 System.out.println();
       	 
       	 //String order_number=orders.get(i).findElement(By.xpath("//div[@class='title']//strong[contains(text(),'Order Number')]")).getText();
       	 String order_number=orders.get(i).getText();

       	 Log.info(order_number);
       	 
       	 String Order_Num=ExcelUtilities.getCellData(Constant.uRowNumber, Constant.col_orderno, "DemoWebShop");

            if(order_number.contains(Order_Num)){

           	 orders.get(i).findElement(By.xpath(".//following-sibling::div/input")).click();
           	 Log.info("Order details button is clicked");
           	 break;        	 
            }
        }
	}
	
	public static void reOrder() {
		 //reorder
        driver.findElement(By.xpath("//input[@class='button-1 re-order-button']")).click();
        Log.info("Re-Order button is clicked");
	}
	
	public static void getSumOfAllOrdersTotal() {
		List<WebElement> list_totalorders = driver.findElements(By.xpath("//div[@class='order-list']/div/ul/li[3]"));
		int sum=0;
		for(WebElement element_orderTotal:list_totalorders) {
			String orderTotal=element_orderTotal.getText();
			orderTotal=orderTotal.split(":")[1].trim().split("\\.")[0];
			int total=Integer.parseInt(orderTotal);
			sum=sum+total;
		}
		Log.info("Sum of Total orders is :"+sum );
	}
	
	public static void getSumOfAllOrdersTotal_DateWise() {
		List<WebElement> list_totalorders_daywise=driver.findElements(By.xpath("//div[@class='order-list']/div/ul/li[2]"));
		for (WebElement daywise_list:list_totalorders_daywise) {
			String daywise_ordervalue=daywise_list.getText().split(" ")[2];
			//System.out.println(daywise_ordervalue);
			
			List<String> Totalorders_daywise= new ArrayList<String>();
			Totalorders_daywise.add(daywise_ordervalue);
			System.out.println(Totalorders_daywise);
		
			
		}
	}
}
