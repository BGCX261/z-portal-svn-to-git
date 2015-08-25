package iglabs.zportal.web.setup.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import iglabs.zportal.module.Module;
import iglabs.zportal.module.ModuleRegistry;
import iglabs.zportal.web.dto.ResponseDTO;
import iglabs.zportal.web.setup.dto.ModuleResponseDTO;
import iglabs.zportal.web.shell.ShellHelper;
import iglabs.zportal.web.shell.ShellInfoProvider;


@Controller
@RequestMapping("/setup")
public class SetupController {
    
    @Autowired
    private ShellHelper shellHelper;
    
    @Autowired
    @Qualifier("setupShellInfoProvider")
    private ShellInfoProvider shellInfoProvider;
    
    @Autowired
    private ModuleRegistry moduleRegistry;
    
    @RequestMapping("")
    public ModelAndView index() {
        return shellHelper.createRootResponse(shellInfoProvider);
    }
    
    @RequestMapping("/modules")
    public @ResponseBody ResponseDTO<List<ModuleResponseDTO>> modules() {
        List<ModuleResponseDTO> result = new ArrayList<ModuleResponseDTO>();
        
        for (Module module: moduleRegistry.getModuleSequence()) {
            result.add(new ModuleResponseDTO(module));
        }
        
        Comparator<ModuleResponseDTO> comparator =
            new Comparator<ModuleResponseDTO>() {

                @Override
                public int compare(ModuleResponseDTO x, ModuleResponseDTO y) {
                    return x.getName().compareTo(y.getName());
                }
                
            };
        
        Collections.sort(result, comparator);
        
        return ResponseDTO.success(result);
    }
}
