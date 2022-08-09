package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Bem vindo a API REST para geração de números para a loteria Mega Sena.";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        // Obs: Retornar os números gerados em ordem crescente.

        List<Integer> listaDeNumeros = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            listaDeNumeros.add(ThreadLocalRandom.current().nextInt(0, 999));
        }

        Collections.sort(listaDeNumeros);

        return listaDeNumeros;

    }
}
