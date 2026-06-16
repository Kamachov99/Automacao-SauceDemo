package automacao.saucedemo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import automacao.saucedemo.core.BaseTest;

public class CartTest extends BaseTest{
	
	@Test
	public void addProdutoCarrinho() {
		
		fazerLogin("standard_user","secret_sauce");
		tirarPrint("CT-Cart 01 - Usuario logado");
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		tirarPrint("CT-Cart 02 - Produto adicionado");
		
		String contadorCart = driver.findElement(By.className("shopping_cart_badge")).getText();
		Assertions.assertEquals("1", contadorCart, "Nenhum produto adicionado");
		
		driver.findElement(By.className("shopping_cart_link")).click();
		tirarPrint("CT-Cart 03 - Tela carrinho");
		
		String nomeProduto = driver.findElement(By.cssSelector(".cart_item .inventory_item_name")).getText();
		Assertions.assertEquals("Sauce Labs Bike Light", nomeProduto, "Produto nao adicionado no carrinho");
		
	}
	
	@Test
	public void removerProdutoCarrinho() {
		
		fazerLogin("standard_user","secret_sauce");
		tirarPrint("CT-RemoverProdutoCarrinho 01 - Usuario logado");
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		tirarPrint("CT-RemoverProdutoCarrinho 02 - Produto adicionado");
		
		driver.findElement(By.className("shopping_cart_link")).click();
		tirarPrint("CT-RemoverProdutoCarrinho 03 - Tela com produto adicionado carrinho");
		
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
		tirarPrint("CT-RemoverProdutoCarrinho 04 - Produto removido");
		
		boolean cartVazio = driver.findElements(By.className("shopping_cart_badge")).isEmpty();
		Assertions.assertTrue(cartVazio, "Carrinho nao ficou vazio");
		
	}

}
