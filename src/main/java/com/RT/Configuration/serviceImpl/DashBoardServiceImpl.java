package com.RT.Configuration.serviceImpl;

import com.RT.Configuration.entity.DashBoard;
import com.RT.Configuration.model.Request;
import com.RT.Configuration.repository.DashBoardRepository;
import com.RT.Configuration.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

@Service
public class DashBoardServiceImpl implements DashBoardService {

    @Autowired
    private DashBoardRepository dashBoardRepository;

    @Override
    public DashBoard add(Request request) throws Exception {

        DashBoard dashBoard = dashBoardRepository.findByName(request.getName(),request.getRoleName());

        if(dashBoard != null){
            throw new Exception("Data Already exist.");
        }

        DashBoard dashBoard1 = new DashBoard();
        dashBoard1.setAndroidAction(request.getAndroidAction());
        dashBoard1.setCreatedOn(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        dashBoard1.setDeleted(false);
        dashBoard1.setDescription(request.getDescription());
        dashBoard1.setDisplayName(request.getDisplayName());
        dashBoard1.setImageUrl(request.getImageUrl());
        dashBoard1.setIosAction(request.getIosAction());
        dashBoard1.setName(request.getName());
        dashBoard1.setPriority(request.getPriority());
        dashBoard1.setRoleName(request.getRoleName());
        dashBoard1.setRouterLink(request.getRouterLink());
        dashBoard1.setStatus(true);
        dashBoard1.setType(request.getType());
        dashBoard1.setWebAction(request.getWebAction());
        dashBoard1.setDisable(false);

        dashBoardRepository.saveAndFlush(dashBoard1);
        return dashBoard1;
    }

    @Override
    public DashBoard update(Request request) throws Exception {

        DashBoard dashBoard = dashBoardRepository.findByName(request.getName(),request.getRoleName());
        if(dashBoard == null){
            throw new Exception("Data Not Exist.");
        }
        dashBoard.setAndroidAction(request.getAndroidAction());
        dashBoard.setModifiedOn(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        dashBoard.setDeleted(false);
        dashBoard.setDescription(request.getDescription());
        dashBoard.setDisplayName(request.getDisplayName());
        dashBoard.setImageUrl(request.getImageUrl());
        dashBoard.setIosAction(request.getIosAction());
        dashBoard.setName(request.getName());
        dashBoard.setPriority(request.getPriority());
        dashBoard.setRoleName(request.getRoleName());
        dashBoard.setRouterLink(request.getRouterLink());
        dashBoard.setStatus(true);
        dashBoard.setType(request.getType());
        dashBoard.setWebAction(request.getWebAction());
        dashBoard.setDisable(false);

        dashBoardRepository.saveAndFlush(dashBoard);
        return dashBoard;
    }

    @Override
    public void delete(Request request) throws Exception {

        DashBoard dashBoard = dashBoardRepository.findByName(request.getName(),request.getRoleName());
        if(dashBoard == null){
            throw new Exception("Data not Exist.");
        }
        dashBoard.setDeleted(true);
        dashBoardRepository.saveAndFlush(dashBoard);
    }

    @Override
    public DashBoard get(String name, String roleName) throws Exception {
        DashBoard dashBoard = dashBoardRepository.findByName(name,roleName);
        if(dashBoard == null){
            throw new Exception("Data Not Available.");
        }
        return dashBoard;
    }

    @Override
    public List<DashBoard> getList(String roleName) throws Exception {

        List<DashBoard> list = dashBoardRepository.findByRoleName(roleName);
        if(list.isEmpty()){
            throw new Exception("Data Not Available.");
        }

        return list;
    }

    @Override
    public DashBoard status(Request request){
        DashBoard dashBoard = dashBoardRepository.findByName(request.getName(),request.getRoleName());
        dashBoard.setStatus(request.isStatus());
        dashBoardRepository.saveAndFlush(dashBoard);
        return dashBoard;
    }

    @Override
    public DashBoard setDisableEnable(Request request){
        DashBoard dashBoard = dashBoardRepository.findByName(request.getName(),request.getRoleName());
        dashBoard.setDisable(request.isDisable());
        dashBoardRepository.saveAndFlush(dashBoard);

        return dashBoard;
    }
}
