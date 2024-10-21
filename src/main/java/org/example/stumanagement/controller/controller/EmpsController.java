package org.example.stumanagement.controller.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.stumanagement.pojo.Emp;
import org.example.stumanagement.pojo.Result;
import org.example.stumanagement.service.EmpsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("emps")
@Slf4j
public class EmpsController {

    @Resource
    private EmpsService empsService;

    /**
     *
     */
    @GetMapping("list")
    public Result getEmps() {
        List<Emp> pageResult = empsService.getEmps();
        return Result.success(pageResult);
    }

}
