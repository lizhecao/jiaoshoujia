package cn.billy.controllers;

import java.util.Arrays;
import java.util.List;

import cn.billy.common.beans.PageReq;
import cn.billy.common.beans.PageResp;
import cn.billy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.billy.common.rbac.User;
import cn.billy.common.beans.ResultBean;
import cn.billy.common.consts.Roles;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 测试数据
	 * 
	 * @param keyword
	 * @return
	 */
	@GetMapping("/search")
	public ResultBean<List<User>> search(@RequestParam String keyword) {
		System.out.println("UserController.search()" + keyword);

		List<User> nodes = Arrays.asList();

		return new ResultBean<>(nodes);
	}

	@GetMapping("/list")
	public ResultBean<PageResp<User>> list(PageReq page){
		return new ResultBean<>(userService.list(page.toPageable(), page.getKeyword()));
	}

    /**
     *  修改密码
     * @param id
     * @param password
     * @return
     */
	@PostMapping("updatepwd")
    public  ResultBean<Boolean> updatePwd(long id, String password){
        System.out.println(userService.getClass());//FIXME DELETE
	    userService.updatePwd(id, password.trim());
	    return new ResultBean<>(true);
    }
}
