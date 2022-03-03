package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class RandomWord {
    private String[] list = {"labud","kuvar","kruna","lampa","limun","motor","novac","oblak","ormar","palma"
            ,"atlas"
            ,"crkva"
            ,"dabar"
            ,"fazan"
            ,"glava"
            ,"ikona"
            ,"kupus"
            ,"tipka"
            ,"marka"
            ,"nagon"
            ,"prsti"
            ,"reper"
            ,"strah"
            ,"uvala"
            ,"biser"
            ,"frula"
            ,"golub"
            ,"himna"
            ,"jesen"
            ,"kobac"
            ,"puska"
            ,"macka"
            ,"sutra"
            ,"tajna"
            ,"utaja"
            ,"vlast"
            ,"zebra"
            ,"zlato"
            ,"cimer"
            ,"danas"
            ,"olovo"
            ,"potok"
            ,"tenis"
            ,"barut"
            ,"fotka"
            ,"guska"
            ,"kifla"
            ,"nalaz"
            ,"mamac"
            ,"ponos"
            ,"sjena"
            ,"tajna"
            ,"vatra"
            ,"zahod"
            ,"akord"
            ,"ekran"
            ,"forum"
            ,"greda"
            ,"lasta"
            ,"kolut"};

    public String word(){
        int number = ThreadLocalRandom.current().nextInt(0,60);
        System.out.println(list[number]);
        return list[number];
    }
}
