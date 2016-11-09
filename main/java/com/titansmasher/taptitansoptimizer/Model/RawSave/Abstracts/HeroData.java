package com.titansmasher.taptitansoptimizer.Model.RawSave.Abstracts;

import com.titansmasher.taptitansoptimizer.Helpers.HashMapConstructor;
import com.titansmasher.taptitansoptimizer.Model.Enums.Hero;

import java.util.Map;

/**
 * Created by Danny on 22/10/2016.
 */

public abstract class HeroData<T> {
    public T h1;
    public T h2;
    public T h3;
    public T h4;
    public T h5;
    public T h6;
    public T h7;
    public T h8;
    public T h9;
    public T h10;
    public T h11;
    public T h12;
    public T h13;
    public T h14;
    public T h15;
    public T h16;
    public T h17;
    public T h18;
    public T h19;
    public T h20;
    public T h21;
    public T h22;
    public T h23;
    public T h24;
    public T h25;
    public T h26;
    public T h27;
    public T h28;
    public T h29;
    public T h30;
    public T h31;
    public T h32;
    public T h33;

    public String H1_KEY =  "1";
    public String H2_KEY =  "2";
    public String H3_KEY =  "3";
    public String H4_KEY =  "4";
    public String H5_KEY =  "5";
    public String H6_KEY =  "6";
    public String H7_KEY =  "7";
    public String H8_KEY =  "8";
    public String H9_KEY =  "9";
    public String H10_KEY = "10";
    public String H11_KEY = "11";
    public String H12_KEY = "12";
    public String H13_KEY = "13";
    public String H14_KEY = "14";
    public String H15_KEY = "15";
    public String H16_KEY = "16";
    public String H17_KEY = "17";
    public String H18_KEY = "18";
    public String H19_KEY = "19";
    public String H20_KEY = "20";
    public String H21_KEY = "21";
    public String H22_KEY = "22";
    public String H23_KEY = "23";
    public String H24_KEY = "24";
    public String H25_KEY = "25";
    public String H26_KEY = "26";
    public String H27_KEY = "27";
    public String H28_KEY = "28";
    public String H29_KEY = "29";
    public String H30_KEY = "30";
    public String H31_KEY = "31";
    public String H32_KEY = "32";
    public String H33_KEY = "33";

    public Map<Hero, T> mapHeros() {
        return new HashMapConstructor<Hero, T>()
                .add(Hero.Takeda, h1)
                .add(Hero.Contessa, h2)
                .add(Hero.Hornetta, h3)
                .add(Hero.Mila, h4)
                .add(Hero.Terra, h5)
                .add(Hero.Inquisireaux, h6)
                .add(Hero.Charlotte, h7)
                .add(Hero.Jordaan, h8)
                .add(Hero.Jukka, h9)
                .add(Hero.Milo, h10)
                .add(Hero.Macelord, h11)
                .add(Hero.Gertrude, h12)
                .add(Hero.Twitterella, h13)
                .add(Hero.MasterHawk, h14)
                .add(Hero.Elpha, h15)
                .add(Hero.Poppy, h16)
                .add(Hero.Skulptor, h17)
                .add(Hero.Sterling, h18)
                .add(Hero.Orba, h19)
                .add(Hero.Remus, h20)
                .add(Hero.Mikey, h21)
                .add(Hero.Peter, h22)
                .add(Hero.Tom, h23)
                .add(Hero.Deznis, h24)
                .add(Hero.Hamlette, h25)
                .add(Hero.Eistor, h26)
                .add(Hero.Flavius, h27)
                .add(Hero.Chester, h28)
                .add(Hero.Mohacas, h29)
                .add(Hero.Jaqulin, h30)
                .add(Hero.Pixie, h31)
                .add(Hero.Jackalope, h32)
                .add(Hero.DarkLord, h33)
                .getMap();
    }
}
