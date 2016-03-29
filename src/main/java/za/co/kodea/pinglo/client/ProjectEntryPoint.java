package za.co.kodea.pinglo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import za.co.kodea.pinglo.client.view.PingloRouteCaptureAppView;
import za.co.kodea.pinglo.client.view.TransitDirectionsServiceMapWidget;
import za.co.kodea.pinglo.client.view.impl.PingloRouteCaptureAppViewImpl;

import java.util.ArrayList;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjectEntryPoint implements EntryPoint {

  @Override
  public void onModuleLoad() {
    RootPanel.get().add(new PingloRouteCaptureAppViewImpl().asWidget());
  }

//  private void loadMapApi() {
//    boolean sensor = true;
//
//    // load all the libs for use in the maps
//    ArrayList<LoadApi.LoadLibrary> loadLibraries = new ArrayList<>();
//    loadLibraries.add(LoadApi.LoadLibrary.ADSENSE);
//    loadLibraries.add(LoadApi.LoadLibrary.DRAWING);
//    loadLibraries.add(LoadApi.LoadLibrary.GEOMETRY);
//    loadLibraries.add(LoadApi.LoadLibrary.PANORAMIO);
//    loadLibraries.add(LoadApi.LoadLibrary.PLACES);
//    loadLibraries.add(LoadApi.LoadLibrary.WEATHER);
//    loadLibraries.add(LoadApi.LoadLibrary.VISUALIZATION);
//
//    Runnable onLoad = new Runnable() {
//      @Override
//      public void run() {
//        draw();
//      }
//    };
//
//    LoadApi.go(onLoad, loadLibraries, sensor);
//  }
//
//  private void draw() {
//    drawTransitDirections();
//  }
//
//  private void drawTransitDirections() {
//    TransitDirectionsServiceMapWidget wMap = new TransitDirectionsServiceMapWidget();
//    addMapWidget(wMap);
//  }
//
//  private void addMapWidget(Widget widget) {
//    RootPanel.get().add(widget);
//  }

}
