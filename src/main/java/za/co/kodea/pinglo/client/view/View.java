package za.co.kodea.pinglo.client.view;

import com.google.gwt.user.client.ui.IsWidget;
import za.co.kodea.pinglo.client.presenter.Presenter;

/**
 * Created by Ghost Desktop on 2016/04/16.
 */
public interface View extends IsWidget {
    void setPresenter(Presenter presenter);
}
