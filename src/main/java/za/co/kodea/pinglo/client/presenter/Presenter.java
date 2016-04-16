package za.co.kodea.pinglo.client.presenter;

import com.sencha.gxt.widget.core.client.container.Viewport;

/**
 * Created by Ghost Desktop on 2016/04/16.
 */
public interface Presenter {
    void bind();
    void go(Viewport viewport);
}
