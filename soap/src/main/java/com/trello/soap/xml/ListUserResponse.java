package com.trello.soap.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "list"
})
@XmlRootElement(name = "ListUserResponse")
public class ListUserResponse {

    @XmlElements(value = { @XmlElement(name="UserResponse") })
    public List<UserResponse> list;

    public List<UserResponse> getList() {
        return list;
    }

    public void setList(List<UserResponse> list) {
        this.list = list;
    }
}
