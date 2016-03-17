package za.co.kodea.pinglo.client.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Created by Ghost on 3/17/2016.
 */
public class PingloRouteCaptureAppViewImpl extends Composite {
    interface PingloRouteCaptureAppViewImplUiBinder extends UiBinder<HTMLPanel, PingloRouteCaptureAppViewImpl> {
    }

    private static PingloRouteCaptureAppViewImplUiBinder ourUiBinder = GWT.create(PingloRouteCaptureAppViewImplUiBinder.class);

    public PingloRouteCaptureAppViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}