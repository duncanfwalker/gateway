package uk.co.bbc.micro.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import uk.co.bbc.micro.events.EpisodeChanged;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uk.co.bbc.micro.rabbit.RabbitSender;

@RestController
public class ChangeController {

    RabbitSender queue;

    @Autowired
    public ChangeController(RabbitSender queue) {
        this.queue = queue;
    }

    @RequestMapping(("/change"))
    @ResponseStatus(HttpStatus.OK)
    public void changed(@RequestBody EpisodeChanged change) throws Exception
    {
        ObjectMapper objectMapper = new ObjectMapper();

        queue.send(objectMapper.writeValueAsString(change));
    }
}
