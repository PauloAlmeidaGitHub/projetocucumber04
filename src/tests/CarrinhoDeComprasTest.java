package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class CarrinhoDeComprasTest {

	WebDriver driver;

	@Dado("^Acessar a loja virtual$")
	public void acessar_a_loja_virtual() {

		// referenciar o driver do navegador
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");

		// abrir o google chrome e acessar a página do projeto
		driver = new ChromeDriver();
		driver.get("http://www.lojaexemplodelivros.com.br/");

		// maximizar o navegador
		driver.manage().window().maximize();
	}

	@Dado("^Selecionar um produto \"([^\"]*)\"$")
	public void selecionar_um_produto(String arg1) {

		// selecionar o produto que será adicionado no carrinho
		driver.findElement(By.xpath("//a[@title='" + arg1 + "']")).click();
	}

	@Dado("^Informar a quantidade desejada (\\d+)$")
	public void informar_a_quantidade_desejada(int arg1) {

		// digitar a quantidade desejada do produto
		driver.findElement(By.cssSelector("#qty")).sendKeys(String.valueOf(arg1));
	}

	@Quando("^Confirmar a compra do produto$")
	public void confirmar_a_compra_do_produto() {
		// Na tela onde aparece a qyantidade tem um botão comprar (2:00:16h da aula 15)
		// Botão da direita, inspecionar vai em <button type... - Botão direito e
		// escolha copy / copy selector
		// Deveria ter im ID do button

		// clicar no botão 'comprar'
		driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.add-to-box > div > button"))
				.click();
	}

	@Então("^O produto é adicionado no carrinho de compras$")
	public void o_produto_é_adicionado_no_carrinho_de_compras() {
		

		// Poderia ser checado pela mensagem "foi adicionado ao carrinho de compras."
		// ou
		// usar a URL da página direcionada, nesse caso:
		// 
		
		// Vamos obter a mensagem exibida pela página
		// comparando resultado esperado X resultado obtido
		
		// Obter o Seletor:
		// Botão direito na mensagem foi adicionado... e depois copiar / copiar seletor (Faltou o Id)
		String mensagem = driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div > ul > li > ul > li > span")).getText();
						assertTrue(mensagem.contains
				("adicionado ao carrinho de compras"));
						
						//obtendo o endereço da página para onde 
				//o usuário foi direcionado
						//comparando resultado esperado X resultado obtido
						String pagina = driver.getCurrentUrl();
						assertEquals(pagina, "http://www.lojaexemplodelivros.com.br/checkout/cart/");	
						
						try {
							
							String data = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
							
							File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
							String caminho = "D:\\_CURSOS\\COTI\\.FAVORITOS\\Testes SW 2022_03_22 M2\\Aula15 ! - CUCUMBER-Commons_io-CarrinhoCompras-GIT Commands\\EVIDENCIAS\\carrinho_de_compras_";
							FileUtils.copyFile(arquivo, new File(caminho + data + ".png"));
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						
						//fechar o navegador
						driver.close();
						driver.quit();

	}
}
