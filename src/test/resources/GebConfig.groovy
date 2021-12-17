import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Platform
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

waiting {
  timeout = 20
  retryInterval = 0.2
}

headless = "headless" == "true"

environments {
  'firefox' {
    println ">>> Test on local-firefox"
    WebDriverManager.firefoxdriver().setup()

    FirefoxOptions options = new FirefoxOptions()
    options.setCapability("marionette", true)


    if (headless) {
      options.setHeadless(true)
    }
    driver = {
      DesiredCapabilities desiredCapabilities = new DesiredCapabilities()
      desiredCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1)

      def driver = new FirefoxDriver(desiredCapabilities.merge(options))
      driver.manage().window().maximize()
      return driver
    }
  }

  'chrome' {
    println ">>> Test on local-chrome"
    WebDriverManager.chromedriver().setup()

    driver = {
      ChromeOptions options = new ChromeOptions()


      options.addArguments("start-maximized")

      if (headless) {
        options.addArguments("window-size=1920,1080")
        options.addArguments('headless')
        options.setCapability("platform", Platform.WINDOWS);

      }

      new ChromeDriver(options)
    }
  }
}
