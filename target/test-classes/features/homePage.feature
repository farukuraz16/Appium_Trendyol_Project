@Appium_Trendyol
  Feature: Trendyol

    @SearchAndCheckCart
    Scenario: Search Product Check Cart
      Given user should see Home Page
      When user search "tshirt" on Home Page
      And user taps Filter on Result Page
      And user taps "Kargo Bedava" on Filter Page
      And user taps ÜRÜNLERİ LİSTELE button on Filter Page
      And user taps Order on Result Page
      And user taps "En Çok Değerlendirilen" option on Order Page
      And user taps second product on Result Page
      And user add the product to shopping cart on the Product Page
      And user taps "M" size on the Product Page
      Then user should see the product on the Cart Page
      When user taps Delete button on Cart Page
      And user taps Popup Delete button on Cart Page
      Then user should see the message "Sepetinizde ürün bulunmamaktadır" on Cart Page




