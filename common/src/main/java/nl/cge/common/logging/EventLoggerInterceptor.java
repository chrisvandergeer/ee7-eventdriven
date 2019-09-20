package nl.cge.common.logging;

import nl.cge.common.events.ApplicationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class EventLoggerInterceptor {

    private final static Logger LOGGER = LogManager.getLogger();

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        String target = context.getTarget().getClass().getSimpleName();
        Optional<ApplicationEvent> event = getEvent(context);
        event.ifPresentOrElse(
                e -> LOGGER.info(target + " received event " + e.toString()),
                () -> LOGGER.error("Remove EventLoggerInterceptor from " + target));
        Object result = context.proceed();
        return result;
    }

    private Optional<ApplicationEvent> getEvent(InvocationContext context) {
        Object[] parameters = context.getParameters();
        if (parameters.length > 0) {
            Object parameter = parameters[0];
            if (parameter instanceof ApplicationEvent) {
                return Optional.of((ApplicationEvent) parameter);
            }
        }
        return Optional.empty();
    }
}
