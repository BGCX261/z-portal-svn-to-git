package iglabs.zportal.web.shell.dto;

import iglabs.zportal.configuration.Configuration;
import iglabs.zportal.web.configuration.WebAppConfigurationKeys;
import iglabs.zportal.web.shell.ShellInfoProvider;

public class RootViewModel {
    
    public RootViewModel(Configuration configuration, ShellInfoProvider infoProvider) {
        this.rootUrl = configuration.getValue(WebAppConfigurationKeys.ROOT_URL);
        this.containerName = infoProvider.getContainerName();
        this.title = infoProvider.getTitle();
    }
    
    public String getRootUrl() {
        return rootUrl;
    }
    
    public String getContainerName() {
        return containerName;
    }
    
    public String getTitle() {
        return title;
    }
    
    
    private final String rootUrl;
    private final String containerName;
    private final String title;
}
