package org.peonsson.com.ViewModels;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Peonsson on 27/11/15.
 */
@XmlRootElement
public class ReturnCodeViewModel {

    private int id;

    public ReturnCodeViewModel() {
    }

    public ReturnCodeViewModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
