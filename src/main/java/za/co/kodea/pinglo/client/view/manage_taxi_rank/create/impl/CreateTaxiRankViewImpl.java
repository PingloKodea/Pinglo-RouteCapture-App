package za.co.kodea.pinglo.client.view.manage_taxi_rank.create.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.maps.client.events.click.ClickMapEvent;
import com.google.gwt.maps.client.events.click.ClickMapHandler;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.maps.client.overlays.MarkerOptions;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;
import za.co.kodea.pinglo.shared.google.GoogleMap;
import za.co.kodea.pinglo.client.presenter.Presenter;
import za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.CreateTaxiRankPresenter;
import za.co.kodea.pinglo.client.view.manage_taxi_rank.create.CreateTaxiRankView;

import java.util.logging.Logger;

/**
 * Created by Ghost Desktop on 2016/04/14.
 */
public class CreateTaxiRankViewImpl implements CreateTaxiRankView {
    static Logger log = Logger.getLogger(CreateTaxiRankViewImpl.class.getName());

    private static CreateTaxiRankViewUiBinder ourUiBinder = GWT.create(CreateTaxiRankViewUiBinder.class);
    private CreateTaxiRankPresenter presenter;

    private MarkerOptions optionsMarker;
    private  Marker marker;

    @UiField(provided = true)
    ContentPanel mapPanel;
    @UiField(provided = true)
    TextField txtAddress;
    @UiHandler("save")
    public void click(SelectEvent selectEvent){
        presenter.validateLatLng(optionsMarker.getPosition());
    }


    public CreateTaxiRankViewImpl() {
        mapPanel = new ContentPanel();
        optionsMarker = MarkerOptions.newInstance();
        txtAddress = new TextField();
        GoogleMap.setMapPanel(mapPanel);
        GoogleMap.setMarkerBehaviour(createHandler());
    }

    private ClickMapHandler createHandler(){
        return new ClickMapHandler() {
            @Override
            public void onEvent(ClickMapEvent clickMapEvent) {
                log.info("event fired");
                optionsMarker.setPosition(clickMapEvent.getMouseEvent().getLatLng());
                //presenter.validateLatLng(clickMapEvent.getMouseEvent().getLatLng());

                if(marker == null){
                    marker =  Marker.newInstance(optionsMarker);
                    marker.setMap(GoogleMap.getGoogleMapInstance());
                }else{
                    marker.clear();
                    marker =  Marker.newInstance(optionsMarker);
                    marker.setMap(GoogleMap.getGoogleMapInstance());
                }
            }
        };
    }

    @Override
    public void setAddressTextField(String address) {
        txtAddress.clear();
        txtAddress.setText(address);
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