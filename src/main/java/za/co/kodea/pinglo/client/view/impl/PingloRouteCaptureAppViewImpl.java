package za.co.kodea.pinglo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.tree.Tree;
import za.co.kodea.pinglo.client.model.OptionProperties;
import za.co.kodea.pinglo.client.model.impl.Option;

/**
 * Created by Ghost on 3/17/2016.
 */
public class PingloRouteCaptureAppViewImpl implements IsWidget {


    interface PingloRouteCaptureAppViewImplUiBinder extends UiBinder<VerticalLayoutContainer, PingloRouteCaptureAppViewImpl> {
    }

    private static PingloRouteCaptureAppViewImplUiBinder ourUiBinder = GWT.create(PingloRouteCaptureAppViewImplUiBinder.class);
    private static OptionProperties optionProperties = GWT.create(OptionProperties.class);

    private final VerticalLayoutContainer  appView;

    @UiField(provided = true)
    final TreeStore<Option> storeOptions = new TreeStore(optionProperties.key());

    public PingloRouteCaptureAppViewImpl() {
        initOptions();
        appView =  ourUiBinder.createAndBindUi(this);
    }

    @UiFactory
    public Tree createTree(){
        return new Tree(this.storeOptions,optionProperties.name());
    }

    @Override
    public Widget asWidget() {
        return appView;
    }

    private void initOptions(){

        Option r1 = new Option("Parent 1", "value1");
        storeOptions.add(r1);
        storeOptions.add(r1, new Option("Child 1.1", "value2"));
        storeOptions.add(r1, new Option("Child 1.2", "value3"));

        Option r2 = new Option("Parent 2", "value4");
        storeOptions.add(r2);
        storeOptions.add(r2, new Option("Child 2.1", "value5"));
        storeOptions.add(r2, new Option("Child 2.2", "value6"));

    }
}