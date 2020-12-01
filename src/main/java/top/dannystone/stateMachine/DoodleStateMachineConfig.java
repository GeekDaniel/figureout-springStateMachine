//package top.dannystone.stateMachine;
//
//import com.google.common.collect.Sets;
//import org.springframework.context.annotation.Bean;
//import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
//import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
//import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
//import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
//import org.springframework.statemachine.listener.StateMachineListener;
//import org.springframework.statemachine.listener.StateMachineListenerAdapter;
//import org.springframework.statemachine.state.State;
//
///**
// * Created with IntelliJ IDEA.
// * Description:
// *
// * @author: daniel
// * Creed: keep it simple and stupid !
// * Time: 2020/8/6 6:07 PM
// */
//public class DoodleStateMachineConfig
//        extends EnumStateMachineConfigurerAdapter<States, Events> {
//
//    @Override
//    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
//        throws Exception {
//        config
//            .withConfiguration()
//            .autoStartup(true)
//            .listener(listener());
//    }
//
//    @Override
//    public void configure(StateMachineStateConfigurer<States, Events> states)
//        throws Exception {
//        states
//            .withStates()
//            .parent(States.PARENT)
//            .initial(States.INITIAL)
//            .fork(States.FORK)
//            .join(States.JOIN)
//            .states(Sets.newHashSet(States.S1, States.S2))
//            .choice(States.CHOICE)
//            .entry(States.ENTRY)
//            .end(States.END)
//            .and()
//            .withStates()
//            .parent(States.PARENT2)
//            .states(Sets.newHashSet(States.S3, States.S4))
//            .end(States.END)
//
//        ;
//
//
//    }
//
//    @Override
//    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
//        throws Exception {
//        transitions
//            .withExternal()
//            .source(States.SI).target(States.S1).event(Events.E1)
//            .and()
//            .withExternal()
//            .source(States.S1).target(States.S2).event(Events.E2);
//    }
//
//    @Bean
//    public StateMachineListener<States, Events> listener() {
//        return new StateMachineListenerAdapter<States, Events>() {
//            @Override
//            public void stateChanged(State<States, Events> from, State<States, Events> to) {
//                System.out.println("State change to " + to.getId());
//            }
//        };
//    }
//}
