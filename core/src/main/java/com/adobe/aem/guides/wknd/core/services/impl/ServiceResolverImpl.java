package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.constants.CommonConstants;
import com.adobe.aem.guides.wknd.core.services.ServiceResolver;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Component(service = ServiceResolver.class, immediate = true)
public class ServiceResolverImpl implements ServiceResolver {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceResolverImpl.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public ResourceResolver getServiceResourceResolver() throws LoginException {
        final Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE, CommonConstants.SERVICE_USER);
        return resourceResolverFactory.getServiceResourceResolver(paramMap);
    }
}
