package com.uniware.ecommerce.product.api.command;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractCommand implements Command {
    protected String lang;

    @Override
    public Map<String, Command> build() {
        final Map<String, Command> command = new HashMap<>();
        command.put(getName(), this);

        return command;
    }
}
