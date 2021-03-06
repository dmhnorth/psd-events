package com.tr.psdtraining.event;

import com.tr.psdtraining.domain.Event;
import com.tr.psdtraining.domain.User;
import org.jboss.netty.logging.Slf4JLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/createEvent", method = RequestMethod.GET)
    public String createEvent() {
        LOGGER.info("about to GET /createEvent");
        return "/event/createEvent";
    }

    @RequestMapping(value = "/createEvent", method = RequestMethod.POST)
    public String createEvent(@RequestBody Event event){
        LOGGER.info("about to POST /createEvent with event = {}", event);
        eventService.save(event);
        return "redirect:/";
    }

    @RequestMapping(value = "/joinEvent", method = RequestMethod.POST)
    public String joinEvent(@RequestBody Event event, User user){
        LOGGER.info("about to POST /joinEvent with event = {}", event);
        eventService.joinEvent(user, event);
        return "redirect:/";
    }
}
