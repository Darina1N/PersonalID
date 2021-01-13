package sk.kosickaakademia.rodne.cislo;

import static java.lang.Long.*;

public class PersonalID {
    public boolean checkId(String id){
        if(id.length()<9||id.length()>11)  // kontrola na dĺžku RČ
            return false;
        int pocetCislic=0;
        for(int i=0;i<id.length();i++){//prechádzam celý String a pocitam len znaky čo sú číslice
            if(Character.isDigit(id.charAt(i)))
                pocetCislic++;
        }

        //kontrola pre počet číslic, RČ môže mať buď 9 alebo 10 číslic,menej alebo viac je zle
        if(pocetCislic<9 || pocetCislic>10)
            return false;

        //kontrola, že ak je číslo 11 alebo 10 ciferné, tak 7 znak môže byť /
        if(id.length()==11 && (pocetCislic!=10 || id.charAt(6)!='/'))
            return false;
        if(id.length()==10 && pocetCislic==9 && id.charAt(6)!='/')
            return false;

        //kontrola číslice vrámci mesiaca (poradie 2) môže byť u muža 0 alebo 1 a u ženy 5 alebo  6
        if(id.charAt(2)!='0'&& id.charAt(2)!='1' && id.charAt(2)!='5' && id.charAt(2)!='6') {
            System.out.println("Nesprávny mesiac");
            return false;
        }

        //ak je len 9 číslic tak na konci pridať 0
        if(pocetCislic==9)
            id=id+'0';

        // nechcem mať v RČ / tak spojím 2 podstringy
        if(id.charAt(6)=='/')
            id=id.substring(0,6)+id.substring(7,11);
        //potrebujem skontrolovať deliteľnosť 11, ale int mi nestačí musím parsovať
        long rc= Long.parseLong(id);
        System.out.println(rc);
        if(rc%11!=0){
            System.out.println("Chybné RČ.");
            return false;
        }
        //ak je rok narodenia začínajúci 0 tak nech to ozaj napíše

        int rok=Integer.valueOf(id.substring(0,2));
        int mesiac=Integer.valueOf(id.substring(2,4));
        int den=Integer.valueOf(id.substring(4,6));

        if(rok<22){
            rok= rok+ 2000;
        }else rok=rok+1900;

        //rozlíšenie že je to žena
        if(id.charAt(2)=='5'|| id.charAt(2)=='6'){
            mesiac=mesiac-50;
        }

        System.out.println("Dátum narodenia: " +den+"."+mesiac+"."+rok);

        //kontrola mesiaca nevieme mať 00 ani 13 a vyššie
        if(mesiac!=00 && mesiac>12) {
            System.out.println("Taký mesiac neexistuje");
            return false;
        }

        //kontrola na počet dní v mesiacoch pre 7 z nich nemôže byť viac ako 31 dní, pre 4 nemôže byť viac ako 30
        if((mesiac==1 || mesiac==3 || mesiac==5 || mesiac==7 || mesiac==8 || mesiac==10 || mesiac==12) && (den>31 || den<1)){
            System.out.println("Taký deň neexistuje");
            return false;
        }
        if((mesiac==4 || mesiac==6 || mesiac==9 || mesiac==11) && (den>30 || den<1)){
            System.out.println("Taký deň neexistuje");
            return false;
        }
        //kontrola počtu dní pre február aj s prestupným rokom
        if(rok%4==0 && mesiac==2 && (den>29 || den<1)){
            System.out.println("Taký deň neexistuje");
            return false;
        }
        if(rok%4!=0 && mesiac==2 && (den>28 || den<1)){
            System.out.println("Taký deň neexistuje");
            return false;
        }


        return true;
    }
}
