package com.wzw.platform.controller.admin;

import com.wzw.platform.model.entity.RelationEntity;
import com.wzw.platform.service.RelationService;
import com.wzw.platform.utils.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RelationController {
    private Logger log = LoggerFactory.getLogger(RelationController.class);

    @Autowired
    private RelationService relationService;


    @GetMapping("relations/{userId}")
    public ResponseWrapper<List<RelationEntity>> getRelationByUserId(@PathVariable int userId){
        return   new ResponseWrapper<>(relationService.getRelationByUserId(userId));
    }
    @PostMapping("/relations")
    public  ResponseWrapper<List<RelationEntity>> insertRelations(@RequestBody() List<RelationEntity> relationList){
        relationService.insertRelations(relationList);
        return new ResponseWrapper<>(relationList);
    }

}
