package com.machi.security.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationSuccessHandlerImpl extends SavedRequestAwareAuthenticationSuccessHandler {

    public AuthenticationSuccessHandlerImpl() {
        setAlwaysUseDefaultTargetUrl(true);
        setDefaultTargetUrl("/dashboard");
    }

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        final HttpSession session = request.getSession();
        final CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        session.setAttribute("userId", userDetails.getId());

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
