package za.co.kodea.pinglo.client.presenter.manage_taxi_rank.create;

import com.google.gwt.maps.client.base.LatLng;
import za.co.kodea.pinglo.client.presenter.Presenter;

/**
 * Created by Ghost Desktop on 2016/04/16.
 */
public interface CreateTaxiRankPresenter extends Presenter {
 public void validateLatLng(LatLng latLng);
}
