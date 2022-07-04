
package com.adobe.aem.guides.wknd.core.filters;

import com.adobe.aemds.guide.utils.JcrResourceConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;

import java.io.IOException;

import static org.apache.sling.engine.EngineConstants.*;


@Component(service = Filter.class, name = "Custom Logging Filter", property = {
        SLING_FILTER_SCOPE + "=" + FILTER_SCOPE_REQUEST, Constants.SERVICE_RANKING + ":Integer=1",
        SLING_FILTER_PATTERN + "=" + "/content/wknd/us/en/.*"
})
public class RequestLoggingFilter implements Filter {

    public static final Logger LOG = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof SlingHttpServletRequest && servletResponse instanceof SlingHttpServletResponse) {
            final SlingHttpServletRequest slingHttpServletRequest = (SlingHttpServletRequest) servletRequest;
            final Resource resource = slingHttpServletRequest.getResource();
            if (resource.getResourceType().equals(JcrResourceConstants.CQ_PAGE)) {
                PageManager pageManager = resource.getResourceResolver().adaptTo(PageManager.class);
                Page page = pageManager.getPage(resource.getPath());
                String resourceType = page.getContentResource().getResourceType();
                if (resourceType.equals("wknd/components/page")) {
                LOG.info("Page Accessed");

                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}

