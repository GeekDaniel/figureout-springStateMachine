package top.dannystone.stateMachine;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * Creed: keep it simple and stupid !
 * Time: 2020/12/1 8:12 PM
 */
@Component
public class PayCrossBorderSuccessGuard implements Guard<States, Events> {
    private int count = 0;

    @Override
    public boolean evaluate(StateContext<States, Events> context) {
        return ++count % 2 == 0;
    }
}
