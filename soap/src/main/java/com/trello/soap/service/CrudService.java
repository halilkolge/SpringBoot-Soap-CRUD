package com.trello.soap.service;

import com.trello.soap.xml.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrudService {

    List<UserRequest> userRequests = new ArrayList<>();
    int temp;
    String id="1";

    public ResponseItem createUser(UserRequest request){
        ResponseItem responseItem = new ResponseItem();
        try {
            request.setId(id);
            userRequests.add(request);
            responseItem.setResult(true);
            responseItem.setMessage("İşlem Başarılı");
            int idInt = Integer.parseInt(id)+1;
            id =String.valueOf(idInt);
            System.out.println("DEBUG:ReturningResponse-createUser,id"+id);
            return responseItem;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            responseItem.setResult(false);
            responseItem.setMessage("İşlem Başarısız.");
            return responseItem;
        }
    }

    public List<UserResponse> listUser(){
        List<UserResponse> userResponses = new ArrayList<>();
        UserResponse userResponse = new UserResponse();
        for (UserRequest userRequest : userRequests){
            userResponse.setId(userRequest.getId());
            userResponse.setName(userRequest.getName());
            userResponse.setSurname(userRequest.getSurname());
            userResponse.setEducation(userRequest.getEducation());
            userResponses.add(userResponse);
        }
        return userResponses;
    }

    public ResponseItem deleteUser(DeleteRequest deleteRequest){
        ResponseItem responseItem = new ResponseItem();

        for (UserRequest userRequest1 : userRequests){
            if (userRequest1.getId().equals(deleteRequest.getId())){
                userRequests.remove(userRequest1);
                responseItem.setResult(true);
                responseItem.setMessage("İşlem Başarılı");
                return responseItem;
            }else {
                responseItem.setResult(false);
                responseItem.setMessage("Girilen id mevcut değil!");
                return responseItem;
            }

        }
        responseItem.setResult(false);
        responseItem.setMessage("Listede silinecek veri yok.");
        return responseItem;
    }

    public ResponseItem updateUser(UserUpdateRequest userUpdateRequest){
        ResponseItem responseItem = new ResponseItem();
        UserRequest userRequest = new UserRequest();
        try {
            for (UserRequest userRequest1 : userRequests){
                if (userRequest1.getId().equals(userUpdateRequest.getId())){
                    userRequests.remove(userRequest1);
                    userRequest.setId(userUpdateRequest.getId());
                    userRequest.setName(userUpdateRequest.getName());
                    userRequest.setSurname(userUpdateRequest.getSurname());
                    userRequest.setEducation(userUpdateRequest.getEducation());
                    userRequests.add(userRequest);
                    responseItem.setResult(true);
                    responseItem.setMessage("İşlem Başarılı");
                    return responseItem;
                }
            }
            responseItem.setResult(false);
            responseItem.setMessage("Listede güncellenecek veri yok.");
            return responseItem;

        }catch (Exception e){
            e.printStackTrace();
            responseItem.setResult(false);
            responseItem.setMessage("Güncelleme işlemi başarısız.");
            return responseItem;
        }
    }

    public UserResponse findById(FindById id){
        UserResponse userResponse = new UserResponse();

        for (UserRequest userRequest : userRequests){
            if (userRequest.getId().equals(id.getId())){
                userResponse.setId(userRequest.getId());
                userResponse.setName(userRequest.getName());
                userResponse.setSurname(userRequest.getSurname());
                userResponse.setEducation(userRequest.getEducation());
                return userResponse;
            }
        }
        return userResponse;
    }
}
