//package hello;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@RestController
//@RequestMapping(path="/demo")
//public class LoginController {
//    @Autowired
//    @Qualifier("userRepository")
//    private UserRepository userRepository;
//
//    @PostMapping("/login")
//    public ResponseEntity< String > checkLogin(@RequestBody User person) {
//
//        if (userRepository.checkLoginCredentials(person.getEmail(),person.getPassword())!=0) {
//
//            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//
//        }
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//
//    }
//}
