package demo.src.main.java.com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class SampleFileController {

    @GetMapping("/sample")
    public String getSampleFile(Model model) {
        try {
            // Adjust the path if sample.txt is in a different directory
            String content = new String(Files.readAllBytes(Paths.get("sample.txt")), StandardCharsets.UTF_8);
            model.addAttribute("fileContent", content);
        } catch (IOException e) {
            model.addAttribute("error", "Error reading file: " + e.getMessage());
        }
        // Return the name of the view template (e.g., sampleView.html)
        return "sampleView";
    }
}
