package automacao.saucedemo.test;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automacao.saucedemo.core.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginLogout() {
		
		tirarPrint("CT-Login 01 - Tela Login");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		tirarPrint("CT-Login 02 - Usuário preenchido");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		tirarPrint("CT-Login 03 - Senha preenchida");
		driver.findElement(By.id("login-button")).click();
		tirarPrint("CT-Login 04 - Login sucesso");
		
		String tituloPagina = driver.findElement(By.className("title")).getText();
		Assertions.assertEquals("Products", tituloPagina, "Login falhou - pagina de produtos nao carregou");
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		tirarPrint("CT-Login 05 - Logout");
		
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		Assertions.assertTrue(
				driver.findElement(By.id("login-button")).isDisplayed(),
				"Logout falhou - botao de login nao aparece");
		
	}

	@Test
	public void loginUsuarioInvalido() {
		
		tirarPrint("CT-LoginInvalido 01 - Tela login");
		fazerLogin("usario_invalido","senha_invalida");
		
		tirarPrint("CT-LoginInvalido 02 - Mensagem erro");
		
		String mensagemErro = driver.findElement(By.cssSelector("[data-test='error']")).getText();
		
		Assertions.assertTrue(
				mensagemErro.contains("Username and password do not match any user in this service"),
				"Mensagem de erro nao aparece");
		
	}
	
	
}
