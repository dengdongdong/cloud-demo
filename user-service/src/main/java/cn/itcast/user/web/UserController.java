package cn.itcast.user.web;

import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
//        System.out.println("111");
//        Long aLong = Objects.requireNonNull(id);
//        List<String> arrayList = new ArrayList();
//        arrayList.add("1");
//        arrayList.add("2");
//        arrayList.add("3");
//        arrayList.add("4");
//        Iterator<String> iterator = arrayList.iterator();
//        ListIterator<String> stringListIterator = arrayList.listIterator();
//        System.out.println(iterator);
        return userService.queryById(id);
    }
}
