package ACMEInvoice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/mywebapp")
    public String mywebapp(@RequestParam(value="name", required=false, defaultValue="Pippo") String name, Model model) {

        model.addAttribute("name", name);

        return "mywebapp";
    }
}