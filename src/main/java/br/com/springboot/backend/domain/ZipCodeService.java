package br.com.springboot.backend;

import br.com.springboot.backend.domain.ZipCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "zipCode", url = "https://viacep.com.br/ws")
public interface ZipCodeService {

    @RequestMapping(method = RequestMethod.GET, value = "{cep}/json", consumes = "application/json")
    ZipCode findJsonBy(@PathVariable("cep") String cep);

    @RequestMapping(method = RequestMethod.GET, value = "{cep}/json/unicode", consumes = "application/json")
    ZipCode findJsonUnicodeBy(@PathVariable("cep") String cep);

    @RequestMapping(method = RequestMethod.GET, value = "{cep}/xml", consumes = "application/xhtml+xml")
    ZipCode findXmlBy(@PathVariable("cep") String cep);

}