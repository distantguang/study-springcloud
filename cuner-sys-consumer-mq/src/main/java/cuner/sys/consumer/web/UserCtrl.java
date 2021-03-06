package cuner.sys.consumer.web;

import cuner.common.req.ResData;
import cuner.common.web.BaseCtrl;
import cuner.sys.common.entity.User;
import cuner.sys.common.vo.UserVo;
import cuner.sys.consumer.feignclient.UserFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserCtrl extends BaseCtrl {

    @Resource
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/user/reg", method = RequestMethod.POST)
    public ResData<Object> reg(@RequestBody UserVo userVo) {
        log.info("Consumer->UserCtrl->reg->start");
        return userFeignClient.reg(userVo);
    }

    @GetMapping("/user/get/{username}")
    public ResData<User> findByUsername(@PathVariable String username) {
        log.info("Consumer->UserCtrl->findByUsername->start");
        return userFeignClient.findByUsername(username);
    }

    @GetMapping("/user/page/{pageNo}/{pageSize}")
    public ResData page(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        log.info("Consumer->UserCtrl->page->start");
        return this.userFeignClient.page(pageNo, pageSize);
    }

    @PostMapping("/user/login")
    public ResData<Object> login(HttpServletRequest request, @RequestBody User user) {
        log.info("Consumer->UserCtrl->login->start");
        return this.userFeignClient.login(user);
    }

}
