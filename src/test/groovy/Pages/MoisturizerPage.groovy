package Pages

import geb.Page
import org.openqa.selenium.By

class MoisturizerPage extends Page {
    static at = {
        addButton
    }

    static content = {
        addButton(wait: true) {$(By.xpath("/html/body/div[1]/div[2]/div[1]/button"))}
        cartItems(wait: true) {$("#cart")}
    }
}
