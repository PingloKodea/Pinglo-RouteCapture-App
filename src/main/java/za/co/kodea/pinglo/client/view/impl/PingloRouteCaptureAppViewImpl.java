package za.co.kodea.pinglo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;
import com.sencha.gxt.widget.core.client.tree.Tree;
import za.co.kodea.pinglo.client.model.impl.Option;

/**
 * Created by Ghost on 3/17/2016.
 */
public class PingloRouteCaptureAppViewImpl implements IsWidget {


    interface PingloRouteCaptureAppViewImplUiBinder extends UiBinder<VerticalLayoutContainer, PingloRouteCaptureAppViewImpl> {
    }

    private static PingloRouteCaptureAppViewImplUiBinder ourUiBinder = GWT.create(PingloRouteCaptureAppViewImplUiBinder.class);

    private final VerticalLayoutContainer appView;

    @UiField
    Tree<Option, String> tree;
    @UiField
    SimplePanel viewPanel;
    @UiField(provided = true)
    final TreeStore<Option>  storeOptions = new TreeStore(new KeyProvider());


    public PingloRouteCaptureAppViewImpl() {
        initOptions();
        appView = ourUiBinder.createAndBindUi(this);
    }


    @Override
    public Widget asWidget() {
        return appView;
    }

    private void initOptions() {

        Option r1 = new Option("Manage Taxi Rank");
        storeOptions.add(r1);
        storeOptions.add(r1, new Option("Create Taxi Rank"));
        storeOptions.add(r1, new Option("View Taxi Rank"));
        storeOptions.add(r1, new Option("Update Taxi Rank"));
        storeOptions.add(r1, new Option("Delete Taxi Rank"));

        Option r2 = new Option("Manage Taxi Routes");
        storeOptions.add(r2);
        storeOptions.add(r2, new Option("Create Taxi Route"));
        storeOptions.add(r2, new Option("View TaxiRoute"));
        storeOptions.add(r2, new Option("Update Taxi Route"));
        storeOptions.add(r2, new Option("Delete Taxi Route"));
        //tree.getStyle().setLeafIcon();

        tree.getSelectionModel().addSelectionHandler(new SelectionHandler<Option>() {
            @Override
            public void onSelection(SelectionEvent<Option> event) {
               tree.getSelectionModel().getSelectedItem();
            }
        });
    }

    @UiFactory
    public ValueProvider<Option, String> createValueProvider() {
        return new ValueProvider<Option, String>() {
            @Override
            public String getValue(Option object) {
                return object.getName();
            }

            @Override
            public void setValue(Option object, String value) {
            }

            @Override
            public String getPath() {
                return "name";
            }
        };
    }

    class KeyProvider implements ModelKeyProvider<Option> {
        @Override
        public String getKey(Option item) {
            return item.getName();
        }
    }


}