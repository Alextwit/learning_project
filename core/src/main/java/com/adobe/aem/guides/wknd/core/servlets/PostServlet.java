package com.adobe.aem.guides.wknd.core.servlets;

import com.adobe.aem.guides.wknd.core.constants.CommonConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.crx.JcrConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletPaths(
        value = {"/bin/info/post"}
)
public class PostServlet extends SlingAllMethodsServlet {

    public static final Logger LOG = LoggerFactory.getLogger(PostServlet.class);

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        /*ResourceResolver rr = request.getResourceResolver();
        // String path = String.format("%s/%s", request.getRequestPathInfo().getResourcePath(), JcrConstants.JCR_CONTENT);
        Resource resource = rr.getResource(request.getRequestPathInfo().getResourcePath() + CommonConstants.SLASH + JcrConstants.JCR_CONTENT);
        //Resource resource = request.getResource();
        Node node = resource.adaptTo(Node.class);
        try {
            node.setProperty("jcr:title", "privet from post servlet");
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
        rr.commit();*/


    }
}