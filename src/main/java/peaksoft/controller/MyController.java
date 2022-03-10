package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getAllStudent(){
        return "all_student";
    }
    @GetMapping("/hr_info")
    public String getIngoOnlyForHR(){
        return "views_for_hr";
    }
    @GetMapping("/manager_info")
    public  String getInfoForManagers(){
        return "views_for_managers";
    }
}
