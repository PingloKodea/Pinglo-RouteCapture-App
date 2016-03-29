package za.co.kodea.pinglo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import za.co.kodea.pinglo.customized.myContentPanel;

/**
 * Created by Ghost on 3/17/2016.
 */
public class PingloRouteCaptureAppViewImpl implements IsWidget {


    interface PingloRouteCaptureAppViewImplUiBinder extends UiBinder<HorizontalLayoutContainer, PingloRouteCaptureAppViewImpl> {
    }

    private static PingloRouteCaptureAppViewImplUiBinder ourUiBinder = GWT.create(PingloRouteCaptureAppViewImplUiBinder.class);

    HorizontalLayoutContainer appView;

    @UiField
    ContentPanel manageTaxiRankPanel;
    @UiField
    ContentPanel manageTaxiRoutePanel;
    @UiField
    AccordionLayoutContainer menuContainer;

    @UiFactory
    public myContentPanel createContentPanel(ContentPanel.ContentPanelAppearance appearance) {
        return new myContentPanel(appearance);
    }

    public PingloRouteCaptureAppViewImpl() {
        appView =  ourUiBinder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {

        return appView;
    }
}