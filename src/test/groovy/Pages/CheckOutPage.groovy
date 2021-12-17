package Pages

import geb.Browser
import geb.Page
import geb.module.*
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class CheckOutPage extends Page {
    static at = {
        titleCheckout
    }

    static content = {
        titleCheckout(wait : true){$("h2").text() == "Checkout"}
        payWithCard(wait: true) {$('button[type=\'submit\']')}
        payWithCardWindow(wait: true) {$("h1").text() == "Stripe.com"}
        emailInput(wait: true) {$("#email").module(EmailInput)}
        cardInput(wait: true) {$("#card_number").module(TelInput)}
        dateInput(wait: true) {$("#cc-exp").module(TelInput)}
        cvcInput(wait: true) {$("#cc-csc").module(TelInput)}
        closeButton(wait: true) {$('a[class=\'close\']')}
    }

}


