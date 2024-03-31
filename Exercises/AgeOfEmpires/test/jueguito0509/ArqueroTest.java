package jueguito0509;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArqueroTest {

	Arquero arqueroUno;
	Arquero arqueroDos;
	int hpArqueroBase;
	int armorArqueroBase;
	Arquero arqueroTres;
	Arquero arqueroCuatro;
	Arquero arqueroCinco;
	Arquero arqueroSeis;

	@Before
	public void setUp() {

		try {
			arqueroUno = new Arquero("pepito", "Azul", new Punto(1, 0), 100);
			arqueroDos = new Arquero("pepito2", "Rojo", new Punto(2, 0), 100);
			arqueroTres = new Arquero("pepito3", "Azul", new Punto(3, 0), 100);
			arqueroCuatro = new Arquero("pepito4", "Amarillo", new Punto(4, 0), 100);
			arqueroCinco = new Arquero("pepito5", "Amarillo", new Punto(5, 0), 100);
			arqueroSeis = new Arquero("pepito6", "Amarillo", new Punto(21, 21), 100);
			hpArqueroBase = arqueroUno.getHp();
			armorArqueroBase = arqueroUno.getArmor();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void queAtaqueAOtroArqueroRivalYSaqueArmorAntesQueHp() {
		arqueroUno.atacar(arqueroDos);
		Assert.assertEquals(hpArqueroBase, arqueroDos.getHp());
		Assert.assertEquals(45, arqueroDos.getArmor());
		Assert.assertEquals(45, arqueroUno.getStamina());
		Assert.assertEquals(9, arqueroUno.getCantFlechas());
	}

	@Test
	public void queAtaqueAOtroArqueroRivalYSaqueArmorYHp() {
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		Assert.assertEquals(0, arqueroDos.getArmor());
		Assert.assertEquals(20, arqueroDos.getHp());
		Assert.assertEquals(35, arqueroUno.getStamina());
		Assert.assertEquals(7, arqueroUno.getCantFlechas());
	}

	@Test
	public void queArqueroElimineAOponente() {
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		Assert.assertFalse(arqueroDos.sigueEnPie());
		arqueroCuatro.atacar(arqueroUno);
		arqueroCuatro.atacar(arqueroUno);
		arqueroCuatro.atacar(arqueroUno);
		arqueroCuatro.atacar(arqueroUno);
		Assert.assertFalse(arqueroUno.sigueEnPie());
		arqueroTres.atacar(arqueroCuatro);
		arqueroTres.atacar(arqueroCuatro);
		arqueroTres.atacar(arqueroCuatro);
		arqueroTres.atacar(arqueroCuatro);
		Assert.assertFalse(arqueroCuatro.sigueEnPie());
	}

	@Test
	public void queArqueroNoSePuedaAtacarASiMismo() {
		arqueroUno.atacar(arqueroUno);
		arqueroUno.atacar(arqueroUno);
		arqueroUno.atacar(arqueroUno);
		arqueroDos.atacar(arqueroDos);
		arqueroDos.atacar(arqueroDos);
		arqueroDos.atacar(arqueroDos);
		arqueroTres.atacar(arqueroTres);
		arqueroTres.atacar(arqueroTres);
		arqueroTres.atacar(arqueroTres);

		Assert.assertEquals(hpArqueroBase, arqueroUno.getHp());
		Assert.assertEquals(armorArqueroBase, arqueroUno.getArmor());
		Assert.assertEquals(hpArqueroBase, arqueroDos.getHp());
		Assert.assertEquals(armorArqueroBase, arqueroDos.getArmor());
		Assert.assertEquals(hpArqueroBase, arqueroTres.getHp());
		Assert.assertEquals(armorArqueroBase, arqueroTres.getArmor());
	}

	@Test
	public void queArqueroNoPuedaAtacarMismoEquipo() {
		arqueroUno.atacar(arqueroTres);
		arqueroUno.atacar(arqueroTres);
		arqueroUno.atacar(arqueroTres);
		arqueroTres.atacar(arqueroUno);
		arqueroTres.atacar(arqueroUno);
		arqueroTres.atacar(arqueroUno);

		Assert.assertEquals(hpArqueroBase, arqueroUno.getHp());
		Assert.assertEquals(armorArqueroBase, arqueroUno.getArmor());
		Assert.assertEquals(hpArqueroBase, arqueroTres.getHp());
		Assert.assertEquals(armorArqueroBase, arqueroTres.getArmor());
	}

	@Test
	public void queArqueroGasteFlechas() {
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		Assert.assertEquals(6, arqueroUno.getCantFlechas());
	}

	@Test
	public void queArqueroNoAtaqueSinStamina() {
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroCuatro);
		arqueroUno.atacar(arqueroCuatro);
		arqueroUno.atacar(arqueroCuatro);
		arqueroUno.atacar(arqueroCuatro);
		arqueroUno.atacar(arqueroCinco);
		arqueroUno.atacar(arqueroCinco);
		arqueroUno.atacar(arqueroCinco);
		Assert.assertEquals(0, arqueroUno.getStamina());
		Assert.assertEquals(15, arqueroCinco.getArmor());
		Assert.assertEquals(hpArqueroBase, arqueroCinco.getHp());
	}

	@Test
	public void queArqueroNoAtaqueSinFlechas() {
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
	}

	@Test
	public void queArqueroNoAtaqueFueraDeRango() {
		arqueroUno.atacar(arqueroSeis);
		Assert.assertEquals(hpArqueroBase, arqueroSeis.getHp());
		Assert.assertEquals(armorArqueroBase, arqueroSeis.getArmor());
		Assert.assertEquals(10, arqueroUno.getCantFlechas());
		Assert.assertEquals(50, arqueroUno.getStamina());
	}

	@Test
	public void queArqueroNoSigaAtacandoAEnemigoMuerto() { // agregar exception
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		Assert.assertFalse(arqueroDos.sigueEnPie());
		Assert.assertEquals(30, arqueroUno.getStamina());
		Assert.assertEquals(6, arqueroUno.getCantFlechas());
	}

	@Test
	public void queArqueroNoAtaqueSiEstaMuerto() { // agregar exception
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		arqueroUno.atacar(arqueroDos);
		Assert.assertFalse(arqueroDos.sigueEnPie());
		arqueroDos.atacar(arqueroUno);
		Assert.assertEquals(hpArqueroBase, arqueroUno.getHp());
		Assert.assertEquals(armorArqueroBase, arqueroUno.getArmor());
	}

}
