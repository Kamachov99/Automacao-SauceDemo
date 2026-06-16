package automacao.saucedemo.test;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automacao.saucedemo.core.BaseTest;

public class FluxoTest extends BaseTest {
	
	@Test
	public void finalizarCompra() {
		
		fazerLogin("standard_user","secret_sauce");
		tirarPrint ("CT-FluxoCompleto 01 - Usuario logado");
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		tirarPrint("CT-FluxoCompleto 02 - Produto adicionado carrinho");
		
		driver.findElement(By.className("shopping_cart_link")).click();
		tirarPrint("CT-FluxoCompleto 03 - Tela carrinho com produto");
		
		driver.findElement(By.id("checkout")).click();
		
		WebDriverWait waitForm = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitForm.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
		
		tirarPrint("CT-FluxoCompleto 04 - Tela formulario checkout");
		
		driver.findElement(By.id("first-name")).sendKeys("Luis");
		driver.findElement(By.id("last-name")).sendKeys("Camacho");
		driver.findElement(By.id("postal-code")).sendKeys("06086120");
		tirarPrint("CT-FluxoCompleto 05 - Dados preenchidos");
		
		driver.findElement(By.id("continue")).click();
		tirarPrint("CT-FluxoCompleto 06 - Overview da compra");
		
		String nomeProduto = driver.findElement(By.className("inventory_item_name")).getText();
		Assertions.assertEquals("Sauce Labs Bolt T-Shirt", nomeProduto, "Produto errado no overview");
		
		driver.findElement(By.id("finish")).click();
		tirarPrint("CT-FluxoCompleto 07 - Compra finalizada com sucesso");
		
		String mensagemConfirmacao = driver.findElement(By.className("complete-header")).getText();
		Assertions.assertEquals("Thank you for your order!", mensagemConfirmacao, "Erro ao finalizar compra");
		
	}

}