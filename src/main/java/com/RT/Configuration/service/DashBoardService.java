package com.RT.Configuration.service;

import com.RT.Configuration.entity.DashBoard;
import com.RT.Configuration.model.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashBoardService {

    public DashBoard add(Request request) throws Exception;
    public DashBoard update(Request request) throws Exception;
    public void delete(Request request) throws Exception;
    public DashBoard get(String name, String roleName) throws Exception;
    public List<DashBoard> getList(String roleName) throws Exception;
    public DashBoard status(Request request);
    public DashBoard setDisableEnable(Request request);

}
