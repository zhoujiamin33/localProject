package com.trkj.thirdproject.controller;

import com.trkj.thirdproject.entity.Bookdelivery;
import com.trkj.thirdproject.service.BookdeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class BookdeliveryController {
    @Autowired
    private BookdeliveryService bookdeliveryService;

    @DeleteMapping("/deldelBookDelivery/{bookdeliveryId}")
    public String deldelBookDelivery(@PathVariable("bookdeliveryId") int bookdeliveryId){
        log.debug("开始删除");
        bookdeliveryService.deleteByPrimaryKey(bookdeliveryId);
        return "delOk";
    }

    @PostMapping("/addBookdelivery")
    public Bookdelivery insert(@RequestBody Bookdelivery bookdelivery){
        bookdeliveryService.insert(bookdelivery);
        return bookdelivery;
    }
}
