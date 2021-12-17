package stepdef.featurestep

import Pages.CheckOutPage
import Pages.MainPage
import Pages.MoisturizerPage
import geb.Browser

import java.sql.Time

import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.When
import static cucumber.api.groovy.EN.And

def mainPage = new MainPage()
def moisturizerPage = new MoisturizerPage()
def checkOutPage = new CheckOutPage()


Given(~/^Launch Application "([^"]*)"$/) { String url ->
  Browser.drive {
    go url}
}

Then(~/^User sees a URL GUI$/) { ->
  Browser.drive {
    assert title == "Current Temperature"
  }
}

When(~/^User clicks on the buy moisturisers button$/) { ->
  at mainPage
  mainPage.moisturizerButton.click()
}

Then(~/^User sees a Moisturisers page$/) { ->
  Browser.drive {
    assert title == "The Best Moisturizers in the World!"
  }
}

When(~/^User clicks on the Add Button on first moisturiser$/) { ->
  at moisturizerPage
  waitFor{moisturizerPage.addButton.displayed}
  moisturizerPage.addButton.click()
}

Then(~/^User sees cart changes from empty to "([^"]*)" item$/) { String items ->
  waitFor {moisturizerPage.cartItems.displayed}
  moisturizerPage.cartItems.text() == items
}

When(~/^User clicks on the cart in the top right corner$/) { ->
  moisturizerPage.cartItems.click()
}

Then(~/^User sees a checkout page$/) { ->
  Browser.drive {
    assert title == "Cart Items"
  }
}

When(~/^User clicks on the Pay with Card button$/) { ->
  at checkOutPage
  waitFor {checkOutPage.payWithCard.displayed}
  checkOutPage.payWithCard.click()
}

Then(~/Application switch to "([^"]*)"/){ String frameId->
  Browser.drive {browser.driver.switchTo().frame(frameId)}
}

Then(~/^User sees a new window to enter the card details$/) { ->
  waitFor{checkOutPage.payWithCardWindow}
}

When(~/^User enters the "([^"]*)", "([^"]*)","([^"]*)" and "([^"]*)"$/) { String email, String cardNumber, String date, String cvc ->
  waitFor {checkOutPage.emailInput.displayed}
  checkOutPage.emailInput.text = email
  checkOutPage.cardInput.text = cardNumber
  checkOutPage.dateInput.text = date
  checkOutPage.cvcInput.text = cvc
}

When(~/^User clicks on the close button$/) { ->
  checkOutPage.closeButton.click()
}

And(~/^User closes the page$/) { ->
  Browser.drive {
    browser.close()
  }
}
