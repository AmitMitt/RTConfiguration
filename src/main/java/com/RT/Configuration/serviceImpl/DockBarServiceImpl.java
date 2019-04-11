package com.RT.Configuration.serviceImpl;

import com.RT.Configuration.entity.DockBar;
import com.RT.Configuration.model.Request;
import com.RT.Configuration.repository.DockBarRepository;
import com.RT.Configuration.service.DockBarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class DockBarServiceImpl implements DockBarService {

    @Autowired
    private DockBarRepository dockBarRepository;

    @Override
    public DockBar add(Request request) throws Exception {

       DockBar dockBar = dockBarRepository.findByName(request.getName(),request.getRoleName());
       if(dockBar != null){
           throw new Exception("Data Already Exist.");
       }

       DockBar dockBar1 = new DockBar();
       dockBar1.setAndroidAction(request.getAndroidAction());
       dockBar1.setCreatedOn(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
       dockBar1.setDeleted(false);
       dockBar1.setDescription(request.getDescription());
       dockBar1.setDisable(false);
       dockBar1.setDisplayName(request.getDisplayName());
       dockBar1.setImageUrl(request.getImageUrl());
       dockBar1.setIosAction(request.getIosAction());
       dockBar1.setName(request.getName());
       dockBar1.setPriority(request.getPriority());
       dockBar1.setRoleName(request.getRoleName());
       dockBar1.setRouterLink(request.getRouterLink());
       dockBar1.setStatus(true);
       dockBar1.setType(request.getType());
       dockBar1.setWebAction(request.getWebAction());

       dockBarRepository.saveAndFlush(dockBar1);
       return dockBar1;
    }

    @Override
    public DockBar update(Request request) throws Exception {

        DockBar dockBar = dockBarRepository.findByName(request.getName(),request.getRoleName());
        if(dockBar == null){
            throw new Exception("Data not Exist.");
        }
        dockBar.setAndroidAction(request.getAndroidAction());
        dockBar.setModifiedOn(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis());
        dockBar.setDeleted(false);
        dockBar.setDescription(request.getDescription());
        dockBar.setDisable(false);
        dockBar.setDisplayName(request.getDisplayName());
        dockBar.setImageUrl(request.getImageUrl());
        dockBar.setIosAction(request.getIosAction());
        dockBar.setName(request.getName());
        dockBar.setPriority(request.getPriority());
        dockBar.setRoleName(request.getRoleName());
        dockBar.setRouterLink(request.getRouterLink());
        dockBar.setStatus(true);
        dockBar.setType(request.getType());
        dockBar.setWebAction(request.getWebAction());

        dockBarRepository.saveAndFlush(dockBar);
        return dockBar;
    }

    @Override
    public void delete(Request request) throws Exception {

        DockBar dockBar = dockBarRepository.findByName(request.getName(),request.getRoleName());
        if(dockBar == null){
            throw new Exception("Data Not Exist.");
        }
        dockBar.setDeleted(true);
        dockBarRepository.saveAndFlush(dockBar);

    }

    @Override
    public DockBar get(String name, String roleName) throws Exception {

        DockBar dockBar = dockBarRepository.findByName(name,roleName);
        if(dockBar == null){
            throw new Exception("Data Not Available.");
        }

        return dockBar;
    }

    @Override
    public List<DockBar> getList(String roleName) throws Exception {

       List<DockBar> list = dockBarRepository.findByRoleName(roleName);
       if (list.isEmpty()){
           throw new Exception("Data Not Available.");
       }
        return list;
    }

    @Override
    public DockBar status(Request request) {

        DockBar dockBar = dockBarRepository.findByName(request.getName(),request.getRoleName());
        dockBar.setStatus(request.isStatus());
        dockBarRepository.saveAndFlush(dockBar);
        return dockBar;
    }

    @Override
    public DockBar setDisableEnable(Request request) {

        DockBar dockBar = dockBarRepository.findByName(request.getName(),request.getRoleName());
        dockBar.setDisable(request.isDisable());
        dockBarRepository.saveAndFlush(dockBar);
        return dockBar;
    }
}
