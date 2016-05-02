package za.co.kodea.pinglo.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.container.Viewport;
import za.co.kodea.pinglo.client.presenter.main.impl.PingloRouteCaptureAppPresenterImpl;
import za.co.kodea.pinglo.client.view.main.impl.PingloRouteCaptureAppViewImpl;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ProjectEntryPoint implements EntryPoint {

  @Override
  public void onModuleLoad() {
    Viewport viewport = new Viewport();
    RootPanel.get().add(viewport);

    new PingloRouteCaptureAppPresenterImpl(new PingloRouteCaptureAppViewImpl()).setViewport(viewport);
  }
}
