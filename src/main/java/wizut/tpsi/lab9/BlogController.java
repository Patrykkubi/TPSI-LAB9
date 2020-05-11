
package wizut.tpsi.lab9;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import java.sql.SQLException;

@Controller
public class BlogController {
    
    @Autowired
    private BlogRepository blogrepo; 
    
    @RequestMapping("/")
    public String homeBlog(Model model)throws SQLException
     {
    model.addAttribute("posty",blogrepo.getAllPosts());
    return "homeBlog";
    }
    
    @PostMapping("/newpost")
    public String newPost(BlogPost post) throws SQLException {
        blogrepo.createPost(post);
        return "redirect:/";
}
    
    
  @PostMapping("/delPost")
    public String delPost(BlogPost post) throws SQLException {
        blogrepo.deletePost(post);
        return "redirect:/";
}
    
  
}


