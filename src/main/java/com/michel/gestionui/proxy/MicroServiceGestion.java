package com.michel.gestionui.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "gestion", url = "http://localhost:1756/")
public interface MicroServiceGestion extends ProxyGlobal{

}
