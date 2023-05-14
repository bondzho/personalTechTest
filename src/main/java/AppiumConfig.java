import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AppiumConfig {

    private static AppiumDriver driver;
    public static String platform;
    private static AppiumDriverLocalService server;

    public static AppiumDriver getDriver() throws MalformedURLException, InterruptedException {
        if (driver == null) {
            if (!isEmulatorRunning()) {
                launchEmulator();
                Thread.sleep(15000);
            }
            setUp();
        }
        return driver;
    }


    private static void setUp() throws MalformedURLException {
        platform = System.getenv("platform");
        DesiredCapabilities caps = new DesiredCapabilities();
        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub/");

        if (platform == null || platform.isEmpty()) {
            platform = "android";
        }

        //start appium server programmatically
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withIPAddress("0.0.0.0")
                .usingPort(4723)
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .withAppiumJS(new File("/opt/homebrew/bin/appium"))
                .withEnvironment(Map.of("ANDROID_HOME", "/Users/airbamac/Library/Android/sdk"));
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();

        //using environment variables to start tests for either android or ios
        switch (platform) {
            case "android":
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "emulator-5554");
                caps.setCapability("appPackage", "com.google.android.gm");
                caps.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");
                caps.setCapability(MobileCapabilityType.NO_RESET, "true");
                caps.setCapability(MobileCapabilityType.FULL_RESET, "false");
                caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
                driver = new AppiumDriver(remoteUrl, caps);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

            case "ios":
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                caps.setCapability(MobileCapabilityType.UDID, "");
                caps.setCapability(MobileCapabilityType.NO_RESET, "false");
                caps.setCapability(MobileCapabilityType.FULL_RESET, "true");
                caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
                driver = new AppiumDriver(remoteUrl, caps);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
        }
    }

    //a boolean for emulator status
    private static boolean isEmulatorRunning() {
        boolean isRunning = false;
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("emulator")) {
                    isRunning = true;
                    break;
                }
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return isRunning;
    }

    // launching emulator programmatically
    private static void launchEmulator() {
        try {
            String emulatorCommand = "/Users/airbamac/Library/Android/sdk/emulator/emulator -avd Pixel_6_API_33";
            Runtime.getRuntime().exec(emulatorCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


