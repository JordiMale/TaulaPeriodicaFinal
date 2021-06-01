package com.example.taulaperiodicafinal;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Taula extends AppCompatActivity {

    final String Solid = "Solid";
    final String Gasos = "Gasos";
    final String Liquid = "Liquid";
    final String Sintetics = "Sintetics";

    final String Metall_Trans = "Metall_Transicio";
    final String MetallAlc = "Metall_Alcalins";
    final String Alcalinoterris = "Alcaliooterris";
    final String Lantanids = "Lantanids";
    final String Actinidis = "Actinidis";
    final String MetallsBlocP = "Metalls_Bloc_P";
    final String Metaloides = "Metaloides";
    final String NoMetalls = "No_metalls";
    final String Halogens = "Halogens";
    final String GasosNoble = "Gasos_nobles";

    //Creem tots els elements de la taula periodica ordenats per el numero.
    private Elementos[] Elements =
            new Elementos[]{
                    new Elementos(NoMetalls, Gasos, "H", "1", "Hidrogeno", "1,00794", "https://es.wikipedia.org/wiki/Hidr%C3%B3geno"),
                    new Elementos(GasosNoble, Gasos, "He", "2", "Helio", "4,002602", "https://es.wikipedia.org/wiki/Helio"),
                    new Elementos(MetallAlc, Solid, "Li", "3", "Litio", "6,941", "https://es.wikipedia.org/wiki/Litio"),
                    new Elementos(Alcalinoterris,Solid,"Be","4","Berilio","9,0122","https://es.wikipedia.org/wiki/Berilio"),
                    new Elementos(Metaloides,Solid,"B","5","Boro","10,811","https://es.wikipedia.org/wiki/Boro"),
                    new Elementos(NoMetalls,Solid,"C","6","Carbono","12,01115","https://es.wikipedia.org/wiki/Carbono"),
                    new Elementos(NoMetalls, Gasos, "N", "7", "Nitrógeno", "14,0067", "https://es.wikipedia.org/wiki/Nitr%C3%B3geno"),
                    new Elementos(NoMetalls, Gasos, "O", "8", "Oxígeno", "15,99994", "https://es.wikipedia.org/wiki/Ox%C3%ADgeno"),
                    new Elementos(Actinidis, Sintetics, "F", "9", "Fluor", "18,998403", "https://es.wikipedia.org/wiki/Flúor"),
                    new Elementos(GasosNoble, Gasos, "Ne", "10", "Neon", "20,179", "https://es.wikipedia.org/wiki/Ne%C3%B3n"),
                    new Elementos(MetallAlc, Solid, "Na", "11", "Sodio", "22,9898", "https://es.wikipedia.org/wiki/Sodio"),
                    new Elementos(Halogens, Solid, "Mg", "12", "Magnesio", "25,305", "https://es.wikipedia.org/wiki/Magnesio"),
                    new Elementos(MetallsBlocP,Solid,"Al","13","Aluminio","26,9815","https://es.wikipedia.org/wiki/Aluminio"),
                    new Elementos(Metaloides, Solid, "Si", "14", "Silicio", "28,086", "https://es.wikipedia.org/wiki/Silicio"),
                    new Elementos(Halogens, Gasos, "P", "15", "Fosforo", "39,97696", "https://es.wikipedia.org/wiki/Fósforo"),
                    new Elementos(NoMetalls,Solid,"S","16","Azufre","32,064","https://es.wikipedia.org/wiki/Azufre"),
                    new Elementos(Halogens,Gasos,"Cl","17","Cloro","35,453","https://es.wikipedia.org/wiki/Cloro"),
                    new Elementos(GasosNoble,Gasos,"Ar","18","Argón","39,948","https://es.wikipedia.org/wiki/Arg%C3%B3n"),
                    new Elementos(MetallAlc, Solid, "K", "19", "Potasio", "39,098", "https://es.wikipedia.org/wiki/Potasio"),
                    new Elementos(Alcalinoterris,Solid,"Ca","20","Calcio","40,08","https://es.wikipedia.org/wiki/Calcio"),
                    new Elementos(Metall_Trans, Solid, "Sc", "21", "Escandio", "44,95591", "https://es.wikipedia.org/wiki/Escandio"),
                    new Elementos(Metall_Trans, Solid, "Ti", "22", "Titanio", "47,90", "https://es.wikipedia.org/wiki/Titanio"),
                    new Elementos(Metall_Trans, Solid, "V", "23", "Vanadio", "50,942", "https://es.wikipedia.org/wiki/Vanadio"),
                    new Elementos(Metall_Trans, Solid, "Cr", "24", "Cromo", "51,9962", "https://es.wikipedia.org/wiki/Cromo"),
                    new Elementos(Metall_Trans, Solid, "Mn", "25", "Mangnaeso", "54,938", "https://es.wikipedia.org/wiki/Manganeso"),
                    new Elementos(Metall_Trans, Solid, "Fe", "26", "Hierro", "55,845", "https://es.wikipedia.org/wiki/Hierro"),
                    new Elementos(Metall_Trans,Solid,"Co","27","Cobalto","58,93","https://es.wikipedia.org/wiki/Cobalto"),
                    new Elementos(Metall_Trans, Solid, "Ni", "28", "Niquel", "58,71", "https://es.wikipedia.org/wiki/N%C3%ADquel"),
                    new Elementos(Metall_Trans,Solid,"Cu","29","Cobre","63,54","https://es.wikipedia.org/wiki/Cobre"),
                    new Elementos(Metall_Trans, Solid, "Zn", "30", "Zinc", "65,37", "https://es.wikipedia.org/wiki/Zinc"),
                    new Elementos(MetallsBlocP, Solid, "Ga", "31", "Galio", "69,723", "https://es.wikipedia.org/wiki/Galio"),
                    new Elementos(Metaloides, Solid, "Ge", "32", "Germanio", "77,64", "https://es.wikipedia.org/wiki/Germanio"),
                    new Elementos(Metaloides,Solid,"As","33","Arsénico","74,922","https://es.wikipedia.org/wiki/Ars%C3%A9nico"),
                    new Elementos(NoMetalls, Solid, "Se", "34", "Selenio", "78,96", "https://es.wikipedia.org/wiki/Selenio"),
                    new Elementos(NoMetalls,Liquid,"Br","35","Bromo","79.909","https://es.wikipedia.org/wiki/Bromo"),
                    new Elementos(GasosNoble, Liquid, "Kr", "36", "Krypton", "83,80", "https://es.wikipedia.org/wiki/Kript%C3%B3n"),
                    new Elementos(MetallAlc, Solid, "Rb", "37", "Rubidio", "85,47", "https://es.wikipedia.org/wiki/Rubidio"),
                    new Elementos(Alcalinoterris, Solid, "Sr", "38", "Estroncio", "87,62", "https://es.wikipedia.org/wiki/Estroncio"),
                    new Elementos(Metall_Trans, Solid, "Y", "39", "Itrio", "88,906", "https://es.wikipedia.org/wiki/Itrio"),
                    new Elementos(Metall_Trans, Solid, "Zr", "40", "Zirconio", "91,22", "https://es.wikipedia.org/wiki/Circonio"),
                    new Elementos(Metall_Trans, Solid, "Nb", "41", "Niobio", "92,906", "https://es.wikipedia.org/wiki/Niobio"),
                    new Elementos(Metall_Trans, Solid, "Mo", "42", "Molibdeno", "95,94", "https://es.wikipedia.org/wiki/Molibdeno"),
                    new Elementos(Metall_Trans, Sintetics, "Tc", "43", "Tecnecio", "97", "https://es.wikipedia.org/wiki/Tecnecio"),
                    new Elementos(Metall_Trans, Solid, "Ru", "44", "Rutenio", "101,07", "https://es.wikipedia.org/wiki/Rutenio"),
                    new Elementos(Metall_Trans, Solid, "Rh", "45", "Rodio", "102,905", "https://es.wikipedia.org/wiki/Rodio"),
                    new Elementos(Metall_Trans, Solid, "Pd", "46", "Paladio", "106,4", "https://es.wikipedia.org/wiki/Paladio"),
                    new Elementos(Metall_Trans, Solid, "Ag", "47", "Plata", "107,87", "https://es.wikipedia.org/wiki/Plata"),
                    new Elementos(Metall_Trans,Solid,"Cd","48","Cadmio","112,40","https://es.wikipedia.org/wiki/Cadmio"),
                    new Elementos(MetallsBlocP, Solid, "In", "49", "Indio", "114,82", "https://es.wikipedia.org/wiki/Indio_(elemento)"),
                    new Elementos(MetallsBlocP, Solid, "Sn", "50", "Estaño", "118,710", "https://es.wikipedia.org/wiki/Esta%C3%B1o"),
                    new Elementos(Metaloides,Solid,"Sb","51","Antimonio","121,76","https://es.wikipedia.org/wiki/Antimonio"),
                    new Elementos(Metaloides, Solid, "Te", "52", "Teluro", "127,60", "https://es.wikipedia.org/wiki/Telurio"),
                    new Elementos(Halogens, Solid, "I", "53", "Iodo", "126,904", "https://es.wikipedia.org/wiki/Yodo"),
                    new Elementos(GasosNoble, Gasos, "Xe", "54", "Xenón", "131,30", "https://es.wikipedia.org/wiki/Xen%C3%B3n"),
                    new Elementos(Alcalinoterris,Solid,"Cs","55","Cesio","132,905","https://es.wikipedia.org/wiki/Cesio"),
                    new Elementos(Alcalinoterris,Solid,"Ba","56","Bario","137,34","https://es.wikipedia.org/wiki/Bario"),
                    new Elementos(Actinidis, Solid, "La", "57", "Lantano", "138,9055", "https://es.wikipedia.org/wiki/Lantano"),
                    new Elementos(Lantanids,Solid,"Ce","58","Cerio","140,12","https://es.wikipedia.org/wiki/Cerio"),
                    new Elementos(Lantanids, Solid, "Pr", "59", "Praseodimio", "140,907", "https://es.wikipedia.org/wiki/Praseodimio"),
                    new Elementos(Lantanids, Solid, "Nd", "60", "Neodimio", "144,24", "https://es.wikipedia.org/wiki/Neodimio"),
                    new Elementos(Lantanids, Solid, "Pm", "61", "Promecio", "147", "https://es.wikipedia.org/wiki/Prometio"),
                    new Elementos(Lantanids, Solid, "Sm", "62", "Samario", "263", "https://es.wikipedia.org/wiki/Samario"),
                    new Elementos(Lantanids, Solid, "Eu", "63", "Europio", "151,964", "https://es.wikipedia.org/wiki/Europio"),
                    new Elementos(Lantanids, Solid, "Gd", "64", "Gadolinio", "157,25", "https://es.wikipedia.org/wiki/Gadolinio"),
                    new Elementos(Lantanids, Solid, "Tb", "65", "Terbio", "158,924", "https://es.wikipedia.org/wiki/Terbio"),
                    new Elementos(Lantanids, Solid, "Dy", "66", "Disprosio", "162,500", "https://es.wikipedia.org/wiki/Disprosio"),
                    new Elementos(Lantanids, Solid, "Ho", "67", "Holmio", "164,9303", "https://es.wikipedia.org/wiki/Holmio"),
                    new Elementos(Lantanids, Solid, "Er", "68", "Erbio", "167,259", "https://es.wikipedia.org/wiki/Erbio"),
                    new Elementos(Lantanids, Solid, "Tm", "69", "Tulio", "168,934", "https://es.wikipedia.org/wiki/Tulio"),
                    new Elementos(Lantanids, Solid, "Yb", "70", "Iterbio", "173,04", "https://es.wikipedia.org/wiki/Iterbio"),
                    new Elementos(Lantanids, Solid, "Lu", "71", "Lutecio", "174,97", "https://es.wikipedia.org/wiki/Lutecio"),
                    new Elementos(Metall_Trans, Solid, "Hf", "72", "Hafnio", "69,723", "https://es.wikipedia.org/wiki/Hafnio"),
                    new Elementos(Metall_Trans, Solid, "Ta", "73", "Tantalio", "180,948", "https://es.wikipedia.org/wiki/T%C3%A1ntalo_(elemento)"),
                    new Elementos(Metall_Trans, Solid, "W", "74", "Wolframio", "183,85", "https://es.wikipedia.org/wiki/Wolframio"),
                    new Elementos(Metall_Trans, Solid, "Re", "75", "Renio", "186,2", "https://es.wikipedia.org/wiki/Renio"),
                    new Elementos(Metall_Trans, Solid, "Os", "76", "Osmio", "193,23", "https://es.wikipedia.org/wiki/Osmio#:~:text=El%20osmio%20es%20un%20elemento,aleaciones%20con%20platino%20e%20iridio."),
                    new Elementos(Metall_Trans, Solid, "Ir", "77", "Iridio", "192,2", "https://es.wikipedia.org/wiki/Iridio"),
                    new Elementos(Metall_Trans, Solid, "Pt", "78", "Platino", "195,09", "https://es.wikipedia.org/wiki/Platino"),
                    new Elementos(Metall_Trans, Solid, "Au", "79", "Oro", "196,967", "https://es.wikipedia.org/wiki/Oro"),
                    new Elementos(Metall_Trans, Liquid, "Hg", "80", "Mercurio", "200,59", "https://es.wikipedia.org/wiki/Mercurio_(elemento)"),
                    new Elementos(MetallsBlocP, Solid, "Tl", "81", "Talio", "204,37", "https://es.wikipedia.org/wiki/Talio"),
                    new Elementos(MetallsBlocP, Solid, "Pb", "82", "Plomo", "207,19", "https://es.wikipedia.org/wiki/Plomo"),
                    new Elementos(MetallsBlocP,Solid,"Bi","83","Bismuto","208,980","https://es.wikipedia.org/wiki/Bismuto"),
                    new Elementos(Metaloides, Solid, "Po", "84", "Polonio", "210", "https://es.wikipedia.org/wiki/Polonio"),
                    new Elementos(Halogens,Solid,"At","85","Astato","210","https://es.wikipedia.org/wiki/Ástato"),
                    new Elementos(GasosNoble, Gasos, "Rn", "86", "Radón", "222", "https://es.wikipedia.org/wiki/Rad%C3%B3n"),
                    new Elementos(MetallAlc, Solid, "Fr", "87", "Francio", "223", "https://es.wikipedia.org/wiki/Francio"),
                    new Elementos(Alcalinoterris, Solid, "Ra", "88", "Radio", "226", "https://es.wikipedia.org/wiki/Radio_(elemento)"),
                    new Elementos(Actinidis,Solid,"Ac","89","Actinio","10.070","https://es.wikipedia.org/wiki/Actinio"),
                    new Elementos(Actinidis, Solid, "Th", "90", "Torio", "232,083", "https://es.wikipedia.org/wiki/Torio"),
                    new Elementos(Actinidis, Solid, "Pa", "91", "Protactinio", "231", "https://es.wikipedia.org/wiki/Protactinio"),
                    new Elementos(Actinidis, Solid, "U", "92", "Uranio", "238,03", "https://es.wikipedia.org/wiki/Uranio"),
                    new Elementos(Actinidis, Sintetics, "Np", "93", "Neptunio", "30,9738", "https://es.wikipedia.org/wiki/Neptunio"),
                    new Elementos(Actinidis, Solid, "Pu", "94", "Plutonio", "242", "https://es.wikipedia.org/wiki/Plutonio"),
                    new Elementos(Actinidis,Solid,"Am","95","Americio","243","https://es.wikipedia.org/wiki/Americio"),
                    new Elementos(Actinidis, Sintetics, "Cm", "96", "Curio", "247", "https://es.wikipedia.org/wiki/Curio"),
                    new Elementos(Actinidis,Solid,"Bk","97","Berkelio","247","https://es.wikipedia.org/wiki/Berkelio"),
                    new Elementos(Actinidis,Solid,"Cf","98","Californio","251","https://es.wikipedia.org/wiki/Californio"),
                    new Elementos(Actinidis, Sintetics, "Es", "99", "Einstenio", "252", "https://es.wikipedia.org/wiki/Einstenio"),
                    new Elementos(Actinidis, Sintetics, "Fm", "100", "Fermio", "257", "https://es.wikipedia.org/wiki/Fermio"),
                    new Elementos(Actinidis, Sintetics, "Md", "101", "Mendelevio", "258", "https://es.wikipedia.org/wiki/Mendelevio"),
                    new Elementos(Actinidis, Sintetics, "No", "102", "Nobelio", "259", "https://es.wikipedia.org/wiki/Nobelio"),
                    new Elementos(Actinidis, Sintetics, "Lr", "103", "Lawrencio", "262", "https://es.wikipedia.org/wiki/Lawrencio"),
                    new Elementos(Metall_Trans, Sintetics, "Rf", "104", "Rutherfordio", "261", "https://es.wikipedia.org/wiki/Rutherfordio"),
                    new Elementos(Metall_Trans, Sintetics, "Db", "105", "Dubnio", "264", "https://es.wikipedia.org/wiki/Dubnio"),
                    new Elementos(Metall_Trans, Sintetics, "Sg", "106", "Seaborgio", "1,00794", "https://es.wikipedia.org/wiki/Seaborgio"),
                    new Elementos(Metall_Trans,Solid,"Bh","107","Bohrio","262","https://es.wikipedia.org/wiki/Bohrio"),
                    new Elementos(Metall_Trans, Sintetics, "Hs", "108", "Hassio", "277", "https://es.wikipedia.org/wiki/Hasio"),
                    new Elementos(Metall_Trans, Sintetics, "Mn", "109", "Meitnerio", "266", "https://es.wikipedia.org/wiki/Meitnerio"),
                    new Elementos(Metall_Trans, Sintetics, "Ds", "110", "Darmstadio", "271", "https://es.wikipedia.org/wiki/Darmstatio"),
                    new Elementos(Metall_Trans, Sintetics, "Rg", "111", "Roentgenium", "271,8", "https://es.wikipedia.org/wiki/Roentgenio"),
                    new Elementos(Metall_Trans,Solid,"Cn","112","Copernicio","285","https://es.wikipedia.org/wiki/Copernicio"),
                    new Elementos(MetallsBlocP, Sintetics, "Nh", "113", "Nihonium", "288", "https://es.wikipedia.org/wiki/Nihonio"),
                    new Elementos(MetallsBlocP, Sintetics, "FI", "114", "Flerovium", "289", "https://es.wikipedia.org/wiki/Flerovio"),
                    new Elementos(MetallsBlocP, Sintetics, "Mc", "115", "Moscovium", "", "https://es.wikipedia.org/wiki/Moscovio"),
                    new Elementos(MetallsBlocP, Sintetics, "Lv", "116", "Livermorium", "291", "https://es.wikipedia.org/wiki/Livermorio"),
                    new Elementos(Halogens, Sintetics, "Ts", "117", "Tennessine", "294", "https://es.wikipedia.org/wiki/Teneso"),
                    new Elementos(GasosNoble, Gasos, "Og", "118", "Oganesón", "286", "https://es.wikipedia.org/wiki/Oganes%C3%B3n"),

            };

    //Aquest 4 arrays son per ordenarlos per solid, liquid, sintetics i gasos
    private Elementos[] sintetics = new Elementos[]{
            new Elementos(Actinidis, Sintetics, "F", "9", "Fluor", "18,998403", "https://es.wikipedia.org/wiki/Fluor"),
            new Elementos(Metall_Trans, Sintetics, "Tc", "43", "Tecnecio", "97", "https://es.wikipedia.org/wiki/Tecnecio"),
            new Elementos(Actinidis, Sintetics, "Np", "93", "Neptunio", "30,9738", "https://es.wikipedia.org/wiki/Neptunio"),
            new Elementos(Actinidis, Sintetics, "Cm", "96", "Curio", "247", "https://es.wikipedia.org/wiki/Curio"),
            new Elementos(Actinidis, Sintetics, "Es", "99", "Einstenio", "252", "https://es.wikipedia.org/wiki/Einstenio"),
            new Elementos(Actinidis, Sintetics, "Fm", "100", "Fermio", "257", "https://es.wikipedia.org/wiki/Fermio"),
            new Elementos(Actinidis, Sintetics, "Md", "101", "Mendelevio", "258", "https://es.wikipedia.org/wiki/Mendelevio"),
            new Elementos(Actinidis, Sintetics, "No", "102", "Nobelio", "259", "https://es.wikipedia.org/wiki/Nobelio"),
            new Elementos(Actinidis, Sintetics, "Lr", "103", "Lawrencio", "262", "https://es.wikipedia.org/wiki/Lawrencio"),
            new Elementos(Metall_Trans, Sintetics, "Rf", "104", "Rutherfordio", "261", "https://es.wikipedia.org/wiki/Rutherfordio"),
            new Elementos(Metall_Trans, Sintetics, "Db", "105", "Dubnio", "264", "https://es.wikipedia.org/wiki/Dubnio"),
            new Elementos(Metall_Trans, Sintetics, "Sg", "106", "Seaborgio", "1,00794", "https://es.wikipedia.org/wiki/Seaborgio"),
            new Elementos(Metall_Trans, Sintetics, "Hs", "108", "Hassio", "277", "https://es.wikipedia.org/wiki/Hassio"),
            new Elementos(Metall_Trans, Sintetics, "Mn", "109", "Meitnerio", "266", "https://es.wikipedia.org/wiki/Meitnerio"),
            new Elementos(Metall_Trans, Sintetics, "Ds", "110", "Darmstadio", "271", "https://es.wikipedia.org/wiki/Darmstadio"),
            new Elementos(Metall_Trans, Sintetics, "Rg", "111", "Roentgenium", "271,8", "https://es.wikipedia.org/wiki/Roentgenium"),
            new Elementos(MetallsBlocP, Sintetics, "Nh", "113", "Nihonium", "284", "https://es.wikipedia.org/wiki/Nihonium"),
            new Elementos(MetallsBlocP, Sintetics, "FI", "114", "Flerovium", "289", "https://es.wikipedia.org/wiki/Flerovium"),
            new Elementos(MetallsBlocP, Sintetics, "Mc", "115", "Moscovium", "288", "https://es.wikipedia.org/wiki/Moscovium"),
            new Elementos(MetallsBlocP, Sintetics, "Lv", "116", "Livermorium", "292", "https://es.wikipedia.org/wiki/Rutherfordio"),
            new Elementos(Halogens, Sintetics, "Ts", "117", "Tennessine", "294", "https://es.wikipedia.org/wiki/Tennessine"),

    };

    private Elementos[] solids = new Elementos[]{

            new Elementos(MetallAlc, Solid, "Li", "3", "Litio", "6,941", "https://es.wikipedia.org/wiki/Litio"),
            new Elementos(Alcalinoterris,Solid,"Be","4","Berilio","9,0122","https://es.wikipedia.org/wiki/Berilio"),
            new Elementos(Metaloides,Solid,"B","5","Boro","10,811","https://es.wikipedia.org/wiki/Boro"),
            new Elementos(NoMetalls,Solid,"C","6","Carbono","12,01115","https://es.wikipedia.org/wiki/Carbono"),
            new Elementos(MetallAlc, Solid, "Na", "11", "Sodio", "22,9898", "https://es.wikipedia.org/wiki/Sodio"),
            new Elementos(Halogens, Solid, "Mg", "12", "Magnesio", "25,305", "https://es.wikipedia.org/wiki/Magnesio"),
            new Elementos(MetallsBlocP,Solid,"Al","13","Aluminio","26,9815","https://es.wikipedia.org/wiki/Aluminio"),
            new Elementos(Metaloides, Solid, "Si", "14", "Silicio", "28,086", "https://es.wikipedia.org/wiki/Silicio"),
            new Elementos(NoMetalls,Solid,"S","16","Azufre","32,064","https://es.wikipedia.org/wiki/Azufre"),
            new Elementos(MetallAlc, Solid, "K", "19", "Potasio", "39,098", "https://es.wikipedia.org/wiki/Potasio"),
            new Elementos(Alcalinoterris,Solid,"Ca","20","Calcio","40,08","https://es.wikipedia.org/wiki/Calcio"),
            new Elementos(Metall_Trans, Solid, "Sc", "21", "Escandio", "44,95591", "https://es.wikipedia.org/wiki/Escandio"),
            new Elementos(Metall_Trans, Solid, "Ti", "22", "Titanio", "47,90", "https://es.wikipedia.org/wiki/Titanio"),
            new Elementos(Metall_Trans, Solid, "V", "23", "Vanadio", "50,942", "https://es.wikipedia.org/wiki/Vanadio"),
            new Elementos(Metall_Trans, Solid, "Cr", "24", "Cromo", "51,9962", "https://es.wikipedia.org/wiki/Cromo"),
            new Elementos(Metall_Trans, Solid, "Mn", "25", "Mangnaeso", "54,938", "https://es.wikipedia.org/wiki/Manganeso"),
            new Elementos(Metall_Trans, Solid, "Fe", "26", "Hierro", "55,845", "https://es.wikipedia.org/wiki/Hierro"),
            new Elementos(Metall_Trans,Solid,"Co","27","Cobalto","58,93","https://es.wikipedia.org/wiki/Cobalto"),
            new Elementos(Metall_Trans, Solid, "Ni", "28", "Niquel", "58,71", "https://es.wikipedia.org/wiki/N%C3%ADquel"),
            new Elementos(Metall_Trans,Solid,"Cu","29","Cobre","63,54","https://es.wikipedia.org/wiki/Cobre"),
            new Elementos(Metall_Trans, Solid, "Zn", "30", "Zinc", "65,37", "https://es.wikipedia.org/wiki/Zinc"),
            new Elementos(MetallsBlocP, Solid, "Ga", "31", "Galio", "69,723", "https://es.wikipedia.org/wiki/Galio"),
            new Elementos(Metaloides, Solid, "Ge", "32", "Germanio", "77,64", "https://es.wikipedia.org/wiki/Germanio"),
            new Elementos(Metaloides,Solid,"As","33","Arsénico","74,922","https://es.wikipedia.org/wiki/Ars%C3%A9nico"),
            new Elementos(NoMetalls, Solid, "Se", "34", "Selenio", "78,96", "https://es.wikipedia.org/wiki/Selenio"),
            new Elementos(MetallAlc, Solid, "Rb", "37", "Rubidio", "85,47", "https://es.wikipedia.org/wiki/Rubidio"),
            new Elementos(Alcalinoterris, Solid, "Sr", "38", "Estroncio", "87,62", "https://es.wikipedia.org/wiki/Estroncio"),
            new Elementos(Metall_Trans, Solid, "Y", "39", "Itrio", "88,906", "https://es.wikipedia.org/wiki/Itrio"),
            new Elementos(Metall_Trans, Solid, "Zr", "40", "Zirconio", "91,22", "https://es.wikipedia.org/wiki/Circonio"),
            new Elementos(Metall_Trans, Solid, "Nb", "41", "Niobio", "92,906", "https://es.wikipedia.org/wiki/Niobio"),
            new Elementos(Metall_Trans, Solid, "Mo", "42", "Molibdeno", "95,94", "https://es.wikipedia.org/wiki/Molibdeno"),
            new Elementos(Metall_Trans, Solid, "Ru", "44", "Rutenio", "101,07", "https://es.wikipedia.org/wiki/Rutenio"),
            new Elementos(Metall_Trans, Solid, "Rh", "45", "Rodio", "102,905", "https://es.wikipedia.org/wiki/Rodio"),
            new Elementos(Metall_Trans, Solid, "Pd", "46", "Paladio", "106,4", "https://es.wikipedia.org/wiki/Paladio"),
            new Elementos(Metall_Trans, Solid, "Ag", "47", "Plata", "107,87", "https://es.wikipedia.org/wiki/Plata"),
            new Elementos(Metall_Trans,Solid,"Cd","48","Cadmio","112,40","https://es.wikipedia.org/wiki/Cadmio"),
            new Elementos(MetallsBlocP, Solid, "In", "49", "Indio", "114,82", "https://es.wikipedia.org/wiki/Indio_(elemento)"),
            new Elementos(MetallsBlocP, Solid, "Sn", "50", "Estaño", "118,710", "https://es.wikipedia.org/wiki/Esta%C3%B1o"),
            new Elementos(Metaloides,Solid,"Sb","51","Antimonio","121,76","https://es.wikipedia.org/wiki/Antimonio"),
            new Elementos(Metaloides, Solid, "Te", "52", "Teluro", "127,60", "https://es.wikipedia.org/wiki/Telurio"),
            new Elementos(Halogens, Solid, "I", "53", "Iodo", "126,904", "https://es.wikipedia.org/wiki/Yodo"),
            new Elementos(Alcalinoterris,Solid,"Cs","55","Cesio","132,905","https://es.wikipedia.org/wiki/Cesio"),
            new Elementos(Alcalinoterris,Solid,"Ba","56","Bario","137,34","https://es.wikipedia.org/wiki/Bario"),
            new Elementos(Actinidis, Solid, "La", "57", "Lantano", "138,9055", "https://es.wikipedia.org/wiki/Lantano"),
            new Elementos(Lantanids,Solid,"Ce","58","Cerio","140,12","https://es.wikipedia.org/wiki/Cerio"),
            new Elementos(Lantanids, Solid, "Pr", "59", "Praseodimio", "140,907", "https://es.wikipedia.org/wiki/Praseodimio"),
            new Elementos(Lantanids, Solid, "Nd", "60", "Neodimio", "144,24", "https://es.wikipedia.org/wiki/Neodimio"),
            new Elementos(Lantanids, Solid, "Pm", "61", "Promecio", "147", "https://es.wikipedia.org/wiki/Prometio"),
            new Elementos(Lantanids, Solid, "Sm", "62", "Samario", "263", "https://es.wikipedia.org/wiki/Samario"),
            new Elementos(Lantanids, Solid, "Eu", "63", "Europio", "151,964", "https://es.wikipedia.org/wiki/Europio"),
            new Elementos(Lantanids, Solid, "Gd", "64", "Gadolinio", "157,25", "https://es.wikipedia.org/wiki/Gadolinio"),
            new Elementos(Lantanids, Solid, "Tb", "65", "Terbio", "158,924", "https://es.wikipedia.org/wiki/Terbio"),
            new Elementos(Lantanids, Solid, "Dy", "66", "Disprosio", "162,500", "https://es.wikipedia.org/wiki/Disprosio"),
            new Elementos(Lantanids, Solid, "Ho", "67", "Holmio", "164,9303", "https://es.wikipedia.org/wiki/Holmio"),
            new Elementos(Lantanids, Solid, "Er", "68", "Erbio", "167,259", "https://es.wikipedia.org/wiki/Erbio"),
            new Elementos(Lantanids, Solid, "Tm", "69", "Tulio", "168,934", "https://es.wikipedia.org/wiki/Tulio"),
            new Elementos(Lantanids, Solid, "Yb", "70", "Iterbio", "173,04", "https://es.wikipedia.org/wiki/Iterbio"),
            new Elementos(Lantanids, Solid, "Lu", "71", "Lutecio", "174,97", "https://es.wikipedia.org/wiki/Lutecio"),
            new Elementos(Metall_Trans, Solid, "Hf", "72", "Hafnio", "69,723", "https://es.wikipedia.org/wiki/Hafnio"),
            new Elementos(Metall_Trans, Solid, "Ta", "73", "Tantalio", "180,948", "https://es.wikipedia.org/wiki/T%C3%A1ntalo_(elemento)"),
            new Elementos(Metall_Trans, Solid, "W", "74", "Wolframio", "183,85", "https://es.wikipedia.org/wiki/Wolframio"),
            new Elementos(Metall_Trans, Solid, "Re", "75", "Renio", "186,2", "https://es.wikipedia.org/wiki/Renio"),
            new Elementos(Metall_Trans, Solid, "Os", "76", "Osmio", "193,23", "https://es.wikipedia.org/wiki/Osmio#:~:text=El%20osmio%20es%20un%20elemento,aleaciones%20con%20platino%20e%20iridio."),
            new Elementos(Metall_Trans, Solid, "Ir", "77", "Iridio", "192,2", "https://es.wikipedia.org/wiki/Iridio"),
            new Elementos(Metall_Trans, Solid, "Pt", "78", "Platino", "195,09", "https://es.wikipedia.org/wiki/Platino"),
            new Elementos(Metall_Trans, Solid, "Au", "79", "Oro", "196,967", "https://es.wikipedia.org/wiki/Oro"),
            new Elementos(MetallsBlocP, Solid, "Tl", "81", "Talio", "204,37", "https://es.wikipedia.org/wiki/Talio"),
            new Elementos(MetallsBlocP, Solid, "Pb", "82", "Plomo", "207,19", "https://es.wikipedia.org/wiki/Plomo"),
            new Elementos(MetallsBlocP,Solid,"Bi","83","Bismuto","208,980","https://es.wikipedia.org/wiki/Bismuto"),
            new Elementos(Metaloides, Solid, "Po", "84", "Polonio", "210", "https://es.wikipedia.org/wiki/Polonio"),
            new Elementos(Halogens,Solid,"At","85","Astato","210","https://es.wikipedia.org/wiki/Ástato"),
            new Elementos(MetallAlc, Solid, "Fr", "87", "Francio", "223", "https://es.wikipedia.org/wiki/Francio"),
            new Elementos(Alcalinoterris, Solid, "Ra", "88", "Radio", "226", "https://es.wikipedia.org/wiki/Radio_(elemento)"),
            new Elementos(Actinidis,Solid,"Ac","89","Actinio","10.070","https://es.wikipedia.org/wiki/Actinio"),
            new Elementos(Actinidis, Solid, "Th", "90", "Torio", "232,083", "https://es.wikipedia.org/wiki/Torio"),
            new Elementos(Actinidis, Solid, "Pa", "91", "Protactinio", "231", "https://es.wikipedia.org/wiki/Protactinio"),
            new Elementos(Actinidis, Solid, "U", "92", "Uranio", "238,03", "https://es.wikipedia.org/wiki/Uranio"),
            new Elementos(Actinidis, Solid, "Pu", "94", "Plutonio", "242", "https://es.wikipedia.org/wiki/Plutonio"),
            new Elementos(Actinidis,Solid,"Am","95","Americio","243","https://es.wikipedia.org/wiki/Americio"),
            new Elementos(Actinidis,Solid,"Bk","97","Berkelio","247","https://es.wikipedia.org/wiki/Berkelio"),
            new Elementos(Actinidis,Solid,"Cf","98","Californio","251","https://es.wikipedia.org/wiki/Californio"),
            new Elementos(Metall_Trans,Solid,"Bh","107","Bohrio","262","https://es.wikipedia.org/wiki/Bohrio"),
            new Elementos(Metall_Trans,Solid,"Cn","112","Copernicio","285","https://es.wikipedia.org/wiki/Copernicio"),
    };

    private Elementos[] liquids = new Elementos[]{
            new Elementos(NoMetalls, Liquid, "Br", "35", "Bromo", "79.909", "https://es.wikipedia.org/wiki/Bromo%22"),
            new Elementos(GasosNoble, Liquid, "Kr", "36", "Krypton", "83,80", "https://es.wikipedia.org/wiki/Kript%C3%B3n"),
            new Elementos(Metall_Trans, Liquid, "Hg", "80", "Mercurio", "200,59", "https://es.wikipedia.org/wiki/Mercurio%22"),
    };

    private Elementos[] gasos = new Elementos[]{
            new Elementos(NoMetalls, Gasos, "H", "1", "Hidrogeno", "1,00794", "https://es.wikipedia.org/wiki/Hidr%C3%B3geno"),
            new Elementos(GasosNoble, Gasos, "He", "2", "Helio", "4,002602", "https://es.wikipedia.org/wiki/Helio"),
            new Elementos(NoMetalls, Gasos, "N", "7", "Nitrógeno", "14,0067", "https://es.wikipedia.org/wiki/Nitr%C3%B3geno"),
            new Elementos(NoMetalls, Gasos, "O", "8", "Oxígeno", "15,99994", "https://es.wikipedia.org/wiki/Ox%C3%ADgeno"),
            new Elementos(GasosNoble, Gasos, "Ne", "10", "Neon", "20,179", "https://es.wikipedia.org/wiki/Ne%C3%B3n"),
            new Elementos(Halogens, Gasos, "P", "15", "Fosforo", "39,97696", "https://es.wikipedia.org/wiki/Fósforo"),
            new Elementos(Halogens,Gasos,"Cl","17","Cloro","35,453","https://es.wikipedia.org/wiki/Cloro"),
            new Elementos(GasosNoble,Gasos,"Ar","18","Argón","39,948","https://es.wikipedia.org/wiki/Arg%C3%B3n"),
            new Elementos(GasosNoble, Gasos, "Xe", "54", "Xenón", "131,30", "https://es.wikipedia.org/wiki/Xen%C3%B3n"),
            new Elementos(GasosNoble, Gasos, "Rn", "86", "Radón", "222", "https://es.wikipedia.org/wiki/Rad%C3%B3n"),
            new Elementos(GasosNoble, Gasos, "Og", "118", "Oganesón", "286", "https://es.wikipedia.org/wiki/Oganes%C3%B3n"),
    };

    //Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);

        return true;
    }

    //Comença el Oncreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        ActionBar actionBar = getSupportActionBar();

        //Creem un adaptador
        AdaptadorElements adaptadorElements = new AdaptadorElements(this, Elements);


        ListView ListView = (ListView) findViewById(R.id.ListView);
        ListView.setAdapter(adaptadorElements);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String [] InfoElementos  = new String[6];

                InfoElementos[0]=Elements[position].getNom();
                InfoElementos[1]=Elements[position].getNumero();
                InfoElementos[2]=Elements[position].getLletra();
                InfoElementos[3]=Elements[position].getPes();
                InfoElementos[4]=Elements[position].getAtomic();
                InfoElementos[5]=Elements[position].getLink();

                //Creem un intent per anar a la classe informacion_Elementos y un bundle también, con la clave elementos.
                Intent intent = new Intent (Taula.this, Informacion_Elementos.class);

                Bundle b = new Bundle();
                b.putStringArray ("Elementos",InfoElementos);
                intent.putExtras(b);

                startActivityForResult(intent, 0);

            }
        });
    }

    //Creem la classe adaptador i dins fiquem tots els colors de cada element, per l'array de elements.
    class AdaptadorElements extends ArrayAdapter<Elementos> {

        public AdaptadorElements(Context context, Elementos[] elements) {
            super(context, R.layout.activity_taula, elements);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_taula, null);

            TextView Nombre = (TextView) item.findViewById(R.id.Nombre);
            Nombre.setText(Elements[position].getNom());

            TextView Lletra = (TextView) item.findViewById(R.id.Simbolo);
            Lletra.setText(Elements[position].getLletra());

            TextView Numero = (TextView) item.findViewById(R.id.Numero);
            Numero.setText(Elements[position].getNumero());

            TextView Peso = (TextView) item.findViewById(R.id.Peso);
            Peso.setText(Elements[position].getPes());



            switch(Elements[position].getAtomic()){
                case "Liquid":
                    Lletra.setTextColor(Color.parseColor("#3300FF"));
                    break;
                case "Sintetics":
                    Lletra.setTextColor(Color.parseColor("#FF3300"));
                    break;
                case "Gasos":
                    Lletra.setTextColor(Color.parseColor("#00CC00"));
                    break;
                case "Solid":
                    Lletra.setTextColor(Color.parseColor("#000000"));
                    break;
            }
            switch (Elements[position].getSerieQuimica()){
                case "Metall_Transicio":
                    item.setBackgroundColor(Color.parseColor("#FFCC99"));
                    break;
                case "No_metalls":
                    item.setBackgroundColor(Color.parseColor("#66FF33"));
                    break;
                case "Metall_Alcalins":
                    item.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case "Alcaliooterris":
                    item.setBackgroundColor(Color.parseColor("#FFFFCC"));
                    break;
                case "Lantanids":
                    item.setBackgroundColor(Color.parseColor("#FF33FF"));
                    break;
                case"Actinidis":
                    item.setBackgroundColor(Color.parseColor("#FF6699"));
                    break;
                case "Metalls_Bloc_P":
                    item.setBackgroundColor(Color.parseColor("#555555"));
                    break;
                case "Metaloides":
                    item.setBackgroundColor(Color.parseColor("#999966"));
                    break;
                case "Halogens":
                    item.setBackgroundColor(Color.parseColor("#FFFF33"));
                    break;
                case "Gasos_nobles":
                    item.setBackgroundColor(Color.parseColor("#33FFFF"));
                    break;
            }
            return item;
        }

    }

    //El mateic pero em l'array de sintetics
    class AdaptadorElementsSintetics extends  ArrayAdapter<Elementos>{
        public AdaptadorElementsSintetics(Context context, Elementos[] sintetics) {
            super(context, R.layout.activity_taula, sintetics);
        }
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_taula, null);

            TextView Nombre = (TextView) item.findViewById(R.id.Nombre);
            Nombre.setText(sintetics[position].getNom());

            TextView Lletra = (TextView) item.findViewById(R.id.Simbolo);
            Lletra.setText(sintetics[position].getLletra());

            TextView Numero = (TextView) item.findViewById(R.id.Numero);
            Numero.setText(sintetics[position].getNumero());

            TextView Peso = (TextView) item.findViewById(R.id.Peso);
            Peso.setText(sintetics[position].getPes());

            switch(sintetics[position].getAtomic()){
                case "Sintetics":
                    Lletra.setTextColor(Color.parseColor("#FF3300"));
                    break;
            }

            switch (sintetics[position].getSerieQuimica()){
                case "Metall_Transicio":
                    item.setBackgroundColor(Color.parseColor("#FFCC99"));
                    break;
                case "No_metalls":
                    item.setBackgroundColor(Color.parseColor("#66FF33"));
                    break;
                case "Metall_Alcalins":
                    item.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case "Alcaliooterris":
                    item.setBackgroundColor(Color.parseColor("#FFFFCC"));
                    break;
                case "Lantanids":
                    item.setBackgroundColor(Color.parseColor("#FF33FF"));
                    break;
                case"Actinidis":
                    item.setBackgroundColor(Color.parseColor("#FF6699"));
                    break;
                case "Metalls_Bloc_P":
                    item.setBackgroundColor(Color.parseColor("#555555"));
                    break;
                case "Metaloides":
                    item.setBackgroundColor(Color.parseColor("#999966"));
                    break;
                case "Halogens":
                    item.setBackgroundColor(Color.parseColor("#FFFF33"));
                    break;
                case "Gasos_nobles":
                    item.setBackgroundColor(Color.parseColor("#33FFFF"));
                    break;
            }
            return item;
        }

    }

    //El mateic pero em l'array de liquids
    class AdaptadorElementsLiquids extends  ArrayAdapter<Elementos>{
        public AdaptadorElementsLiquids(Context context, Elementos[] liquids) {
            super(context, R.layout.activity_taula, liquids);
        }
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_taula, null);

            TextView Nombre = (TextView) item.findViewById(R.id.Nombre);
            Nombre.setText(liquids[position].getNom());

            TextView Lletra = (TextView) item.findViewById(R.id.Simbolo);
            Lletra.setText(liquids[position].getLletra());

            TextView Numero = (TextView) item.findViewById(R.id.Numero);
            Numero.setText(liquids[position].getNumero());

            TextView Peso = (TextView) item.findViewById(R.id.Peso);
            Peso.setText(liquids[position].getPes());

            switch(liquids[position].getAtomic()){
                case "Liquid":
                    Lletra.setTextColor(Color.parseColor("#0000FF"));
                    break;
            }



            switch (liquids[position].getSerieQuimica()){
                case "Metall_Transicio":
                    item.setBackgroundColor(Color.parseColor("#FFCC99"));
                    break;
                case "No_metalls":
                    item.setBackgroundColor(Color.parseColor("#66FF33"));
                    break;
                case "Metall_Alcalins":
                    item.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case "Alcaliooterris":
                    item.setBackgroundColor(Color.parseColor("#FFFFCC"));
                    break;
                case "Lantanids":
                    item.setBackgroundColor(Color.parseColor("#FF33FF"));
                    break;
                case"Actinidis":
                    item.setBackgroundColor(Color.parseColor("#FF6699"));
                    break;
                case "Metalls_Bloc_P":
                    item.setBackgroundColor(Color.parseColor("#555555"));
                    break;
                case "Metaloides":
                    item.setBackgroundColor(Color.parseColor("#999966"));
                    break;
                case "Halogens":
                    item.setBackgroundColor(Color.parseColor("#FFFF33"));
                    break;
                case "Gasos_nobles":
                    item.setBackgroundColor(Color.parseColor("#33FFFF"));
                    break;
            }
            return item;
        }

    }

    //El mateic pero em l'array de solids
    class AdaptadorElementsSolids extends  ArrayAdapter<Elementos>{
        public AdaptadorElementsSolids(Context context, Elementos[] solids) {
            super(context, R.layout.activity_taula, solids);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_taula, null);

            TextView Nombre = (TextView) item.findViewById(R.id.Nombre);
            Nombre.setText(solids[position].getNom());

            TextView Lletra = (TextView) item.findViewById(R.id.Simbolo);
            Lletra.setText(solids[position].getLletra());

            TextView Numero = (TextView) item.findViewById(R.id.Numero);
            Numero.setText(solids[position].getNumero());

            TextView Peso = (TextView) item.findViewById(R.id.Peso);
            Peso.setText(solids[position].getPes());

            switch(solids[position].getAtomic()){
                case "Solid":
                    Lletra.setTextColor(Color.parseColor("#000000"));
                    break;
            }

            switch (solids[position].getSerieQuimica()){
                case "Metall_Transicio":
                    item.setBackgroundColor(Color.parseColor("#FFCC99"));
                    break;
                case "No_metalls":
                    item.setBackgroundColor(Color.parseColor("#66FF33"));
                    break;
                case "Metall_Alcalins":
                    item.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case "Alcaliooterris":
                    item.setBackgroundColor(Color.parseColor("#FFFFCC"));
                    break;
                case "Lantanids":
                    item.setBackgroundColor(Color.parseColor("#FF33FF"));
                    break;
                case"Actinidis":
                    item.setBackgroundColor(Color.parseColor("#FF6699"));
                    break;
                case "Metalls_Bloc_P":
                    item.setBackgroundColor(Color.parseColor("#555555"));
                    break;
                case "Metaloides":
                    item.setBackgroundColor(Color.parseColor("#999966"));
                    break;
                case "Halogens":
                    item.setBackgroundColor(Color.parseColor("#FFFF33"));
                    break;
                case "Gasos_nobles":
                    item.setBackgroundColor(Color.parseColor("#33FFFF"));
                    break;
            }

            return item;
        }
    }

    //El mateic pero em l'array de gasos.
    class AdaptadorElementsGasos extends  ArrayAdapter<Elementos>{
        public AdaptadorElementsGasos(Context context, Elementos[] gasos) {
            super(context, R.layout.activity_taula, gasos);
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_taula, null);

            TextView Nombre = (TextView) item.findViewById(R.id.Nombre);
            Nombre.setText(gasos[position].getNom());

            TextView Lletra = (TextView) item.findViewById(R.id.Simbolo);
            Lletra.setText(gasos[position].getLletra());

            TextView Numero = (TextView) item.findViewById(R.id.Numero);
            Numero.setText(gasos[position].getNumero());

            TextView Peso = (TextView) item.findViewById(R.id.Peso);
            Peso.setText(gasos[position].getPes());

            switch(gasos[position].getAtomic()){
                case "Gasos":
                    Lletra.setTextColor(Color.parseColor("#00CC00"));
                    break;
            }

            switch (gasos[position].getSerieQuimica()){
                case "Metall_Transicio":
                    item.setBackgroundColor(Color.parseColor("#FFCC99"));
                    break;
                case "No_metalls":
                    item.setBackgroundColor(Color.parseColor("#66FF33"));
                    break;
                case "Metall_Alcalins":
                    item.setBackgroundColor(Color.parseColor("#FF0000"));
                    break;
                case "Alcaliooterris":
                    item.setBackgroundColor(Color.parseColor("#FFFFCC"));
                    break;
                case "Lantanids":
                    item.setBackgroundColor(Color.parseColor("#FF33FF"));
                    break;
                case"Actinidis":
                    item.setBackgroundColor(Color.parseColor("#FF6699"));
                    break;
                case "Metalls_Bloc_P":
                    item.setBackgroundColor(Color.parseColor("#AAAAAA"));
                    break;
                case "Metaloides":
                    item.setBackgroundColor(Color.parseColor("#999966"));
                    break;
                case "Halogens":
                    item.setBackgroundColor(Color.parseColor("#FFFF33"));
                    break;
                case "Gasos_nobles":
                    item.setBackgroundColor(Color.parseColor("#33FFFF"));
                    break;
            }
            return item;
        }
    }

    //Pra el Action Bar fem case para cada opcio a triar.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //Opcio anar  al joc
            case R.id.item5:
                Intent AnarJoc = new Intent(Taula.this, Joc.class);
                startActivity(AnarJoc);
                return true;

                //Opcion mostrar tots els elemnts
            case R.id.item6:
                AdaptadorElements adaptadorElements = new AdaptadorElements(this, Elements);
                setTitle("Tots els elementss");
                ListView ListView = (ListView) findViewById(R.id.ListView);
                ListView.setAdapter(adaptadorElements);
                return true;

                //Mostrar elements sintetics
            case R.id.item1:
                ActionBar ActionBar = getSupportActionBar();
                ActionBar.setTitle("Sintetics");
                ActionBar.setDisplayHomeAsUpEnabled(true);
                AdaptadorElementsSintetics adaptadorElementsSintetics = new AdaptadorElementsSintetics(this, sintetics);
                ListView Sinteticsln = (ListView) findViewById(R.id.ListView);
                Sinteticsln.setAdapter(adaptadorElementsSintetics);
                return true;

                //Mostrar elements gaseosos
            case R.id.item2:
                ActionBar ActionBar2 = getSupportActionBar();
                ActionBar2.setTitle("Gasos");
                ActionBar2.setDisplayHomeAsUpEnabled(true);

                AdaptadorElementsGasos adaptadorElementsGasos = new AdaptadorElementsGasos(this, gasos);
                ListView Gasosln = (ListView) findViewById(R.id.ListView);
                Gasosln.setAdapter(adaptadorElementsGasos);
                return true;

                //mostrar elements solids
            case R.id.item3:
                ActionBar ActionBar3 = getSupportActionBar();
                ActionBar3.setTitle("Solids");
                ActionBar3.setDisplayHomeAsUpEnabled(true);

                AdaptadorElementsSolids adaptadorElementsSolids = new AdaptadorElementsSolids(this, solids);
                ListView Solidsln = (ListView) findViewById(R.id.ListView);
                Solidsln.setAdapter(adaptadorElementsSolids);
                return true;
                //Mostrar elements liquids
            case R.id.item4:
                ActionBar ActionBar4 = getSupportActionBar();
                ActionBar4.setTitle("Liquids");
                ActionBar4.setDisplayHomeAsUpEnabled(true);

                AdaptadorElementsLiquids adaptadorElementsLiquids = new AdaptadorElementsLiquids(this, liquids);
                ListView Liquidsln = (ListView) findViewById(R.id.ListView);
                Liquidsln.setAdapter(adaptadorElementsLiquids);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}