package com.marvel.comics.teste;

import com.marvel.comics.model.Comic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://gateway.marvel.com", name = "comic")
public interface ComicClient {

    @GetMapping("/v1/public/comics/{id}?ts=1&apikey=beaa15ea2f2b961768401045257ed245&hash=a0fc033f3955578644ebbbd1671b1ce7")
    Comic buscaComicsPorId(@PathVariable("id") Long id);

}
