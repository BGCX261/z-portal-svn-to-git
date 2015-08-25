package iglabs.zportal.web.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import iglabs.zportal.web.dto.ResponseDTO;


public class JsonController {
    @ExceptionHandler(Exception.class)
    public @ResponseBody ResponseDTO exception(Exception ex) {
        
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.print(ex.getMessage());
        // writer.write("\r\n");
        // ex.printStackTrace(printWriter);

        return ResponseDTO.failure(writer.toString());
    }
}
