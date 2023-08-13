package com.michel.gestionui.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import com.michel.gestionui.models.CategorieAux;
import com.michel.gestionui.models.CompteAux;
import com.michel.gestionui.models.OperationAux;

@FeignClient(name = "gestion", url = "http://localhost:1756/")
public interface MicroServiceGestion extends ProxyGlobal{

	

	
	
	
	

	

	

	
}
