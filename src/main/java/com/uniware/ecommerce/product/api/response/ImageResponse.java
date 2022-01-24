package com.uniware.ecommerce.product.api.response;

import lombok.Data;

@Data
public class ImageResponse extends AssetResponse {
    private String imageURL50;
    private String imageURL100;
    private String imageURL200;
    private String imageURL400;
    private String imageURL800;
    private Integer frame;
    private Integer totalFrames;

}
