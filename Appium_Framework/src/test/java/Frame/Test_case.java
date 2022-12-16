package Frame;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Test_case extends Capabilities {
	@BeforeTest
	public void KillAllProcesses() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(8000);
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"//emulator2.bat");
		Thread.sleep(60000);
	}
	@Test(enabled = false)
	public void tc1() throws IOException, InterruptedException {
		service = startServer();
		AndroidDriver<AndroidElement> driver= hybrid_capabilities(appactivity, apppackage, deviceName, chromeexecutable);
		Thread.sleep(3000);
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bhutan\"))").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toast=driver.findElement(MobileBy.xpath("//android.widget.Toast")).getText();
		System.out.println(toast);
		
}
	@Test(enabled = true)
	public void tc2() throws InterruptedException, IOException {
		service = startServer();
		AndroidDriver<AndroidElement> driver= hybrid_capabilities(appactivity, apppackage, deviceName, chromeexecutable);
		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath("//*[@text='Sign in']")).click();
		//driver.findElement(MobileBy.id("welcomeCardSignInButton")).click();
		Thread.sleep(3000);
		driver.findElement(MobileBy.xpath("//*[@text='Continue with Google']")).click();
		Thread.sleep(10000);
		driver.findElement(MobileBy.id("com.google.android.gms:id/container")).click();
	}
}

