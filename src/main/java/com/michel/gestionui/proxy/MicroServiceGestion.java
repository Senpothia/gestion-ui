package com.michel.gestionui.proxy;

import org.springframework.cloud.openfeign.FeignClient;

import com.michel.gestionui.models.CompteAux;

@FeignClient(name = "gestion", url = "http://localhost:1756/")
public interface MicroServiceGestion extends ProxyGlobal{

	

	

	
}
