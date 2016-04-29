package za.co.kodea.pinglo.client.view.manage_taxi_route.create.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.overlays.Marker;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.StringLabelProvider;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.form.SimpleComboBox;
import za.co.kodea.pinglo.client.model.google.GoogleMap;
import za.co.kodea.pinglo.client.model.impl.Province;
import za.co.kodea.pinglo.client.presenter.Presenter;
import za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.CreateTaxiRankPresenter;
import za.co.kodea.pinglo.client.presenter.manage_taxi_route.create.CreateTaxiRoutePresenter;
import za.co.kodea.pinglo.client.view.manage_taxi_route.create.CreateTaxiRouteView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ghost Desktop on 2016/04/18.
 */
public class CreateTaxiRouteViewImpl implements CreateTaxiRouteView {


    private static CreateTaxiRouteViewImplUiBinder ourUiBinder = GWT.create(CreateTaxiRouteViewImplUiBinder.class);
    private CreateTaxiRoutePresenter presenter;
    private MapWidget mapWidget;
    private GoogleMap googleMap;
    private Marker mapMarker;

    @UiField(provided = true)
    ContentPanel mapPanel;
    @UiField(provided = true)
    SimpleComboBox<String> comboOriginProvince;
    @UiField(provided = true)
    SimpleComboBox<String> comboDestinationProvince;
    @UiField(provided = true)
    SimpleComboBox<String> comboOriginRank;
    @UiField(provided = true)
    SimpleComboBox<String> comboDestinationRank;

    public CreateTaxiRouteViewImpl() {
        initUIComboBoxes();
        initMap();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (CreateTaxiRoutePresenter) presenter;
    }

    @Override
    public Widget asWidget() {
        return ourUiBinder.createAndBindUi(this);
    }

    private void initMap() {
        mapPanel = new ContentPanel();
        googleMap = new GoogleMap(mapPanel,GoogleMap.REGISTER_RANK);
        mapWidget = googleMap.getMapWidget();
    }

    private void initUIComboBoxes() {
        initProvinceComboBoxes();
        initRankComboBoxes();
    }

    private void initRankComboBoxes() {
        comboOriginRank = new SimpleComboBox(new StringLabelProvider<String>());
        comboDestinationRank = new SimpleComboBox(new StringLabelProvider<String>());

        List<String> list = new ArrayList();
        list.add("Bree");
        list.add("Noord");

        comboOriginRank.add(list);
        comboDestinationRank.add(list);

    }

    private void initProvinceComboBoxes() {
        comboOriginProvince = new SimpleComboBox(new StringLabelProvider<String>());
        comboDestinationProvince = new SimpleComboBox(new StringLabelProvider<String>());

        List<String> list = new ArrayList();
        list.add("Eastern Cape");
        list.add("Free State");
        list.add("Gauteng");
        list.add("KwaZulu-Natal");
        list.add("Limpopo");
        list.add("Mpumalanga");
        list.add("Northern Cape");
        list.add("North West");

        comboOriginProvince.add(list);
        comboDestinationProvince.add(list);
    }



    interface CreateTaxiRouteViewImplUiBinder extends UiBinder<TabPanel, CreateTaxiRouteViewImpl> {
    }
}