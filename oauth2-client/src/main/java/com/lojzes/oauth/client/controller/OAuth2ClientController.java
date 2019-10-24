package com.lojzes.oauth.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OAuth2ClientController {

  @Autowired private ClientRegistrationRepository clientRegistrationRepository;

  @RequestMapping("/")
  public String index(Model model) {
    ClientRegistration githubRegistration =
        this.clientRegistrationRepository.findByRegistrationId("github");

    model.addAttribute("cliend_id", githubRegistration.getClientId());
    model.addAttribute("cliend_name", githubRegistration.getClientName());
    model.addAttribute("scopes", githubRegistration.getScopes());

    return "index";
  }
}
