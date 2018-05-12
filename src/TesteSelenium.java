import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSelenium {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Walker\\Documents\\Programas\\geckodriver.exe");
			
		//Abre o navegador.
		WebDriver driver = new FirefoxDriver();
		
		//Acessar a página.
		driver.get("https://www.google.com.br");
		
		//Pesquisando o campo texto do formulário do google.
		WebElement campoPesquisa = driver.findElement(By.name("q"));
		
		//Passando valores pra ele.
		campoPesquisa.sendKeys("github.com/evertonwalker");
		
		//submete o formulário
		campoPesquisa.submit();
		
		
	}	

}
