import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class verificarMenuTest {
    private WebDriver driver;
    @Before
    public void Setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\claud\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testVerificarMenu(){
        String textoWomen = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).getText();
        assertEquals("WOMEN", textoWomen);

        String textoDresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).getText();
        assertEquals("DRESSES", textoDresses);

        String textoTshirt = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).getText();
        assertEquals("T-SHIRTS", textoTshirt);
    }

    @Test
    public void testVerificarSubmenu(){
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
        actions.moveToElement(target).perform();

        String textoTop = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/a")).getText();
        assertEquals("TOPS", textoTop);

        String textoTshirts = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")).getText();
        assertEquals("T-shirts", textoTshirts);

        String textoBlouses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a")).getText();
        assertEquals("Blouses", textoBlouses);

        String textoDresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/a")).getText();
        assertEquals("DRESSES", textoDresses);

        String textoCasualDresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a")).getText();
        assertEquals("Casual Dresses", textoCasualDresses);

        String textoEveningDresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[2]/a")).getText();
        assertEquals("Evening Dresses", textoEveningDresses);

        String textoSummerDresses = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a")).getText();
        assertEquals("Summer Dresses", textoSummerDresses);

    }

    @Test
    public void testPesquisarVestido(){
        driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
        driver.findElement(By.className("button-search")).click();

        String textoQuantidade = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText();
        assertNotEquals("0 results have been found.", textoQuantidade);

        int listaVestidosEncontrados = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")).size();
        for (int i = 1; i <= listaVestidosEncontrados; i++) {

           String nomesVestido = String.format("//*[@id=\"center_column\"]/ul/li[%d]/div/div[2]/h5/a", i);
           String textoNomeVestido = driver.findElement(By.xpath(nomesVestido)).getText();

           String imagemVestido = String.format("//*[@id=\"center_column\"]/ul/li[%d]/div/div[1]/div/a[1]/img", i);
           String imagem = driver.findElement(By.xpath(imagemVestido)).getAttribute("src");

           if (textoNomeVestido.equals(null) || imagem.equals("(unknown)") ){
               assert false;
           }
        }
    }


    @After
    public void TearDown(){
        driver.quit();
    }
}
