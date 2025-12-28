Feature: Google Maps Add Place API
@AddPlace
Scenario Outline: Add a new place successfully

     Given user provides add place payload with "<name>" "<language>" "<address>"
     When user hits "addPlaceAPI" with "POST" request
     Then API should return status code 200
     And response status should be "OK"
     And response should contain place id

Examples:
   |name|language|address|
   |Mickey|Spanish|Down Town|
   |Minnie|Spanish|New York|

@GetPlace
Scenario: Get place API
    Given user fetches existing place with place_id
    When user hits "getPlaceAPI" with "GET" request
    Then API should return status code 200


@DeletePlace
Scenario: Delete a newly added place

     Given user provided delete place api
     When user hits "deletePlaceAPI" with "POST" request
     Then API should return status code 200