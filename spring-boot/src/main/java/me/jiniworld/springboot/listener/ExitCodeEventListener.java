package me.jiniworld.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExitCodeEventListener {

    @EventListener
    public void handleExitCodeEvent(ExitCodeEvent event) {
        log.info("ExitCodeEvent >>> Exit code: {}", event.getExitCode());
    }

}
