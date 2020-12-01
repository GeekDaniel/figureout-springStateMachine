package top.dannystone.stateMachine;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * Creed: keep it simple and stupid !
 * Time: 2020/12/1 8:18 PM
 */
@Component
public class PayCrossBorderSuccessAction implements Action<States, Events> {
    @Override
    public void execute(StateContext<States, Events> context) {
        System.out.println("do PayCrossBorderSuccessAction ...");
    }
}
