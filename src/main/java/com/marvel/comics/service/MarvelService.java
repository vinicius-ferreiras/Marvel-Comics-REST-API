package com.marvel.comics.service;

import com.marvel.comics.retorno.Retorno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "comic", url = "https://gateway.marvel.com")
public interface MarvelService {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/public/comics/{id}?ts=1&apikey=beaa15ea2f2b961768401045257ed245&hash=a0fc033f3955578644ebbbd1671b1ce7")
    public Retorno getComicsPorId(@PathVariable("id") Long id);
}
