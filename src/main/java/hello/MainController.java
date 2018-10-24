package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hello.User;
import hello.UserRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
@CrossOrigin
@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }
    @PostMapping("/persistPerson")
    public ResponseEntity<Object> persistPerson(@RequestBody User person) {

            User savedUser = userRepository.save(person);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
            return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public @ResponseBody String checkLogin(@RequestBody User person) {

        if (userRepository.checkLoginCredentials(person.getEmail(),person.getPassword())!=0) {

            return "Login Successful";

        }
        return "Login Failed";

    }
}