package za.co.kodea.pinglo.client.view.main;

import com.google.gwt.user.client.ui.Widget;
import za.co.kodea.pinglo.client.view.View;

/**
 * Created by Ghost on 3/17/2016.
 */
public interface PingloRouteCaptureAppView extends View {
    void displayMessageBox(String title,String message);
    void setCenterScreen(Widget widget);
}
