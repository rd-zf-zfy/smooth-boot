package org.smooth.study.swagger.controller;

import java.util.List;

import org.smooth.study.swagger.common.ApiResponse;
import org.smooth.study.swagger.common.DataType;
import org.smooth.study.swagger.common.ParamType;
import org.smooth.study.swagger.entity.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * User Controller
 * </p>
 *
 * @author zhangfei
 * @date Created in 2021-06-11 11:30
 */
@RestController
@RequestMapping("/user")
@Api(tags = "1.0.0-SNAPSHOT", value = "用户管理")
@Slf4j
public class UserController {
    @GetMapping("/getUserByName")
    // swagger 接口描述，可不写, 如果你不想写 @ApiOperation 那么 swagger 也会使用默认的方法名作为描述信息
    @ApiOperation(value = "条件查询（getByUserName）", notes = "备注")
    // swagger 接口参数描述,多个参数用  @ApiImplicitParams，可不写, 如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "username",
                    value = "用户名",
                    dataType = DataType.STRING,
                    paramType = ParamType.QUERY,
                    defaultValue = "颖")})
    public ApiResponse<User> getByUserName(String username) {
        // 日志
        log.info("用户名：" + username);
        return ApiResponse.<User>builder().code(200).msg("操作成功").data(new User(1, username, "JAVA")).build();
    }

    @GetMapping("/getUser/{id}")
    @ApiOperation(value = "主键查询（getById）", notes = "备注")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)})
    public ApiResponse<User> getById(@PathVariable Integer id) {
        return ApiResponse.<User>builder().code(200).msg("操作成功").data(new User(id, "u1", "p1")).build();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除用户（deleteById）", notes = "备注")
    @ApiImplicitParam(name = "id", value = "用户编号", dataType = DataType.INT, paramType = ParamType.PATH)
    public ApiResponse<Object> deleteById(@PathVariable Integer id) {
        return ApiResponse.builder().code(200).msg("操作成功").build();
    }

    @PostMapping("/save")
    @ApiOperation(value = "添加用户（save）")
    public ApiResponse<Object> save(@RequestBody User user) {
        return ApiResponse.builder().code(200).msg("操作成功").build();
    }

    @PostMapping("/multiUserSave")
    @ApiOperation(value = "添加用户（multiUserSave -list 集合）")
    public ApiResponse<Object> multiUserSave(@RequestBody List<User> user) {
        return ApiResponse.builder().code(200).msg("操作成功").build();
    }

    @PostMapping("/array")
    @ApiOperation(value = "添加用户（multiUserSave -array 数组）")
    public ApiResponse<Object> multiUserSave(@RequestBody User[] user) {
        return ApiResponse.builder().code(200).msg("操作成功").build();
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "修改用户（updateUser）")
    public ApiResponse<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ApiResponse.builder().code(200).msg("操作成功").build();
    }

    @PostMapping("/{id}/file")
    @ApiOperation(value = "文件上传（uploadFile）")
    public ApiResponse<Object> uploadFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        log.info(file.getContentType());
        log.info(file.getName());
        log.info(file.getOriginalFilename());
        return ApiResponse.builder().code(200).msg("操作成功").build();
    }
}
