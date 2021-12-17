package stepdef

import geb.Browser
import geb.binding.BindingUpdater
import geb.driver.CachingDriverFactory
import org.openqa.selenium.OutputType
import org.openqa.selenium.WebDriverException

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

def bindingUpdater
def theBrowser

Before { scenario ->
  println "Starting scenario '${scenario.name}'"
  if (!binding.hasVariable('browser')) {
    theBrowser = new Browser()
    bindingUpdater = new BindingUpdater(binding, theBrowser)
    bindingUpdater.initialize()
  }
}

After { scenario ->
  println "Finished scenario '${scenario.name}' with status '${scenario.status}'"
  bindingUpdater?.remove()

  theBrowser = null
}

