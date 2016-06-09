package uk.co.bbc.micro.controller;

import org.junit.Test;
import uk.co.bbc.micro.events.EpisodeChanged;
import uk.co.bbc.micro.rabbit.RabbitSender;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by walked51 on 08/06/2016.
 */
public class ChangeControllerTest {


    @Test
    public void changedDelegatesToService() throws Exception {
        RabbitSender mock = mock(RabbitSender.class);
        ChangeController controller = new ChangeController(mock);

        EpisodeChanged programmeChange = new EpisodeChanged("id","title","p1234");
        controller.changed(programmeChange);
        verify(mock).send("{\"uuid\":\"id\",\"newTitle\":\"title\",\"pid\":\"p1234\"}");
    }

}