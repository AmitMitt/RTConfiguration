package com.RT.Configuration.controller;

import com.RT.Configuration.entity.DockBar;
import com.RT.Configuration.model.Request;
import com.RT.Configuration.model.Response;
import com.RT.Configuration.service.DockBarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docBar")
public class DockBarController {

    @Autowired
    private DockBarService dockBarService;

    @PostMapping("/add")
    public ResponseEntity<Response> add(@RequestBody Request request) throws Exception {
        dockBarService.add(request);
        Response response = new Response();
        response.setMessage("Add Successfully.");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> update(@RequestBody Request request) throws Exception {
        dockBarService.update(request);
        Response response = new Response();
        response.setMessage("Update Successfully.");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response> delete(@RequestBody Request request) throws Exception {
        dockBarService.delete(request);
        Response response = new Response();
        response.setMessage("Deleted Successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{name}/{roleName}")
    public ResponseEntity<DockBar> get(@PathVariable("name") String name, @PathVariable("roleName") String roleName) throws Exception {
        DockBar dockBar = dockBarService.get(name,roleName);
        return ResponseEntity.ok(dockBar);
    }

    @GetMapping("/getList/{roleName}")
    public ResponseEntity<List<DockBar>> getList(@PathVariable("roleName") String roleName) throws Exception {
        List<DockBar> list = dockBarService.getList(roleName);
        return ResponseEntity.ok(list);
    }

    @PutMapping("status")
    public ResponseEntity<Response> status(@RequestBody Request request){
        DockBar dockBar = dockBarService.status(request);
        Response response = new Response();
        response.setMessage("Set Status for "+dockBar.getDisplayName()+" is "+dockBar.isStatus());
        return ResponseEntity.ok(response);
    }

    @PutMapping("isDisable")
    public ResponseEntity<Response> isDisable(@RequestBody Request request){
        DockBar dockBar = dockBarService.setDisableEnable(request);
        Response response = new Response();
        response.setMessage("Set isDisable for "+dockBar.getDisplayName()+" is "+dockBar.isDisable());
        return ResponseEntity.ok(response);
    }
}
