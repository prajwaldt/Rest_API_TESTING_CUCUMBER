Feature: validating place api

@addplacwwe
Scenario Outline: verifying the place added successfully using app place api
Given add placeapi payload  "<name>" "<language>" "<address>" 
When user calls "addplaceApi" api with "Post" methods 
Then the api call got with success 200
And "status" in response body is "OK" value
And "scope" in response body is "APP" value

Examples:
|name   |language|address|
|prajwal|Kannada|BNG|
# |puni|Kannada|DVG|  to comment use #

@addplace2
Scenario Outline: verifying the place added successfully using app place api
Given add placeapi payload  "<name>" "<language>" "<address>" 
When user calls "addplaceApi" api with "Post" methods 
Then the api call got with success 200
And "status" in response body is "OK" value
And "scope" in response body is "APP" value

Examples:
|name   |language|address|
#|prajwal|Kannada|BNG|
|puni|Kannada|DVG|  to comment use #

@deleteapi
Scenario: verify delete api
Given add delete api payload
When user calls deleteplaceApi api with Post methods
Then  in response body is  value