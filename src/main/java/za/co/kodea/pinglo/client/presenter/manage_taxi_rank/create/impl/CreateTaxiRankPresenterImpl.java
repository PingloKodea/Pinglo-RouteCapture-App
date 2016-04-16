package za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.impl;

import com.sencha.gxt.widget.core.client.container.Viewport;
import za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create.CreateTaxiRankPresenter;
import za.co.kodea.pinglo.client.view.manage_taxi_rank.create.CreateTaxiRankView;

/**
 * Created by Ghost Desktop on 2016/04/16.
 */
public class CreateTaxiRankPresenterImpl implements CreateTaxiRankPresenter {

    private final CreateTaxiRankView view;

    public CreateTaxiRankPresenterImpl(CreateTaxiRankView view) {
        this.view = view;
        bind();
    }

    @Override
    public void bind() {
        view.setPresenter(this);
    }

    @Override
    public void go(Viewport viewport) {

    }
}
