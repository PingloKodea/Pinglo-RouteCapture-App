package za.co.kodea.pinglo.client.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import za.co.kodea.pinglo.client.model.impl.Option;

/**
 * Created by Ghost Desktop on 2016/04/11.
 */
public interface OptionProperties  extends PropertyAccess {

    @Editor.Path("name")
    ModelKeyProvider key();
    ValueProvider<Option,String> name();
    ValueProvider<Option,String> value();
}
