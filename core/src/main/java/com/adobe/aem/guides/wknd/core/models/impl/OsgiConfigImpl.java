package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.OsgiConfig;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = OsgiConfig.class, immediate = true)
@Designate(ocd = OsgiConfigImpl.ServiceConfig.class)
public class OsgiConfigImpl implements OsgiConfig {

    @ObjectClassDefinition(name = "Alex configuration",
    description = "Osgi configuration demo")
    public @interface ServiceConfig {

        @AttributeDefinition(
                name = "Service name",
                description = "Enter service name",
                type = AttributeType.STRING)
        public String serviceName() default "Alex service";
    }


}
