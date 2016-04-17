package za.co.kodea.pinglo.client.model.google;

import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.events.click.ClickMapEvent;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.maps.client.services.DirectionsRenderer;
import com.google.gwt.maps.client.services.DirectionsRendererOptions;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.WindowResizeListener;
import com.sencha.gxt.widget.core.client.ContentPanel;

import java.util.ArrayList;

/**
 * Created by Ghost Desktop on 2016/04/17.
 */
public class GoogleMap {

    private int markerBehaviour;
    public static final int REGISTER_RANK = 1;

    private LatLng centerLatLngRSA;
    private DirectionsRenderer directionsDisplay;
    private int mapZoom = 6;
    private MapOptions mapOptions;
    private  MapWidget mapWidget;
    private ContentPanel mapPanel;
    private MarkerOptions optionsMarker;
    private Marker marker;

    public GoogleMap(ContentPanel mapPanel, int markerType) {
        markerBehaviour = markerType;
        this.mapPanel = mapPanel;
        loadMapsLibraries();
    }

    private void initMap() {

        centerLatLngRSA = LatLng.newInstance(-29.10797, 26.14517);
        mapOptions = MapOptions.newInstance();
        mapOptions.setZoom(mapZoom);
        mapOptions.setMapTypeId(MapTypeId.ROADMAP);
        mapOptions.setCenter(centerLatLngRSA);
        mapWidget = new MapWidget(mapOptions);

        //auto resize the map
        resizeMap(Window.getClientWidth(), Window.getClientHeight()-300);

        Window.addWindowResizeListener(new WindowResizeListener() {

            public void onWindowResized(int width, int height) {
                resizeMap(width, height);
            }
        });

        DirectionsRendererOptions options = DirectionsRendererOptions.newInstance();
        directionsDisplay = DirectionsRenderer.newInstance(options);
        directionsDisplay.setMap(mapWidget);

        addMarkerBehaviour();
        mapPanel.add(mapWidget);
    }

    private void resizeMap(int width, int height) {
        int mapX = mapWidget.getAbsoluteLeft();
        int mapY = mapWidget.getAbsoluteTop();
        int newWidth = width - mapX;
        int newHeight = height - mapY;
        mapWidget.setSize( newWidth + "px", newHeight + "px");
    }

    private void addMarkerBehaviour(){
        switch(markerBehaviour){
            case REGISTER_RANK:addMarkerOnClick1(); break;
            default: break;
        }
    }

    private void addMarkerOnClick1(){
        optionsMarker = MarkerOptions.newInstance();

        mapWidget.addClickHandler(new ClickMapHandler() {
            @Override
            public void onEvent(ClickMapEvent clickMapEvent) {
                optionsMarker.setPosition(clickMapEvent.getMouseEvent().getLatLng());

                if(marker == null){
                    marker =  Marker.newInstance(optionsMarker);
                    marker.setMap(mapWidget);
                }else{
                    marker.clear();
                    marker =  Marker.newInstance(optionsMarker);
                    marker.setMap(mapWidget);
                }
            }
        });
    }

    public void loadMapsLibraries() {
        boolean sensor = false;

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

    public MapWidget getMapWidget() {
        return mapWidget;
    }


}
