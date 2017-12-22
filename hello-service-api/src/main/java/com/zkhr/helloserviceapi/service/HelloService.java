package com.zkhr.helloserviceapi.service;

import com.zkhr.helloserviceapi.dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dicheng on 17-12-22.
 */
@RequestMapping("/refactor")
public interface HelloService {

    //@RequestParam @RequestHeader @RequestMapping value值千万不能少，在springmvc中，可以根据参数名来作为默认值，可以缺省
    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
