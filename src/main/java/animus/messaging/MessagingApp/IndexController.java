package animus.messaging.MessagingApp;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {

//    @GetMapping()
//    public String getIndex(Model model){
//        List<MemberDTO> members = List.of(
//                new MemberDTO("John Doe", "Hello, Are you there?", "/img/Avatar1.png", "Just now", 1),
//                new MemberDTO("Lara Croft", "Sed ut perspiciatis...", "/img/Avatar2.png", "Yesterday", 0)
//        );
//
//        List<MessageDTO> messages = List.of(
//                new MessageDTO("Brad Pitt", "Lorem ipsum...", "/img/Avatar3.png", "12 mins ago", false),
//                new MessageDTO("Lara Croft", "Unde omnis iste...", "/img/Avatar4.png", "13 mins ago", true)
//        );
//
//        model.addAttribute("members", members);
//        model.addAttribute("messages", messages);
//        model.addAttribute("messageForm", new MessageForm());
//
//        return "index";
//    }

//    @GetMapping("/")
//    public String getUsernamePage() {
//        return "index"; // Loads username.html
//    }

//    @GetMapping("/chat")
//    public String chatPage(HttpSession session, Model model) {
//        String username = (String) session.getAttribute("username");
//        if (username == null || username.isBlank()) {
//            return "redirect:/";
//        }
//        model.addAttribute("username", username);
//        return "index"; // Loads index.html (your chat page)
//    }

//    @PostMapping("/set-username")
//    @ResponseBody
//    public void setUsername(@RequestBody Map<String, String> payload, HttpSession session) {
//        session.setAttribute("username", payload.get("username"));
//    }

}
