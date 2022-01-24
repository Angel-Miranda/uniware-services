package com.uniware.ecommerce.config;

import com.uniware.ecommerce.model.entity.ProductEntity;
import com.uniware.ecommerce.model.entity.ShoppingCartEntity;
import com.uniware.ecommerce.model.dto.Product;
import com.uniware.ecommerce.model.dto.ShoppingCart;
import com.uniware.ecommerce.product.api.response.*;
import com.uniware.ecommerce.product.model.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper getModelMapper() {
        final ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);

        mapper.typeMap(ManufacturerResponse.class, Manufacturer.class)
                .addMappings(m -> {
                    m.map(ManufacturerResponse::getManuId, Manufacturer::setId);
                    m.map(ManufacturerResponse::getManuName, Manufacturer::setName);
                });

        mapper.typeMap(ModelResponse.class, Model.class)
                .addMappings(m -> {
                    m.map(ModelResponse::getModelId, Model::setId);
                    m.map(ModelResponse::getModelname, Model::setName);
                    m.map(ModelResponse::getYearOfConstrFrom, Model::setYearFrom);
                    m.map(ModelResponse::getYearOfConstrTo, Model::setYearTo);
                });

        mapper.addMappings(new PropertyMap<VehicleResponse, Vehicle>() {
            @Override
            protected void configure() {
                map().getModel().setId(source.getVehicleDetails().getModId().longValue());
                map().getModel().setName(source.getVehicleDetails().getModelName());
                map().getManufacturer().setId(source.getVehicleDetails().getManuId().longValue());
                map().getManufacturer().setName(source.getVehicleDetails().getManuName());

                map().setCcmTech(source.getVehicleDetails().getCcmTech());
                map().setId(source.getVehicleDetails().getCarId().longValue());
                map().setConstructionType(source.getVehicleDetails().getConstructionType());
                map().setCylinder(source.getVehicleDetails().getCylinder());
                map().setCylinderCapacityCcm(source.getVehicleDetails().getCylinderCapacityCcm());
                map().setCylinderCapacityLiter(source.getVehicleDetails().getCylinderCapacityLiter());
                map().setFuelType(source.getVehicleDetails().getFuelType());
                map().setFuelTypeProcess(source.getVehicleDetails().getFuelTypeProcess());
                map().setImpulsionType(source.getVehicleDetails().getImpulsionType());
                map().setMotorType(source.getVehicleDetails().getMotorType());
                map().setPowerHpFrom(source.getVehicleDetails().getPowerHpFrom());
                map().setPowerHpTo(source.getVehicleDetails().getPowerHpTo());
                map().setPowerKwFrom(source.getVehicleDetails().getPowerKwFrom());
                map().setPowerKwTo(source.getVehicleDetails().getPowerKwTo());
                map().setTypeName(source.getVehicleDetails().getTypeName());
                map().setTypeNumber(source.getVehicleDetails().getTypeNumber());
                map().setValves(source.getVehicleDetails().getValves());
                map().setYearOfConstrFrom(source.getVehicleDetails().getYearOfConstrFrom());
                map().setYearOfConstrTo(source.getVehicleDetails().getYearOfConstrTo());
                map().setRmiTypeId(source.getVehicleDetails().getRmiTypeId());
            }
        });

        mapper.typeMap(BrandResponse.class, Brand.class)
                .addMappings(m -> {
                    m.map(BrandResponse::getBrandId, Brand::setId);
                    m.map(BrandResponse::getBrandName, Brand::setName);
                });

        mapper.typeMap(ShoppingCartEntity.class, ShoppingCart.class)
                .addMappings(m -> {
                    m.map(ShoppingCartEntity::getId, ShoppingCart::setId);
                })
                .setProvider(pr -> ShoppingCart.builder().build());

        mapper.typeMap(ProductEntity.class, Product.class)
                        .addMappings(m -> {
                            m.map(src -> src.getArticle().getSku(), (dest, v) -> dest.setSku((String) v));
                            m.map(src -> src.getArticle().getDescription(), (dest, v) -> dest.setDescription((String) v));
                            m.map(ProductEntity::getPrice, Product::setPrice);
                            m.map(ProductEntity::getQuantity, Product::setQuantity);
                        });

        mapper.addMappings(new PropertyMap<MotorResponse, Motor>() {
            @Override
            protected void configure() {
                map().getManufacturer().setId(source.getManuId().longValue());
                map().getManufacturer().setName(source.getManuText());
                map().setId(source.getMotorId().longValue());
            }
        });


        mapper.typeMap(GenericArticleResponse.class, GenericArticle.class)
                .addMappings(m -> {
                    m.map(GenericArticleResponse::getGenericArticleId, GenericArticle::setId);
                    m.map(GenericArticleResponse::getGenericArticleDescription, GenericArticle::setDescription);
                    m.map(GenericArticleResponse::getLegacyArticleId, GenericArticle::setLegacyId);
                });


        ArticlePropertyMapper articlePropertyMapper = new ArticlePropertyMapper(mapper);
        mapper.addMappings(articlePropertyMapper);

        return mapper;
    }

    class ArticlePropertyMapper extends PropertyMap<ArticleResponse, Article> {
        private ModelMapper modelMapper;

        ArticlePropertyMapper(ModelMapper modelMapper) {
            this.modelMapper  = modelMapper;
        }

        @Override
        protected void configure() {
            map().setId(source.getDataSupplierId());
            map().setNumber(source.getArticleNumber());

            map().getBrand().setId(source.getMfrId().longValue());
            map().getBrand().setName(source.getMfrName());

            map().getMisc().getStatus().setId(source.getMisc().getArticleStatusId());
            map().getMisc().getStatus().setDescription(source.getMisc().getArticleStatusDescription());
            map().getMisc().getStatus().setValidFromDate(source.getMisc().getArticleStatusValidFromDate());
            map().getMisc().setQuantityPerPackage(source.getMisc().getQuantityPerPackage());
            map().getMisc().setQuantityPerPartPerPackage(source.getMisc().getQuantityPerPartPerPackage());
            map().getMisc().setIsSelfServicePacking(source.getMisc().getIsSelfServicePacking());
            map().getMisc().setHasMandatoryMaterialCertification(source.getMisc().getHasMandatoryMaterialCertification());
            map().getMisc().setIsRemanufacturedPart(source.getMisc().getIsRemanufacturedPart());
            map().getMisc().setIsAccessory(source.getMisc().getIsAccessory());

            map().setGtins(source.getGtins());
            map().setTradeNumbers(source.getTradeNumbers());
        }
    }
}
