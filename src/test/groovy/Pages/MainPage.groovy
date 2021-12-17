package Pages

import geb.Page
import org.openqa.selenium.By

class MainPage extends Page {

    static at = {
        moisturizerButton
    }

    static content = {
        moisturizerButton(wait: true) { $('a[href=\'/moisturizer\']')}
    }
}
