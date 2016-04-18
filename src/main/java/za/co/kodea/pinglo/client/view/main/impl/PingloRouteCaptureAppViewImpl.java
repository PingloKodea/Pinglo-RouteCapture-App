package za.co.kodea.pinglo.client.view.main.impl;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.text.shared.SimpleSafeHtmlRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.SimpleSafeHtmlCell;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.tree.Tree;
import za.co.kodea.pinglo.client.model.impl.Option;
import za.co.kodea.pinglo.client.presenter.Presenter;
import za.co.kodea.pinglo.client.presenter.main.PingloRouteCaptureAppPresenter;
import za.co.kodea.pinglo.client.view.main.PingloRouteCaptureAppView;

/**
 * Created by Ghost on 3/17/2016.
 */
public class PingloRouteCaptureAppViewImpl implements PingloRouteCaptureAppView{


    private static PingloRouteCaptureAppViewImplUiBinder ourUiBinder = GWT.create(PingloRouteCaptureAppViewImplUiBinder.class);
    private PingloRouteCaptureAppPresenter presenter;

    @UiField
    ContentPanel centerPanel;
    @UiField
    Tree<Option,String> tree;


    public PingloRouteCaptureAppViewImpl() {
    }


    @Override
    public Widget asWidget() {
        return   ourUiBinder.createAndBindUi(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = (PingloRouteCaptureAppPresenter) presenter;
    }

    @Override
    public void setCenterScreen(Widget widget) {
        centerPanel.add(widget);
    }

    @Override
    public void displayMessageBox(String title, String message) {
        new MessageBox(title,message).show();
    }

    @Override
    public ContentPanel getCenterScreen() {
        return centerPanel;
    }

    @UiFactory
    public TreeStore<Option> createOptions(){
        TreeStore<Option>  storeOptions = new TreeStore(new KeyProvider());

        Option r1 = new Option("Manage Taxi Rank","Manage Taxi Rank");
        storeOptions.add(r1);
        storeOptions.add(r1, new Option("Create Taxi Rank","Create Taxi Rank"));
        storeOptions.add(r1, new Option("View Taxi Rank","View Taxi Rank"));
        storeOptions.add(r1, new Option("Update Taxi Rank","Update Taxi Rank"));
        storeOptions.add(r1, new Option("Delete Taxi Rank","Update Taxi Rank"));

        Option r2 = new Option("Manage Taxi Routes","Manage Taxi Routes");
        storeOptions.add(r2);
        storeOptions.add(r2, new Option("Create Taxi Route","Create Taxi Route"));
        storeOptions.add(r2, new Option("View TaxiRoute","View TaxiRoute"));
        storeOptions.add(r2, new Option("Update Taxi Route","Update Taxi Route"));
        storeOptions.add(r2, new Option("Delete Taxi Route","Delete Taxi Route"));

        return storeOptions;
    }

    @UiFactory
    public Cell<String> createTreeEvent(){

        return new SimpleSafeHtmlCell<String>(SimpleSafeHtmlRenderer.getInstance(), "click", "touched") {
            @Override
            public void onBrowserEvent(Context context, Element parent, String value, NativeEvent event, ValueUpdater<String> valueUpdater) {
                super.onBrowserEvent(context, parent, value, event, valueUpdater);

                if ("touched".equals(event.getType()) || "click".equals(event.getType())) {
                    presenter.loadScreen(tree.getSelectionModel().getSelectedItem().getName());
                }
            }
        };
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

    interface PingloRouteCaptureAppViewImplUiBinder extends UiBinder<ContentPanel, PingloRouteCaptureAppViewImpl> {
    }
}