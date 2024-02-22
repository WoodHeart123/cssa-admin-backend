package org.cssa.admin.event;

import org.cssa.admin.dao.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LogEventListener {

    @Autowired
    LogMapper logMapper;
    @EventListener
    @Async
    public void log(LogEvent logEvent) {
        logMapper.createLog(logEvent.getOptLog());
    }
}