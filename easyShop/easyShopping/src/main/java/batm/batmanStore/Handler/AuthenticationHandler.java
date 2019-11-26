/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batm.batmanStore.Handler;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Component;

/**
 *
 * @author USER
 */
@Component
public class AuthenticationHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler{
    
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) throws IOException, ServletException {
        boolean hasUserRole = false;
        boolean hasAdminRole = false;
        Collection<? extends GrantedAuthority> authorities = a.getAuthorities();
        
        for(GrantedAuthority grantedAuthority : authorities){
            if (grantedAuthority.getAuthority().equals("ROLE_USER")){
                hasUserRole = true;
                break;
            }
            else if ( grantedAuthority.getAuthority().equals("ROLE_ADMIN")){
                hasAdminRole = true;
                break;
            }
            
        }
        
        if (hasUserRole){
            redirectStrategy.sendRedirect(hsr, hsr1, "/Home");
        }
        else{
            throw new IllegalStateException();
        }
    }
    
}
