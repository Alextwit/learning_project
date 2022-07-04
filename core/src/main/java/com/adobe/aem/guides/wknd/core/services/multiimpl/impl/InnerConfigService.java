package com.adobe.aem.guides.wknd.core.services.multiimpl.impl;

import com.adobe.aem.guides.wknd.core.services.multiimpl.MultipleImplementationDemoService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = MultipleImplementationDemoService.class, immediate = true)
@Designate(ocd = InnerConfigService.SeparateConfigTwo.class)
public class InnerConfigService implements MultipleImplementationDemoService {

    private SeparateConfigTwo separateConfigTwo;

    @Activate
    public void activate(SeparateConfigTwo separateConfigtwo) {
        this.separateConfigTwo = separateConfigtwo;
    }

    @Deactivate
    public void deactivate() {
    }

    @Override
    public String getName() {
        return separateConfigTwo.serviceName();
    }

    @ObjectClassDefinition(name = "Alex second config",
            description = "Alex config demo")
    @interface SeparateConfigTwo {

        @AttributeDefinition(
                name = "Service name",
                description = "Enter service name",
                type = AttributeType.STRING)
        public String serviceName() default "Alex inner config";

    }
}
