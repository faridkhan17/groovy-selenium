import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = ['pretty', 'html:target/site/cucumber', 'json:target/json/cucumber.json', 'junit:target/junit/cucumber.xml'],
    features = ['src/test/resources/feature'],
    glue = ['src/test/groovy/stepdef'],
    strict = true,
    tags = ['@BuyingItemFeature']
)
class Runner {

}
