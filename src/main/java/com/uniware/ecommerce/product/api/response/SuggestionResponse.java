package com.uniware.ecommerce.product.api.response;

import lombok.Data;

import java.util.List;

@Data
public class SuggestionResponse {
    private String status;
    private List<String> suggestions;
}
