package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    Varasto varasto3;
    Varasto varasto4;
    Varasto varasto5;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2=new Varasto(-100);
        varasto3=new Varasto(0,100);
        varasto4=new Varasto(5,10);
        varasto5=new Varasto(5,-10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVaraston2() {
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVaraston3() {
        assertEquals(0, varasto3.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    @Test
    public void otetaanLiikaa() {
        varasto.otaVarastosta(120);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void laitetaanLiikaa() {
        varasto.lisaaVarastoon(varasto.getTilavuus()+100);
        assertEquals(varasto.getSaldo(), varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriJosNegatiivinenLuoTyhjan() {
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriJosTilavuusNollaLuoTyhjan() {
        assertEquals(0, varasto3.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void lisataanNegatiivinen() {
        varasto3.lisaaVarastoon(-1000);
        assertEquals(0, varasto3.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void palautetaanArvot() {
        varasto3.lisaaVarastoon(10);
        assertEquals(0, varasto3.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void palautetaanArvot2() {
        varasto2.lisaaVarastoon(10);
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void liianPieniVarasto() {
        varasto2.lisaaVarastoon(10);
        assertEquals(5, varasto4.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void negatiivinenAlkusaldoNollaantuu() {
        assertEquals(0, varasto5.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void stringToimii() {
        assertEquals("saldo = 0, viela tilaa 0", varasto3.toString());
    }

}