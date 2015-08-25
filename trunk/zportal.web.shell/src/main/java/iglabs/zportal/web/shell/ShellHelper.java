package iglabs.zportal.web.shell;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import iglabs.zportal.configuration.Configuration;
import iglabs.zportal.web.shell.dto.RootViewModel;



public class ShellHelper {
    
    @Autowired
    private Configuration configuration;
    
    public ModelAndView createRootResponse(ShellInfoProvider infoProvider) {
        ModelAndView result = new ModelAndView("shell/root");

        RootViewModel viewModel = new RootViewModel(configuration, infoProvider);
        result.addObject("viewModel", viewModel);
        
        return result;
    }
}
