package TestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pojo.Location;
import pojo.addPlace;

public class AddPlaceTestData {

	public String deletePlacePayload;

	public addPlace addPlacePayload(String name, String language, String address)
	{
		addPlace add = new addPlace();
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		add.setLocation(loc);
		add.setAccuracy(50);
		add.setName(name);
		add.setPhone_number("(+91)9838933937");
		add.setAddress(address);
		add.setWebsite("http://google.com");
		add.setLanguage(language);
		List<String> types = new ArrayList<>();
		types.add("shoe park");
		types.add("shop");
		add.setTypes(types);
		return add;
	}

	public Map<String, String> deletePlacePayload(String placeId) {
        Map<String, String> map = new HashMap<>();
        map.put("place_id", placeId);
        return map;
    }
}