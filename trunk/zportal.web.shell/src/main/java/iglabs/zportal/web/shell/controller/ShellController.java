package iglabs.zportal.web.shell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import iglabs.zportal.util.Sequences;
import iglabs.zportal.web.controller.JsonController;
import iglabs.zportal.web.dto.ResponseDTO;
import iglabs.zportal.web.shell.menu.Menu;
import iglabs.zportal.web.shell.menu.MenuItem;
import iglabs.zportal.web.shell.menu.MenuRegistry;
import iglabs.zportal.web.shell.dto.ContainerNameRequestDTO;


@Controller
@RequestMapping(value = "/shell", method = RequestMethod.POST)
public class ShellController extends JsonController {
    
    @Autowired
    private MenuRegistry menuRegistry;
    
    @RequestMapping(value = "/listMenuItems")
    public @ResponseBody ResponseDTO<List<MenuItem>>
        listMenuItems(@RequestBody ContainerNameRequestDTO dto) {
        
        Menu menu = menuRegistry.getMenu(dto.getContainerName());
        if (menu == null) {
            throw new RuntimeException("Не найдено меню для заданного контейнера");
        }
        
        List<MenuItem> items = Sequences.toList(menu.getItems());
        return ResponseDTO.success(items);
    }
}
