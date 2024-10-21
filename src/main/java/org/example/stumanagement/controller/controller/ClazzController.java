package org.example.stumanagement.controller.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.stumanagement.pojo.Clazz;
import org.example.stumanagement.pojo.PageResult;
import org.example.stumanagement.pojo.Result;
import org.example.stumanagement.service.ClazzService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("clazzs")
@Slf4j
public class ClazzController {

    @Resource
    private ClazzService clazzService;

    /**
     * name	否	黄埔一期	班级名称
     * begin	否	2023-01-01	范围匹配的开始时间(结课时间)
     * end	否	2023-05-01	范围匹配的结束时间(结课时间)
     * page	是	1	分页查询的页码，如果未指定，默认为1
     * pageSize	是	10	分页查询的每页记录数，如果未指定，默认为10
     */
    @GetMapping
    public Result queryClazzs(@RequestParam(required = false) String name,
                              @RequestParam(required = false) LocalDate begin,
                              @RequestParam(required = false) LocalDate end,
                              @RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer pageSize) {
        PageResult<Clazz> pageResult = clazzService.queryClazzs(name, begin, end, page, pageSize);
        return Result.success(pageResult);
    }

    /**
     * name	string	必须	班级名称
     * room	string	必须	班级教室
     * beginDate	string	必须	开课时间
     * endDate	string	必须	结课时间
     * masterId	number	非必须	班主任
     * subject	number	必须	学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6:嵌入式
     */
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        clazzService.addClazz(clazz);
        return Result.success();
    }

    /**
     * id	number	必须	班级ID
     */
    @GetMapping("{id}")
    public Result getClazzById(@PathVariable Integer id) {
        return Result.success(clazzService.getClazzById(id));
    }

    /**
     * id	number	必须	id
     * name	string	必须	班级名称
     * room	string	必须	班级教室
     * beginDate	string	必须	开课时间
     * endDate	string	必须	结课时间
     * masterId	number	必须	班主任ID(员工ID)
     * subject	number	非必须	学科, 1:java, 2:前端, 3:大数据, 4:Python, 5:Go, 6:嵌入式
     */
    @PutMapping
    public Result setClazz(@RequestBody Clazz clazz) {
        clazzService.setClazz(clazz);
        return Result.success();
    }

    /**
     * id	number	1	必须	班级的ID
     */
    @DeleteMapping("{id}")
    public Result removeClazz(@PathVariable Integer id) {
        clazzService.removeClazz(id);
        return Result.success();
    }

    @GetMapping("list")
    public Result getClazzList() {
        return Result.success(clazzService.getClazzList());
    }
}
