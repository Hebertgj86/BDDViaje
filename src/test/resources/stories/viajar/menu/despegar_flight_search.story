Meta:

Narrative:
As a user of despegar
I want to search a flight with my specifications
So that I can choose the best option for me

Scenario: search flight with same origin and destiny
Given I am on despegar.com.co home's page
When I fill search fields
|from|to|yyyyini|mmini|ddini|yyyyfin|mmfin|ddfin|
|Medellín, Antioquia, Colombia|Medellín, Antioquia, Colombia|2018|09|1|2018|09|28|
And click on search button
Then system show a same city error notification below destiny field

Scenario: search flight without destiny
Given I am on despegar.com.co home's page
When I fill search fields
|from|to|yyyyini|mmini|ddini|yyyyfin|mmfin|ddfin|
|Medellín, Antioquia, Colombia|Medellín, Antioquia, Colombia|2018|09|1|2018|09|28|
And click on search button
Then system show a destiny is empty error notification below origin field

Scenario: search flight without origin
Given I am on despegar.com.co home's page
When I fill search fields
|from|to|yyyyini|mmini|ddini|yyyyfin|mmfin|ddfin|
|Medellín, Antioquia, Colombia|Medellín, Antioquia, Colombia|2018|09|1|2018|09|28||
And click on search button
Then system show a origin is empty error notification below origin field

Scenario: search flight with same origin and destiny
Given I am on despegar.com.co home's page
When I fill search fields
|from|to|yyyyini|mmini|ddini|yyyyfin|mmfin|ddfin|
|Medellín, Antioquia, Colombia|Medellín, Antioquia, Colombia|2018|09|1|2018|09|28|
And click on search button
Then system show the result the consult
And system save the consult



