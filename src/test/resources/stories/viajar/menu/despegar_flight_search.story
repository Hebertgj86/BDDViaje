Meta:

Narrative:
As a user of despegar
I want to search a flight with my specifications
So that I can choose the best option for me


Scenario: search flight with same origin and destiny
Given I am on despegar.com.co home's page
When I fill search fields
|from                  |to                    |
|Medellín, Antioquia, Colombia|Cartagena de Indias, Bolívar, Colombia|
And click on search button
Then system show the result the consult
And system save the consult




