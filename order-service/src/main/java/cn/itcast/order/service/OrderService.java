package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    //    注入Resttemplate
    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
//        2、利用RestTemlate发送http请求，查询用户信息
//2.1、URL路径

        String url="http://userServer/user/"+order.getUserId();
//        2.2、发送http请求，实现远程调用
//        ResponseEntity<User> forEntity = restTemplate.getForEntity(url,User.class);
//        System.out.println("Respons0eEntity<User>:"+forEntity.toString());
        User user = restTemplate.getForObject(url, User.class);
//        3、封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
