package za.co.kodea.pinglo.client.view.manage_taxi_rank.create.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import za.co.kodea.pinglo.client.model.google.GoogleMap;
import za.co.kodea.pinglo.client.presenter.Presenter;
import za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.CreateTaxiRankPresenter;
import za.co.kodea.pinglo.client.view.manage_taxi_rank.create.CreateTaxiRankView;

/**
 * Created by Ghost Desktop on 2016/04/14.
 */
public class CreateTaxiRankViewImpl implements CreateTaxiRankView {


    private static CreateTaxiRankViewUiBinder ourUiBinder = GWT.create(CreateTaxiRankViewUiBinder.class);
    private CreateTaxiRankPresenter presenter;
    private  MapWidget mapWidget;
    private GoogleMap googleMap;
    private Marker mapMarker;

    @UiField(provided = true)
    ContentPanel mapPanel;

    public CreateTaxiRankViewImpl() {
        mapPanel = new ContentPanel();
        googleMap = new GoogleMap(mapPanel,GoogleMap.REGISTER_RANK);
        mapWidget = googleMap.getMapWidget();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (CreateTaxiRankPresenter) presenter;
    }

    @Override
    public Widget asWidget() {
        return ourUiBinder.createAndBindUi(this);
    }

    interface CreateTaxiRankViewUiBinder extends UiBinder<TabPanel, CreateTaxiRankViewImpl> {
    }
}