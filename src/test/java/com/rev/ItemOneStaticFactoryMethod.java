package com.rev;
import com.EffectiveJavaObjects.Bunny;
import org.junit.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;


public class ItemOneStaticFactoryMethod {

    @Test()
    /*using constructors*/
    public void getString(){
        String constructorString =  new String("this is a constructor string");
        assertThat(constructorString).isEqualTo(constructorString.toString());
    }

    /*using static factory*/
    @Test
    public void getStringUsingStaticFactory(){
        String staticFactoryString1  = String.valueOf("this is a static factory string");
        assertThat(staticFactoryString1).isEqualTo(staticFactoryString1.toString());

        char[]charArray = {'a','b','c'};
        String staticFactoryString2 =  String.valueOf(charArray);
        assertThat(staticFactoryString2).isEqualTo(staticFactoryString2.toString());
    }

    @Test
    public void canGetBunnyUsingStaticFactory(){
        Bunny bunny = new Bunny("Fufu", "lop");
        assertThat(bunny.getName()).isEqualTo("Fufu");

        /*will be used when type isn't known*/
        Bunny staticBunny = Bunny.createDefaultBunny("tufu");
        assertThat(bunny.getName()).isEqualTo("tufu");
    }
}
