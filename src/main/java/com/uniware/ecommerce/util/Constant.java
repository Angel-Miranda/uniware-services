package com.uniware.ecommerce.util;

public class Constant {
    public static class WebPaths {
        private static final String SLASH = "/";
        public static final String MANUFACTURER_ID = "{manufacturerId}";
        public static final String MODEL_ID = "{modelId}";
        public static final String VEHICLE_ID = "{vehicleId}";
        public static final String MANUFACTURERS = SLASH + "manufacturers";
        public static final String SHOPPING_CARTS = SLASH + "shopping-carts";
        public static final String MODELS = SLASH + "models";
        public static final String VEHICLES = SLASH + "vehicles";
        public static final String MOTORS = SLASH + "motors";
        public static final String MODELS_BY_MANUFACTURER = SLASH + MANUFACTURER_ID + MODELS;
        public static final String VEHICLES_BY_MODEL = MODELS_BY_MANUFACTURER + SLASH + MODEL_ID + VEHICLES;
        public static final String MOTORS_BY_MANUFACTURER = SLASH + MANUFACTURER_ID + MOTORS;
        public static final String VEHICLE_DETAIL = MODELS_BY_MANUFACTURER + SLASH + MODEL_ID + VEHICLES + SLASH + VEHICLE_ID;
        public static final String BRANDS = SLASH + "brands";
        public static final String ARTICLES = SLASH + "articles";
    }

    public static class SecurityConstant {
        public static final String AUTHORITIES = "authorities";
        public static final String ROLE_PREFIX = "ROLE_";
        public static final String TOKEN_PREFIX = "Bearer";

        public static final String AUTHENTICATION_CODE = "SEC-001";
        public static final String USER_PASSWORD_MESSAGE = "Usuario y/o pasword incorrecto.";

        public static final String TOKEN_CODE = "SEC-001";
        public static final String TOKEN_NO_PRESENT_MESSAGE = "El token no esta presente en la peticion.";

    }

    public static final class Role {
        public static final String DEFAULT = "DEFAULT";
    }

}
