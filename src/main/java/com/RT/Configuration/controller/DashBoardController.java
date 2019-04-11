package com.RT.Configuration.controller;

import com.RT.Configuration.entity.DashBoard;
import com.RT.Configuration.model.Request;
import com.RT.Configuration.model.Response;
import com.RT.Configuration.service.DashBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashBoard")
public class DashBoardController {

    @Autowired
    private DashBoardService dashBoardService;

    @PostMapping("/add")
    public ResponseEntity<Response> add(@RequestBody Request request) throws Exception {
        dashBoardService.add(request);
        Response response = new Response();
        response.setMessage("Add Successfully.");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> update(@RequestBody Request request) throws Exception {
        dashBoardService.update(request);
        Response response = new Response();
        response.setMessage("Update Successfully.");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response> delete(@RequestBody Request request) throws Exception {
        dashBoardService.delete(request);
        Response response = new Response();
        response.setMessage("Deleted Successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{name}/{roleName}")
    public ResponseEntity<DashBoard> get(@PathVariable("name") String name, @PathVariable("roleName") String roleName) throws Exception {
        DashBoard dashBoard = dashBoardService.get(name,roleName);
        return ResponseEntity.ok(dashBoard);
    }

    @GetMapping("/getList/{roleName}")
    public ResponseEntity<List<DashBoard>> getList(@PathVariable("roleName") String roleName) throws Exception {
        List<DashBoard> dashBoard = dashBoardService.getList(roleName);
        return ResponseEntity.ok(dashBoard);
    }

    @PutMapping("status")
    public ResponseEntity<Response> status(@RequestBody Request request){
        DashBoard dashBoard = dashBoardService.status(request);
        Response response = new Response();
        response.setMessage("Set Status for "+dashBoard.getDisplayName()+" is "+dashBoard.isStatus());
        return ResponseEntity.ok(response);
    }

    @PutMapping("isDisable")
    public ResponseEntity<Response> isDisable(@RequestBody Request request){
        DashBoard dashBoard = dashBoardService.setDisableEnable(request);
        Response response = new Response();
        response.setMessage("Set isDisable for "+dashBoard.getDisplayName()+" is "+dashBoard.isDisable());
        return ResponseEntity.ok(response);
    }
}