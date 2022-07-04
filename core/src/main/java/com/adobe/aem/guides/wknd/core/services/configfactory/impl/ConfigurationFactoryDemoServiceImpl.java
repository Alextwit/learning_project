package com.adobe.aem.guides.wknd.core.services.configfactory.impl;

import com.adobe.aem.guides.wknd.core.services.configfactory.ConfigurationFactoryDemoService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = ConfigurationFactoryDemoService.class, immediate = true)
@Designate(ocd = ConfigurationFactoryDemoServiceImpl.OsgiConfigFactory.class, factory = true)
public class ConfigurationFactoryDemoServiceImpl implements ConfigurationFactoryDemoService {

    private OsgiConfigFactory osgiConfigFactory;

    @Activate
    public void activate(final OsgiConfigFactory osgiConfigFactory) {
        this.osgiConfigFactory = osgiConfigFactory;
    }

    @Override
    public String getName() {
        return osgiConfigFactory.serviceName();
    }

    @ObjectClassDefinition(name = "OsgiConfigFactory",
            description = "OsgiConfigFactory demo")
    public @interface OsgiConfigFactory {

        @AttributeDefinition(
                name = "Service name",
                description = "Enter service name",
                type = AttributeType.STRING)
        public String serviceName() default "OsgiConfigFactory";
    }
}
