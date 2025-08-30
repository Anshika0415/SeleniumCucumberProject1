Feature: Login Functionality and testing various flows

Background:
Given agent enters "test@email.com" and "abcabc" and logins


@test
Scenario: Login in the site
  Then agent performs tasks on practice page


@test
Scenario: Test e-commerse website of lets code it
	Then enter into ecom website and register
	When agent tries to add an item
	Then agent should be able to checkout
	And agent should be able to check order status
	
	

  
 