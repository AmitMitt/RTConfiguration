package com.RT.Configuration.service;

import com.RT.Configuration.entity.DockBar;
import com.RT.Configuration.model.Request;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DockBarService {

    public DockBar add (Request request) throws Exception;
    public DockBar update(Request request) throws Exception;
    public void delete(Request request) throws Exception;
    public DockBar get(String name, String roleName) throws Exception;
    public List<DockBar> getList(String roleName) throws Exception;
    public DockBar status(Request request);
    public DockBar setDisableEnable(Request request);

}
