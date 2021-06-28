package com.trello.soap.endpoint;

import com.trello.soap.SoapApplication;
import com.trello.soap.service.CrudService;
import com.trello.soap.xml.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CrudEndpoint {

    final static Logger logger = LoggerFactory.getLogger(CrudEndpoint.class);


    private static final String NAMESPACE = "http://www.javatechie.com/spring/soap/api/loanEligibility";

    @Autowired
    private CrudService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CreateRequest")
    @ResponsePayload
    public ResponseItem createUser(@RequestPayload UserRequest request) {
        logger.info("DEBUG:Invoke-createUser");
        return service.createUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "ListUserRequest")
    @ResponsePayload
    public List<UserResponse> listUser(@RequestPayload GetAllRequest test) {
        return service.listUser();
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "DeleteRequest")
    @ResponsePayload
    public ResponseItem deleteUser(@RequestPayload DeleteRequest id) {
        return service.deleteUser(id);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "UpdateRequest")
    @ResponsePayload
    public ResponseItem updateUser(@RequestPayload UserUpdateRequest request) {
        return service.updateUser(request);
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "FindByIdRequest")
    @ResponsePayload
    public UserResponse findByIdUser(@RequestPayload FindById id) {
        return service.findById(id);
    }

}
