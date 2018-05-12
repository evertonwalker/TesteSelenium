package LeiloesTestes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class UsuarioTestes {

	public UsuarioTestes() {
		//driver de configuração para o novo selenium 
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Walker\\Documents\\Programas\\geckodriver.exe");
	}

	private FirefoxDriver driver;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/usuarios/new");
	}

	@Test
	public void testarInsercaoUsuario() {

		WebElement nomeUsuario = driver.findElement(By.name("usuario.nome"));
		WebElement emailUsuario = driver.findElement(By.name("usuario.email"));

		nomeUsuario.sendKeys("Everton Walker");
		emailUsuario.sendKeys("everton.walker@hotmail.com");

		WebElement botao = driver.findElement(By.id("btnSalvar"));
		botao.click();

		//ou você pode utilizar o submit com qualquer elemento de input do formulário.
		// nomeUsuario.submit();

		boolean encontrouNome = driver.getPageSource().contains("Everton Walker");
		boolean encontrouEmail = driver.getPageSource().contains("everton.walker@hotmail.com");	

		assertTrue(encontrouNome);
		assertTrue(encontrouEmail);

	}


	@Test
	public void testarNomeObrigatorio() {

		WebElement emailUsuario = driver.findElement(By.name("usuario.email"));

		emailUsuario.sendKeys("everton.walker@hotmail.com");

		WebElement botao = driver.findElement(By.id("btnSalvar"));
		botao.click();

		//ou você pode utilizar o submit com qualquer elemento de input do formulário.
		// nomeUsuario.submit();

		boolean faltouUmNome = driver.getPageSource().contains("Nome obrigatorio!");

		assertTrue(faltouUmNome);

	}
	
	
	@Test
	public void testarBotaoIncluir() {
		
		driver.get("http://localhost:8080/usuarios");
		driver.findElement(By.linkText("Novo Usuário")).click();
		
		boolean encontrouPalavraNome = driver.getPageSource().contains("Nome:");	
		
		assertTrue(encontrouPalavraNome);
	}

	@After
	public void finaliza() {
		driver.close();
	}
	
}
