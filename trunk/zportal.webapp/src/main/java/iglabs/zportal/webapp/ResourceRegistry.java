package iglabs.zportal.webapp;

import iglabs.zportal.web.WebResourceRegistry;

public class ResourceRegistry implements WebResourceRegistry {

    @Override
    public String getMapping() {
        return "/static/**";
    }

    @Override
    public String[] getPaths() {
        return new String[] {
            "classpath:/iglabs/zportal/webapp/resources/"
        };
    }
    
}
