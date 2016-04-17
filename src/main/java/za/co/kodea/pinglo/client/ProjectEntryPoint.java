package za.co.kodea.pinglo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.maps.client.LoadApi;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.Viewport;
import za.co.kodea.pinglo.client.presenter.main.impl.PingloRouteCaptureAppPresenterImpl;
import za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.impl.CreateTaxiRankPresenterImpl;
import za.co.kodea.pinglo.client.view.TransitDirectionsServiceMapWidget;
import za.co.kodea.pinglo.client.view.main.impl.PingloRouteCaptureAppViewImpl;
import za.co.kodea.pinglo.client.view.manage_taxi_rank.create.impl.CreateTaxiRankViewImpl;

import java.util.ArrayList;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjectEntryPoint implements EntryPoint {

  @Override
  public void onModuleLoad() {
    Viewport viewport = new Viewport();
    RootPanel.get().add(viewport);

    new PingloRouteCaptureAppPresenterImpl(new PingloRouteCaptureAppViewImpl()).go(viewport);
    //new CreateTaxiRankPresenterImpl(new CreateTaxiRankViewImpl()).go(viewport);

    //viewport.add(new CreateTaxiRankViewImpl());
   // loadMapApi();
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
