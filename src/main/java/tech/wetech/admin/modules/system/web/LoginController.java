package tech.wetech.admin.modules.system.web;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wetech.admin.core.utils.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cjbi
 */
@Controller
public class LoginController extends BaseController {

    @RequestMapping("/login")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        logger.info("begin to login");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������";
        } else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
            error = "��½ʧ�ܴ�������";
        } else if(exceptionClassName != null) {
            error = "��������" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "system/login";
    }

    @RequestMapping("/main")
    public String main() throws Exception {
        logger.info("begin to main");
        return "/system/main";
    }
}
