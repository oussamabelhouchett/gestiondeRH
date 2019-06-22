package com.pfe;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class custom implements Endpoint<String> {
    @Override
    public String getId() {
        return "hello";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public String invoke() {
        return "youtube";
    }
}
