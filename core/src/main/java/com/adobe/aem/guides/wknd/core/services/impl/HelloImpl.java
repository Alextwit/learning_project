package com.adobe.aem.guides.wknd.core.services.impl;

import com.adobe.aem.guides.wknd.core.services.Hello;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(service = Hello.class, immediate = true)
public class HelloImpl implements Hello{

    public static final String ok = "HELLO FROM SERVICE";

    @Activate
    public void activate(){};

    @Override
    public String getHello() {
        return ok;
    }
}
