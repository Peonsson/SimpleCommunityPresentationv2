package org.peonsson.com.ViewModels;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Peonsson on 27/11/15.
 */
@XmlRootElement
public class ReturnBooleanViewModel {

    private boolean bool;

    public ReturnBooleanViewModel() {
    }

    public ReturnBooleanViewModel(boolean bool) {
        this.bool = bool;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
