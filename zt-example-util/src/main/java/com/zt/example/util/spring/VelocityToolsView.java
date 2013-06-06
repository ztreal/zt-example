package com.zt.example.util.spring;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.config.XmlFactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolManager;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class VelocityToolsView extends VelocityLayoutView {

    private ViewToolManager toolManager;

 	@Override
 	protected Context createVelocityContext (Map<String, Object> model,
 	                                         HttpServletRequest request,
 	                                         HttpServletResponse response) {
 		ToolContext toolContext = toolManager.createContext(request, response);
 		VelocityContext context = new VelocityContext(toolContext);
// 		if (model != null) context.putAll(model.entrySet());
 		return context;
 	}

 	@Override
 	public void afterPropertiesSet() throws Exception {
 		super.afterPropertiesSet();
 		XmlFactoryConfiguration config = new XmlFactoryConfiguration();
 		config.read(getServletContext().getResourceAsStream(getToolboxConfigLocation()));
 		boolean autoConfigure = false;
 		boolean includeDefaults = false;
 		toolManager = new ViewToolManager(getServletContext(), autoConfigure, includeDefaults);
 		toolManager.configure(config);
 		toolManager.setVelocityEngine(getVelocityEngine());
 	}
}