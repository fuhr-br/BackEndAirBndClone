package principal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import principal.services.ServiceCliente;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
    private ServiceCliente service;

}
