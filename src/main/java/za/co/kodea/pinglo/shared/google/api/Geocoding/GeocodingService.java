package za.co.kodea.pinglo.shared.google.api.Geocoding;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.*;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.services.*;
import com.google.gwt.user.client.Window;
import za.co.kodea.pinglo.shared.google.key.Key;

import java.util.Objects;

/**
 * Created by Ghost Desktop on 2016/04/30.
 */
public class GeocodingService {

    public GeocodingService() {
    }

    public GeocoderResult getAddress(LatLng latLng){
        final GeocoderResult[] result = new GeocoderResult[1];

        GeocoderRequest request = GeocoderRequest.newInstance();
        request.setLocation(latLng);

        Geocoder geocoder = Geocoder.newInstance();
        geocoder.geocode(request, new GeocoderRequestHandler() {
            @Override
            public void onCallback(JsArray<GeocoderResult> jsArray, GeocoderStatus geocoderStatus) {
                if (geocoderStatus == GeocoderStatus.OK) {
                   result[0] = jsArray.shift();
                } else {
                    Window.alert("request failed");
                }
            }
        });

        return result[0];
    }




}
