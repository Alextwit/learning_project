package com.adobe.aem.guides.wknd.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Alex first config",
description = "Alex config demo")
public @interface AlexOsgiConfig {

    @AttributeDefinition(
            name = "Service name",
            description = "Enter service name",
            type = AttributeType.STRING)
    public String serviceName() default "Alex separate config";
}
