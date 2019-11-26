/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batm.batmanStore.Services;


import batm.batmanStore.Model.User;
import batm.batmanStore.reg.UserRegistration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author USER
 */
public interface UserService extends UserDetailsService{
    User findByEmail(String email);

    User save(UserRegistration registration);
}
