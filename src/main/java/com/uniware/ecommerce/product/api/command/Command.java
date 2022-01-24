package com.uniware.ecommerce.product.api.command;

import java.util.Map;

public interface Command {
    String getName();

    Map<String, Command> build();
}
