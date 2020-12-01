package top.dannystone.stateMachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * Creed: keep it simple and stupid !
 * Time: 2020/8/6 6:08 PM
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.sendEvent(Events.CREAT);
        stateMachine.sendEvent(Events.PAID);
        stateMachine.sendEvent(Events.CROSS_BORDER);
        stateMachine.sendEvent(Events.CROSS_BORDER);
    }
}
