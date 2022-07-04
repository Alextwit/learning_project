package com.adobe.aem.guides.wknd.core.services.multiimpl.impl;

import com.adobe.aem.guides.wknd.core.services.multiimpl.MultipleImplementationDemoService;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = MultipleImplementationDemoService.class, immediate = true)
@Designate(ocd = GeneralXmlConfigService.SeparateConfigThree.class)
public class GeneralXmlConfigService implements MultipleImplementationDemoService {

    private SeparateConfigThree separateConfigThree;

    @Activate
    @Modified
    public void activate(final SeparateConfigThree separateConfigThree) {
        this.separateConfigThree = separateConfigThree;
    }

    @Override
    public String getName() {
        return separateConfigThree.serviceName();
    }

    @ObjectClassDefinition(name = "Alex third config",
            description = "Alex config demo")
    @interface SeparateConfigThree {

        @AttributeDefinition(
                name = "Service name",
                description = "Enter service name",
                type = AttributeType.STRING)
        String serviceName();
    }
}