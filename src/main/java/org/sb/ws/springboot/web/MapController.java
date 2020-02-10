package org.sb.ws.springboot.web;

import lombok.RequiredArgsConstructor;
import org.sb.ws.springboot.config.auth.LoginUser;
import org.sb.ws.springboot.config.auth.dto.SessionUser;
import org.sb.ws.springboot.service.MapsService;
import org.sb.ws.springboot.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MapController {
    private final MapsService mapsService;
    private final HttpSession httpSession;


    @GetMapping("/map")
    public String index(Model model, @LoginUser SessionUser user) {

        model.addAttribute("posts", mapsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "map-main";
    }

    @GetMapping("/map/save")
    public String mapSave() {
        return "map-save";
    }
}
