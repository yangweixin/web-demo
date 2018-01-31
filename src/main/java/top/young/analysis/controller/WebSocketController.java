package top.young.analysis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.young.analysis.entity.WSClientMsg;
import top.young.analysis.entity.WSServerMsg;

/**
 * @Method: top.young.analysis.controller
 * @Desc:
 * @Author: Yang Weixin
 * @Date: 2018/1/31 15:42
 */
@Controller
public class WebSocketController {

    private Logger logger = LoggerFactory.getLogger(WebSocketController.class);
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("sendMsg")
    @SendTo("/topic/subscribe")
    public WSServerMsg sendMsg(WSClientMsg msg){
        logger.info("receive msg: "+ msg.getName());
        return new WSServerMsg("server has received your message: "+ msg.getName());
    }

    @SubscribeMapping("subscribe")
    public WSServerMsg sub(){
        logger.info("server: xxx subscribe me.");
        return new WSServerMsg("Server Thanks for subscribing.");
    }

    @RequestMapping("/pushMsg")
    public void pushMsg(){
        simpMessagingTemplate.convertAndSend("/topic/pool", new WSServerMsg("Server: welcome to pool"));
    }
}
