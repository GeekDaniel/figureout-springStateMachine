package top.dannystone.stateMachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * Creed: keep it simple and stupid !
 * Time: 2020/8/6 6:07 PM
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig
    extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Autowired
    private PayCrossBorderSuccessGuard payCrossBorderSuccessGuard;

    @Autowired
    private PayCrossBorderSuccessAction payCrossBorderSuccessAction;

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
        throws Exception {
        config
            .withConfiguration()
            .autoStartup(true)
            .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
        throws Exception {
        states
            .withStates()
            .initial(States.INIT)
            .junction(States.PAY_CROSS_BORDER_ING)
            .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
        throws Exception {
        transitions
            .withExternal()
            .source(States.INIT)
            .target(States.WAIT_PAYMENT)
            .event(Events.CREAT)

            .and().withExternal()
            .source(States.WAIT_PAYMENT)
            .target(States.PAY_SUCCESS)
            .event(Events.PAID)

            .and().withExternal()
            .source(States.PAY_SUCCESS)
            .target(States.PAY_CROSS_BORDER_ING)
            .event(Events.CROSS_BORDER)

            .and()
            .withJunction()
            .source(States.PAY_CROSS_BORDER_ING)
            .first(States.PAY_CROSS_BORDER_SUCCESS, payCrossBorderSuccessGuard, payCrossBorderSuccessAction)
            .last(States.PAY_CROSS_BORDER_FAIL)

            .and()
            .withExternal()
            .source(States.PAY_CROSS_BORDER_FAIL)
            .target(States.PAY_CROSS_BORDER_ING)
            .event(Events.CROSS_BORDER)

            .and()
            .withExternal()
            .source(States.PAY_CROSS_BORDER_SUCCESS)
            .target(States.WAIT_PLATFORM_RECEIVED)
            .event(Events.SELLER_DELIVERY);
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }
}
