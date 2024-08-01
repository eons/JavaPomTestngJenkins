package baseTC;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class BaseTC {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;

// ----------------------------------------------------------------------------------------------
// *************************** Data coming from XML file ****************************************
// ----------------------------------------------------------------------------------------------
    @BeforeClass(groups={"master", "parabank", "demowf", "dataProvider"})
    @Parameters({"os", "browser", "url"})
    public void setup(String os, String br, String url) throws IOException {

        logger = LogManager.getLogger(this.getClass());

        switch(br.toLowerCase()){
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;
            default: System.out.println("Invalid browser name"); return;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();
    }

// ----------------------------------------------------------------------------------------------
// ********************* For selenium GRID with Config.´properties file *************************
// ----------------------------------------------------------------------------------------------
//    @BeforeClass
//    @Parameters({"os", "browser"})
//    public void setup(String os, String br) throws IOException {
//
//        String path = "D:/MyWorkspace/learnings/Java/coe_mar_2024_java/src/main/resources/config.properties";
//        FileReader file = new FileReader(path);
//        p = new Properties();
//        p.load(file);
//        System.out.println("env: " + p.getProperty("execution_env"));
//        System.out.println("SO: " + os);
//        System.out.println("browser: " + br);
//        if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//
//            if(os.equalsIgnoreCase("windows")){
//                capabilities.setPlatform(Platform.WIN11);
//            }else if(os.equalsIgnoreCase("mac")){
//                capabilities.setPlatform(Platform.MAC);
//            }else if (os.equalsIgnoreCase("linux")){
//                capabilities.setPlatform(Platform.LINUX);
//            }else {
//                System.out.println("No matching OS");
//                return;
//            }
//
//            switch(br.toLowerCase()){
//                case "chrome": capabilities.setBrowserName("chrome"); break;
//                case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
//                case "firefox": capabilities.setBrowserName("firefox"); break;
//                case "safari": capabilities.setBrowserName("safari"); break;
//                default: System.out.println("Invalid browser name"); return;
//            }
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//        }
//
//        if(p.getProperty("execution_env").equalsIgnoreCase("local")){
//            switch(br.toLowerCase()){
//            case "chrome": driver = new ChromeDriver(); break;
//            case "edge": driver = new EdgeDriver(); break;
//            case "firefox": driver = new FirefoxDriver(); break;
//            default: System.out.println("Invalid browser name"); return;
//            }
//        }
//
//        logger = LogManager.getLogger(this.getClass());
//        logger.info("So: " + os + " || Browser: " + br);
//
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get(p.getProperty("appURL1"));
//        driver.manage().window().maximize();
//    }

// ----------------------------------------------------------------------------------------------
// ************************ Data coming from Config.´properties file ****************************
// ----------------------------------------------------------------------------------------------
//    @BeforeClass
//    public void setup(String os, String br) throws IOException {
//
//        FileReader file = new FileReader("./resources//config.properties");
//        p = new Properties();
//        p.load(file);
//
//        logger = LogManager.getLogger(this.getClass());
//        switch(br.toLowerCase()){
//            case "chrome": driver = new ChromeDriver(); break;
//            case "edge": driver = new EdgeDriver(); break;
//            case "firefox": driver = new FirefoxDriver(); break;
//            default: System.out.println("Invalid browser name"); return;
//        }
//
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get(p.getProperty("appURL1"));
//        driver.manage().window().maximize();
//    }


// ----------------------------------------------------------------------------------------------
// ******************************* Simple driver settings ***************************************
// ----------------------------------------------------------------------------------------------
//    @BeforeClass
//    public void setup() throws IOException {
//
//        logger = LogManager.getLogger(this.getClass());
//        driver = new ChromeDriver();
//
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://parabank.parasoft.com/parabank/index.htm");
//        driver.manage().window().maximize();
//    }
//
//    @AfterClass(groups={"master", "parabank", "demowf", "dataProvider"})
//    public void teardown(){
//        driver.quit();
//    }

    // -----------------------------------------------------------------------------------------

    public String randomString(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomOneNumber(){
        return RandomStringUtils.randomNumeric(1);
    }

    public String randomTwoNumbers(){
        return RandomStringUtils.randomNumeric(2);
    }

    public String randomFourNumbers(){
        return RandomStringUtils.randomNumeric(4);
    }

    public String randomFiveNumbers(){
        return RandomStringUtils.randomNumeric(5);
    }

    public String randomNineNumbers(){
        return RandomStringUtils.randomNumeric(9);
    }

    public String randomTenNumbers(){
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomDate(){
        String first = randomOneNumber();
        String second = randomTwoNumbers();
        String third = "2024";
        return (first + "/" + second + "/" + third);
    }

    public String randomAlphaNumberic(){
        String characters = RandomStringUtils.randomAlphabetic(5);
        String numbers = RandomStringUtils.randomNumeric(10);
        return (characters + numbers);
    }

    public String captureScreen(String testName) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") +"\\screenshots\\" + testName + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
