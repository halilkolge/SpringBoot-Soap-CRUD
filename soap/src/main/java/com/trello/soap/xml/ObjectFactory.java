package com.trello.soap.xml;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory(){

    }

    public UserRequest createUserRequest(){
        return new UserRequest();
    }

    public ResponseItem createResponseItem(){
        return new ResponseItem();
    }

}
