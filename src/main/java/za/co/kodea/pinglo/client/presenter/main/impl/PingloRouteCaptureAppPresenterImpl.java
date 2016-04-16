package za.co.kodea.pinglo.client.presenter.main.impl;

import com.sencha.gxt.widget.core.client.container.Viewport;
import za.co.kodea.pinglo.client.presenter.main.PingloRouteCaptureAppPresenter;
import za.co.kodea.pinglo.client.view.main.PingloRouteCaptureAppView;
import za.co.kodea.pinglo.client.view.manage_taxi_rank.create.impl.CreateTaxiRankViewImpl;

/**
 * Created by Ghost Desktop on 2016/04/13.
 */
public class PingloRouteCaptureAppPresenterImpl implements PingloRouteCaptureAppPresenter{

    private final PingloRouteCaptureAppView view;

    public PingloRouteCaptureAppPresenterImpl(PingloRouteCaptureAppView view) {
        this.view = view;
        bind();
    }

    @Override
    public void bind() {
        view.setPresenter(this);
    }

    @Override
    public void go(Viewport viewport) {
        viewport.add(view);
    }

    @Override
    public void loadScreen(String screenName) {

        switch(screenName){
            case"Create Taxi Rank": view.setCenterScreen(new CreateTaxiRankViewImpl().asWidget()); break;
            case"View Taxi Rank": view.displayMessageBox("Error","View Taxi Rank"); break;
            case"Update Taxi Rank": view.displayMessageBox("Error","Update Taxi Rank");  break;
            case"Delete Taxi Rank": view.displayMessageBox("Error","Delete Taxi Rank"); break;
            case"Create Taxi Route": view.displayMessageBox("Error","Create Taxi Route"); break;
            case"View TaxiRoute": view.displayMessageBox("Error","View TaxiRoute"); break;
            case"Update Taxi Route": view.displayMessageBox("Error","Update Taxi Route"); break;
            case"Delete Taxi Route": view.displayMessageBox("Error","Delete Taxi Route"); break;
            default: view.displayMessageBox("Error","Option not recognised");
        }
    }
}
