package za.co.kodea.pinglo.client.view.manage_taxi_rank.create.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.services.DirectionsRenderer;
import com.google.gwt.maps.client.services.DirectionsRendererOptions;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import za.co.kodea.pinglo.client.presenter.Presenter;
import za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.CreateTaxiRankPresenter;
import za.co.kodea.pinglo.client.view.manage_taxi_rank.create.CreateTaxiRankView;

import java.util.ArrayList;

/**
 * Created by Ghost Desktop on 2016/04/14.
 */
public class CreateTaxiRankViewImpl implements CreateTaxiRankView {


    private static CreateTaxiRankViewUiBinder ourUiBinder = GWT.create(CreateTaxiRankViewUiBinder.class);
    private CreateTaxiRankPresenter presenter;
    private LatLng centerLatLngRSA;
    private DirectionsRenderer directionsDisplay;
    private int mapZoom = 10;
    private MapOptions mapOptions;
    private  MapWidget mapWidget;

    @UiField(provided = true)
    ContentPanel mapPanel;


    public CreateTaxiRankViewImpl() {
        loadMapsLibraries();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (CreateTaxiRankPresenter) presenter;
        mapPanel = new ContentPanel();
    }

    private void initMap() {

        centerLatLngRSA = LatLng.newInstance(-29.10797, 26.14517);
        mapOptions = MapOptions.newInstance();
        mapOptions.setZoom(mapZoom);
        mapOptions.setMapTypeId(MapTypeId.ROADMAP);
        mapOptions.setCenter(centerLatLngRSA);

        mapWidget = new MapWidget(mapOptions);
        mapWidget.setSize("500px", "500px");

        DirectionsRendererOptions options = DirectionsRendererOptions.newInstance();
        directionsDisplay = DirectionsRenderer.newInstance(options);
        directionsDisplay.setMap(mapWidget);

        mapPanel.add(mapWidget);
    }

    private void loadMapsLibraries() {
        boolean sensor = true;

        // load all the libs for use in the maps
        ArrayList<LoadApi.LoadLibrary> loadLibraries = new ArrayList<>();
        loadLibraries.add(LoadApi.LoadLibrary.ADSENSE);
        loadLibraries.add(LoadApi.LoadLibrary.DRAWING);
        loadLibraries.add(LoadApi.LoadLibrary.GEOMETRY);
        loadLibraries.add(LoadApi.LoadLibrary.PANORAMIO);
        loadLibraries.add(LoadApi.LoadLibrary.PLACES);
        loadLibraries.add(LoadApi.LoadLibrary.WEATHER);
        loadLibraries.add(LoadApi.LoadLibrary.VISUALIZATION);

        Runnable onLoad = new Runnable() {
            @Override
            public void run() {
                initMap();
            }
        };

        LoadApi.go(onLoad, loadLibraries, sensor);
    }

    @Override
    public Widget asWidget() {
        return ourUiBinder.createAndBindUi(this);
    }

    interface CreateTaxiRankViewUiBinder extends UiBinder<TabPanel, CreateTaxiRankViewImpl> {
    }
}