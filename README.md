# Teste automatizado 
Site: http://automationpractice.com/

Cenários dos testes em BDD

Cenário 1: Verificar menus WOMEN, DRESSES e T-SHIRTS

          Dado que entrei na pagina inicial do site
          Quando carregar toda a pagina inicial	
          Então o sistema deve apresentar na tela os menus em sequencia WOMEN, DRESSES E T-SHIRTS
          
Cenário 2: Verificar submenu WOMEN

          Dado que entrei na pagina inicial do site	
          Quando passar o mouse encima do menu WOMEN	
          Então o sistema deve do lado esquerdo apresentar o item TOPS
          E deve apresentar abaixo dois sub menus T-shirts e Blouses
          E do lado direito deve apresentar o item DRESSES
          E abaixo tres submenus Casual Dresses, Evening Dresses e Summer Dresses"

Cenário 3: Pesquisar por um vestido

          Dado que entrei na pagina inicial do site
          E na barra de pesquisa pesquisei por "Printed Dress"
          Quando clicar no botão pesquisar
          Então o sistema deve carregar os produtos encontrados
          E o resultado retornado não pode ser 0
          E os produtos devem possuir nome e imagem
