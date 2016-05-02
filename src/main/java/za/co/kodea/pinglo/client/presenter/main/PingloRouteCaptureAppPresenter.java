package za.co.kodea.pinglo.client.presenter.main;


import com.google.gwt.user.client.ui.Panel;
import com.sencha.gxt.widget.core.client.container.Viewport;
import za.co.kodea.pinglo.client.presenter.Presenter;

/**
 * Created by Ghost Desktop on 2016/04/13.
 */
public interface PingloRouteCaptureAppPresenter extends Presenter {
    void loadScreen(String screenName);
    void setViewport(Viewport viewport);
}
