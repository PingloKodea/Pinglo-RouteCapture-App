package za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.impl;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.services.GeocoderAddressComponent;
import com.google.gwt.maps.client.services.GeocoderResult;
import com.sencha.gxt.widget.core.client.ContentPanel;
import za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.CreateTaxiRankPresenter;
import za.co.kodea.pinglo.client.view.manage_taxi_rank.create.CreateTaxiRankView;
import za.co.kodea.pinglo.shared.google.api.Geocoding.GeocodingService;

/**
 * Created by Ghost Desktop on 2016/04/16.
 */
public class CreateTaxiRankPresenterImpl implements CreateTaxiRankPresenter {

    private final CreateTaxiRankView view;

    private LatLng latLng;
    private String address;
    private GeocodingService service;
    private GeocoderResult geocoderResult;

    public CreateTaxiRankPresenterImpl(CreateTaxiRankView view) {
        this.view = view;
        service = new GeocodingService();
        bind();
    }

    @Override
    public void validateLatLng(LatLng latLng) {
        this.latLng = latLng;
        address = buildAddress(service.getAddress(latLng));

    }

    private String buildAddress(GeocoderResult result) {

        String street_number = "";
        String route = "";
        String neighborhood = "";
        String sublocality = "";
        String administrative_area_level_1 = "";
        String administrative_area_level_2 = "";

        geocoderResult = result;
        GeocoderAddressComponent addressComponent;
        JsArray<GeocoderAddressComponent> jsArrayAddressComponent = geocoderResult.getAddress_Components();

        for (int index = 0; index < geocoderResult.getAddress_Components().length(); index++) {
            addressComponent = jsArrayAddressComponent.shift();

            switch (addressComponent.getTypes().get(0)) {
                case "street_number":
                    street_number = addressComponent.getShort_Name();
                    break;
                case "route":
                    route = addressComponent.getShort_Name();
                    break;
                case "neighborhood":
                    neighborhood = addressComponent.getShort_Name();
                    break;
                case "sublocality":
                    sublocality = addressComponent.getShort_Name();
                    break;
                case "administrative_area_level_1":
                    administrative_area_level_1 = addressComponent.getShort_Name();
                    break;
                case "administrative_area_level_2":
                    administrative_area_level_2 = addressComponent.getShort_Name();
                    break;
            }
        }

        return ((street_number != "") ? street_number + ", " : "") +
                ((route != "") ? route + ", " : "") +
                ((neighborhood != "") ? neighborhood + ", " : "") +
                ((sublocality != "") ? sublocality + ", " : "") +
                ((administrative_area_level_1 != "") ? administrative_area_level_1 + ", " : "") +
                ((administrative_area_level_2 != "") ? administrative_area_level_2 + ", " : "");
    }

    @Override
    public void bind() {
        view.setPresenter(this);
    }

    @Override
    public void go(ContentPanel contentPanel) {
        contentPanel.add(view.asWidget());
    }
}
