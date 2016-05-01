package za.co.kodea.pinglo.shared.google;

import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
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

    private static LatLng centerLatLngRSA;
    private static DirectionsRenderer directionsDisplay;
    private static MapOptions mapOptions;
    private static MapWidget mapWidget;


    private GoogleMap() {
    }

    public static void loadMapsLibraries() {
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

    private static void initMap() {

        mapWidget = new MapWidget(getMapOptions());

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
    }

    private static MapOptions getMapOptions(){
        centerLatLngRSA = LatLng.newInstance(-29.10797, 26.14517);
        mapOptions = MapOptions.newInstance();
        mapOptions.setZoom(6);
        mapOptions.setMapTypeId(MapTypeId.ROADMAP);
        mapOptions.setCenter(centerLatLngRSA);
        return mapOptions;
    }

    private static void resizeMap(int width, int height) {
        int mapX = mapWidget.getAbsoluteLeft();
        int mapY = mapWidget.getAbsoluteTop();
        int newWidth = width - mapX;
        int newHeight = height - mapY;
        mapWidget.setSize( newWidth + "px", newHeight + "px");
    }

    public static void setMarkerBehaviour(ClickMapHandler handler){
        mapWidget.addClickHandler(handler);
    }

    public static void setMapPanel(ContentPanel panel){
        mapWidget.setOptions(getMapOptions());
        panel.add(mapWidget);
    }

    public static MapWidget getGoogleMapInstance(){
        return mapWidget;
    }

}
