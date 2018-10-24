package hello;

import org.springframework.stereotype.Repository;
public interface UserReopsitoryCustom
{
    int checkLoginCredentials(String username, String password);

}